import models.ResourceType;
import service.NodeService;
import java.util.Scanner;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        NodeService nodeService = new NodeService();
        Scanner scanner = new Scanner(System.in);

        //Log in creation - https://medium.com/@edanurgurgen94/creating-user-login-with-java-3272197fe507 accessed 14/11/2025
        HashMap<String, String> users = new HashMap<>();
        users.put("jbloogs", "1234");
        users.put("twoods", "1234");
        System.out.println("=== LOGIN SYSTEM ===");

        System.out.print("Your Username: ");
        String userName = scanner.nextLine();

        System.out.print("Your Password: ");
        String password = scanner.nextLine();


        // --- LOGIN CHECK ---
        if (!users.containsKey(userName) || !users.get(userName).equals(password)) {

            System.out.println("Login Failed! Do you want to reset your password?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");

            int answer = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (answer == 1) {

                System.out.print("Enter your new password: ");
                String newPassword = scanner.nextLine();

                if (newPassword.equals(users.get(userName))) {
                    System.out.println("Do not use your previous password!");
                    System.out.print("Enter a different password: ");
                    newPassword = scanner.nextLine();
                }

                users.put(userName, newPassword);  // update stored password
                System.out.println("Password updated! You are now logged in.");

            } else {
                System.out.println("Login Failed! Exiting...");
                return;
            }
        } else {
            System.out.println("Successfully logged in!");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        // Preload some resources for testing
        System.out.println("Example knowledge node creations");
        System.out.println();
        nodeService.addResource(ResourceType.NODE, "AB 1", "Computer", "A computer is what you use to carry out tasks");
        nodeService.addResource(ResourceType.NODE, "AB 2", "Programming", "Programming is used to make things happen");
        nodeService.addResource(ResourceType.NODE, "CD 1", "Databases", "Databases store the data for use at a later time");

        boolean running = true;
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        while (running) {
            System.out.println("\nRESEARCHER MENU");
            System.out.println("SELECT 1 Add a new Node");
            System.out.println("SELECT 2 Search for resources");
            System.out.println("SELECT 3 Show total number of resources");
            System.out.println("SELECT 4 To Edit a node");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Node ID in format of your initals followed by number: ");
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

                default:
                    System.out.println("Invalid option, please select 1-4.");

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
            }
        }
    }
}
