package L5.model;

public class L5Post {
    private long creationTime;
    private String subject;
    private String text;

    public L5Post(String subject, String text) {
        this.creationTime = System.currentTimeMillis();
        this.text = text;
        this.subject = subject;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
