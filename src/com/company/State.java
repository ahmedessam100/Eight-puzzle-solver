package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class State {

    private ArrayList<Integer> puzzleState = new ArrayList<Integer>();

    private ArrayList<State> neighbours = new ArrayList<>();

    private int blankPosition;

    private static HashSet<Integer> right = new HashSet<Integer>() {{
        add(2);
        add(5);
        add(8);
    }};

    public State(ArrayList<Integer> state, int blankPosition) {
        puzzleState = state;
        this.blankPosition = blankPosition;
    }

    public ArrayList<Integer> getPuzzleState() { return puzzleState; }

    public ArrayList<State> getNeighbours() { return neighbours; }

    // moveLeft
    public State moveLeft(State currentState) {

        /* Moving the blank to the left */
        int newBlankPosition = currentState.blankPosition - 1;

        State state = new State(currentState.puzzleState, newBlankPosition);

        Collections.swap(state.puzzleState, newBlankPosition, currentState.blankPosition);

        return state;
    }

    // moveRight
    public State moveRight(State currentState) {

        /* Moving the blank to the left */
        int newBlankPosition = currentState.blankPosition + 1;

        State state = new State(currentState.puzzleState, newBlankPosition);

        Collections.swap(state.puzzleState, newBlankPosition, currentState.blankPosition);

        return state;
    }

    // moveDown
    public State moveDown(State currentState) {

        /* Moving the blank to the left */
        int newBlankPosition = currentState.blankPosition + 3;

        State state = new State(currentState.puzzleState, newBlankPosition);

        Collections.swap(state.puzzleState, newBlankPosition, currentState.blankPosition);

        return state;
    }

    // moveUp
    public State moveUp(State currentState) {

        /* Moving the blank to the left */
        int newBlankPosition = currentState.blankPosition - 3;

        State state = new State(currentState.puzzleState, newBlankPosition);

        Collections.swap(state.puzzleState, newBlankPosition, currentState.blankPosition);

        return state;
    }

    /* expand */
    public void expand() {

        /* Left */
        if (this.blankPosition % 3 != 0 && this.blankPosition - 1 >= 0)
        {

            this.neighbours.add(moveLeft(this));
        }

        /* Up */
        if(this.blankPosition > 2 && this.blankPosition - 3 >= 0)
        {

            this.neighbours.add(moveUp(this));
        }

        /* Down */
        if(this.blankPosition < 6 && this.blankPosition + 3 <= this.puzzleState.size() - 1)
        {

            this.neighbours.add(moveDown(this));
        }

        /* Right */
        if(!right.contains(this.blankPosition) && this.blankPosition + 1 <= this.puzzleState.size() - 1)
        {

            this.neighbours.add(moveRight(this));
        }
    }

}