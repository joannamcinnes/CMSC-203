/*
 * Class: CMSC203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: CryptoManager is a utility class that encrypts and decrypts a phrase using two
 *    different approaches. The first approach is called the Caesar Cipher and is a
 *    simple "substitution cipher" where characters in a message are replaced by a
 *    substitute character. The second approach, due to Giovan Battista Bellaso,
 *    uses a key word, where each character in the word specifies the offset for
 *    the corresponding character in the message, with the key word wrapping around
 *    as needed.
 * Due: 07/08/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your name here: Joanna McInnes
 * 
 * @author originally Farnaz Eivazi
 * @version originally 7/16/2022
 * 
 * @author augmented by Joanna McInnes
 * @version updated 7/8/2024
 */

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	public static boolean isStringInBounds (String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
                return false;
            }
        }
        return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	
	public static String caesarEncryption(String plainText, int key) {
		
        // Test whether plainText is within the allowed bounds
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }  

        StringBuilder encryptedText = new StringBuilder();
        
        key = key % RANGE;  // Make sure that the key is within the allowed range
        for (char c : plainText.toCharArray()) {
            char encryptedChar = (char) (c + key);
            if (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		
	      // Test whether plainText is within the allowed bounds
        if (!isStringInBounds(plainText)) {
        	return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder encryptedText = new StringBuilder();
        
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char keyChar = bellasoStr.charAt(i % bellasoStr.length());
            int encryptedChar = (ch + keyChar) % RANGE + LOWER_RANGE;
            encryptedText.append((char) encryptedChar);
        }
        
//        for (int i = 0; i < plainText.length(); i++) {
//            char plainChar = plainText.charAt(i);
//            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
//            char encryptedChar = (char) (plainChar + bellasoChar);
//            while (encryptedChar > UPPER_RANGE) {
//                encryptedChar -= RANGE;
//            }
//            encryptedText.append(encryptedChar);
//       }
        return encryptedText.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	public static String caesarDecryption (String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        
        key = key % RANGE;  // Make sure that the key is within the allowed range
        for (char c : encryptedText.toCharArray()) {
            char decryptedChar = (char) (c - key);
            if (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append((char) decryptedChar);
        }
        return decryptedText.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
            
 //       for (int i = 0; i < encryptedText.length(); i++) {
 //          char encryptedChar = encryptedText.charAt(i);
 //           char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
 //           char decryptedChar = (char) (encryptedChar - bellasoChar);
 //           while (decryptedChar < LOWER_RANGE) {
 //               decryptedChar += RANGE;
 //           }
 //           decryptedText.append(decryptedChar);
 //       }
        
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            char keyChar = bellasoStr.charAt(i % bellasoStr.length());
            int decryptedChar = (ch - keyChar + RANGE) % RANGE + LOWER_RANGE;
            decryptedText.append((char) decryptedChar);
        }
        
        return decryptedText.toString();
	}
}
