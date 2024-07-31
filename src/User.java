import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class User {

    private  String username;
    private  String password;
    private Scanner scanner =new Scanner(System.in);
    public  User()
    {
        System.out.println("***** Welcome *****");
        System.out.println("enter username: ");
        username = scanner.nextLine();
        System.out.println("Hello "+ username + " ");
        setPassword();
    }

    public String getUsername() {
        return username;
    }

    public  String getPassword()
    {
        return password;
    }
    private void setPassword()
    {
        System.out.println("please enter password: ");
        password = scanner.nextLine();
        if (!isStrongPassword(password)) {
            System.out.println("password is not strong");
            setPassword();
        }
    }
    private boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");

        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);
        Matcher specialCharMatcher = specialCharPattern.matcher(password);

        return upperCaseMatcher.find() && lowerCaseMatcher.find() && digitMatcher.find() && specialCharMatcher.find();
    }
}

