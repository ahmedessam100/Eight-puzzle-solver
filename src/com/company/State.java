package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class State {

    private ArrayList<Integer> puzzleState;

    private int blankPosition;

    private int cost;

    private int heuristicCost;

    private int pathCost;

    private static HashSet<Integer> right = new HashSet<Integer>() {{
        add(2);
        add(5);
        add(8);
    }};

    public State(ArrayList<Integer> state, int blankPosition, int cost, int pathCost) {
        puzzleState = state;
        this.blankPosition = blankPosition;
        this.cost = cost;
        this.pathCost = pathCost;
    }

    public int getCost() { return this.cost; }

    public void setCost(int cost) { this.cost = cost; }

    public int getHeuristicCost() { return this.heuristicCost; }

    /* f(n) = g(n) + h(n) */
    public int getPathCost() { return this.cost + this.heuristicCost; }

    public void setPathCost(int pathCost)
    {
        this.pathCost = pathCost;
    }

    public int getAccumulativeCost() { return this.pathCost; }

    /* computing h(n) */
    public void computeCost(String heuristic)
    {
        int cost = 0;

        if (heuristic.equalsIgnoreCase("euclidean"))
        {
            cost = Heuristics.euclideanDistance(this, 3);
        }

        else if (heuristic.equalsIgnoreCase("manhattan"))
        {
            cost = Heuristics.manhattanDistance(this, 3);
        }

        this.heuristicCost = cost;
    }

    public ArrayList<Integer> getPuzzleState() { return puzzleState; }

    /* moveLeft */
    public State moveLeft(State currentState, String heuristic) {

        /* Moving the blank left */
        int newBlankPosition = currentState.blankPosition - 1;

        ArrayList<Integer> puzzleState = new ArrayList<>(currentState.getPuzzleState());

        Collections.swap(puzzleState, newBlankPosition, currentState.blankPosition);

        State state = new State(puzzleState, newBlankPosition, currentState.cost + 1, 0);

        state.computeCost(heuristic);
        state.setPathCost(currentState.getPathCost() + state.getHeuristicCost());

        return state;
    }

    /* moveRight */
    public State moveRight(State currentState, String heuristic) {

        /* Moving the blank right */
        int newBlankPosition = currentState.blankPosition + 1;

        ArrayList<Integer> puzzleState = new ArrayList<>(currentState.getPuzzleState());

        Collections.swap(puzzleState, newBlankPosition, currentState.blankPosition);

        State state = new State(puzzleState, newBlankPosition, currentState.cost + 1, 0);

        state.computeCost(heuristic);
        state.setPathCost(currentState.getPathCost() + state.getHeuristicCost());

        return state;
    }

    /* moveDown */
    public State moveDown(State currentState, String heuristic) {

        /* Moving the blank down */
        int newBlankPosition = currentState.blankPosition + 3;

        ArrayList<Integer> puzzleState = new ArrayList<>(currentState.getPuzzleState());

        Collections.swap(puzzleState, newBlankPosition, currentState.blankPosition);

        State state = new State(puzzleState, newBlankPosition, currentState.cost + 1, 0);

        state.computeCost(heuristic);
        state.setPathCost(currentState.getPathCost() + state.getHeuristicCost());

        return state;
    }

    /* moveUp */
    public State moveUp(State currentState, String heuristic) {

        /* Moving the blank up */
        int newBlankPosition = currentState.blankPosition - 3;

        ArrayList<Integer> puzzleState = new ArrayList<>(currentState.getPuzzleState());

        Collections.swap(puzzleState, newBlankPosition, currentState.blankPosition);

        State state = new State(puzzleState, newBlankPosition, currentState.cost + 1, 0);

        state.computeCost(heuristic);
        state.setPathCost(currentState.getPathCost() + state.getHeuristicCost());

        return state;
    }

    /* expand */
    public ArrayList<State> expand(String heuristic) {

        ArrayList<State> neighbours = new ArrayList<>();

        /* Right */
        if(!right.contains(this.blankPosition) && this.blankPosition + 1 <= this.puzzleState.size() - 1)
        {
            neighbours.add(moveRight(this, heuristic));
        }

        /* Down */
        if(this.blankPosition < 6 && this.blankPosition + 3 <= this.puzzleState.size() - 1)
        {
            neighbours.add(moveDown(this, heuristic));
        }

        /* Up */
        if(this.blankPosition > 2 && this.blankPosition - 3 >= 0)
        {
            neighbours.add(moveUp(this, heuristic));
        }

        /* Left */
        if (this.blankPosition % 3 != 0 && this.blankPosition - 1 >= 0)
        {
            neighbours.add(moveLeft(this, heuristic));
        }

        return neighbours;
    }

}
