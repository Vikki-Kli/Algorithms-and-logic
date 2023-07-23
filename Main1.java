package tinkoffexame;

import java.util.Scanner;

// На вход дается ряд чисел. Вывести YES, если они расположены в порядке неубывания или невозрастания, и NO в любом другом случае.

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] stringArr = s.split(" ");
        int signLast, signNow;
        String bool = "YES";
        for (int i = 0; i < stringArr.length; i++) {
            signLast = 0;
            signNow = 0;
            if (i!= stringArr.length-1) signNow = Integer.parseInt(stringArr[i]) - Integer.parseInt(stringArr[i+1]);
            if (i!=0) signLast = Integer.parseInt(stringArr[i-1]) - Integer.parseInt(stringArr[i]);
            if (signNow*signLast<0) {
                bool = "NO";
                break;
            }
        }
        System.out.println(bool);
    }
}

