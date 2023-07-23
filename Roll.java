package tinkoff;

import java.util.Scanner;

public class Roll {
    public static void main (String[] args) {

        //Почему Ваня внезапно становится Костей?

        int n;

        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                String s = scan.next();
                n = Integer.parseInt(s);
                if (n<1) System.out.printf("Как можно поделить рулет на %d частей? Давайте еще раз \n", n);
                else break;
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод данных. Введите одно целое число не больше 2х10^9");
            }
        }

        double cuts = Math.log(n)/Math.log(2);
        System.out.println((int)Math.ceil(cuts));
    }
}
