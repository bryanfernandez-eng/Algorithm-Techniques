import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack; 

public class Stacks {
    public static void main(String[] args) {
        new Stacks(); 
        
    }

    public Stacks(){
        JavaUtilStack();
        System.out.println("-------------------");
        JavaUtilArrayDeque();
    }

    public void JavaUtilStack(){
        Stack<String> stack = new Stack<>(); 
        stack.push("First");
        stack.push("Middle"); 
        stack.push("Last"); 
        int i = 1; 
        while(!stack.isEmpty()){
            System.out.println(i + ": " + (stack.pop()));
            i++;
        }
    }
    public void JavaUtilArrayDeque(){
        Deque<String> stack = new ArrayDeque<>(); 

        stack.push("First");
        stack.push("Middle"); 
        stack.push("Last"); 

        int i = 1; 
        while(!stack.isEmpty()){
            System.out.println(i + ":" + stack.pop()); 
        }
    }
}