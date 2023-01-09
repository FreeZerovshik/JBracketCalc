package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();
        List<Integer> openBrackets = new ArrayList<>();
        List<Integer> closeBrackets = new ArrayList<>();

        int idx = 0;

        for (char c: inputText.toCharArray()) {
            if (c == '(') {
                openBrackets.add(idx);
            } else if (c == ')' && openBrackets.size() > 0 ) {
                openBrackets.remove(openBrackets.size()-1);
            } else if (c == ')') {
                closeBrackets.add(idx);
            }

            idx++;
        }

        idx = 0;
        StringBuilder resultStr = new StringBuilder();

        for (char c: inputText.toCharArray()) {
            if (!openBrackets.contains(idx) && !closeBrackets.contains(idx)) resultStr.append(c);

            idx++;
        }

        if (resultStr.length()>0) System.out.printf("%d - %s", resultStr.length(), resultStr);
        else System.out.println(resultStr.length());
    }
}