import models.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonsTest {

    @Test
    public void test_node_Addition() {
        Node A = new Node();
        Node B = new Node();

        A.setContent("Hello");
        B.setContent(" World");

        Adder adder = new Adder();
        Node C = adder.add(A, B);

        String expected = "Hello World";

        Assertions.assertEquals(expected, C.getContent());
    }

    @Test
    public void test_node_Addition_no_content() {
        Node A = new Node();
        Node B = new Node();

        Adder adder = new Adder();
        Node C = adder.add(A, B);

        String expected = ""

        Assertions.assertEquals(expected, C.getContent());
    }

    @Test
    public void test_node_Addition_empty() {
        Node A = new Node();
        Node B = new Node();

        A.setContent("Hello");
        B.setContent("");

        Adder adder = new Adder();
        Node C = adder.add(A, B);

        String expected = "Hello";

        Assertions.assertEquals(expected, C.getContent());
    }
}
