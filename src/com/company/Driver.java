package com.company;

import java.util.*;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        Solver solver = new Solver();
        ArrayList<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 3, 4, 0, 6, 7, 8));

    /*
        ArrayList<Integer> initialState = new ArrayList<Integer>();
//        ArrayList<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 0, 4, 5, 6, 7, 8));


        for(int i = 0; i < 9; i++) {
            initialState.add(i);
        }

        Collections.shuffle(initialState);

    */

        System.out.println("*************Solving using DFS algorithm*************");
        solver.solve(initialState, "A*", "manhattan");
    }
}