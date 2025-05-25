public class WiseSaying {
    private static long nextId = 1;

    private long id;
    private String content;
    private String author;

    public WiseSaying(String content, String author) {
        this.id = nextId++;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void printWiseSaying() {
        System.out.printf("%d / %s / %s%n", id, content, author);
    }
}
