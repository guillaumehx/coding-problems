import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class AES {

    public static String encrypt(final String message, final String base64Key) throws Exception {

        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, convertStringToKey(base64Key), ivSpec);
        byte[] cipherText = cipher.doFinal(message.getBytes());

        // Concatenate IV and ciphertext
        byte[] result = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        System.arraycopy(cipherText, 0, result, iv.length, cipherText.length);

        return Base64.getEncoder().encodeToString(result);
    }

    public static String decrypt(final String base64EncryptedMessage, final String base64Key) throws Exception {

        byte[] combined = Base64.getDecoder().decode(base64EncryptedMessage);
        byte[] iv = new byte[16];
        byte[] cipherText = new byte[combined.length - 16];

        System.arraycopy(combined, 0, iv, 0, 16);
        System.arraycopy(combined, 16, cipherText, 0, cipherText.length);

        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, convertStringToKey(base64Key), ivSpec);
        byte[] decrypted = cipher.doFinal(cipherText);

        return new String(decrypted);
    }

    public static void encryptFile(String inputFilePath, String outputFilePath, String base64Key) throws Exception {

        File inputFile = new File(inputFilePath);
        byte[] fileContent = Files.readAllBytes(inputFile.toPath());

        String fileContentString = Base64.getEncoder().encodeToString(fileContent);
        String encryptedContent = encrypt(fileContentString, base64Key);

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(encryptedContent.getBytes());
        }

        System.out.println("File successfully encrypted : " + outputFilePath);
    }

    public static void decryptFile(String inputFilePath, String outputFilePath, String base64Key) throws Exception {

        File inputFile = new File(inputFilePath);

        String encryptedContent = new String(Files.readAllBytes(inputFile.toPath()));
        String decryptedContent = decrypt(encryptedContent, base64Key);

        byte[] fileContent = Base64.getDecoder().decode(decryptedContent);
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(fileContent);
        }

        System.out.println("File successfully decrypted : " + outputFilePath);
    }

    private static Key convertStringToKey(final String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        if (keyBytes.length != 32) {
            throw new Exception("Expected key length of 32 bytes (256 bits), actual length was " + (keyBytes.length * 8) + " bits.");
        }
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static void main(String[] args) throws Exception {
        //encryptFile("C:\\Users\\guill\\Downloads\\drone.txt", "C:\\Users\\guill\\Downloads\\drone_crypted.txt", "1ATOackXaQrNsEyIhpb8mM+ntxZsT/eqGinytXaXNm4=");
        //decryptFile("C:\\Users\\guill\\Downloads\\drone_crypted.txt", "C:\\Users\\guill\\Downloads\\drone_crypted_decrypted.txt", "1ATOackXaQrNsEyIhpb8mM+ntxZsT/eqGinytXaXNm4=");
    }

}
