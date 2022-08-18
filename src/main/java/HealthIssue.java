public class HealthIssue {
    private int id;
    private String issue;

    public HealthIssue() {
    }

    public HealthIssue(int id, String issue) {
        this.id = id;
        this.issue = issue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
