package encoding;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;

/**
 * packageName    : encoding
 * fileName       : AESType
 * author         : jaeminlim
 * date           : 2022/07/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/07/27        jaeminlim       최초 생성
 */
public class AESType {

    public String encodeAes(String planeText, String secretKey) {
        String encryptText;
        try {
            Key key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
            // CBC 타입을 사용하고, 패딩 알고리즘은 PKCS5Padding 방식을 선택
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // CBC 타입에 필요한 IV 값은 비밀키 앞의 16자리를 사용
            String iv = secretKey.substring(0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));

            byte[] encrypted = cipher.doFinal(planeText.getBytes(StandardCharsets.UTF_8));
            encryptText = DatatypeConverter.printBase64Binary(encrypted);
        } catch (GeneralSecurityException e) {
            // throws가 싫어서 RuntimeException을 사용
            throw new RuntimeException(e);
        }
        return encryptText; 
    }

    public static void main(String[] args) {
        final String secretKey = "bbubbush!@#$%^&*";
        AESType aesType = new AESType();
        String encKey = aesType.encodeAes("01056635346", secretKey);
        System.out.println(encKey);
    }


}
