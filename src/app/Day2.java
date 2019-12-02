package app;

import java.util.Arrays;

public class Day2 {

    public static final String FILE_NAME = "day2";

    public int part1(String input) throws Exception {
        int[] intCode = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

        intCode[1] = 12;
        intCode[2] = 2;

        return computeIntCode(intCode)[0];
    }

    public String part2(String input) throws Exception {
        int[] originalIntCode = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] intCode = originalIntCode.clone();
        int noun = 99, verb = 99;

        outerloop:
        while (verb > 0) {
            while (noun > 0) {
                intCode[1] = noun;
                intCode[2] = verb;

                if(computeIntCode(intCode)[0] == 19690720){
                    break outerloop;
                } else {
                    intCode = originalIntCode.clone();
                }
                noun--;
            }
            verb--;
            noun = 99;
        }

        return String.format("%02d", noun) + String.format("%02d", verb);
    }

    private int[] computeIntCode(int[] input) throws Exception {
        int[] intCode = input.clone();
        int offset = 0;
        int instruction, position1, position2, outputPosition;

        do {
            instruction = intCode[offset];
            position1 = intCode[offset + 1];
            position2 = intCode[offset + 2];
            outputPosition = intCode[offset + 3];

            if (instruction == 1) {
                intCode[outputPosition] = intCode[position1] + intCode[position2];
            } else if (instruction == 2) {
                intCode[outputPosition] = intCode[position1] * intCode[position2];
            } else if (instruction != 99) {
                throw new Exception("Invalid instruction found: " + instruction);
            }
            offset += 4;
        } while (instruction != 99);

        return intCode;
    }
}