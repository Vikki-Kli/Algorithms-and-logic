package kontur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agitation {
    public static void main(String[] args) {

        class Street {
            final ArrayList<Integer> paperedHouseNumbers = new ArrayList<>();
            int nextHouseForPapering = 1;

            void addHouseNumber(int number) {
                paperedHouseNumbers.add(number);
                if (nextHouseForPapering == number) {
                    while (paperedHouseNumbers.contains(nextHouseForPapering)) {
                        nextHouseForPapering++;
                    }
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        int countOfPaperedBuildings = Integer.parseInt(scan.nextLine());
        HashMap<String, Street> paperedStreets = new HashMap<>();
        Pattern letterPattern = Pattern.compile("([a-z]+)");
        Pattern numberPattern = Pattern.compile("(\\d+)");

        for (int i = 0; i < countOfPaperedBuildings; i++) {
            String input = scan.nextLine();
            Matcher letterMatcher = letterPattern.matcher(input);
            Matcher numberMatcher = numberPattern.matcher(input);
            letterMatcher.find();
            numberMatcher.find();
            String streetName = letterMatcher.group();
            int houseNumber = Integer.parseInt(numberMatcher.group());
            if (paperedStreets.containsKey(streetName)) {
                paperedStreets.get(streetName).addHouseNumber(houseNumber);
            }
            else {
                paperedStreets.put(streetName, new Street());
                paperedStreets.get(streetName).addHouseNumber(houseNumber);
            }
        }

        int countOfPosters = Integer.parseInt(scan.nextLine());
        String[] streetsForPapering = new String[countOfPosters];
        for (int i = 0; i < countOfPosters; i++) {
            String streetName = scan.nextLine();
            streetsForPapering[i] = streetName;
        }

        for (String streetName : streetsForPapering) {
            if (paperedStreets.containsKey(streetName)) {
                System.out.println(paperedStreets.get(streetName).nextHouseForPapering);
            }
            else {
                paperedStreets.put(streetName, new Street());
                System.out.println(paperedStreets.get(streetName).nextHouseForPapering);
            }
            paperedStreets.get(streetName).addHouseNumber(paperedStreets.get(streetName).nextHouseForPapering);

        }
    }
}
