package com.company;

import java.util.*;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        Solver solver = new Solver();

        ArrayList<Integer> initialState = new ArrayList<>();

        /* Generating initial random state */
        for(int i = 0; i < 9; i++) {
            initialState.add(i);
        }

        Collections.shuffle(initialState);


        String heuristic = "manhattan";
        String searchApproach = "A*";

        System.out.println("*************Solving using " + searchApproach + " algorithm*************");
        solver.solve(initialState, searchApproach, heuristic);
    }
}