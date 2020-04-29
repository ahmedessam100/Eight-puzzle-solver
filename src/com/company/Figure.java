package com.company;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Figure {
    private int size;
    private JFrame f = new JFrame();
    private JButton[] button;

    public JFrame getF() {
        return f;
    }

    public Figure(int size, ArrayList<Integer> puzzleState){

        this.size = size;

        button = new JButton[size];

        for(int i=0; i<size; i++){

            if(puzzleState.get(i) == 0){
                button[i] = new JButton("");
                button[i].setBackground(Color.RED);

            }
            else{
                button[i] = new JButton(puzzleState.get(i).toString());
                button[i].setBackground(Color.WHITE);
            }

            f.add(button[i]);
        }

        f.setLayout(new GridLayout(3, 3));
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void setFrame(ArrayList<Integer> puzzleState) {

        for(int i=0; i < this.size; i++){

            if(puzzleState.get(i) == 0){
                button[i] = new JButton("");
                button[i].setBackground(Color.RED);

            }
            else{
                button[i] = new JButton(puzzleState.get(i).toString());
                button[i].setBackground(Color.WHITE);
            }

            f.add(button[i]);
        }

        f.setLayout(new GridLayout(3, 3));
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void clearFrame()
    {
        f.getContentPane().removeAll();
    }
}
