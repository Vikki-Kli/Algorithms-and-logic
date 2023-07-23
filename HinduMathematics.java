package kontur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HinduMathematics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] charArray = str.toCharArray();
        ArrayList<Character> numbers = new ArrayList<>();
        for (char c : charArray) {
            numbers.add(c);
        }

        Collections.sort(numbers);
        String minStr = "";
        for (char i : numbers) {
            minStr += i;
        }
        int min = Integer.parseInt(minStr);

        Collections.reverse(numbers);
        String maxStr = "";
        for (char i : numbers) {
            maxStr += i;
        }
        int max = Integer.parseInt(maxStr);

        System.out.println(max-min);
    }
}
