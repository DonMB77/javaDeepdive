package FunctionalProgramming;

@FunctionalInterface
public interface DistanceCalculator {

    double calculateDistance(City city1, City city2);

    // in a FunctionalInterface it is forbidden to have two abstract methods!
    // double calculateDeliveryTime(); is forbidden to be declared here.

    //it can however have as many default and static methods as needed
    default void someDefaultMethod() {};

    static void someStaticMethod() {};
}
