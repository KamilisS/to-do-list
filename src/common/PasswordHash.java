/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gvt48
 */
public class PasswordHash {
    
    public static String hashPassword(String password, String email) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordHash.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
        StringBuilder ps = new StringBuilder(password);
        ps.insert(0, email.charAt(0));
        password = ps.toString() + email.charAt(1);
        
        messageDigest.update(password.getBytes());
        byte[] result = messageDigest.digest();
        
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
    
}
