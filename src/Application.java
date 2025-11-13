import models.ResourceType;
import service.NodeService;

public class Application {
    public static void main(String[] args) {
        NodeService nodeService = new NodeService();
        nodeService.addResource(ResourceType.NODE, "Node 1","Computer");
        nodeService.addResource(ResourceType.NODE, "Node 2","Programming");
        nodeService.addResource(ResourceType.NODE, "Node 3","Databases");


        nodeService.totalItems();
    }
}