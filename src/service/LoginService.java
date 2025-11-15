package service;

import models.Researcher;
import java.util.HashMap;
import java.util.Scanner;

//Log in creation - https://medium.com/@edanurgurgen94/creating-user-login-with-java-3272197fe507 accessed 14/11/2025

    public class LoginService {

        private HashMap<String, Researcher> users= new HashMap<>();

        //LoginService constructor which will run when the service is created/initiated
        public LoginService() {

            users = new HashMap<>();

            //Tiger Woods
            Researcher tiger = new Researcher("Tiger Woods", "tiger.woods@sage.com", "1234");
            users.put(tiger.getEmail(), tiger);
            users.put(tiger.getFullName(), tiger);
            users.put(tiger.getFullName().toLowerCase(), tiger);

            //Joe Bloogs
            Researcher joe = new Researcher("Joe Bloogs", "joe.bloogs@sage.com", "1234");
            users.put(joe.getEmail(), joe);
            users.put(joe.getFullName(), joe);
            users.put(joe.getFullName().toLowerCase(), joe);

            //test login
            Researcher test = new Researcher("Test User", "a", "a");
            users.put(test.getEmail(), test);
            users.put(test.getFullName(), test);
            users.put(test.getFullName().toLowerCase(), test);
        }

        public boolean login(Scanner scanner) {

            System.out.println("********************************************************************************************************************************");
            System.out.println();
            System.out.println("++++ SAGE LOGIN ++++");
            System.out.println();
            System.out.print("Enter the login details provided at registration and press Enter");
            System.out.println();
            System.out.print("Your Email Address or Full Name: ");
            String userName = scanner.nextLine();

            System.out.print("Your Password: ");
            String password = scanner.nextLine();


            // Login check carried out using this code
            Researcher user = users.get(userName);
            if  (user == null || !user.getPassword().equals(password)) {

                System.out.println("Login Failed! Do you want to reset your password?");
                System.out.println("Select 1 = Yes");
                System.out.println("Select 2 = No");

                int answer = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                if (answer == 1) {

                    System.out.print("Enter your new password: ");
                    String newPassword = scanner.nextLine();

                    if (newPassword.equals(user != null ? user.getPassword() : "")) {
                        System.out.println("Do not use your previous password!");
                        System.out.print("Enter a different password: ");
                        newPassword = scanner.nextLine();
                    }

                    if (user != null) {
                        user.setPassword(newPassword);
                    }

                    System.out.println("Your Password has been reset");
                    return true;

                } else {
                    System.out.println("Login Failed the program is now Exiting");
                    return false;
                }
            }

            System.out.println("Successfully logged in!");
            return true;
            }
        }

