package examplesfrombooks.javabycomparison;

import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

public class TransmissionParser {

    static Transmission parse(@Nonnull String rawMessage) {
        requireNonNull(rawMessage, "requireNonNull");
        if (rawMessage.length() != Transmission.MESSAGE_LENGTH) {
            throw new MalformedMessageException(
                String.format("Expected %d, but got %d characters",
                    Transmission.MESSAGE_LENGTH, rawMessage.length()),
                rawMessage);
        }
        String rawId = rawMessage.substring(0, Transmission.ID_LENGTH);
        String rawContent = rawMessage.substring(Transmission.ID_LENGTH);
        try {
            int id = Integer.parseInt(rawId);
            String content = rawContent.trim();
            return new Transmission(id, content);
        } catch (NumberFormatException e) {
            throw new MalformedMessageException(
                String.format("Expected number, but got '%s'", rawId),
                rawMessage, e);
        }
    }
}

final class MalformedMessageException extends IllegalArgumentException {
    final String raw;

    MalformedMessageException(String message, String raw) {
        super(String.format("%s in '%s'", message, raw));
        this.raw = raw;
    }

    MalformedMessageException(String message, String raw, Throwable cause) {
        super(String.format("%s in '%s'", message, raw), cause);
        this.raw = raw;
    }
}
