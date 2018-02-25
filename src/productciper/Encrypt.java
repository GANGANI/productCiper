/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productciper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Gangani
 */
public class Encrypt {
    public void Encrypt()throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter IP:");
        String ip = obj.readLine();
        String op = "";
        
        Random ranNum2 = new Random();
        int  n = ranNum2.nextInt(100) + 1;
        System.out.println("key 2 = "+n);
        List strLis = Devide(ip,new Random(n));
        
        
        
        String output = "";
        Random num = new Random();
        int  ranNum = num.nextInt(25) + 1;
        System.out.println("key 1 = "+ranNum);
        for (int i = 0; i < strLis.size(); i++) {
            String word = (String) strLis.get(i);
            String wrd = replacing(word,ranNum);
            if(i!=0){
                output = output + " " + wrd;
            }
            else{
                output = output + wrd;
            }
	}
        System.out.println(output);
    }
    
    String replacing(String word, int ranNum){
        StringBuilder str = new StringBuilder();
        int len = word.length();
        char strn;
        int t1;

        for(int i=0;i<len;i++)
        {
            strn = word.charAt(i);
            if(Character.isUpperCase(strn))
            {
                t1 = (int)strn - (int)'A';
                t1 = (t1 + ranNum)%26;
                t1 = t1 + (int)'A';
                strn = (char)t1;
                str.append(strn);
            }
            else if(Character.isLowerCase(strn))
            {
                t1 = (int)strn - (int)'a';
                t1 = (t1 + ranNum)%26;
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
    
    public static List Devide(String text,Random num){
        List<String> words = Arrays.asList(text.split(" "));
        Collections.shuffle(words, num);
        return words;
    }
    
    private void keyGenerator(int x,int y){
        
    }
}
