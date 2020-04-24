package com.company;

public class Heuristics {

    public static int manhattanDistance(State state, int size) {
        int cost = 0, i, j, rowVal, colVal, index = 0;

        for (i=0; i < size; i++)
        {
            for (j = 0; j < size; j++)
            {
                rowVal = state.getPuzzleState().get(index) / size;
                colVal = state.getPuzzleState().get(index) % size;

                cost += Math.abs(i - rowVal) + Math.abs(j - colVal);
                index++;
            }
        }

        return cost;
    }

    public static int euclideanDistance(State state, int size) {
        int cost = 0, i, j, rowVal, colVal, index = 0;

        for (i=0; i < size; i++)
        {
            for (j = 0; j < size; j++)
            {
                rowVal = state.getPuzzleState().get(index) / size;
                colVal = state.getPuzzleState().get(index) % size;

                cost += Math.sqrt(Math.pow(i - rowVal, 2) + Math.pow(j - colVal, 2));
                index++;
            }
        }

        return cost;
    }
}
