package service;

import models.*;
import repository.Store;
import java.util.List;

public class NodeService {
    private final Store store;

    public NodeService() {
        this.store = new Store();
    }

    //Encapsulation - OOP
    public void addResource(ResourceType rType, String nodeId, String title, String content) {
        LibraryResource resource = null;
        if (rType == ResourceType.NODE) {
            resource = createNode(nodeId, title, content);
        }
        if (resource != null) {
            store.addResource(resource);
        } else {
            System.out.println("Unsupported resource type: " + rType);
        }
        //store.addResource(resource);
    }

    public void totalItems() {
        store.countResources();
    }

    //Added 13/11/2025 12:35 for the search to work
    public List<LibraryResource> searchResources(String term) {
        return store.search(term);
    }
    //end of addition - search

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

    private Node createNode(String nodeId, String title, String content) {
        Node node = new Node();
        node.setNodeid(nodeId);
        node.setTitle(title);
        node.setContent(content);

        return node;
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

    public void showAllResources() {
        List<LibraryResource> resources = store.getAllResources();

        if (resources.isEmpty()) {
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