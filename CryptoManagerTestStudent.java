
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("I AM TESTING STRING BOUNDS"));
		assertFalse(CryptoManager.isStringInBounds("Hello JAVA!"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("OLSSV'QH]H(", CryptoManager.caesarEncryption("HELLO JAVA!", 7));
		assertEquals("V\")WJVN)R\\)SXJWWJ", CryptoManager.caesarEncryption("MY NAME IS JOANNA", 9));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO JAVA!", CryptoManager.caesarDecryption("OLSSV'QH]H(", 7));
		assertEquals("MY NAME IS JOANNA", CryptoManager.caesarDecryption("V\")WJVN)R\\)SXJWWJ", 9));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("5(5:=E=.9*O", CryptoManager.bellasoEncryption("HELLO JAVA!", "MCINNES"));
		assertEquals("0AR74A.N.6H<84B7/", CryptoManager.bellasoEncryption("MY NAME IS JOANNA", "CHRISTINE"));		
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("HELLO JAVA!", CryptoManager.bellasoDecryption("5(5:=E=.9*O", "MCINNES"));
		assertEquals("MY NAME IS JOANNA", CryptoManager.bellasoDecryption("0AR74A.N.6H<84B7/", "CHRISTINE"));
	}

}
