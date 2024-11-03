package presentManagement;

public class Present {
    public static Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight, Sweet[] sweets) {
        int arraySize = 0;
        for (int i = 0; sweets.length > i; i++) {
            if (sweets[i].sugarWeight >= minSugarWeight && sweets[i].sugarWeight <= maxSugarWeight) {
                ++arraySize;
            }
        }

        int index = 0;
        Sweet[] returnSweets = new Sweet[arraySize];
        for (int i = 0; sweets.length > i; i++) {
            if (sweets[i].sugarWeight >= minSugarWeight && sweets[i].sugarWeight <= maxSugarWeight) {
                returnSweets[index] = sweets[i];
                ++index;
            }
        }
        return returnSweets;
    }

    public static float calculateTotalWeight(Sweet[] sweets) {
        float weightSum = 0;
        for (Sweet sweet : sweets) {
            weightSum += sweet.weight;
        }
        return weightSum;
    }
}
