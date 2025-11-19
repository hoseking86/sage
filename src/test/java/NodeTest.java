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


        Assertions.assertEquals("1", node.getNodeid());
        Assertions.assertEquals("Computers are Tools", node.getTitle());
        Assertions.assertEquals("Computers are used to handle data and perform tasks", node.getContent());
    }

    //Test 17 - Test Working
    @Test
    public void test_Set_And_Get_Fields_Empty() {
        Node node = new Node();
        node.setNodeid("");
        node.setTitle("");
        node.setContent("");

        Assertions.assertEquals("", node.getNodeid());
        Assertions.assertEquals("", node.getTitle());
        Assertions.assertEquals("", node.getContent());
    }

    //Test 18 - Test Working
    @Test
    public void test_Set_And_Get_Fields_Incomplete() {
        Node node = new Node();
        node.setNodeid("1");
        node.setTitle("Computers and Mobile Devices");
        node.setContent("");

        Assertions.assertEquals("1", node.getNodeid());
        Assertions.assertEquals("Computers and Mobile Devices", node.getTitle());
        Assertions.assertEquals("", node.getContent());
    }





    @Test
    public void testLinkingNodes() {
        Node parent = new Node("1", "Parent", "Parent Content");
        Node child = new Node("2", "Child", "Child Content");

        parent.addLink(child);

        Assertions.assertEquals(1, parent.getLinkedNodes().size());
        Assertions.assertEquals("2", parent.getLinkedNodes().get(0).getNodeid());
    }
}
