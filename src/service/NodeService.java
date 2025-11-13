package service;

import models.*;
import repository.Store;

public class NodeService {
    private final Store store;

    public NodeService() {
        this.store = new Store();
    }

    public void addResource(ResourceType rType, String nodeId, String title) {
        LibraryResource resource = null;
        if (rType == ResourceType.NODE) {
            resource = createNode(nodeId, title);
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

    private Node createNode(String nodeId, String title) {
        Node node = new Node();
        node.setNodeid(nodeId);
        node.setTitle(title);

        return node;
    }
}
