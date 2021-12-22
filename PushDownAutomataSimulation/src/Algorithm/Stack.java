package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private List<String> stackElements = new ArrayList<>();

    public Stack() { }
    public Stack(List<String> stackElements) {
        for(int i=0; i<stackElements.size(); i++) {
            this.stackElements.add(stackElements.get(i));
        }
    }

    public String peek() {
        if (stackElements.isEmpty()) {
            return null;
        }
        return stackElements.get(stackElements.size() - 1);
    }

    public String pop() {
        if (stackElements.isEmpty()) {
            return null;
        }
        String top = stackElements.get(stackElements.size() - 1);
        stackElements.remove(stackElements.size() - 1);
        return top;
    }

    public void push(String element) { stackElements.add(element); }
    public boolean isEmpty() { return stackElements.isEmpty(); }
    public List<String> getStackElements() { return stackElements; }
}
