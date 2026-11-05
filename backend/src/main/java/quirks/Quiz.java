package quirks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Quiz {
    public static void main(String[] args) {
/*
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;

        System.out.println("Q1: Integers");
        System.out.println("i1 == i2: " + (i1 == i2));
        System.out.println("i3 == i4: " + (i3 == i4));
        System.out.println("i3.equals(i4): " + (i3.equals(i4)));
*/

/*

        double nan1 = Double.NaN;
        double nan2 = Double.NaN;
        Double nan3 = Double.NaN;
        Double nan4 = Double.NaN;

        System.out.println("Q2: NaN");
        System.out.println("nan1 == nan2: " + (nan1 == nan2));
        System.out.println("nan1 == nan1: " + (nan1 == nan1));
        System.out.println("nan3.equals(nan4): " + nan3.equals(nan4));
        System.out.println("nan4 == nan4: " + (nan4 == nan4));

*/
/*
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println("Q3: String Pool");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + (s1.equals(s3));
*/
/*
        System.out.println("Q4: Floating-point");
        System.out.println("0.1 + 0.2 == 0.3: " + ((0.1 + 0.2) == 0.3));
        System.out.println("0.1 + 0.2: " + (0.1 + 0.2));

*/
/*

        List<String> navne = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println("Q5: Arrays.asList(..)");
        System.out.println("Listens indhold: " + navne);
        // kaster en RuntimeException. Pak evt ind i try-catch
        navne.add("David");
        System.out.println("Efter tilføjelse: " + navne);

// Man kan dog ændre værdier i listen
        navne.set(0, "Alicia");
        System.out.println("Efter ændring: " + navne);

// Et alternativ hvor vi får en mutable liste
        List<String> mutableList = new ArrayList<>(Arrays.asList("Alice", "Bob"));

*/

/*
        List<String> navne = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("Q6: Foreach");
        System.out.println("Før: " + navne);

        for (String navn : navne) {
            if (navn.startsWith("A")) {
                // kaster en RuntimeException. Pak evt ind i try-catch
                navne.remove(navn);
            }
        }

        System.out.println("Efter fejl: " + navne);

// Korrekt måde med iterator
        Iterator<String> it = navne.iterator();
        while (it.hasNext()) {
            String navn = it.next();
            if (navn.startsWith("C")) {
                it.remove();  // Brug iterator's remove
            }
        }

        System.out.println("Efter korrekt fjernelse: " + navne);
*/
/*
        class Person {
            String name;
            Person(String name) {
                this.name = name;
            }
        }

        final Person person = new Person("Alice");
        System.out.println("Q7: Final");
        System.out.println("Persons navn: " + person.name);
        person.name = "Bob";
        System.out.println("Efter ændring: " + person.name);
*/
    }

}
