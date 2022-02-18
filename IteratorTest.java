import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest{
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.push("Josh");
        names.push("Tim");
        names.push("Jill");

        Iterator<String> namesIter = names.iterator();

        while (namesIter.hasNext()) {
            System.out.println(namesIter.next());
        }

        for (String name: names) {
            System.out.println(name);
        }
    }
}

//listIterator is also a thing...
//2:20:43 (1:26:53)