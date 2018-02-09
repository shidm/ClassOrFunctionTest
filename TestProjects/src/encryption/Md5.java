package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public static String getMd5(String message,int code) {
        MessageDigest md5;
        byte[] newPwd = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            if (code == 0) {
                md5.update(message.getBytes());
                newPwd = md5.digest();
            }else
                newPwd = md5.digest(message.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < newPwd.length; i++) {
            if (Integer.toHexString(0xFF & newPwd[i]).length() == 1)
                s.append("0").append(Integer.toHexString(0xFF & newPwd[i]));
            else
                s.append(Integer.toHexString(0xFF & newPwd[i]));
        }
        return s.toString() ;
    }
}
