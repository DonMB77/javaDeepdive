package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {

    public static void main (String[] args) {
        List<Child> children = new ArrayList<>();

        //processParentElements(children); // throws compilation error since List of Parent elements isn't given

        processElements(children); // since the wildcard permits this input, no error
    }

    public static void processParentElements(List<Parent> parents) {}

    public static void processElements(List<? extends Parent> elements) {
        Parent parent = elements.get(0); // getting a parent element will always work
        //Child child = elements.get(0); // getting a Child specifically might not work, since there is no direct guarantee that it will be a Child. As such this throws an error.

        // also we cannot add new content to the collection. The following all throw errors, except the null example
        // this is because we cannot say for sure, which type we will encounter. Therefor interactions with such collections are limited.
        //elements.add(new Parent());
        //elements.add(new Child());
        //elements.add(new Grandchild());

        elements.add(null); // this works
    }

    public static void processElements2(List<? super Child> elements) {
        Object element = elements.get(0);
        // Child parentElement = elements.get(0); // Since we do not get a guarantee which exact type we will encounter, we cannot go for a Child type in particular.

        // So we can add any type that is a child of Child itself.
        elements.add(new Child());
        elements.add(new Grandchild());
        elements.add(null); // yes, that still works

        //elements.add(new Parent()); // due to lower bounded wildcards, we cannot add a parent of Child
        //elements.add(new Object());
    }
}

class Parent {}

class Child extends Parent {

    public void childSpecificMethod() {}
}

class Grandchild extends Child {}
