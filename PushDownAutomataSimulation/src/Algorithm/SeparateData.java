package Algorithm;

import InputOutput.OutputFile;
import java.util.*;

public class SeparateData {

    private int numVariablesInput;
    private int numVariablesStack;
    private int numGoalState;
    private int numState;
    private ArrayList<String> states;
    private ArrayList<String> startState;
    private ArrayList<String> goalStates;
    private ArrayList<String> stackAlphabet;
    private ArrayList<String> initialStackSymbol;
    private ArrayList<String> inputAlphabet;
    private ArrayList<String> temp;
    private ArrayList<List> transitions;
    private ArrayList<List> pdaString;

    private String routeValidation = "";

    public void SplitData(ArrayList<String> arrayList) {
        numVariablesInput = Integer.parseInt(arrayList.get(0));
        numVariablesStack = Integer.parseInt(arrayList.get(1));
        numGoalState = Integer.parseInt(arrayList.get(2));
        numState = Integer.parseInt(arrayList.get(3));
        states = new ArrayList<>(Arrays.asList(arrayList.get(4).split(" ")));
        startState = new ArrayList<>(Arrays.asList(arrayList.get(5).split(" ")));
        goalStates = new ArrayList<>(Arrays.asList(arrayList.get(6).split(" ")));
        stackAlphabet = new ArrayList<>(Arrays.asList(arrayList.get(7).split(" ")));
        initialStackSymbol = new ArrayList<>(Arrays.asList(arrayList.get(8).split(" ")));
        inputAlphabet = new ArrayList<>(Arrays.asList(arrayList.get(9).split(" ")));
        transitions = new ArrayList<>();
        pdaString = new ArrayList<>();

        for(int i=10; i<arrayList.size(); i++) {
            if (arrayList.get(i).split(" ").length == 5) {
                temp = new ArrayList<String>(Arrays.asList(arrayList.get(i).split(" ")));
                transitions.add(temp);
            }
        }

        for(int i=(transitions.size())+10; i<arrayList.size(); i++) {
            temp = new ArrayList<>(Arrays.asList(arrayList.get(i)));
            pdaString.add(temp);
        }

        PDAlgorithm pdAlgorithm = new PDAlgorithm(startState, goalStates, transitions);

        for(int i=0; i<pdaString.size(); i++) {
            routeValidation += pdAlgorithm.PDA(pdaString.get(i).get(0).toString())+"\n";
        }

        OutputFile outputFile = new OutputFile();
        outputFile.WriteFile(routeValidation);
    }
}
