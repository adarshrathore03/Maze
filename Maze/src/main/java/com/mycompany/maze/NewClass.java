/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.*;

/**
 *
 * @author rajpu
 */
public class NewClass extends JFrame{
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depthFirstTrav.searchPath(maze,1,1,path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(50,50);//to shift grid
        
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1 : color = Color.BLACK;break;
                    case 9 : color = Color.red;break;
                    default : color = Color.white;break;
                }
                g.setColor(color);
                g.fillRect(30*i, 30*j, 30, 30);
                g.setColor(Color.red);
                g.drawRect(30*i,30*j,30,30);
            }
        }
        
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            
            g.setColor(Color.green);
            g.fillRect(30*pathx, 30*pathy, 20, 20);
        }
    }
    
    public static void main(String[] args){
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
