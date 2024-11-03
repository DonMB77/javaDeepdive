import presentManagement.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        // test array for filterSweetsBySugarRange()
        Candy candy1 = new Candy("Mars", 20.00f, 5.00f);
        Cookie cookie1 = new Cookie("American Cookie", 22.00f, 8.00f);
        Lollipop lollipop1 = new Lollipop("Strawberry Lollipop", 30.00f, 11.00f);
        Sweet[] sweetsTestArray1 = {candy1,cookie1,lollipop1};

        // test case for filterSweetsBySugarRange()
        System.out.println("Sweets filtered by sugar weight:");
        Sweet[] sweetsfilteredBySugarRange = Present.filterSweetsBySugarRange(5.00f, 10.00f, sweetsTestArray1);
        for (Sweet sweet : sweetsfilteredBySugarRange) {
            System.out.println(sweet.toString());
        }

        // test case for calculateTotalWeight()
        System.out.println("Calculate total weight:");
        double sweetsTotalWeight = Present.calculateTotalWeight(sweetsTestArray1);
        System.out.println(sweetsTotalWeight);
    }
}