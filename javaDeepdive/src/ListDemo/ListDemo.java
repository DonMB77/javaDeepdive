package ListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List list1 = new ArrayList();
        List<String> list2 = new ArrayList<>();

        // non-generic list demo
        // here we will store multiple types on the same List. If we retrieve one we will always get a type Object
        list1.add("string demo");
        list1.add(1);
        Object object = list1.get(1);
        System.out.println(object);

        // generic list demo
        // in here we specified the elements of this list
        list2.add("some string");
        //list2.add(1); // COMPILATION Error. We specified String.
        String string = list2.get(0);
        System.out.println(string);

        // LinkedList
        list2 = new LinkedList<>(); // this essentially converts the elements of the ArrayList to a LinkedList
        list2.add("another string");
        System.out.println(list2.get(0));

        // Init demo
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(list3.get(1));

        // List toString
        System.out.println(list3);

        // foreach demo
        for (Integer i : list3) {
            System.out.println(i);
        }

        // clear
        list3.clear();
        System.out.println(list3);
    }
}
