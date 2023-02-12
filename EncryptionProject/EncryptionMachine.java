// Kylah Moon
// 10/19/21
// CSE 142
// TA: Jacob Berg - Section AU
// Take-home Assesment #3
// This program encrypts a user's message using a ceaser cypher with the use 
//of a class constant called 'SHIFT'. 

import java.util.*;

public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 8;

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        intro();
        entryKey(console);
        encryptionWords(console);
    }

    public static void intro(){
        System.out.println("Welcome to the CSE142 Encryption Machine!");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key so your recipient can decrypt.");
        System.out.println();
        System.out.println("Encrypted messages use a shared keyword to decrypt.");
    }

// This method prints out the entry key portion of the program.
   public static void entryKey(Scanner console){
        System.out.print("  Enter key: ");
        String word = console.next();
        
        String encryptLetter= "";

        System.out.print("    \"" + word + "\"" + " has been encrypted to: ");
        
        encryptLetterMethod(word); 
    }


// This method asks the user how many words they would like to encrypt and then encrypts them.
    public static void encryptionWords(Scanner console){
        System.out.println();
        System.out.print("How many words are in your message? ");
        int number = console.nextInt();
      
        String encryptLetter = "";
      
        for (int i = 1;  i <= number; i++){
            System.out.print("  Next word: ");
            String word = console.next();
            System.out.print("    \"" + word + "\"" + " has been encrypted to: ");
            encryptLetterMethod(word);
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }

// This method encrypts the word, letter by letter.
    public static void encryptLetterMethod (String word){
        for(int j = 0; j < word.length(); j++){
            char letter = word.charAt(j); 
            int numberOfLetter = (ALPHABET.indexOf(letter) + SHIFT) % ALPHABET.length();
            char encryptLetter = ALPHABET.charAt(numberOfLetter);
            System.out.print(encryptLetter);
        }
    }
}
    