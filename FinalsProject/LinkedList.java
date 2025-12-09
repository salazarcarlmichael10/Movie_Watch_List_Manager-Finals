public class LinkedList {
    private String genreName;
    public LinkedList next;

    public LinkedList() {
        this.genreName = "";
        this.next = null;
    }

    public LinkedList(String genreName) {
        this.genreName = genreName;
        this.next = null;
    }

    public LinkedList(String genreName, LinkedList next) {
        this.genreName = genreName;
        this.next = next;
    }

    public void setgenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getgenreName() {
        return genreName;
    }
}