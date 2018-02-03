/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_gui;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author MUHAMMAD ASHRAF BAHY
 */
public class HillCipher2x2 {
    private int n = 26;
    
    
    public String decrypt(String str , int [][] key){
        

        List<String> plaintext = new ArrayList<>();
    
        List<String> ciphertext = new ArrayList<>();
        
     for (int i = 0; i < str.length(); i++) {
            String pt =""+str.charAt(i);
            if (!pt.equals(" ")) {
                
//                System.out.println(pt);
           plaintext.add(pt);
            }
        }
            if (plaintext.size()%2 !=0) {
            
        
      plaintext.add("a");
        }
        
        System.out.println("plain text after padding = "+plaintext.toString());
 
 
          //get ensure gcd(key , n)=1
       int key_value =(key[0][0]*key[1][1])-(key[0][1]*key[1][0]); 
//        System.out.println(key[0][0]);
//        System.out.println(key[0][1]);
//        System.out.println(key[1][0]);
//        System.out.println(key[1][1]);
        
        if (key_value>n) {
            key_value = key_value%n;
        }
        
  else      if (key_value<0) {
            key_value = key_value+n;
        }
        
       
        System.out.println("key value = "+key_value);
        
        
        int inverse= multinverse(key_value);
        System.out.println("inverse  = "+inverse);
//        System.out.println(key[1][1]+","+-key[0][1]+","+-key[1][0]+","+key[0][0]);
        int math_invers[][] = {{key[1][1]*inverse,-key[0][1]*inverse},{-key[1][0]*inverse,key[0][0]*inverse}};
        
        //operation
        if (get_gcd(key_value, n)==1) {
            
          for (int i = 0; i < plaintext.size(); i+=2) {
              int f = i;
//              System.out.println("size = "+plaintext.size());
//              System.out.println(plaintext.get(i)+","+plaintext.get(++i));
            int matrix_block[][] = {{getCharValue(plaintext.get(f))},{getCharValue(plaintext.get(++f))}} ;
//              System.out.println((key[0][0]+","+matrix_block[0][0])+","+(key[0][1]+","+matrix_block[1][0]));
             int c1 =(math_invers[0][0]*matrix_block[0][0])+(math_invers[0][1]*matrix_block[1][0]);
             int c2 =(math_invers[1][0]*matrix_block[0][0])+(math_invers[1][1]*matrix_block[1][0]);
                  c1 = c1%n;
                  c2 = c2%n;
                  while (c1<0){
                  c1+=26;
                  
                  }
                  while (c2<0){
                  c2+=26;
                  
                  }
                  ciphertext.add(getValueChar(c1));
                  ciphertext.add(getValueChar(c2));
//                System.out.println("c1="+c1);       
//                System.out.println("c2="+c2);       
            }
            
        }
     String final_result = "";
        for (int i = 0; i < ciphertext.size(); i++) {
            final_result+=ciphertext.get(i);
            
        }
    
    return final_result;
    }
    
    
    
    
    
    public String encrypt(String str , int [][] key){
 
        List<String> plaintext = new ArrayList<>();
    
        List<String> ciphertext = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {
            String pt =""+str.charAt(i);
             if (!pt.equals(" ")) {
                
//                System.out.println(pt);
           plaintext.add(pt);
            }
        }
            if (plaintext.size()%2 !=0) {
            
        
      plaintext.add("a");
        }
        
        System.out.println("plain text after padding = "+plaintext.toString());
 
          //get ensure gcd(key , n)=1
       int key_value =(key[0][0]*key[1][1])-(key[0][1]*key[1][0]); 
//        System.out.println(key[0][0]);
//        System.out.println(key[0][1]);
//        System.out.println(key[1][0]);
//        System.out.println(key[1][1]);
        
        while (key_value>n) {
            key_value = key_value%n;
        }
        
  while (key_value<0) {
            key_value = key_value+n;
        }
        
        
        System.out.println("key value = "+key_value);
 
        //operation
        if (get_gcd(key_value, n)==1) {
            
          for (int i = 0; i < plaintext.size(); i+=2) {
              int f = i;
//              System.out.println("size = "+plaintext.size());
//              System.out.println(plaintext.get(i)+","+plaintext.get(++i));
            int matrix_block[][] = {{getCharValue(plaintext.get(f))},{getCharValue(plaintext.get(++f))}} ;
//              System.out.println((key[0][0]+","+matrix_block[0][0])+","+(key[0][1]+","+matrix_block[1][0]));
             int c1 =(key[0][0]*matrix_block[0][0])+(key[0][1]*matrix_block[1][0]);
             int c2 =(key[1][0]*matrix_block[0][0])+(key[1][1]*matrix_block[1][0]);
                  c1 = c1%n;
                  c2 = c2%n;
                  ciphertext.add(getValueChar(c1));
                  ciphertext.add(getValueChar(c2));
//                System.out.println("c1="+c1);       
//                System.out.println("c2="+c2);       
            }
            
        }
     String final_result = "";
        for (int i = 0; i < ciphertext.size(); i++) {
            final_result+=ciphertext.get(i);
            
        }
    
    return final_result;
    }
  
    
    ///////////////////////////////////////////////operatin\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //17 , 26
    public static int get_gcd(int first , int second){
        if (second==0){return first;
            
        }
    return get_gcd(second, first%second);
    }
    
  
    public static String getValueChar(int s){
    
       //build the char
        List<String> char_list = new ArrayList<>();
    
//        HashMap<String, Integer >  char_list= new HashMap<String, Integer>();
        HashMap<Integer, String >  alphabet= new HashMap<Integer, String>();
        //small char
        for (int i = 97; i < 123; i++) {
            String str =""+(char)i;
//            System.out.println(str);
            char_list.add(str);
        }
        //Cap char
        for (int i = 0; i < 26; i++) {
            String str =char_list.get(i);
//            System.out.println(str);
            alphabet.put( i,str);
        }
        
        String val = alphabet.get(s);
        return val;
    }
    
    
    public static int getCharValue(String s){
    
       //build the char
        List<String> char_list = new ArrayList<>();
    
//        HashMap<String, Integer >  char_list= new HashMap<String, Integer>();
        HashMap<String, Integer >  alphabet= new HashMap<String, Integer>();
        //small char
        for (int i = 97; i < 123; i++) {
            String str =""+(char)i;
//            System.out.println(str);
            char_list.add(str);
        }
        //Cap char
        for (int i = 0; i < 26; i++) {
            String str =char_list.get(i);
//            System.out.println(str);
            alphabet.put(str, i);
        }
        
        int val = alphabet.get(s);
        return val;
    }
    
    public static int multinverse(int m ){
    String a1 = ""+m;
    String b1 = "26";
    BigInteger a = new BigInteger(a1);
    BigInteger b = new BigInteger(b1);
    BigInteger res = a.modInverse(b);
    String q  = ""+res;
    int result = Integer.parseInt(q);
    
    return result;
    }
    
    
    public static void main(String[] args) {
//        System.out.println(get_gcd(20, 26));
//        System.out.println(getCharValue("c"));
        
        HillCipher2x2 h = new  HillCipher2x2();
        int matrix [][]={{9,4},{5,7}};

      String s ="iopr";
//        System.out.println(  h.encrypt(s, matrix));
        System.out.println(  h.decrypt(s, matrix));
        
    }
    
}
