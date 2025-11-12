import models.ResourceType;
import service.NodeService;

public class Application {
    public static void main(String[] args) {
        NodeService nodeService = new NodeService();
        nodeService.addResource(ResourceType.NODE, "node 1");
        nodeService.addResource(ResourceType.NODE, "node 2");
        nodeService.addResource(ResourceType.NODE, "node 3");
        nodeService.addResource(ResourceType.NODE, "node 4");
        nodeService.addResource(ResourceType.NODE, "node 5");

        nodeService.totalItems();
    }
}