package tinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class Staircase {
    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, t;
        while (true) {
            try {
                String s = scan.nextLine();
                String[] a = s.split(" ");
                n = Integer.parseInt(a[0]);
                t = Integer.parseInt(a[1]);
                if (n < 2 || t > 100) System.out.println("Число сотрудников должно быть не меньше 2, а время ухода должно быть не больше 100");
                else break;
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод данных. Введите 2 целых положительных числа");
            }
        }

        int[] arr = new int[n];
        while (true) {
            try {
                String s = scan.nextLine();
                String[] a = s.split(" ");
                for (int i=0; i<a.length; i++) {
                    arr[i] = Integer.parseInt(a[i]);
                    if (arr[i]<=0) throw new Exception();
                }
                if (a.length!=n) throw new Exception();
                else break;
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод данных. Введите целые положительные числа, разделенные пробелом, по количеству сотрудников");
            }
        }

        int big_pot;
        while (true) {
            try {
                String s = scan.next();
                int x = Integer.parseInt(s);
                if (x>n || x<1) System.out.println("Что-то не сошлось. Не могу найти сотрудника с таким номером");
                else {
                    big_pot = arr[x-1];
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод данных. Введите целое положительное число");
            }
        }

        Arrays.sort(arr);
        int max = arr[n-1];
        int min = arr[0];
        int floors;
        if (big_pot-min < t || max-big_pot < t) floors = max-min;
        else if (big_pot-min < max-big_pot) floors = big_pot-min + (max-min);
        else floors = max-big_pot + (max-min);

        System.out.println(floors);
    }
}
