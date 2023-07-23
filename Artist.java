package konturexam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Artist {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = scan.nextLine();
        List<Integer> integers = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();;
        System.out.println((integers.lastIndexOf(Collections.max(integers))+1) + " " + (integers.indexOf(Collections.min(integers))+1));
    }
}
