package BT_TH;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Java_String_Reverse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        int i = 0; int j = A.length() - 1; boolean sw = true;
        while (i < j){
            if (A.charAt(i) != A.charAt(j)){
                System.out.println("No");
                sw = false;
                break;
            }
            i ++; j--;
        }
        if (sw)
            System.out.println("Yes");

    }
}







