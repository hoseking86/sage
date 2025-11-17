import models.ResourceType;
import service.NodeService;
import java.util.Scanner;
import service.LoginService;
import models.Node;
import java.util.List;
import models.NodeVisualizer;//May take out?

public class Application {
    public static void main(String[] args) {

        //Classes - OOP
        //These are initiated when the program first runs
        NodeService nodeService = new NodeService();
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        //This initiates the log in before anything else
        //Encapsulation and Abstraction - OOP
        //Encapsulation - login process inside the LoginService class
        //Abstraction - uses login method
        //Checking the details in loginService and returns true or false using thr boolean logic
        boolean loggedIn = loginService.login(scanner); //https://www.w3schools.com/java/java_booleans.asp accessed 10/11/2025

        if (!loggedIn) {
            System.out.println("Exiting program...");
            return;
        }

        //After login the Researcher will be presented with the menu with available options

        System.out.println();
        System.out.println("********************************************************************************************************************************");
        System.out.println();
        // Preload some resources for testing
        System.out.println("                                           Example knowledge node creations");
        System.out.println("                                      ----------------------------------------");
        System.out.println();

        //Encapsulation and Abstraction - OOP
        nodeService.addResource(ResourceType.NODE, "AB1", "Computer", "A computer is what you use to carry out tasks");
        nodeService.addResource(ResourceType.NODE, "AB2", "Programming", "Programming is used to make things happen");
        nodeService.addResource(ResourceType.NODE, "CD1", "Databases", "Databases store the data for use at a later time");
        nodeService.addResource(ResourceType.NODE, "AB3", "Computer", "Computer hardware includes a keyboard and mouse");
        nodeService.addResource(ResourceType.NODE, "CD2", "Databases", "An example of a database management tool is MySQL");

        // Create visualizer and attach to all existing nodes
        NodeVisualizer visualizer = new NodeVisualizer();
        for (Node node : nodeService.getAllNodes()) {
            node.addObserver(visualizer);
        }

        boolean running = true;
        while (running) {



            System.out.println();
            //https://medium.com/@AlexanderObregon/creating-user-menus-in-java-with-loops-and-switch-040149bd9732 accessed 10/11/2025
                System.out.println("\n                                                   RESEARCHER MENU");
                System.out.println("                                      ----------------------------------------");

            // Added for the Observer to update Linked Nodes Display current linked nodes dynamically
            System.out.println("                                 Current linked nodes:");
            List<Node> allNodes = nodeService.getAllNodes();
            if (allNodes.isEmpty()) {
                System.out.println("                                    none");
            } else {
                for (Node node : allNodes) {
                    visualizer.onNodeUpdated(node); // Trigger visualizer output
                }
            }
            //Observer update addition end here
                System.out.println();
                //System.out.println("                                 Current linked nodes: ");
                System.out.println();
                System.out.println("Please choose one of the following and press ENTER:");
                System.out.println();
                System.out.println("SELECT 1 Add a new Node");
                System.out.println("SELECT 2 Search for resources");
                System.out.println("SELECT 3 Show total number of resources");
                System.out.println("SELECT 4 To Edit a node");
                System.out.println("SELECT 5 To create linked nodes");
                System.out.println("SELECT 6 For user logout");
                //System.out.println();
                //System.out.println();
                //System.out.println("Current linked nodes: **Show linked nodes here**");

                String choice = scanner.nextLine();

                //These are needed when setting up selectable menu items
                switch (choice) {
                    case "1":
                        System.out.print("Enter Node ID in format of your initials followed by number EG TW01 (no spaces!) : ");
                        String nodeid = scanner.nextLine();

                        System.out.print("Enter title for the Node: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter the content for the Node: ");
                        String content = scanner.nextLine();

                        nodeService.addResource(ResourceType.NODE, nodeid, title, content);
                        System.out.println("Node has been added");
                        break;

                    case "2":
                        System.out.print("Enter search term: ");
                        String term = scanner.nextLine();
                        var results = nodeService.searchResources(term);

                        if (results.isEmpty()) {
                            System.out.println("Nothing stored please carry out a new search.");
                        } else {
                            System.out.println("\nSEARCH RESULTS:");
                            results.forEach(System.out::println);
                        }
                        break;

                    case "3":
                        nodeService.totalItems();
                        break;

                    case "4":
                        nodeService.showAllResources(); // show existing nodes
                        System.out.print("Enter the Node ID to edit: ");
                        String editId = scanner.nextLine();

                        System.out.print("Enter new title (leave blank to keep current): ");
                        String newTitle = scanner.nextLine();

                        System.out.print("Enter new content (leave blank to keep current): ");
                        String newContent = scanner.nextLine();

                        boolean updated = nodeService.updateResource(editId, newTitle, newContent);
                        if (updated) {
                            System.out.println("Node updated successfully!");
                        } else {
                            System.out.println("Node not found. Please check the ID and try again.");
                        }
                        break;


                    case "5":
                        nodeService.showAllResources();
                        System.out.print("Enter first Node ID: ");
                        String n1 = scanner.nextLine();

                        System.out.print("Enter second Node ID: ");
                        String n2 = scanner.nextLine();

                        if (nodeService.linkNodes(n1, n2)) {
                            System.out.println("Nodes linked successfully!");

                            // Attach visualizer to linked nodes if not already attached
                            Node nodeA = nodeService.getNodeById(n1);
                            Node nodeB = nodeService.getNodeById(n2);

                            if (nodeA != null) nodeA.addObserver(visualizer);
                            if (nodeB != null) nodeB.addObserver(visualizer);

                            // Trigger visualization manually
                            if (nodeA != null) visualizer.onNodeUpdated(nodeA);
                            if (nodeB != null) visualizer.onNodeUpdated(nodeB);

                        } else {
                            System.out.println("One or both IDs were not found.");
                        }
                        break;

                    case "6":
                        System.out.println("Logging out...");
                        running = false;  // this will exit the while loop
                        break;

                    default:
                        System.out.println("This is not a valid option, please select 1-5.");
                        break;
                }
            }
        }
    }
