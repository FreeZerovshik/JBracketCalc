package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputText = sc.nextLine();
        StringBuilder tmpStr = new StringBuilder();
        StringBuilder resultStr = new StringBuilder();

        int openBracketsCnt = 0;
        int resultCntBrackets = 0;
        
        for (char c: inputText.toCharArray()) {
            if (c == '(') {
                openBracketsCnt += 1;
                tmpStr.append(c);
            } else if (c == ')' && openBracketsCnt == 1 ) {
                resultCntBrackets += 1;

                resultStr.append(tmpStr.append(c));
                tmpStr.setLength(0);
                openBracketsCnt = 0;
            } else if (c == ')' && openBracketsCnt >0) {
                openBracketsCnt -= 1;
                tmpStr.append(c);
                resultCntBrackets +=1;
            }
        }

        if (openBracketsCnt > 0 ) {
            String s = tmpStr.substring(openBracketsCnt);
            resultStr.append(s);
        }

        if (resultCntBrackets > 0 ) System.out.format("%d - %s", resultCntBrackets*2,  resultStr);
        else System.out.println(resultCntBrackets);

    }
}