import models.ResourceType;
import service.NodeService;

public class Application {
    public static void main(String[] args) {
        NodeService nodeService = new NodeService();
        nodeService.addResource(ResourceType.NODE, "Node 1    -","Computer      -", "A computer is what you use to carry out tasks" );
        nodeService.addResource(ResourceType.NODE, "Node 2    -","Programming   -","Programming is used to main things happen");
        nodeService.addResource(ResourceType.NODE, "Node 3    -","Databases     -",  "Databases store the data for use at a later time");

        System.out.println();
        nodeService.totalItems();
    }
}