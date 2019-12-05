package app;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static final int RANGE_MIN = 278384;
    public static final int RANGE_MAX = 824795;

    public int part1() {
        int count = 0;
        for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
            if (meetsCriteria(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean meetsCriteria(int i) {
        Integer[] digits = getDigits(i);
        boolean foundDouble = false;
        int repeated = -1;
        for (int j = 0; j < digits.length - 1; j++) {
            if ((digits[j] > digits[j + 1])) {
                return false;
            }
            if (repeated != digits[j + 1]) {
                if (j == 0) {
                    if (digits[j] == digits[j + 1]) {
                        foundDouble = true;
                        repeated = digits[j];
                    }
                } else if (digits[j] == digits[j + 1] && digits[j] != digits[j - 1]) {
                    foundDouble = true;
                    repeated = digits[j];
                }
            } else {
                foundDouble = false;
                repeated = -1;
            }
        }

        return foundDouble;
    }

    public static Integer[] getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[] {});
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }
}