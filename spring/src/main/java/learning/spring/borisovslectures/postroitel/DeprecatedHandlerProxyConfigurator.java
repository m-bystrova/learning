package learning.spring.borisovslectures.postroitel;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if(implClass.isAnnotationPresent(Deprecated.class)) {

            if(implClass.getInterfaces().length == 0){
                return Enhancer.create(implClass,
                    (org.springframework.cglib.proxy.InvocationHandler) (o, method, args) -> getInvokationHandlerLogic(method, args, t));
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(),
                (proxy, method, args) -> getInvokationHandlerLogic(method, args, t));
        } else {
            return t;
        }
    }

    private Object getInvokationHandlerLogic(Method method, Object[] args, Object t)
        throws IllegalAccessException, InvocationTargetException
    {
        System.out.println("*** InvocationHandler");
        return method.invoke(t, args);
    }
}
