package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SortWordsInArray {

    public static void main (String[] args) {
        System.out.println("Please, enter words separated by space: ");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        String[] wordsSplit = userInput.split("\\s+");

        Arrays.sort(wordsSplit, (s1, s2) ->  {
            int comparisonResult = s2.length() - s1.length();
            if (comparisonResult == 0) {
                comparisonResult = s1.compareToIgnoreCase(s2);
            }
            return comparisonResult;
        });

        for (String word : wordsSplit) {
            System.out.println(word);
        }
    }
}