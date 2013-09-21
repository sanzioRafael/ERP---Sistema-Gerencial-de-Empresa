/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Rafael
 */
public class EncriptaSenha {
    
    public static String encripta(String senha) {
        try {
            /*
             *Digester criado com o algoritimo MD5
             * Além desse, o Java suporta ainda MD2, SHA, SHA-1, SHAg-256, SHA-384 e outros
             */
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //O metodo update adiciona bytes a mensagem a ser criptografada
            digest.update(senha.getBytes());
            /*
             * cria-se um encoder para impedir que a senha encriptada apareça
             * com  caracteres que costumam causar problemas em xml e alguns bancoa de dados
            */
            BASE64Encoder encoder = new BASE64Encoder();
            /*
             *O método digest.digest() retorna a mensagem encriptada
             * O método encoder.encode() retorna os caracteres problemáricos
             */
            return encoder.encode(digest.digest());
            
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
            return senha;
        }
    
    }
    
}
