package repository;

import models.LibraryResource;
import java.util.ArrayList;
import java.util.List;
import models.Node;


public class Store {
    private List<LibraryResource> resources = new ArrayList<>();
    //The resource is storing the LibraryResource data
    public void addResource(LibraryResource resource) {
        resources.add(resource);


        if (resource instanceof Node node) {
            System.out.println("Added Node with ID: " + node.getNodeid() + " " + "Node Title: " + node.getTitle() + " " + "Node Content: " + node.getContent());

        }
    }

        //Method to actively count the number of created/stored resources
        //https://www.geeksforgeeks.org/java/count-occurrences-elements-list-java/ accessed 12/11/2025
    public void countResources() {
        System.out.println("Number of Resources Stored: " + resources.size());
    }

    public List<LibraryResource> search(String term) {
        List<LibraryResource> results = new ArrayList<>();
        String lowerTerm = term.toLowerCase();

        //This is where the search fields should be added
        for (LibraryResource resource : resources) {
            if (resource instanceof Node node) {
                String title = node.getTitle().toLowerCase();
                String content = node.getContent().toLowerCase();
                String nodeid = node.getNodeid().toLowerCase();

                //Needs updating when search fields are added
                if (title.contains(lowerTerm) || content.contains(lowerTerm) || nodeid.contains(lowerTerm)) {
                    results.add(node);
                }
            }
        }
        return results;
    }

    // Getter for all resources
    public List<LibraryResource> getAllResources() {
        return new ArrayList<>(resources);
    }

}
