//Import of standard Java classes
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.Node;

//Testing Node class in Main
public class NodeTest {

    //Test 16 - Test Working
    @Test
    public void test_Set_And_Get_Fields() {
        Node node = new Node();
        node.setNodeid("1");
        node.setTitle("Computers are Tools");
        node.setContent("Computers are used to handle data and perform tasks");

        String expectedID = "1";
        String expectedTitle = "Computers are Tools";
        String expectedContent = "Computers are used to handle data and perform tasks";

        Assertions.assertEquals(expectedID, node.getNodeid());
        Assertions.assertEquals(expectedTitle,node.getTitle());
        Assertions.assertEquals(expectedContent, node.getContent());
    }

    //Test 17 - Test Working
    @Test
    public void test_Set_And_Get_Fields_Empty() {
        Node node = new Node();
        node.setNodeid("");
        node.setTitle("");
        node.setContent("");

        String expectedID = "";
        String expectedTitle = "";
        String expectedContent = "";

        Assertions.assertEquals(expectedID, node.getNodeid());
        Assertions.assertEquals(expectedTitle,node.getTitle());
        Assertions.assertEquals(expectedContent, node.getContent());

    }

    //Test 18 - Test Working
    @Test
    public void test_Set_And_Get_Fields_Incomplete() {
        Node node = new Node();
        node.setNodeid("1");
        node.setTitle("Computers and Mobile Devices");
        node.setContent("");

        String expectedID = "1";
        String expectedTitle = "Computers and Mobile Devices";
        String expectedContent = "";

        Assertions.assertEquals(expectedID, node.getNodeid());
        Assertions.assertEquals(expectedTitle,node.getTitle());
        Assertions.assertEquals(expectedContent, node.getContent());
    }

    //Test 19 - Test Working
    @Test
    public void test_Linking_Nodes_Full_Details() {
        Node first = new Node("1", "First", "First Node Content");
        Node second = new Node("2", "Second", "Second Node Content");

        first.addLink(second);

        //First Node Expected Values
        String expectedFirstNodeID = "1";
        String expectedFirstNodeTitle = "First";
        String expectedFirstNodeContent = "First Node Content";

        //Second Expected Values
        String expectedSecondNodeID = "2";
        String expectedSecondNodeTitle = "Second";
        String expectedSecondNodeContent = "Second Node Content";

        //First Node Assertions
        Assertions.assertEquals(expectedFirstNodeID, first.getNodeid());
        Assertions.assertEquals(expectedFirstNodeTitle, first.getTitle());
        Assertions.assertEquals(expectedFirstNodeContent, first.getContent());

        //Second Assertions
        Assertions.assertEquals(expectedSecondNodeID, second.getNodeid());
        Assertions.assertEquals(expectedSecondNodeTitle, second.getTitle());
        Assertions.assertEquals(expectedSecondNodeContent, second.getContent());

        // Assertions for linking
        Assertions.assertEquals(1, first.getLinkedNodes().size());
        Assertions.assertEquals(second, first.getLinkedNodes().getFirst());
    }

    //Test 20 - Test Working
    @Test
    public void test_Linking_Nodes_Missing_NodeID_Fails() {
        // First node missing an ID
        Node first = new Node("", "First", "First Node Content");
        Node second = new Node("2", "Second", "Second Node Content");

        // Automatically assign an ID to a Node if the ID is missing
        if (first.getNodeid().isEmpty()) {
            first.setNodeid("1");
        }

        first.addLink(second);

        // Expected values — First Node should have a valid ID
        String expectedFirstNodeID = "1"; // expecting a proper ID
        String expectedFirstNodeTitle = "First";
        String expectedFirstNodeContent = "First Node Content";

        String expectedSecondNodeID = "2";
        String expectedSecondNodeTitle = "Second";
        String expectedSecondNodeContent = "Second Node Content";

        // Actual values from the objects
        String actualFirstNodeID = first.getNodeid();
        String actualFirstNodeTitle = first.getTitle();
        String actualFirstNodeContent = first.getContent();

        String actualSecondNodeID = second.getNodeid();
        String actualSecondNodeTitle = second.getTitle();
        String actualSecondNodeContent = second.getContent();

        // First Node Assertions — this will fail because First Node ID is empty
        Assertions.assertEquals(expectedFirstNodeID, actualFirstNodeID, "First Node ID should not be empty");
        Assertions.assertEquals(expectedFirstNodeTitle, actualFirstNodeTitle, "First Title should match");
        Assertions.assertEquals(expectedFirstNodeContent, actualFirstNodeContent, "First Content should match");

        // Second Node Assertions
        Assertions.assertEquals(expectedSecondNodeID, actualSecondNodeID, "Second Node ID should match");
        Assertions.assertEquals(expectedSecondNodeTitle, actualSecondNodeTitle, "Second Title should match");
        Assertions.assertEquals(expectedSecondNodeContent, actualSecondNodeContent, "Second Content should match");

        // Assertions for linking
        Assertions.assertEquals(1, first.getLinkedNodes().size(), "First Node should have one linked node");
        Assertions.assertEquals(second, first.getLinkedNodes().get(0), "Linked node should match second Node");
    }

}
