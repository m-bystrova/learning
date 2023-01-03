package com.learning.spring.multithreading;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Multithreading {
    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        for (int i = 1; i < 1001; i += 100) {
            list.add(extracted(i, i));
        }
        for (Long l : list) {
            System.out.print(l + " ");
        }
    }

    private static long extracted(int limitList, int nThreads) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
            = "https://yandex.ru/search";
        ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl + "/?text=3.1415968", String.class);
        String regex = "\\s";
        List<String> words = Stream.of(response.getBody().replaceAll("[\\{\\}]*", "k").split(regex))
            .skip((int) (3 * Math.random()))
            .limit(limitList)
            .collect(Collectors.toList());

        long startTs = System.currentTimeMillis();
        ExecutorService pool
            = Executors.newFixedThreadPool(nThreads);
        CompletionService<ResponseEntity<String>> service = new ExecutorCompletionService<>(pool);

        List<Callable<ResponseEntity<String>>> callables = new ArrayList<>();
        for (String i : words) {
            callables.add(new RestCallable(restTemplate, fooResourceUrl, i.toString()));
        }

        for (Callable<ResponseEntity<String>> callable : callables) {
            service.submit(callable);
        }
        pool.shutdown();
        List<String> result = new ArrayList<>();
        try {
            while (!pool.isTerminated()) {
                Future<ResponseEntity<String>> future = service.take();
                result.add(future.get().getBody());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTs = System.currentTimeMillis();
        return endTs - startTs;
    }

    static class RestCallable implements Callable<ResponseEntity<String>> {

        final RestTemplate restTemplate;
        final String fooResourceUrl;
        final String s;

        RestCallable(final RestTemplate restTemplate, final String fooResourceUrl, final String s) {
            this.restTemplate = restTemplate;
            this.fooResourceUrl = fooResourceUrl;
            this.s = s;
        }

        public ResponseEntity<String> call() {
            return restTemplate.getForEntity(fooResourceUrl + "/?text=" + s, String.class);
        }
    }
}