package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //Linking nodes
    //This is a getter for the linked nodes
    public List<Node> getLinkedNodes() {
        return linkedNodes;
    }

    //This is the actual method for adding a linked node
    public void addLink(Node node) {
        if (!linkedNodes.contains(node)) {
            linkedNodes.add(node);
        }
    }


    @Override
    public String toString() {
        String linkedIds;
        //Linked nodes
        if (linkedNodes.isEmpty()) {
            linkedIds = "None";
        } else {
            linkedIds = linkedNodes.stream()
                    .map(Node::getNodeid)
                    .collect(Collectors.joining(", "));
        }
        return "Node ID: " + nodeid +
                "  Title: " + title +
                "  Content: " + content +
                "  Linked Nodes: " + linkedIds;
    }
}
