/*
Edward Tan
CSC 171
lab section MW 4:50
NETid 31983648
email etan7@u.rochester.edu

 */
/*
Edward Tan
CSC 171
lab section MW 4:50
NETid 31983648
email etan7@u.rochester.edu

 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ChangeListener {

    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();
    ArrayList<Integer> clickCount= new ArrayList<>();
    public String showStatus = "hello";
    int p1win;
    int p2win;
    JLabel turn;

    public TicTacToe() {

        //set jframe, panel , label and button
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setLayout(new FlowLayout());
        panel1.setVisible(true);


        turn = new JLabel("Player1's turn  || P1 wins: 0 | P2 wins:0");
        turn.setVisible(true);
        turn.setFont(new Font("Ink Free",Font.BOLD,15));
        turn.setOpaque(true);



        JButton button = new JButton("NEW GAME ");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        int x = getWidth();
                        int y = getHeight();
                        Graphics g = getGraphics();
                        g.drawLine(0,y*1/7,x,y*1/7);
                        g.drawLine(0,y*3/7,x,y*3/7);
                        g.drawLine(0,y*5/7,x,y*5/7);
                        g.drawLine(x/3,y/7,x/3,y);
                        g.drawLine(2*x/3,y/7,2*x/3,y);
                        clickCount.add(1);
                    }
                }
        );
        panel1.add(button);
        button.setBounds(20,0,100,50);



        addMouseListener(new Effect());
        panel1.add(turn);
        panel1.setSize(600,50);
        add(panel1);
        pack();

        setSize(600, 700);


    }


    private class Effect implements MouseListener {

        //mouse listeners
        Effect(){
            setSize(900,1050);
            setLayout(null);
            setVisible(true);
        }
        public void mouseClicked(MouseEvent e) {

            check1();
            check2();
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {

            int w = getWidth();
            int h = getHeight();
            int x = e.getX();
            int y = e.getY();
            Graphics g = getGraphics();
            clickCount.add(1);
            turn.setText("Player"+ (2-clickCount.size() %2 )+ "'s turn" +
                    " ||   p1 win: " + p1win +" | P2 win: "+ p2win);


            //determine the click is in which box
            // box 1 to 9
            if (x < w/3 && x > 0 && y > h*1/7 && y < 3*h/7) {
                if (clickCount.size() % 2 == 0) {
                    g.drawOval(0, h/7, w/3, 2*h/7);
                    player1.add(1);
                }
                else {
                    g.drawLine(0, h/7, w/3, 3*h/7);
                    g.drawLine(0, 3*h/7, w/3, h/7);
                    player2.add(1);
                }
            }

            if(x > w/3 && x < 2*w/3 && y > h*1/7 && y < 3*h/7){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(w/3, h/7, w/3, 2*h/7);
                    player1.add(2);
                }
                else{
                    g.drawLine(w/3,h/7,2*w/3,3*h/7);
                    g.drawLine(w/3,3*h/7,2*w/3,h/7);
                    player2.add(2);
                }
            }

            if(x > 2*w/3 && x < w && y > h*1/7 && y < 3*h/7){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(2*w/3, h/7, w/3, 2*h/7);
                    player1.add(3);
                }
                else{
                    g.drawLine(2*w/3,h/7,w,3*h/7);
                    g.drawLine(2*w/3,3*h/7,w,h/7);
                    player2.add(3);
                }
            }

            if(x < w/3 && x > 0 && y > 3*h/7 && y < 5*h/7){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(0, 3*h/7, w/3, 2*h/7);
                    player1.add(4);
                }
                else{
                    g.drawLine(0,3*h/7,w/3,5*h/7);
                    g.drawLine(0,5*h/7,w/3,3*h/7);
                    player2.add(4);
                }
            }

            if(x > w/3 && x < 2*w/3 && y > 3*h/7 && y < 5*h/7){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(w/3, 3*h/7, w/3, 2*h/7);
                    player1.add(5);
                }
                else{
                    g.drawLine(w/3,3*h/7,2*w/3,5*h/7);
                    g.drawLine(w/3,5*h/7,2*w/3,3*h/7);
                    player2.add(5);
                }
            }

            if(x > 2*w/3 && x < w && y > 3*h/7 && y < 5*h/7){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(2*w/3, 3*h/7, w/3, 2*h/7);
                    player1.add(6);
                }
                else{
                    g.drawLine(2*w/3,3*h/7,w,5*h/7);
                    g.drawLine(2*w/3,5*h/7,w,3*h/7);
                    player2.add(6);
                }
            }

            if (x < w/3 && x > 0 && y > 5*h/7 && y < h) {
                if (clickCount.size() % 2 == 0) {
                    g.drawOval(0, 5*h/7, w/3, 2*h/7);
                    player1.add(7);
                } else {
                    g.drawLine(0, 5*h/7, w/3, h);
                    g.drawLine(0, h, w/3, 5*h/7);
                    player2.add(7);
                }
            }

            if(x > w/3 && x < 2*w/3 && y > 5*h/7 && y < h){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(w/3, 5*h/7, w/3, 2*h/7);
                    player1.add(8);
                }
                else{
                    g.drawLine(w/3,5*h/7,2*w/3,h);
                    g.drawLine(w/3,h,2*w/3,5*h/7);
                    player2.add(8);
                }
            }

            if(x > 2*w/3 && x < w && y > 5*h/7 && y < h){
                if(clickCount.size() % 2 == 0) {
                    g.drawOval(2*w/3, 5*h/7, w/3, 2*h/7);
                    player1.add(9);
                }
                else{
                    g.drawLine(2*w/3,5*h/7,w,h);
                    g.drawLine(2*w/3,h,w,5*h/7);
                    player2.add(9);
                }
            }
        }

        public void mouseReleased(MouseEvent e) {

        }
    }



    // check if player1 wins
    public void check1() {

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            repaint();
            clickCount.clear();
            player1.clear();
            player2.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            repaint();
            clickCount.clear();
            player1.clear();
            player2.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            repaint();
            clickCount.clear();
            player1.clear();
            player2.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p1win++;
            showStatus = "P1 wins";
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p1win++;
            showStatus = "P1 wins";
        }
    }

    //check if player2 wins
    public void check2(){

        if(player2.contains(1) && player2.contains(2)&& player2.contains(3)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(1)&& player2.contains(5)&& player2.contains(9)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(2)&&player2.contains(5)&& player2.contains(8)){
            repaint();
            player1.clear();
            clickCount.clear();
            player2.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(3)&& player2.contains(6)&&player2.contains(9)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(3)&& player2.contains(5)&& player2.contains(7)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(4)&& player2.contains(5)&& player2.contains(6)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }
        if(player2.contains(7)&& player2.contains(8)&& player2.contains(9)){
            repaint();
            player1.clear();
            player2.clear();
            clickCount.clear();
            p2win++;
            showStatus = "P2 wins";
        }

    }


    public void stateChanged(ChangeEvent e) {
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}