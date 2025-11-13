import models.ResourceType;
import service.NodeService;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        NodeService nodeService = new NodeService();
        //This is added for testing to ensure the added resources are counted
        nodeService.addResource(ResourceType.NODE, "Node 1    ","Computer      ", "A computer is what you use to carry out tasks" );
        nodeService.addResource(ResourceType.NODE, "Node 2    ","Programming   ","Programming is used to main things happen");
        nodeService.addResource(ResourceType.NODE, "Node 3    ","Databases     ",  "Databases store the data for use at a later time");

        System.out.println();
        nodeService.totalItems();

        //added 13/11/2025 12:35 Used for Searching
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPLEASE ENTER SOMETHING TO SEARCH FOR: ");
        String term = scanner.nextLine();

        var results = nodeService.searchResources(term);

        if (results.isEmpty()) {
            System.out.println("SORRY NO MATCHES ARE FOUND PLEASE RETRY ANOTHER SEARCH");
        } else {
            System.out.println("\nSEARCH RESULTS:");
            results.forEach(System.out::println);
            //end of Search
        }
    }
}