package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'I') sum += 1;
            if (c == 'V') sum += 5;
            if (c == 'X') sum += 10;
            if (c == 'L') sum += 50;
            if (c == 'C') sum += 100;
            if (c == 'D') sum += 500;
            if (c == 'M') sum += 1000;
        }

        if (s.indexOf("IV") != -1) sum -= 2;
        if (s.indexOf("IX") != -1) sum -= 2;
        if (s.indexOf("XL") != -1) sum -= 20;
        if (s.indexOf("XC") != -1) sum -= 20;
        if (s.indexOf("CD") != -1) sum -= 200;
        if (s.indexOf("CM") != -1) sum -= 200;
        return sum;
    }

}
