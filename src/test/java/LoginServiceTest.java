//Import of standard Java classes
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.LoginService;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LoginServiceTest {

    // Helper method to simulate user input for Scanner
    private Scanner mockInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        return new Scanner(in);
    }

    //Test 4 - Test Working
    @Test
    public void test_Login_Success_Using_Email() {
        LoginService service = new LoginService();

        // "tiger.woods@sage.com" = email, "1234" = password
        Scanner scanner = mockInput("tiger.woods@sage.com\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertTrue(result);
    }

    //Test 5 - Test Working
    @Test
    public void test_Login_Failed_Using_Wrong_Email() {
        LoginService service = new LoginService();

        // "tiger.mcllory@sage.com" = email, "sage123" = password
        Scanner scanner = mockInput("tiger.mcllory@sage.com\nsage123\n");

        boolean result = service.login(scanner);
        Assertions.assertFalse(result);
    }

    //Test 6 - Test Working
    @Test
    public void test_Login_Success_Using_FullName() {
        LoginService service = new LoginService();

        // User stored as: "Tiger Woods"
        Scanner scanner = mockInput("Tiger Woods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertTrue(result);
    }

    //Test 7 - Test Working
    @Test
    public void test_Login_Failed_Using_Not_FullName() {
        LoginService service = new LoginService();

        // Test User stored as: "Tiger"
        Scanner scanner = mockInput("Tiger\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertFalse(result);
    }

    //Test 8 - Test Working
    @Test
    public void test_Login_Success_Using_Correct_Password() {
        LoginService service = new LoginService();

        Scanner scanner = mockInput("Tiger Woods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertTrue(result);
    }

    //Test 9 - Test Working
    @Test
    public void test_Login_Fail_Using_Incorrect_Password() {
        LoginService service = new LoginService();

        Scanner scanner = mockInput("Tiger Woods\nplymouth\n");

        boolean result = service.login(scanner);
        Assertions.assertFalse(result);
    }

    //Test 10 - Test Working
    @Test
    public void test_Login_Success_Is_A_Registered_FullName() {
        LoginService service = new LoginService();

        Scanner scanner = mockInput("Tiger Woods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertTrue(result);
    }

    //Test 11 - Test Working
    @Test
    public void test_Login_Fails_Not_A_Registered_FullName() {
        LoginService service = new LoginService();

        Scanner scanner = mockInput("Bubba Watson\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertFalse(result);
    }

    //Test 12 - Test Working
    @Test
    public void test_Login_With_LowerCase_FullName() {
        LoginService service = new LoginService();

        // Researcher was added as "tiger woods"
        Scanner scanner = mockInput("tiger woods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertTrue(result);

    }
    //Test 13 - Test Working
    @Test
    public void test_Login_With_UpperCase_FullName() {
        LoginService service = new LoginService();

        // Researcher was added as "Tiger Woods"
        Scanner scanner = mockInput("Tiger Woods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertTrue(result);
    }

    //Test 14 - Test Working
    @Test
    public void test_Login_Failed_With_Mixture_UpperCase_LowerCase_FullName() {
        LoginService service = new LoginService();

        Scanner scanner = mockInput("tiger Woods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertFalse(result);
    }

    //Test 15 - Test Working
    @Test
    public void test_Login_Failed_Using_Incorrectly_Spelt_FullName() {
        LoginService service = new LoginService();

        Scanner scanner = mockInput("Tigger Wooods\n1234\n");

        boolean result = service.login(scanner);
        Assertions.assertFalse(result);
    }
}
