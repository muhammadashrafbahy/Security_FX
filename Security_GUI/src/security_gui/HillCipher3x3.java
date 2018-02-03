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
public class HillCipher3x3 {
    private int n = 26;
    
      public static int multinverse(int m ){
    String a1 = ""+m;
    String b1 = "26";
    BigInteger a = new BigInteger(a1);
    BigInteger b = new BigInteger(b1);
    BigInteger res = a.modInverse(b);
//    BigInteger res1 = a.mod(b);
    
    String q  = ""+res;
    int result = Integer.parseInt(q);
    
    return result;
    }
    
    public String encrypt(String str  , int key [][]){
   
        
    List<String> plaintext = new ArrayList<>();
    List<String> ciphertext = new ArrayList<>();
    
        for (int i = 0; i < str.length(); i++) {
            String s = "" + str.charAt(i);
          if (!s.equals(" ")) {
                
//                System.out.println(pt);
           plaintext.add(s);
            }
        }
        
        if (plaintext.size()%3 !=0) {
            //fghggg
        
     for (int start = 97; plaintext.size()%3 !=0; start++) {
      
            String character_padd =""+(char)start;    
         
            plaintext.add(character_padd);
         
        } 
        }
        System.out.println("plain text after padding = "+plaintext.toString());
        
    
      int  first  = (key[0][0])*((key[1][1]*key[2][2])-(key[1][2]*key[2][1]));
      int  second  = (key[0][1])*((key[1][0]*key[2][2])-(key[1][2]*key[2][0]));
      int  third  = (key[0][2])*((key[1][0]*key[2][1])-(key[1][1]*key[2][0]));
      
        int key_value= first - second +third;
              if (key_value>n) {
            key_value = key_value%n;
        }
        
while (key_value<0) {
            key_value = key_value+n;
        }
        
        System.out.println("key value = "+key_value);
        
        if (get_gcd(key_value, n)==1) {
            for (int i = 0; i < plaintext.size(); i+=3) {
                int f = i;
                int s = f+1;
                int t = s+1;
          int matrix_block [][]= {{getCharValue(plaintext.get(f))},{getCharValue(plaintext.get(s))},{getCharValue(plaintext.get(t))}};
          
          int c1 = (key[0][0]*matrix_block[0][0])+(key[0][1]*matrix_block[1][0])+(key[0][2]*matrix_block[2][0]);
          
          int c2 = (key[1][0]*matrix_block[0][0])+(key[1][1]*matrix_block[1][0])+(key[1][2]*matrix_block[2][0]);
          
          int c3 = (key[2][0]*matrix_block[0][0])+(key[2][1]*matrix_block[1][0])+(key[2][2]*matrix_block[2][0]);
          
          
          c1=c1%n;
          c2=c2%n;
          c3=c3%n;
          
          ciphertext.add(getValueChar(c1));
          ciphertext.add(getValueChar(c2));
          ciphertext.add(getValueChar(c3));
          
          
            }
            
            
        }
        
        
     String final_result = "";
        for (int i = 0; i < ciphertext.size(); i++) {
            final_result+=ciphertext.get(i);
            
        }
    
    return final_result;
    }
    
