package kontur;

import java.util.ArrayList;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] arg) {

        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        ArrayList<Short> numbers = new ArrayList<>();
        for (int i=0; i<count; i++) {
            short number = scan.nextShort();
            short numberNegative = (short) (-1*number);
            if (numbers.contains(numberNegative)) {
                numbers.remove(Short.valueOf(numberNegative));
            }
            else {
                numbers.add(number);
            }
        }
        System.out.println(numbers.get(0)*-1);
    }
}
