package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Search {

    private ArrayList<Integer> goalState = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

    private Figure f;

    public void dfs(State initialState) throws InterruptedException {
        State currState = null;
        Deque<State> stateStack = new ArrayDeque<State>();
        stateStack.push(initialState);
        f = new Figure(9, initialState.getPuzzleState());
        f.clearFrame();
        HashSet<String> visited = new HashSet<String>();
        int nodes = 0, cost;

        while (!stateStack.isEmpty()) {
            currState = stateStack.pop();
            nodes++;
            System.out.println("-----------------------------------State-----------------------------------");
            System.out.println(currState.getPuzzleState());
            visited.add(currState.getPuzzleState().toString());

            f.setFrame(currState.getPuzzleState());

            if (isGoal(currState)) {
                System.out.println("Cost of path: " + currState.getCost());
                System.out.println("Number of Nodes expanded:" + nodes);
                System.out.println("----------------------------GOAL REACHED---------------------");
                return;
            }

            TimeUnit.MILLISECONDS.sleep(250);
            f.clearFrame();

            currState.expand("").forEach((neighbour) -> {
                if (!visited.contains(neighbour.getPuzzleState().toString())){
                    stateStack.push(neighbour);
                }
            });
        }
    }

    public void bfs(State initialState) throws InterruptedException {
        Queue<State> frontier = new LinkedList<>();
        HashSet<String> explored = new HashSet<>();

        f = new Figure(9, initialState.getPuzzleState());
        f.clearFrame();
        frontier.add(initialState);
        int nodes = 0;
        State currState;

        while(!frontier.isEmpty()){

            currState = frontier.remove();
            explored.add(currState.getPuzzleState().toString());
            nodes++;
            System.out.println("-------------------------State-------------------------");
            System.out.println(currState.getPuzzleState());
            f.setFrame(currState.getPuzzleState());

            if(isGoal(currState)){
                System.out.println("Cost of path: " + currState.getCost());
                System.out.println("Number of Nodes expanded:" + nodes);
                System.out.println("----------------------------GOAL REACHED---------------------");
                return;
            }

            TimeUnit.MILLISECONDS.sleep(250);
            f.clearFrame();

            currState.expand("").forEach((neighbour) -> {
                if(!explored.contains(neighbour.getPuzzleState().toString())){
                    frontier.add(neighbour);
                }
            });

        }
    }

    public void aStar(State initialState, String heuristic) throws InterruptedException {
        State currState;
        PriorityQueue<State> frontier = new PriorityQueue<>(Comparator.comparingInt(State::getPathCost));
        HashSet<String> inHeap = new HashSet<String>();

        initialState.computeCost(heuristic);
        frontier.add(initialState);
        inHeap.add(initialState.getPuzzleState().toString());
        f = new Figure(9, initialState.getPuzzleState());
        f.clearFrame();
        HashSet<String> visited = new HashSet<String>();
        int nodes = 0;

        while (!frontier.isEmpty())
        {
            currState = frontier.poll();
            nodes++;
            inHeap.remove(currState.getPuzzleState().toString());
            System.out.println("-----------------------------------State-----------------------------------");
            System.out.println(currState.getPuzzleState());
            visited.add(currState.getPuzzleState().toString());

            f.setFrame(currState.getPuzzleState());

            if (isGoal(currState))
            {
                System.out.println("Cost of path: " + currState.getCost());
                System.out.println("Number of nodes expanded: " + nodes);
                System.out.println("----------------------------GOAL REACHED----------------------------");
                return;
            }

            TimeUnit.MILLISECONDS.sleep(250);
            f.clearFrame();

            State finalCurrState = currState;
            AtomicReference<State> state1 = new AtomicReference<>();

            currState.expand(heuristic).forEach((neighbour) -> {

                neighbour.computeCost(heuristic);

                if (!visited.contains(neighbour.getPuzzleState().toString()) && !inHeap.contains(neighbour.getPuzzleState().toString()))
                {
                    frontier.add(neighbour);
                    inHeap.add(neighbour.getPuzzleState().toString());
                }

                else if(inHeap.contains(neighbour.getPuzzleState().toString()))
                {
                   if (neighbour.getPathCost() > finalCurrState.getCost() + neighbour.getHeuristicCost())
                   {

                       frontier.forEach((state) -> {
                           if (state.getPuzzleState().toString().equals(neighbour.getPuzzleState().toString()))
                           {
                                state1.set(state);
                           }
                       });

                       frontier.remove(state1.get());
                       state1.get().setCost(finalCurrState.getCost() + 1);
                       frontier.add(state1.get());
                   }
                }
            });
        }
    }

    private boolean isGoal(State currentState)
    {
        return Arrays.equals(currentState.getPuzzleState().toArray(), goalState.toArray());
    }
}