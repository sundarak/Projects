import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordManager = new PasswordManager<>();

        System.out.println("Enter Master Password");
        String masterPassword = scanner.nextLine();

        while (!passwordManager.checkMasterPassword(masterPassword)) {
            System.out.println("Enter Master Password");
            masterPassword = scanner.nextLine();
        }

        boolean running = true;
        while (running) {

            String command = scanner.nextLine();

            if ("New password".equals(command)) {

                String websiteName = scanner.nextLine();

                String password = scanner.nextLine();
                passwordManager.put(websiteName, password);
                System.out.println("New password added");
            } else if ("Get password".equals(command)) {

                String site = scanner.nextLine();
                String retrievedPassword = passwordManager.get(site);
                if (retrievedPassword != null) {
                    System.out.println(retrievedPassword);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if ("Delete account".equals(command)) {

                String deleteSite = scanner.nextLine();
                String removedPassword = passwordManager.remove(deleteSite);
                if (removedPassword != null) {
                    System.out.println("Account deleted");
                } else {
                    System.out.println("Account does not exist");
                }
            } else if ("Check duplicate password".equals(command)) {

                String checkPassword = scanner.nextLine();
                List<String> duplicateSites = passwordManager.checkDuplicate(checkPassword);
                if (duplicateSites.isEmpty()) {
                    System.out.println("No account uses that password");
                } else {
                    System.out.println("Websites using that password:");
                    for (String siteName : duplicateSites) {
                        System.out.println(siteName);
                    }
                }
            } else if ("Get accounts".equals(command)) {
                Set<String> accounts = passwordManager.keySet();
                if (accounts.isEmpty()) {
                    System.out.println("No accounts found");
                } else {
                    System.out.println("Your accounts:");
                    for (String account : accounts) {
                        System.out.println(account);
                    }
                }
            } else if ("Generate random password".equals(command)) {

                int length = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                String generatedPassword = passwordManager.generateRandomPassword(length);
                System.out.println(generatedPassword);
            } else if ("Exit".equals(command)) {
                running = false;
            } else {
                System.out.println("Command not found");
            }
        }
        scanner.close(); // Close the scanner when done
    }
}
