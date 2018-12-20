/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Tank BlueTank=new Tank("/Users/Desktop/Ch8ThreadsTankGame/TankBlueS.jpg");
   public int score1;
   public int score2;
   public Tank BlueTank2=new Tank("/Users/Desktop/Ch8ThreadsTankGame/TankBlueS.jpg");
   JLabel sc1;
   JLabel sc2;
   JLabel scr1;
   JLabel scr2;

    public MovingBalls()
    {   
    this.setLayout(null);
        score2=10;
        score1=0;
        sc1=new JLabel("Player 1 Score: ");
        sc2=new JLabel("Player 2 Score: ");
        scr1=new JLabel(""+score1);
        scr2=new JLabel(""+score2);
        sc1.setBounds(40, 10, 150, 50);
        scr1.setBounds(135, 10, 80, 50);
        sc2.setBounds(400, 10, 150, 50);
        scr2.setBounds(495, 10, 80, 50);
        this.add(sc1);
        this.add(sc2);
        this.add(scr1);
        this.add(scr2);
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=300;
        BlueTank.pos.y=340;
        BlueTank2.pos.x=150;
        BlueTank2.pos.y=340;
        this.addKeyListener(new keylist());
      
      
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }    if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTank2.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTank2.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_E)
            {
                
                BlueTank2.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgtank, BlueTank2.pos.x, BlueTank2.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        g.drawImage(imgrocket, BlueTank2.Rocket.pos.x, BlueTank2.Rocket.pos.y,null);

        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
          
            
            
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 25, 25);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
               
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                 score1=score1+10;
                scr1.setText(""+score1);
                break;
                
            }
            if(BlueTank2.Rocket.pos.distance(OneBall.x, OneBall.y)<=50){
                score2=score2+10;
                scr2.setText(""+score2);
               System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
            
                Balls.remove(OneBall);
                
                break;
            }
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
        OneBall.move(this.getWidth());
        }    
       
        
          if(Balls.size()==0){
        if(score1<score2){
        JOptionPane.showMessageDialog(null, "Player2  Won :","won", JOptionPane.INFORMATION_MESSAGE);
        break;
        }else{
        JOptionPane.showMessageDialog(null, "Player1  Won :","won", JOptionPane.INFORMATION_MESSAGE);
        break;
        }}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
