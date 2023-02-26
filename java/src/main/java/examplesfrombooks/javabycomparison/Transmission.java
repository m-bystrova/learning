package examplesfrombooks.javabycomparison;

class Transmission {
    public static final int MESSAGE_LENGTH = 24;
    public static final int ID_LENGTH = 10;

    private final int id;
    private final String content;

    public Transmission(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
