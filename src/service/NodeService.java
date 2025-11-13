package service;

import models.*;
import repository.Store;
import java.util.List;

public class NodeService {
    private final Store store;

    public NodeService() {
        this.store = new Store();
    }

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

    private Node createNode(String nodeId, String title, String content) {
        Node node = new Node();
        node.setNodeid(nodeId);
        node.setTitle(title);
        node.setContent(content);

        return node;
    }

}
