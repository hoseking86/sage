package models;

import java.util.ArrayList;
import java.util.List;

public class Node extends LibraryResource {
    public Node() {}
    private String nodeid;
    private String title;
    private String content;

    private List<Node> linkedNodes = new ArrayList<>();

    public Node(String nodeid, String title, String content) {
        this.nodeid = nodeid;
        this.title = title;
        this.content = content;
    }

    public String getNodeid() { return nodeid; }
    public void setNodeid(String nodeid) { this.nodeid = nodeid; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<Node> getLinkedNodes() { return linkedNodes; }

    // Simple bidirectional link
    public void link(Node node) {
        if (node == null || node == this) return;
        if (!linkedNodes.contains(node)) {
            linkedNodes.add(node);
            node.link(this);  // link back
        }
    }

    @Override
    public String toString() {
        return "Node ID: " + nodeid +
                "  Title: " + title +
                "  Content: " + content +
                "  Linked Nodes: " + linkedNodes.size();
    }
}
