/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class Ch8Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //  Task []ArrayTasks=new Task[100];
        
        for (int i=0;i<100;i++)
        {
        //    ArrayTasks[i]=new Task(i);
            
        }
        
        for (int i=0;i<100;i++)
        {
            //ArrayTasks[i].start();
            
        }
        
        JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball());
        mb.Balls.add(new Ball(100,100,20,Color.ORANGE));
        mb.Balls.add(new Ball(160,160,15,Color.red));
        mb.Balls.add(new Ball(180,180,10,Color.CYAN));
        mb.Balls.add(new Ball(200,120,15,Color.BLACK));
        mb.Balls.add(new Ball(220,140,10,Color.GREEN));
        mb.Balls.add(new Ball(120,200,20,Color.YELLOW));
        mb.Balls.add(new Ball(140,220,10,Color.MAGENTA));
        mb.Balls.add(new Ball(240,130,20,Color.PINK));
        mb.Balls.add(new Ball(225,230,15,Color.DARK_GRAY));



        
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
       
        
        
    }
    
}
