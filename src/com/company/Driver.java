package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {

        Solver solver = new Solver();

        ArrayList<Integer> initialState = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++) {
            initialState.add(i);
        }

        Collections.shuffle(initialState);
        solver.solve(initialState, "DFS");
    }
}