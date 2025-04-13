import org.junit.Test;

import static org.junit.Assert.*;

public class AESTest {

    private final String base64key = "1ATOackXaQrNsEyIhpb8mM+ntxZsT/eqGinytXaXNm4=";

    @Test
    public void assertEncryption() throws Exception {
        String encryptedMessage = AES.encrypt("Hello", base64key);
        assertEquals(AES.decrypt(encryptedMessage, base64key), "Hello");

        encryptedMessage = AES.encrypt("Hello there", base64key);
        assertEquals(AES.decrypt(encryptedMessage, base64key), "Hello there");

        encryptedMessage = AES.encrypt("Bonjour, j'aime les croques-monsieurs. 12345 ## @@", base64key);
        assertEquals(AES.decrypt(encryptedMessage, base64key), "Bonjour, j'aime les croques-monsieurs. 12345 ## @@");
    }

    @Test
    public void assertDecryption() throws Exception {
        String encryptedMessage = "Vw9DfjDGW5FGMBADJ9mI/tDth2ZzKMPap2/A4VRxkz8=";
        assertEquals(AES.decrypt(encryptedMessage, base64key), "Hello");

        encryptedMessage = "Z2/gci5EysJtfeBtCx2rlaAKycI6UELhHkjd3XrBL8U=";
        assertEquals(AES.decrypt(encryptedMessage, base64key), "Hello there");

        encryptedMessage = "LGCQVPb7iXMjcsPvy0NhSlgosp890901oTQcdjV05xRFPDQJdxI5QXjrhF/F/ibDyyhnVyK+Io0ALBQtSzwsmTUFI7ht9fdT28QhfsehaFo=";
        assertEquals(AES.decrypt(encryptedMessage, base64key), "Bonjour, j'aime les croques-monsieurs. 12345 ## @@");
    }

}