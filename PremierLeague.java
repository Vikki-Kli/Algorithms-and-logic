package kontur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PremierLeague {
    final static byte WIN_POINTS = 3;
    final static byte DRAW_POINTS = 1;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        byte teamsCount = Byte.parseByte(scan.nextLine());
        String input;
        String[] inputArr;
        ArrayList<Points> tournamentTable = new ArrayList<>();

        for (int i = 0; i < teamsCount; i++) {
            input = scan.nextLine();
            inputArr = input.split(" ");
            tournamentTable.add(new Points(inputArr[0], Short.parseShort(inputArr[1])));
        }

        input = scan.nextLine();
        inputArr = input.split("-");
        String teamAName = inputArr[0];
        String teamBName = inputArr[1];
        byte victory = 0, draw = 0, loss = 0;

        //блок для победы команды А
        for (Points i : tournamentTable) {
            if (i.teamName.equals(teamAName)) {
                i.teamPoints += WIN_POINTS;
            }
        }
        Collections.sort(tournamentTable);
        victory = (byte)(tournamentTable.indexOf(findByName(tournamentTable, teamAName)) + 1);

        //блок для победы команды В
        for (Points i : tournamentTable) {
            if (i.teamName.equals(teamAName)) {
                i.teamPoints -= WIN_POINTS;
            }
            if (i.teamName.equals(teamBName)) {
                i.teamPoints += WIN_POINTS;
            }
        }
        Collections.sort(tournamentTable);
        loss = (byte)(tournamentTable.indexOf(findByName(tournamentTable, teamAName)) + 1);

        //блок для ничьей
        for (Points i : tournamentTable) {
            if (i.teamName.equals(teamAName)) {
                i.teamPoints += DRAW_POINTS;
            }
            if (i.teamName.equals(teamBName)) {
                i.teamPoints += -WIN_POINTS + DRAW_POINTS;
            }
        }
        Collections.sort(tournamentTable);
        draw = (byte)(tournamentTable.indexOf(findByName(tournamentTable, teamAName)) + 1);

        System.out.println(victory + " " + draw + " " + loss);
    }

    static Points findByName(ArrayList<Points> arrayList, String name) {
        Points points = null;
        for (Points i : arrayList) {
            if (i.teamName.equals(name)) {
                points = i;
            }
        }
        return points;
    }
}

class Points implements Comparable<Points> {

    String teamName;
    short teamPoints;

    Points(String teamName, short teamPoints) {
        this.teamName = teamName;
        this.teamPoints = teamPoints;
    }

    @Override
    public int compareTo(Points o) {
        int result = -1 * Short.compare(this.teamPoints, o.teamPoints);
        if (result == 0) {
            result = this.teamName.compareTo(o.teamName);
        }
        return result;
    }
}


