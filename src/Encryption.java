import java.util.Base64;
import java.util.Random;
import java.util.Scanner;

class Encryption extends User {
    private Scanner scanner = new Scanner(System.in);
    private String encryptedString;

    public void start() {
        System.out.println("Enter a string to encrypt: ");
        String inputString = scanner.nextLine();
        encryptedString = encrypt(inputString);
        System.out.println("Encrypted string: " + encryptedString);

        System.out.println("Do you want to decrypt the string? (yes/no)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            decrypt();
        }
    }

    private String encrypt(String str) {
        String randomString = generateRandomString(10);// Generate a random string of length 10
        String randomString2 = generateRandomString(10);
        String combinedString = randomString + "_:" + str + "_:" + getUsername() + "_:" + randomString2 + "_:" + getPassword();
        return Base64.getEncoder().encodeToString(combinedString.getBytes());
    }

    private void decrypt() {
        System.out.println("Enter your username: ");
        String inputUsername = scanner.nextLine();
        System.out.println("Enter your password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(getUsername()) && inputPassword.equals(getPassword())) {
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedString);
            String decodedString = new String(decodedBytes);
            // Split the decoded string using the delimiter
            String[] parts = decodedString.split("_:");
            if (parts.length == 5) {
                String originalString = parts[1];
                System.out.println("Decrypted string: " + originalString);
            } else {
                System.out.println("Decryption failed. Incorrect format.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private String generateRandomString(int length) {
        String characters = "!ABCD#EFGHIJKL@MN$OP&Q%RST*UVWXYZ-abcdefghijklmnopqrstuvwxyz+0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
