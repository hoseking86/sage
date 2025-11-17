package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//Inheritance happening here
public class Node extends LibraryResource {

    public Node() {}

    private String nodeid;
    private String title;
    private String content;
    private List<Node> linkedNodes = new ArrayList<>();

    //Observer Design Pattern - Linked node visual update
    private List<NodeObservers> observers = new ArrayList<>();
    //End of addition of DP

    public Node(String nodeid, String title, String content) {
        this.nodeid = nodeid;
        this.title = title;
        this.content = content;
    }
    //Observer Design Pattern - Linked node visual update
    public void addObserver(NodeObservers observer) {
        observers.add(observer);
    }

    public void removeObserver(NodeObservers observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (NodeObservers observer : observers) {
            observer.onNodeUpdated(this);
        }
    }
    //End of addition of DP

    //These get and sets are methods used to read and update the nodes
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

    //Observer Design Pattern - Linked node visual update
    //public void addLink(Node node) {
        //if (!linkedNodes.contains(node)) {
            //linkedNodes.add(node);
            //notifyObservers();   // 🔔 Notify when links change
       // }
   //}

    //This is the method for adding a linked node
    public void addLink(Node node) {
        if (!linkedNodes.contains(node)) {
            linkedNodes.add(node);
            notifyObservers(); //Line added for Observer Design Pattern - Linked node visual update
        }
    }
    //End of addition of DP

    //This code is overriding the string
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