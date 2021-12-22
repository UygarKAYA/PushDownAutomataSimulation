package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class PDAlgorithm {

    private ArrayList<String> startState;
    private ArrayList<String> goalStates;
    private ArrayList<List> transitions;
    private ArrayList<List> newTransition;
    private ArrayList<Configuration> newConfig;
    private ArrayList<Configuration> configArray;
    private ArrayList<Configuration> newConfigList;
    private ArrayList<Configuration> newConfig_;

    private Stack tempStack;
    private Configuration routeValidate;

    public PDAlgorithm(ArrayList<String> startState, ArrayList<String> goalStates, ArrayList<List> transitions) {
        this.startState = startState;
        this.goalStates = goalStates;
        this.transitions = transitions;
    }

    public boolean isGoalState(String state) {
        for(int i=0; i<goalStates.size(); i++) {
            if(state.equals(goalStates.get(i)))
                return true;
        }
        return false;
    }

    public ArrayList<List> getTransitions(String state) {
        newTransition = new ArrayList<>();
        for(int i=0; i<transitions.size(); i++) {
            if(transitions.get(i).get(0).equals(state))
                newTransition.add(transitions.get(i));
        }
        return newTransition;
    }

    public ArrayList<Configuration> config(Configuration configuration) {
        newConfig = new ArrayList<>();
        tempStack = new Stack(configuration.getStack().getStackElements());
        ArrayList<List> transitions = getTransitions(configuration.getState());

        for(int i=0; i<transitions.size(); i++) {
            if(transitions.get(i).get(1).equals("ε") && transitions.get(i).get(2).equals("ε")) {
                if(!(transitions.get(i).get(3).equals("ε")))
                    tempStack.push(transitions.get(i).get(3).toString());
                newConfig.add(new Configuration(transitions.get(i).get(4).toString(), tempStack, configuration.getInputString(), configuration.getRoute()+" "+transitions.get(i).get(4)));
            }

            else if(transitions.get(i).get(1).equals("ε") && !tempStack.isEmpty() && transitions.get(i).get(2).equals(configuration.getStack().peek())) {
                tempStack.pop();
                if(!(transitions.get(i).get(3).equals("ε")))
                    tempStack.push(transitions.get(i).get(3).toString());
                newConfig.add(new Configuration(transitions.get(i).get(4).toString(), tempStack, configuration.getInputString(), configuration.getRoute()+" "+transitions.get(i).get(4)));
            }

            else if(!configuration.getInputString().isEmpty() && transitions.get(i).get(1).equals(configuration.getInputString().substring(0,1)) && transitions.get(i).get(2).equals("ε")) {
                if(!transitions.get(i).get(3).equals("ε"))
                    tempStack.push(transitions.get(i).get(3).toString());
                newConfig.add(new Configuration(transitions.get(i).get(4).toString(), tempStack, configuration.getInputString().substring(1), configuration.getRoute()+" "+transitions.get(i).get(4)));
            }

            else if(!configuration.getInputString().isEmpty() && transitions.get(i).get(1).equals(configuration.getInputString().substring(0,1)) && !tempStack.isEmpty() && transitions.get(i).get(2).equals(configuration.getStack().peek())) {
                tempStack.pop();
                if(!(transitions.get(i).get(3).equals("ε")))
                    tempStack.push(transitions.get(i).get(3).toString());
                newConfig.add(new Configuration(transitions.get(i).get(4).toString(), tempStack, configuration.getInputString().substring(1), configuration.getRoute()+" "+transitions.get(i).get(4)));
            }
        }
        return newConfig;
    }

    public String PDA(String input) {
        newConfigList = new ArrayList<>();
        routeValidate = new Configuration(startState.get(0), new Stack(), input, startState.get(0));
        newConfigList.add(routeValidate);

        while(newConfigList.size() > 0) {
            configArray = new ArrayList<>();
            for(int i=0; i<newConfigList.size(); i++) {
                if(newConfigList.get(i).getInputString().isEmpty() && isGoalState(newConfigList.get(i).getState()))
                     return newConfigList.get(i).getRoute()+"\nAccepted";
                newConfig_ = config(newConfigList.get(i));
                configArray.addAll(newConfig_);
            }
            routeValidate = newConfigList.get(newConfigList.size()-1);
            newConfigList.clear();
            newConfigList.addAll(configArray);
        }
        return routeValidate.getRoute()+"\nRejected";
    }
}
