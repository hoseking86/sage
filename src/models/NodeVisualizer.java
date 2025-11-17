package models;

public class NodeVisualizer implements NodeObservers {

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