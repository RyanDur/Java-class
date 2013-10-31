import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailServer {
    private String from = "";
    private String to = "";
    private String message = "";
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean valid(String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public MailServer() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public void setFrom(String email) {
        from = email;
    }

    public void setTo(String email) {
        this.to = email;
    }

    public void setMessage(String message) {
        this.message += message;
    }

    public boolean ready() {
        if(from != "" && to != "") {
            return true;
        }
        return false;
    }

    public void printMessage() {
        System.out.println(from);
        System.out.println(to);
        System.out.println(message);
    }

    public void sendMessage() {
        System.out.println("Sending email...");
        printMessage();
    }

    public void header(String input) {
        String[] splitInput = input.split(":");
        String head = splitInput[0];
        String email = splitInput[1].trim();

        if(valid(email)) {
            if(head.equals("MAIL FROM")) {
                setFrom(input);
                System.out.println("OK");
            } else if(head.equals("RCPT TO")) {
                setTo(input);
                System.out.println("OK");
            } else {
            }
        } else {
            System.out.println("Invalid email address");
        }
    }

    public void readyMail() {
        Console console = System.console();
        String input = "";
        while(!input.equals("QUIT")) {
            input = console.readLine();
            if(input.equals("DATA")) {
                if(ready()) {
                    printMessage();
                } else {
                    System.out.println("Invalid command.");
                }
            }
            if(ready() && input.equals(".")) {
                sendMessage();
            } else if(input.contains(":")){
                header(input);
            } else {
                setMessage(input);
            }
        }
    }

    public static void main(String []args) {
        MailServer ms = new MailServer();
        System.out.println("Welcome to My Mail Server!");

        ms.readyMail();
    }
}