    public String decrypt(String str  , int key [][]){
   
        
    List<String> plaintext = new ArrayList<>();
    List<String> ciphertext = new ArrayList<>();
    
        for (int i = 0; i < str.length(); i++) {
            String s = "" + str.charAt(i);
             if (!s.equals(" ")) {
                
//                System.out.println(pt);
           plaintext.add(s);
            }
        }
        
//        if (plaintext.size()%3 !=0) {
//            
//        
//     for (int start = 97; plaintext.size()%3 !=0; start++) {
//      
//            String character_padd =""+(char)start;    
//         
//            plaintext.add(character_padd);
//         
//        } 
//        }
//        System.out.println("plain text after padding = "+plaintext.toString());
        
    
      int  first  = (key[0][0])*((key[1][1]*key[2][2])-(key[1][2]*key[2][1]));
      int  second  = (key[0][1])*((key[1][0]*key[2][2])-(key[1][2]*key[2][0]));
      int  third  = (key[0][2])*((key[1][0]*key[2][1])-(key[1][1]*key[2][0]));
      
        int key_value= first - second +third;
          while(key_value>n) {
            key_value = key_value%n;
        }
        
while (key_value<0) {
            key_value = key_value+n;
        }
        
        System.out.println("key value = "+key_value);
        
        int inverse = multinverse(key_value);
        System.out.println("inverse = "+inverse);
        key = mathinverse(key,inverse);
//        System.out.println(key[2][0]);
        if (get_gcd(key_value, n)==1) {
            for (int i = 0; i < plaintext.size(); i+=3) {
                int f = i;
                int s = f+1;
                int t = s+1;
          int matrix_block [][]= {{getCharValue(plaintext.get(f))},{getCharValue(plaintext.get(s))},{getCharValue(plaintext.get(t))}};
          
          int c1 = (key[0][0]*matrix_block[0][0])+(key[0][1]*matrix_block[1][0])+(key[0][2]*matrix_block[2][0]);
          
          int c2 = (key[1][0]*matrix_block[0][0])+(key[1][1]*matrix_block[1][0])+(key[1][2]*matrix_block[2][0]);
          
          int c3 = (key[2][0]*matrix_block[0][0])+(key[2][1]*matrix_block[1][0])+(key[2][2]*matrix_block[2][0]);
                System.out.println(c1);
          
          c1=c1%n;
          c2=c2%n;
          c3=c3%n;
            while (c1 < 0) {            
           c1=  c1+26;
        }
            while (c2 < 0) {            
           c2=  c2+26;
        }
            while (c3 < 0) {            
           c3=  c3+26;
        }
          ciphertext.add(getValueChar(c1));
          ciphertext.add(getValueChar(c2));
          ciphertext.add(getValueChar(c3));
          
          
            }
            
            
        }
        
        String final_result = "";
        for (int i = 0; i < ciphertext.size(); i++) {
            final_result+=ciphertext.get(i);
            
        }
    
    return final_result;
    }
    
    
     ///////////////////////////////////////////////operatin\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
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
   
    
    
    public static int [][] mathinverse(int matrix [][] , int inverse){
    int k00 =(matrix[1][1]*matrix[2][2])-(matrix[1][2]*matrix[2][1]); 
    int k01 =-((matrix[1][0]*matrix[2][2])-(matrix[1][2]*matrix[2][0])); 
    int k02 =(matrix[1][0]*matrix[2][1])-(matrix[1][1]*matrix[2][0]); 
   
//        while (k01 < 0) {            
//           k01=  k01+26;
//        }
    
    int k10 =-((matrix[0][1]*matrix[2][2])-(matrix[0][2]*matrix[2][1])); 
    int k11 =(matrix[0][0]*matrix[2][2])-(matrix[0][2]*matrix[2][0]); 
    int k12 =-((matrix[0][0]*matrix[2][1])-(matrix[0][1]*matrix[2][0])); 
//  while (k10 < 0) {            
//           k10=  k10+26;
//        }  
//  while (k12 < 0) {            
//           k12=  k12+26;
//        }
    int k20 =(matrix[0][1]*matrix[1][2])-(matrix[0][2]*matrix[1][1]); 
    int k21 =-((matrix[0][0]*matrix[1][2])-(matrix[0][2]*matrix[1][0])) ; 
    int k22 =(matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]); 
//          while (k21 < 0) {            
//           k21=  k21+26;
//        }
        int new_mtrx [][] ={{k00*inverse,k10*inverse,k20*inverse},{k01*inverse,k11*inverse,k21*inverse},{k02*inverse,k12*inverse,k22*inverse}};
        
    return new_mtrx;
    }
    
    
    
    public static void main(String[] args) {
        HillCipher3x3 h = new HillCipher3x3();
    String s = "fire" ;
    int matrix[][]={{1,3,1},{1,1,2},{2,3,4}};
        System.out.println(h.encrypt(s, matrix)) ;
//        System.out.println(h.decrypt(s, matrix)) ;
        
    }
    
}
