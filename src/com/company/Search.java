package com.company;

import java.lang.reflect.Array;
import java.util.*;

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
        Queue<State> frontier = new LinkedList<>();
        HashSet<String> explored = new HashSet<>();

        frontier.add(initialState);
        while(!frontier.isEmpty()){
           State state = frontier.remove();
            explored.add(state.getPuzzleState().toString());

            new Figure(9, state.getPuzzleState());

            if(isGoal(state)){
                System.out.println(state.getPuzzleState());
                System.out.println("-------------------------GOAL REACHED------------------");
                return;
            }



            System.out.println(state.getPuzzleState());

            System.out.println("-------------------------State-------------------------");

            state.expand();
            for(State neighbor:state.getNeighbours()){
                if(!explored.contains(neighbor.getPuzzleState().toString())){
                    frontier.add(neighbor);
                }
            }
        }
    }

    public void aStar(State initialState)
    {

    }

    private boolean isGoal(State currentState)
    {
        return Arrays.equals(currentState.getPuzzleState().toArray(), goalState.toArray());
    }
}
