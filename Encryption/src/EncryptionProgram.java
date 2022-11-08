import java.util.*;

public class EncryptionProgram {
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffled;
    private char character;
    private String line;
    private char[] letters;

    EncryptionProgram() {
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffled = new ArrayList<>();
        character = ' ';

        newKey();
        askQuestion();
    }

    private void askQuestion() {
        while(true) {
            System.out.println("************************************************************");
            System.out.println("What do you want to do? ");
            System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt((0)));

            switch(response) {
                case 'N' -> newKey();
                case 'G' -> getKey();
                case 'E' -> encrypt();
                case 'D' -> decrypt();
                case 'Q' -> quit();
                default -> System.out.println("Not a valid answer :(");
            }
        }
    }

    private void newKey() {
        character = ' ';
        list.clear();
        shuffled.clear();

        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }

        shuffled = new ArrayList<>(list);
        Collections.shuffle(shuffled);
        System.out.println("*A new key has been generated*");
    }

    private void getKey() {
        System.out.println("Key: ");
        for(Character x : list) {
            System.out.print(x);
        }

        System.out.println();
        for(Character x : shuffled) {
            System.out.print(x);
        }

        System.out.println();
    }

    private void encrypt() {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffled.get(j);
                    break;
                }
            }
        }

        System.out.println("Encryption: ");
        for (char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void decrypt() {
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffled.size(); j++) {
                if (letters[i] == shuffled.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        System.out.println("Decryption: ");
        for (char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void quit() {
        System.out.println("Thank you, have a nice day bro :D");
        System.exit(0);
    }
}
