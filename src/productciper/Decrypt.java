/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productciper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Gangani
 */
public class Decrypt {
    public void Decrypt()throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter IP:");
        String ip = obj.readLine();
        System.out.println("Enter Key 1:");
        int k1 = Integer.parseInt(obj.readLine());
        System.out.println("Enter Key 2:");
        int k2 = Integer.parseInt(obj.readLine());


        List<String> words = Arrays.asList(ip.split(" "));
        unshuffle(words,new Random(k2));
        
        String output="";
        for (int i = 0; i < words.size(); i++) {
            String word = (String) words.get(i);
            String wrd = replacing(word,k1);
            if (i!=0){
                output = output +" "+ wrd;
            }
            else{
                output = output + wrd;
            }
	}
        System.out.println(output);

    }
    
    String replacing(String line, int k){
        StringBuilder str = new StringBuilder();
        int len = line.length();
        char strn;
        int t1;
        for(int i=0;i<len;i++)
        {
            strn = line.charAt(i);
            if(Character.isUpperCase(strn))
            {
                t1 = (int)strn - (int)'A';
                t1 = (t1 - k +26)%26;
                t1 = t1 + (int)'A';
                strn = (char)t1;
                str.append(strn);
            }
            else if(Character.isLowerCase(strn))
            {
                t1 = (int)strn - (int)'a';
                t1 = (t1 - k+26)%26;
                t1 = t1 + (int)'a';
                strn = (char)t1;
                str.append(strn);
            }
            else
            {
                str.append(strn);
            }
        }
        String output = str.toString();
        return output;
    }
    
    private static <T> void unshuffle(List<T> list, Random rnd) {
        int[] seq = new int[list.size()];
        for (int i = seq.length; i >= 1; i--) {
            seq[i - 1] = rnd.nextInt(i);
        }
        for (int i = 0; i < seq.length; i++) {
            Collections.swap(list, i, seq[i]);
        }
    }
    
}
