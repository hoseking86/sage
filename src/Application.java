import models.ResourceType;
import service.NodeService;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        NodeService nodeService = new NodeService();
        Scanner scanner = new Scanner(System.in);

        // Preload some resources for testing
        nodeService.addResource(ResourceType.NODE, "Node 1", "Computer", "A computer is what you use to carry out tasks");
        nodeService.addResource(ResourceType.NODE, "Node 2", "Programming", "Programming is used to make things happen");
        nodeService.addResource(ResourceType.NODE, "Node 3", "Databases", "Databases store the data for use at a later time");

        boolean running = true;

        while (running) {
            System.out.println("\nRESEARCHER MENU");
            System.out.println("SELECT 1 Add a new Node");
            System.out.println("SELECT 2 Search for resources");
            System.out.println("SELECT 3 Show total number of resources");
            System.out.println("SELECT 4 Edit node");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Node ID in format of your initals followed by number: ");
                    String nodeid = scanner.nextLine();

                    System.out.print("Enter title for the Node: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter the content for the Node: ");
                    String content = scanner.nextLine();

                    nodeService.addResource(ResourceType.NODE, nodeid, title, content);
                    System.out.println("Node has been added");
                    break;

                case "2":
                    System.out.print("Enter search term: ");
                    String term = scanner.nextLine();
                    var results = nodeService.searchResources(term);

                    if (results.isEmpty()) {
                        System.out.println("Nothing stored please carry out a new search.");
                    } else {
                        System.out.println("\nSEARCH RESULTS:");
                        results.forEach(System.out::println);
                    }
                    break;

                case "3":
                    nodeService.totalItems();
                    break;

                default:
                    System.out.println("Invalid option, please select 1-4.");
            }
        }

        scanner.close();
    }
}
