package com.company;

import java.util.*;

public class Driver {
    public static void main(String[] args) {

        Solver solver = new Solver();
        ArrayList<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 2, 0, 3, 4, 5, 6, 7, 8));

    /*
        ArrayList<Integer> initialState = new ArrayList<Integer>();


        for(int i = 0; i < 9; i++) {
            initialState.add(i);
        }

        Collections.shuffle(initialState);

    */

        System.out.println("*************Solving using BFS algorithm*************");
        solver.solve(initialState, "BFS");
    }
}