package tinkoffexame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Скучным считается ряд чисел, из которого можно убрать одно число, и остальные числа будут встречаться в нем одинаковое
// количество раз. На вход дается ряд чисел, определить, сколько первых его чисел представляют собой скучный ряд.


public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] numbers = s.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String number : numbers) {
            if (map.containsKey(number)) {
                Integer value = map.get(number);
                map.put(number, value + 1);
            } else {
                map.put(number, 1);
            }
        }
        for (int i = numbers.length-1; i >= 0; i--) {
            ArrayList<Integer> list = new ArrayList<>(map.values());
            boolean bool = true;
            int booleanCount = 0;
            for (int j = 0; j < list.size()-1; j++) {
                if (!list.get(j).equals(list.get(j+1)) && booleanCount == 0) {
                    booleanCount = -1;
                    list.set(j+1, list.get(j));
                }
                else if (!list.get(j).equals(list.get(j+1)) && booleanCount == -1) {
                    bool = false;
                    break;
                }
            }
            if (bool) {
                System.out.println(i+1);
                break;
            }
            Integer value = map.get(numbers[i]);
            if (value == 1) map.remove(numbers[i]);
            else map.put(numbers[i], value-1);
        }
    }
}
