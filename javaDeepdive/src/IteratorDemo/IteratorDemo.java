package IteratorDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorDemo {

    public static void main (String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println("Interator Demo: ===========");

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Iterators cannot reset automatically
        if(!iterator.hasNext()) {
            System.out.println("If we are in this block, there is no next element");
        }

        // In order to use the same Iterator,
        // we just need to initialize a new Iterator using the same variable.

        System.out.println("Iterator - remove demo + new initialization: ====");
        iterator = integers.iterator();
        while (iterator.hasNext()) {
            int nextIteratorInt = iterator.next();
            if (nextIteratorInt % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(integers);

        System.out.println("Iterator - fail save iterator demo: ====");
        List<Integer> threadSafeList = new CopyOnWriteArrayList<>(integers);
        iterator = threadSafeList.iterator();
        threadSafeList.add(100);
        while (iterator.hasNext()) {
            threadSafeList.removeFirst();
            int nextElement = iterator.next();
            System.out.println(nextElement);
        }
        System.out.println(threadSafeList);
    }
}
