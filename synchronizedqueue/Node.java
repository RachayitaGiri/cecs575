package synchronizedqueue;

public class Node {
    private String data;
    public Node next;

    public Node(String str) {
        data = str;
    }
    public String getData() {
        return data;
    }
}
