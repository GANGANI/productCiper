/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productciper;

import java.io.*;

/**
 *
 * @author Gangani
 */
public class ProductCiper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Enter choice");
        System.out.append("1.Encryption\n2.Decryption\n");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int ch = Integer.parseInt(obj.readLine());
        if(ch==1)
        {
            Encrypt e = new Encrypt();
            e.Encrypt();
        }
        else if(ch==2)
        {
            Decrypt d = new Decrypt();
            d.Decrypt();
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
    
}
