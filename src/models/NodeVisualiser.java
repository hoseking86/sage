package models;

public class NodeVisualiser implements NodeObservers {

    //This is creating the visualisation for the linked node list - https://www.baeldung.com/java-observer-pattern?utm_source=chatgpt.com Accessed 16/11/2025
    @Override
    public void onNodeUpdated(Node node) {
        System.out.print("Node " + node.getNodeid() + " linked to: ");
        if (node.getLinkedNodes().isEmpty()) {
            System.out.println("(none)");
        } else {
            String linkedIds = node.getLinkedNodes().stream()
                    .map(Node::getNodeid)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            System.out.println(linkedIds);
        }
    }
}