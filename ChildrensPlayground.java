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

        // Суть: какой наибольший по площади прямоугольник можно найти, если его левый верхний угол - текущая ячейка.
        //
        // Код отдельно перебирает каждую ячейку, и для тех ячеек, которые равны '.', проходит следующий алгоритм:
        // пока следующие символы в строке равны '.', увеличивается длина площадки. Когда точки кончаются, вычисляется
        // площадь как длина*1. Затем проверяется нижележащая строка, но не с начала, а с символа под первоначальным.
        // Берется новая длина, но не более предыдущей, снова вычисляется площадь: длина*2. И так, пока в очередной
        // нижележащей строке символ под первоначальным не будет '*'. Среди всех итераций находится максимальнкая
        // площадь, цикл перебора сдвигается дальше. Алгоритм выполняется для всех ячеек, равных '.'
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
