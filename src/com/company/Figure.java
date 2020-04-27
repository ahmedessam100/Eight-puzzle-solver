package com.company;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Figure {
    private int size;
    JFrame f = new JFrame();
    JButton[] button;

    public Figure(int size, ArrayList<Integer> puzzleState){
        this.size = size;

        button = new JButton[size];

        for(int i=0; i<size; i++){

            button[i] = new JButton(puzzleState.get(i).toString());

            if(puzzleState.get(i) == 0){
                button[i].setBackground(Color.RED);
            }

            f.add(button[i]);
        }

        f.setLayout(new GridLayout(3, 3));
        f.setSize(300, 300);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
