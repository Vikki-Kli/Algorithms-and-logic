package tinkoffexame;

import java.util.ArrayList;
import java.util.Scanner;

// ���� ���������� � �������� ���� ������� � ������. �������� �������� � ��� ������� ��������� ������, ����� �����
// ������� � �������� �� ���� ������ ��������� ����. ���������� �������� ��������� ������, ���������� �������� �������.
// ����������, ������� ���������� �������� ���������� � ������� ����. �� ���� ������ ����� ������� � ���� ������ ����� ������.

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int count = Integer.parseInt(s);
        s = scan.nextLine();
        String[] stringArr = s.split(" ");
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(stringArr[i]);
        }
        ArrayList<Integer> listOfStarts = new ArrayList<>();
        ArrayList<Integer> listOfEnds = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int sum = 0;
            for (int j = i; j < count; j++) {
                sum += array[j];
                if (sum==0) {
                    listOfStarts.add(i);
                    listOfEnds.add(j);
                    break;
                }
            }
        }
        int countOfNormal = 0;
        for (int i = 0; i < listOfStarts.size(); i++) {
            if (i == 0) countOfNormal += 1 + listOfStarts.get(i) + count-1-listOfEnds.get(i)
                    + (listOfStarts.get(i) * (count-1-listOfEnds.get(i)));
            else countOfNormal += 1 + listOfStarts.get(i)-listOfStarts.get(i-1)-1 + count-1-listOfEnds.get(i)
                    + ((listOfStarts.get(i)-listOfStarts.get(i-1)-1) * (count-1-listOfEnds.get(i)));
        }
        System.out.println(countOfNormal);
    }
}
