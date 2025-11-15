package service;

import models.Researcher;
import java.util.HashMap;
import java.util.Scanner; //This is used to read the input from the Researcher/User

//Log in creation - https://medium.com/@edanurgurgen94/creating-user-login-with-java-3272197fe507 accessed 14/11/2025

    public class LoginService {

        //https://www.w3schools.com/java/java_hashmap.asp accessed 12/11/2025
        private HashMap<String, Researcher> users= new HashMap<>();

        //LoginService constructor which will run when the service is created/initiated
        public LoginService() {

            //These are example users that are added to the user map by the application as there is no Auth service or user creation set up
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

        //This is the log in stage of the program
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


            // Login check on the details provided handled by using this code
            //The Researcher is checked against the hash map. If the details do not match the Researcher cant log in
            Researcher user = users.get(userName);
            if (user == null || !user.getPassword().equals(password)) {
                System.out.println("Login Failed the program is now Exiting");
                return false;

            }
            System.out.println("Successfully logged in!");
            return true;
            }
        }

