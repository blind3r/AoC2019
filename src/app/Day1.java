package app;

import java.util.List;

public class Day1 {

    public static final String FILE_NAME = "day1";

    public int part1(List<String> moduleList) {
        int total = 0;
        for (String moduleMass : moduleList) {
            total += calculateFuelForModule(Integer.valueOf(moduleMass));
        }

        return total;
    }

    public int part2(List<String> moduleList) {
        int fuelForModule, total = 0;
        for (String moduleMass : moduleList) {
            fuelForModule = Integer.valueOf(moduleMass);
            do {
                fuelForModule = calculateFuelForModule(fuelForModule);
                total += fuelForModule;

            } while (fuelForModule > 0);
        }

        return total;
    }

    private static int calculateFuelForModule(int moduleMass) {
        int answer = (int) (Math.floor(moduleMass / 3) - 2);
        return answer >= 0 ? answer : 0;
    }

}