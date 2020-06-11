
import java.util.*;
public class Cryto {
    public static void main(String [] args) {
        //System.out.println(normalizeText("This is some \"really\" great. (Text)!?"));
        String message = encryptString("I like apples", 2, 2);
        decryptString(message, 2);
    }

    // normalizes text to all uppercase, no punctuation or spaces
    public static String normalizeText(String message) {
        message = message.replaceAll("[^a-zA-Z ]", ""); // removes all punctuation
        message = message.replaceAll(" ", "").toUpperCase(); // removes spaces, makes uppercase
        return message;
    }

    // encrypts message with shifted alphabet
    public static String caesarify(String message, int key) {
        String newMessage = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] newAlphabet = shiftAlphabet(key); // get new shifted alphabet
        for (int i = 0; i < message.length(); i++) {
            newMessage += newAlphabet[alphabet.indexOf(message.charAt(i))]; // index of message char in alphabet
                                                                                // is index of new char in shifted alphabet
        }
        return newMessage;
    }

    // returns new alphabet that has been shifted by inputted amount
    public static char[] shiftAlphabet(int shift) {
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] newAlphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            newAlphabet[i] = alphabet[Math.floorMod(shift + i, 26)]; // place char in shifted index into newAlphabet
                                                                        // floorMod method accounts for negative shifts
        }
        return newAlphabet;
    }

    // returns encrypted message that has been grouped into specified size
    public static String groupify(String encryptedMessage, int groupSize) {
        String groupedMessage = "";
        while (encryptedMessage.length() % groupSize != 0) { // while message cannot be evenly split by groupSize
            encryptedMessage += "x";
        }
        for (int i = 0; i < encryptedMessage.length(); i+=groupSize) {
            groupedMessage += encryptedMessage.substring(i, i+groupSize) + " "; // split string into group size
        }
        return groupedMessage;
    }

    // normalizes, encrypts, and groups message
    public static String encryptString(String message, int shift, int groupSize) {
        String normalizedString = normalizeText(message);
        String encryptedMessage = caesarify(normalizedString, shift);
        return groupify(encryptedMessage, groupSize);
    }

    public static void decryptString(String encryptedMessage, int shiftedValue) {
        int newLength = encryptedMessage.indexOf('x'); // find start of filler x's
        String newMessage = encryptedMessage.substring(0, newLength); // remove x's
        
        newMessage = normalizeText(newMessage); // remove spaces

        System.out.println(caesarify(newMessage, shiftedValue * (-1))); // decrypt message by shifting the opposite of shift value
    }
}

