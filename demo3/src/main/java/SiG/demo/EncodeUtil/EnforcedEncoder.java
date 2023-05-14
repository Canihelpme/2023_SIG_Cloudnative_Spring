package SiG.demo.EncodeUtil;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
@Log4j2
public class EnforcedEncoder implements PasswordEncoder, SimplePasswordEncoder {

    @Override
    public String encryptPassword(final String password){

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }
        assert messageDigest != null;
        messageDigest.update(generateSalt());
        messageDigest.update(password.getBytes());
        return String.format("%064x", new BigInteger(1, messageDigest.digest()));
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    } //SHA-512 암호화 로직


    @Override
    public String simpleEncryptPassword(final String password) {

        final StringBuilder sb = new StringBuilder();

        for(byte b : password.getBytes(StandardCharsets.UTF_8)) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }


}