package konturexam;

import java.util.Arrays;
import java.util.Scanner;

public class Possessed {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] numbers = s.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int requiredSum = Integer.parseInt(numbers[1]);
        s = scan.nextLine();
        numbers = s.split(" ");
        int[] integers = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        int count = 0;

        for (int i = 0; i < integers.length; i++) {
            int zeroCount = 0;
            int sum = 0;
            for (int j = i; j < integers.length; j++) {
                if (integers[j] == 0) zeroCount++;
                sum += integers[j];
                if (zeroCount>1 || sum > requiredSum) break;
                count++;
            }
        }
        System.out.println(count);
    }
}
