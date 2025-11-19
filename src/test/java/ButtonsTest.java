import models.Node;

//Import of standard Java classes
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonsTest {

    //TEST 1 - Test Working
    @Test
    public void test_node_Addition() {
        Node A = new Node();
        Node B = new Node();

        A.setContent("Apple Macs");
        B.setContent(" Use the macOS operating system");

        NodeAdder nodeAdder = new NodeAdder();
        Node C = nodeAdder.add(A, B);

        String expected = "Apple Macs Use the macOS operating system";

        Assertions.assertEquals(expected, C.getContent());
    }

    //TEST 2 - Test Working
    @Test
    public void test_node_Addition_no_content() {
        Node A = new Node();
        Node B = new Node();

        NodeAdder nodeAdder = new NodeAdder();
        Node C = nodeAdder.add(A, B);

        String expected = "";

        Assertions.assertEquals(expected, C.getContent());
    }
    //TEST 3 - Test Working
    @Test
    public void test_node_Addition_empty() {
        Node A = new Node();
        Node B = new Node();

        A.setContent("Apple Macs");
        B.setContent("");

        NodeAdder nodeAdder = new NodeAdder();
        Node C = nodeAdder.add(A, B);

        String expected = "Apple Macs";

        Assertions.assertEquals(expected, C.getContent());
    }
}
