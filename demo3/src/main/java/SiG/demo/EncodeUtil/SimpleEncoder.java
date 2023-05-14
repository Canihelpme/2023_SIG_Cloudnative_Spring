package SiG.demo.EncodeUtil;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

public class SimpleEncoder implements PasswordEncoder {

    @Override
    public String encryptPassword(final String password) {

        final StringBuilder sb = new StringBuilder();

        for(byte b : password.getBytes(StandardCharsets.UTF_8)) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

}



