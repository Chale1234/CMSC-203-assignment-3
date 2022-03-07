/**
 *  Class: CMSC203 CRN 21464
 Program: Assignment #3
 Instructor: Professor Ahmed Tarik
 Summary of Description: (This program encrypt and decrypt plain text using Caesar Cipher and Bellaso method) 
 Due Date: 03/07/2022 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 programmer : Enchalew Abebe


 * @author Enchalew abebe
 *
 */
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// declaring and assigning variable
		int size = plainText.length();
		boolean status = true;
		
		// for loop and if statement to determine whether the string is with in allowable range
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
			{
				// return false if characters is not in our limit
				status =  false;
			}
		}
		// return to true if character in allowable bound
		return status;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {

		//declaring and assign variable
		String encrypted = "";
		// key integer that specifies the off set
		key%=RANGE;
		
		// using for loop  and while loop to encrypt
		for (int index = 0; index < plainText.length(); index++) 
		{
			int encryptC = (int)plainText.charAt(index) + key;
			
			// the while loop determine if the encryptC is greater than Upper bound and decrement it with range.
			while(encryptC > (int) UPPER_BOUND) 
			{
				encryptC-=RANGE;
			}
			encrypted+=(char)encryptC;
		}
		// return the encrypted string
		return encrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		String encrypted = "";
		
		// for loop to offset the plain text and the upper case string to be encrypted
		for (int index = 0; index < plainText.length(); index++) 
		{
			int i = index % bellasoStr.length();
			int decryptB = plainText.charAt(index) + bellasoStr.charAt(i);
			
			// using while loop  specifies the offset
			while (decryptB > (int)UPPER_BOUND) {
				decryptB-=RANGE;
			}
			encrypted+=(char)decryptB;
		}
		// return the encrypted string
		return encrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		// declare variable
		String decrypted = "";
		// an integer key specifiers
		key%=RANGE;
		
		// using the for loop to decrypt  an  encrypted text
		for (int index = 0; index < encryptedText.length(); index++)
		{
			int encryptC = (char)(encryptedText.charAt(index) - key);
			while (encryptC < (int)LOWER_BOUND)
			{
				encryptC+=RANGE;
			}
			decrypted+=(char)encryptC;
		}
		//  return to the plain text string
		return decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// declare variable
		String decrypted = "";
		// use the for loop 
		for (int index = 0; index < encryptedText.length(); index++) 
		{
			int i = index % bellasoStr.length();
			int decryptB = encryptedText.charAt(index) - bellasoStr.charAt(i);
			 // use the while loop
			while (decryptB < (int) LOWER_BOUND) {
				decryptB+=RANGE;
			}
			// append string
			decrypted+=(char)decryptB;
		}
		// return decrypted
		return decrypted;
	}
}