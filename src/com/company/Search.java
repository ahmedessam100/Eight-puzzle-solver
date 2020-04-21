package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Search {

    private ArrayList<Integer> goalState = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

    public void dfs(State initialState)
    {
        State currState;
        Stack<State> stateStack = new Stack<State>();
        stateStack.push(initialState);

        HashSet<String> visited = new HashSet<String>();

        while (!stateStack.isEmpty()) {

            currState = stateStack.pop();
            System.out.println("-----------------------------------State-----------------------------------");
            System.out.println(currState.getPuzzleState());
            visited.add(currState.getPuzzleState().toString());

            if (isGoal(currState)) {
                System.out.println("----------------------------GOAL REACHED---------------------");
                return;
            }

            currState.expand();
            for(State neighbour: currState.getNeighbours()) {
                if (!visited.contains(neighbour.getPuzzleState().toString())){
                    stateStack.push(neighbour);
                }
            }

        }


    }

    public void bfs(State initialState)
    {

    }

    public void aStar(State initialState)
    {

    }

    private boolean isGoal(State currentState)
    {
        return Arrays.equals(currentState.getPuzzleState().toArray(), goalState.toArray());
    }
}
