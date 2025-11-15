package service;

import java.util.HashMap;
import java.util.Scanner;


//Log in creation - https://medium.com/@edanurgurgen94/creating-user-login-with-java-3272197fe507 accessed 14/11/2025

    public class LoginService {

        private HashMap<String, String> users = new HashMap<>();

        public LoginService() {

            //These are currently manually added
            users.put("t@sage.com", "1234");
            users.put("j@sage.com", "1234");
            users.put("a", "a");

        }

        public boolean login(Scanner scanner) {

            System.out.println("********************************************************************************************************************************");
            System.out.println();
            System.out.println("++++ SAGE LOGIN ++++");
            System.out.println();
            System.out.print("Enter the login details provided at registration and press Enter");
            System.out.println();
            System.out.print("Your Email Address: ");
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
                    System.out.println("Your Password has been reset");
                    return true;

                } else {
                    System.out.println("Login Failed the program is now Exiting");
                    return false;
                }
            } else {
                System.out.println("Successfully logged in!");
                return true;
            }
        }
    }