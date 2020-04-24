package com.company;

import java.util.ArrayList;

public class Solver {

    public void solve(ArrayList<Integer> initial, String searchApproach, String heuristic)
    {

        State initialState = new State(initial, initial.indexOf(0), 0);

        Search search = new Search();

        /* DFS */
        if (searchApproach.equalsIgnoreCase("DFS")) {
            search.dfs(initialState);
        }

        /* BFS */
        else if(searchApproach.equalsIgnoreCase("BFS"))
        {
            search.bfs(initialState);
        }

        /* A* */
        else if(searchApproach.equalsIgnoreCase("A*"))
        {
            search.aStar(initialState, heuristic);
        }
    }
}