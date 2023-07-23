package kontur;

import java.util.Scanner;

public class ChildrensPlayground {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputArr = input.split(" ");
        final short HEIGHT = Short.parseShort(inputArr[0]);
        final short LENGTH = Short.parseShort(inputArr[1]);
        char[][] cityBLock = new char[HEIGHT][LENGTH];

        for (int i = 0; i < HEIGHT; i++) {
            String line = scan.nextLine();
            char[] lineArray = line.toCharArray();
            for (int j = 0; j < LENGTH; j++) {
                cityBLock[i][j] = lineArray[j];
            }
        }

        // ����: ����� ���������� �� ������� ������������� ����� �����, ���� ��� ����� ������� ���� - ������� ������.
        //
        // ��� �������� ���������� ������ ������, � ��� ��� �����, ������� ����� '.', �������� ��������� ��������:
        // ���� ��������� ������� � ������ ����� '.', ������������� ����� ��������. ����� ����� ���������, �����������
        // ������� ��� �����*1. ����� ����������� ����������� ������, �� �� � ������, � � ������� ��� ��������������.
        // ������� ����� �����, �� �� ����� ����������, ����� ����������� �������: �����*2. � ���, ���� � ���������
        // ����������� ������ ������ ��� �������������� �� ����� '*'. ����� ���� �������� ��������� �������������
        // �������, ���� �������� ���������� ������. �������� ����������� ��� ���� �����, ������ '.'
        int maxArea = 0;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (cityBLock[i][j] == '.') {
                    short playgroundHeight = 1;
                    short lastLength = 1;
                    short doubleI = (short)i;
                    short doubleJ = (short)j;

                    while (cityBLock[doubleI][doubleJ] == '.') {
                        short playgroundLength = 1;

                        while (cityBLock[doubleI][doubleJ+1] == '.') {
                            if (playgroundHeight != 1 && playgroundLength + 1 > lastLength) {
                                break;
                            }
                            doubleJ++;
                            playgroundLength++;
                        }
                        lastLength = playgroundLength;
                        int area = playgroundLength * playgroundHeight;
                        if (maxArea < area) maxArea = area;
                        doubleJ = (short)j;
                        doubleI++;
                        playgroundHeight++;
                    }
                }
            }
        }
        System.out.println(maxArea);
    }
}
