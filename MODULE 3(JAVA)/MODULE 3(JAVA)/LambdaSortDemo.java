import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("David");

        System.out.println("Before sorting: " + names);

        
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("After sorting: " + names);
    }
}
