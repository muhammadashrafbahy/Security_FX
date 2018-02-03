/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combination;

/**
 *
 * @author osama fawzy
 */
public class de_combination {
    
    
    public static void main(String[] args) {
        
    
    
   
    char [][] matrix = {
                            {'a','b','c','d','e'},
                            {'f','g','h','i','j'},
                            {'k','l','m','n','o'},
                            {'p','q','r','s','t'},
                            {'u','v','w','x','y'}
                        };
        String [] special = {"a","b","c","d","e"};
        
        String input = "vmedsno";
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
     
        System.out.println(final_result);
}
    
}
