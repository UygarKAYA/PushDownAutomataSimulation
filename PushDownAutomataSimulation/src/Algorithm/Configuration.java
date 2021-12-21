package Algorithm;

public class Configuration {

    private String state;
    private Stack stack;
    private String inputString;
    private String route;

    public Configuration(String state, Stack stack, String inputString, String route) {
        this.state = state;
        this.stack = stack;
        this.inputString = inputString;
        this.route = route;
    }

    public String getState() { return state; }
    public Stack getStack() { return stack; }
    public String getInputString() { return inputString; }
    public String getRoute() { return route; }
}
