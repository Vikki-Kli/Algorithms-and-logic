package tinkoffexame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// На вход дается строка, целиком состоящая из букв a, b, c и d. Хорошей подстрокой считается подстрока, содержащая все
// эти буквы хотя бы по одному разу. Определить, хорошую подстроку какой минимальной длины можно найти в исходной строке.
// Если хороших подстрок не найдено, вывести -1.

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        char[] charArr = s.toCharArray();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            switch (charArr[i]){
                case 'a' -> a.add(i);
                case 'b' -> b.add(i);
                case 'c' -> c.add(i);
                case 'd' -> d.add(i);
            }
        }
        if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()) {
            System.out.println("-1");
        }
        else {
            ArrayList<Integer> max = new ArrayList<>();
            max.add(Collections.max(a));
            max.add(Collections.max(b));
            max.add(Collections.max(c));
            max.add(Collections.max(d));
            boolean boolA = false, boolB = false, boolC = false, boolD = false;
            for (int i = Collections.min(max); i < charArr.length; i++) {
                switch (charArr[i]){
                    case 'a' -> boolA = true;
                    case 'b' -> boolB = true;
                    case 'c' -> boolC = true;
                    case 'd' -> boolD = true;
                }
                if (boolA && boolB && boolC && boolD) {
                    System.out.println(i-Collections.min(max)+1);
                    break;
                }
            }
            if (!(boolA && boolB && boolC && boolD)) System.out.println(-1);
        }
    }
}
