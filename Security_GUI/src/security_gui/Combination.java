/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security_gui;

/**
 *
 * @author osama fawzy
 */
public class Combination {
   
    public static String Encrption(String input){
        char[][] matrix = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'}
        };
        String[] special = {"a", "b", "c", "d", "e"};        
        input= input.replace("z", "q");
        
        String result = "";
        String final_result = "";
        String fh_result = "";
        String sh_result = "";
        char input1[] = input.toCharArray();

        for (int i = 0; i < input1.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (input1[i] == matrix[j][k]) {
                        result += special[j] + special[k];
                    }
                }
            }
        }
//        System.out.println(result);

        for (int i = 0; i < result.length() / 2; i++) {
            char[] new_result = result.toCharArray();
            fh_result += new_result[i];
        }

        for (int i = result.length() / 2; i < result.length(); i++) {
            char[] new_result = result.toCharArray();
            sh_result += new_result[i];
        }

//        System.out.println(fh_result);
//        System.out.println(sh_result);
        int f = 0;
        int s = 0;
        for (int i = 0; i < sh_result.length(); i++) {
            char temp = fh_result.charAt(i);
            char temp1 = sh_result.charAt(i);
//            System.out.println(temp);
//            System.out.println(temp1);

            for (int j = 0; j < special.length; j++) {
                if (special[j].equals(temp + "")) {
                    f = j;
                }
                if (special[j].equals(temp1 + "")) {
                    s = j;
                }
            }

            final_result += matrix[f][s];
        }
        System.out.println(final_result);

 
        return final_result;
    }

    public static String DEcreption(String input){
      
    char [][] matrix = {
                            {'a','b','c','d','e'},
                            {'f','g','h','i','j'},
                            {'k','l','m','n','o'},
                            {'p','q','r','s','t'},
                            {'u','v','w','x','y'}
                        };
        String [] special = {"a","b","c","d","e"};
        
//        String input = "vmedsno";
        String result="";
        String final_result="";
        
        char input1[] = input.toCharArray();
        
        String result1="";
        String result2="";
        
        for (int i = 0; i < input1.length; i++) {
            
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (input1[i]==matrix[j][k]) {
                       result1+=special[j];
                       result2+=special[k];
                    }
                }
            }
            
        }
        result= result1+result2;
//        System.out.println(result);
        
        int f =0;
        int s =0;
        for (int i = 0; i < result.length(); i=i+2) {
            char temp = result.charAt(i);
            char temp1 =result.charAt(i+1);
            
            for (int j = 0; j < special.length; j++) {
                if (special[j].equals(temp+"")) {
                    f=j;
                }
                if (special[j].equals(temp1+"")) {
                    s=j;
                }
            }
            
            final_result+=matrix[f][s];
        }
     
//        System.out.println(final_result);
        return final_result;
    }
}
