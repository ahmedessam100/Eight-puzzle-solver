package com.company;

import java.util.*;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        Solver solver = new Solver();

        ArrayList<Integer> initialState = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        /* Generating initial random state */
        for(int i = 0; i < 9; i++) {
            initialState.add(i);
        }

        Collections.shuffle(initialState);

        System.out.println("Enter the searching approach:");
        String searchApproach = scanner.nextLine();

        String heuristic = "";

        if (searchApproach.equalsIgnoreCase("A*") || searchApproach.equalsIgnoreCase("aStar"))
        {
            System.out.println("Enter A* heuristic(manhattan/euclidean):");
            heuristic = scanner.nextLine();
        }

        System.out.println("*************Solving using " + searchApproach + " algorithm*************");
        solver.solve(initialState, searchApproach, heuristic);
    }
}