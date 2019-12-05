package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RunAoC {
    public static void main(String[] args) throws Exception {
        runDay4();
    }

    public static void runDay4() throws IOException {    
        Day4 day4 = new Day4();
        System.out.println("-> Day 4");
        System.out.print("part 1: " + day4.part1());
       // System.out.print(" - part 2: " + day3.part2(input));
    }

    public static void runDay3() throws IOException {
        List<String> input = Files.readAllLines(Paths.get("bin/inputs/" + Day3.FILE_NAME));
        
        Day3 day3 = new Day3();
        System.out.println("-> Day 3");
        System.out.print("part 1: " + day3.part1(input));
        System.out.print(" - part 2: " + day3.part2(input));
    }

    public static void runDay2() throws Exception {
        String input = Files.readAllLines(Paths.get("bin/inputs/" + Day2.FILE_NAME)).get(0);
        
        Day2 day2 = new Day2();
        System.out.println("-> Day 2");
        System.out.print("part 1: " + day2.part1(input));
        System.out.print(" - part 2: " + day2.part2(input));
    }

    public static void runDay1() throws IOException {
        List<String> moduleList = Files.readAllLines(Paths.get("bin/inputs/" + Day1.FILE_NAME));
        
        Day1 day1 = new Day1();
        System.out.println("-> Day 1");
        System.out.print("part 1: " + day1.part1(moduleList));
        System.out.print(" - part 2: " + day1.part2(moduleList));
    }
}