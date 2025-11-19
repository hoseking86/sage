import models.Node;

public class NodeAdder {
    public Node add(Node A, Node B) {
        Node C = new Node();
        if (A.getContent() == null || B.getContent() == null) {
            C.setContent("");
        } else {
            C.setContent(A.getContent() + B.getContent());
        }
        return C;
    }
}
