/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security_gui;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author Hammad
 */
public class Playfair {

    private static char[][] Table;
    private static Point[] positions;


    public static void createTable(String key) {
        Table = new char[5][5];
        positions = new Point[26];

        String s = prepareText(key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        int len = s.length();
        for (int i = 0, k = 0; i < len; i++) {
            char c = s.charAt(i);
            if (positions[c - 'A'] == null) {
                Table[k / 5][k % 5] = c;
                positions[c - 'A'] = new Point( k / 5,k % 5);
                k++;
            }
        }
    }
    public static String prepareText(String s) {
        System.out.println(s);
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println(s.replace("J", "I"));
        return s.replace("J", "I");
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder(s);
        //nmhgf
        for (int i = 0; i < sb.length(); i += 2) {

            if (i == sb.length() - 1) {
                if(sb.length() % 2 == 1){
                    if(sb.charAt(i)=='X'){
                        sb.append('Z');
                    }else{
                        sb.append('X');
                    }
                }
                
            } else if (sb.charAt(i) == sb.charAt(i + 1)) {
                if (sb.charAt(i) == 'X') {
                    sb.insert(i + 1, 'Z');
                } else {
                    sb.insert(i + 1, 'X'); //بيضيف x بين المتكرر 

                }

            }
        }
        return codec(sb, 1);// 1 عشان انا هعمل شيفت لقدام 
    }

    public static String decode(String s) {
        return codec(new StringBuilder(s), 4); // 4 عشان هعمل شيفت لورى 
    }

    public static String codec(StringBuilder text, int direction) {

        int len = text.length();
        for (int i = 0; i < len; i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int row1 = positions[a - 'A'].x;
            int row2 = positions[b - 'A'].x;
            int col1 = positions[a - 'A'].y;
            int col2 = positions[b - 'A'].y;

            //لو الاتنين فى نفس الصف 
            if (row1 == row2) {
                col1 = (col1 + direction) % 5;
                col2 = (col2 + direction) % 5;
                // فى نفس العمود
            } else if (col1 == col2) {
                row1 = (row1 + direction) % 5;
                row2 = (row2 + direction) % 5;
                // بيبدل بينهم لو مش ف نفس الصف او العمود 
            } else {
                int tmp = col1;
                col1 = col2;
                col2 = tmp;
            }
            /*
             a b c
             e d x
             t y u
            
             */

            text.setCharAt(i, Table[row1][col1]);
            text.setCharAt(i + 1, Table[row2][col2]);
        }
        return text.toString();
    }
}
