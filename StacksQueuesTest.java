import java.util.LinkedList;

public class StacksQueuesTest {

    public static void stackTest() {
        LinkedList<String> names = new LinkedList<>();
        names.push("Josh");
        names.push("Tim");
        names.push("Jill");
        
        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());
    }

    public static void queueTest() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Josh");
        names.add("Tim");
        names.add("Jill");
        System.out.println(names.remove());
        System.out.println(names.remove());
        System.out.println(names.remove());

    }

    public static void main(String[] args) {
        System.out.println("Elements added: 'Josh', 'Tim', 'Jill' (In that order)");
        System.out.println("Remove from Stack:");
        stackTest();
        System.out.println("Remove from Queue:");
        queueTest();
    }
}

//2:08:15 (1:26:53)

//pop() and removeFirst() and remove(no argument) are EQUIVALENT. push(arg) puts the argument as the FIRST element, and add(arg) puts the argument as the LAST element.
//pop, removeFirst etc all remove the FIRST element.