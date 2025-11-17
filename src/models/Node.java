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

    //Creating a list of Observers
    //Obs run when the NodeObserver needs to update when a node changes
    private List<NodeObservers> observers = new ArrayList<>();

    //Observer Design Pattern - Linked node visual update - https://www.tutorialspoint.com/java/util/observable_addobserver.htm Accessed 17/11/2025
    //This code will allow an observer to be added or taken away from a public/external object.
    public void addObserver(NodeObservers observer) {
        observers.add(observer);
    }
    public void removeObserver(NodeObservers observer) {
        observers.remove(observer);
    }

    //This loops through observers calling on the onNodeUpdated method/class
    private void notifyObservers() {
        for (NodeObservers observer : observers) {
            observer.onNodeUpdated(this);
        }
    }
    //End of addition of Design Pattern


    //Constructor which sets/initialises the Object in this case Node with the relevant fields
    public Node(String nodeid, String title, String content) {
        this.nodeid = nodeid;
        this.title = title;
        this.content = content;
    }

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

    //This is the method for adding a linked node
    public void addLink(Node node) {
        if (!linkedNodes.contains(node)) {
            linkedNodes.add(node);
            notifyObservers(); //This line added for Observer Design Pattern - Linked node visual update
        }
    }


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