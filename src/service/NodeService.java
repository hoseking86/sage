package service;

import models.*;
import repository.Store;
import java.util.List;
import java.util.ArrayList;

public class NodeService {
    private final Store store;

    public NodeService() {
        this.store = new Store();
    }

    //Store is a holding the library resources
    //Encapsulation - OOP
    public void addResource(ResourceType rType, String nodeId, String title, String content) {
        LibraryResource resource = null;
        if (rType == ResourceType.NODE) {
            resource = createNode(nodeId, title, content);
        }
        if (resource != null) {
            store.addResource(resource);
        }
    }

    //Used for Observer addition
    public List<Node> getAllNodes() {
        List<LibraryResource> resources = store.getAllResources();
        List<Node> nodes = new ArrayList<>();

        for (LibraryResource res : resources) {
            if (res instanceof Node node) {
                nodes.add(node);
            }
        }

        return nodes;
    } //End of addition

    //Needed for Observer Pattern
    public Node getNodeById(String nodeId) {
        List<LibraryResource> resources = store.getAllResources();
        for (LibraryResource resource : resources) {
            if (resource instanceof Node node && node.getNodeid().equalsIgnoreCase(nodeId)) {
                return node;
            }
        }
        return null; // Node not found
    }
    //End of addition

    //This shows the Researcher how many nodes have been saved (including the example nodes)
    public void totalItems() {
        store.countResources();
    }

    //Added 13/11/2025 12:35 for the search to work
    public List<LibraryResource> searchResources(String term) {
        return store.search(term);
    }
    //end of addition - search

    //Creation of a node using the set fields
    private Node createNode(String nodeId, String title, String content) {
        Node node = new Node();
        node.setNodeid(nodeId);
        node.setTitle(title);
        node.setContent(content);

        return node;
    }

    //This is the code to update a node
    public boolean updateResource(String nodeId, String newTitle, String newContent) {
        List<LibraryResource> resources = store.getAllResources();

        for (LibraryResource resource : resources) {
            if (resource instanceof Node node && node.getNodeid().equalsIgnoreCase(nodeId)) {
                if (!newTitle.isBlank()) node.setTitle(newTitle);
                if (!newContent.isBlank()) node.setContent(newContent);
                return true; // Updated successfully
            }
        }
        return false; // Node not found
    }

    //Linking nodes
    public boolean linkNodes(String id1, String id2) {
        List<LibraryResource> resources = store.getAllResources();

        Node node1 = null;
        Node node2 = null;

        // find nodes
        for (LibraryResource res : resources) {
            if (res instanceof Node node) {
                if (node.getNodeid().equalsIgnoreCase(id1)) node1 = node;
                if (node.getNodeid().equalsIgnoreCase(id2)) node2 = node;
            }
        }

        // not found?
        if (node1 == null || node2 == null) {
            return false;
        }

        // link both ways
        node1.addLink(node2);
        node2.addLink(node1);

        return true;
    }

    //This shows all the resources
    public void showAllResources() {
        List<LibraryResource> resources = store.getAllResources();

        if (resources.isEmpty()) { //https://www.w3schools.com/java/ref_string_isempty.asp accessed 13/11/2025
            System.out.println("No resources available.");
            return;
        }

        System.out.println("\n=== ALL RESOURCES ===");
        for (LibraryResource resource : resources) {
            if (resource instanceof Node node) {
                System.out.println("ID: " + node.getNodeid());
                System.out.println("Title: " + node.getTitle());
                System.out.println("Content: " + node.getContent());
                System.out.println("------------------------");

            }
        }
    }
}