// Import of standard Java classes
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.Node;
import service.NodeService;
import models.ResourceType;


//******The program currently allows for duplicate IDs, so this test tests that the duplications can be set
//******If the program was to be re-written, duplications would not be allowed. So this test has been written as a reference

// Testing Node class
public class DuplicateNodeIDTest {

    //Test 21 - Test Working
    @Test
    public void test_Duplicate_Node_IDs_Allowed() {

        NodeService service = new NodeService();

        // First node to be added
        service.addResource(ResourceType.NODE, "TW1", "Computers", "Content1");

        // Second node to be added and will have the same Node ID
        service.addResource(ResourceType.NODE, "TW1", "Mobile devices", "Content2");

        // Get all nodes
        var nodes = service.getAllNodes();


        Assertions.assertEquals(2, nodes.size(),
                "The Current program will allow for duplicate IDs to be created, as a result there should be 2 nodes created with duplicate IDs.");

        // This will check the details of both nodes
        Node first = nodes.get(0);
        Node second = nodes.get(1);

        Assertions.assertEquals("TW1", first.getNodeid());
        Assertions.assertEquals("TW1", second.getNodeid());

        Assertions.assertEquals("Computers", first.getTitle());
        Assertions.assertEquals("Mobile devices", second.getTitle());
    }

}



