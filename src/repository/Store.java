package repository;

import models.LibraryResource;
import java.util.ArrayList;
import java.util.List;
import models.Node;

public class Store {
    private List<LibraryResource> resources = new ArrayList<>();

    public void addResource(LibraryResource resource) {
        resources.add(resource);


        if (resource instanceof Node node) {
            System.out.println("Added Node with ID: " + node.getNodeid());
        }
    }

    public void countResources() {
        System.out.println("Number of resources: " + resources.size());
    }
}
