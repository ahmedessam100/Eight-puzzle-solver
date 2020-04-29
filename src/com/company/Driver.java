package com.company;

import java.util.*;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        Solver solver = new Solver();
        ArrayList<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 3, 0, 4, 6, 7, 8));

    /*
        ArrayList<Integer> initialState = new ArrayList<Integer>();
//        ArrayList<Integer> initialState = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 0, 4, 5, 6, 7, 8));


        for(int i = 0; i < 9; i++) {
            initialState.add(i);
        }

        Collections.shuffle(initialState);

    */

        String heuristic = "manhattan";
        String searchApproach = "A*";

        System.out.println("*************Solving using " + searchApproach + " algorithm*************");
        long start = System.currentTimeMillis();
        solver.solve(initialState, searchApproach, heuristic);
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");

    }
}