
package tinkoff;

import java.util.ArrayList;
import java.util.Scanner;

public class Line {
    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        short n;
        while (true) {
            try {
                String s = scan.nextLine();
                n = Short.parseShort(s);
                if (n < 2 || n > 1000) System.out.println("Количество учеников должно быть от 2 до 1000");
                else break;
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод данных. Введите целое положительное число от 2 до 1000");
            }
        }

        int[] pupilsHeight = new int[n];
        while (true) {
            try {
                String s = scan.nextLine();
                String[] a = s.split(" ");
                for (int i=0; i<a.length; i++) {
                    pupilsHeight[i] = Integer.parseInt(a[i]);
                    if (pupilsHeight[i]<=0) throw new Exception();
                }
                if (a.length!=n) throw new Exception();
                else break;
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод данных. Введите целые положительные числа, разделенные пробелом, по количеству, которое указали выше");
            }
        }

        byte parity;
        ArrayList<Short> places = new ArrayList<>();
        for (short place = 1; place <= pupilsHeight.length; place++) {
            parity = (byte) (place%2);
            if (pupilsHeight[place-1]%2 != parity) {
                places.add(place);
            }
            if (places.size() > 2) {
                break;
            }
        }

        if (places.size() == 2) {
            System.out.println(places.get(0) + " " + places.get(1));
        }
        else if (places.size() == 0 && pupilsHeight.length > 2) {
            System.out.println("1 3");
        }
        else {
            System.out.println("-1 -1");
        }
    }
}
