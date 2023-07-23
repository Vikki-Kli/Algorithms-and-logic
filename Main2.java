package tinkoffexame;

import java.util.Scanner;

// В компании есть n джунов и m сеньоров. Каждая программа, написанная джуном, должна пройти проверки от сеньоров k раз.
// Один сеньор не может проверять одновременно две программы, и одну программу не могут проверять два сеньора одновременно.
// Любой из сеньоров тратит на проверку любой программы 1 минуту. Если каждый из джунов напишет по программе, сколько времени
// потребуется сеньорам, чтобы проверить их все? На вход даются числа n, m и k через пробелы.

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(arr[2]);
        int checkCount = 0;
        int seniorNumber = 1;
        int time = 0;
        for (int i = 1; i <= n; i++) {
            if (seniorNumber==1) time++;
            if (i==n) {
                checkCount++;
                i = 0;
            }
            if (checkCount==k) break;
            if (seniorNumber==m) seniorNumber=1;
            else seniorNumber++;
        }
        System.out.println(time);
    }
}
