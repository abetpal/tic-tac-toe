import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class tictactoe1
{
    JFrame ob;
    JLabel turn, gm, xwin, owin, Draw, Wallpaper;
    String sign = "";
    JButton b[] = new JButton[9];
    JButton reset,resetThis,exit,menu;
    int chance = 1,i = 0,Gmno = 1,Xwin = 0,Owin = 0,draw = 0,timesclicked = 0;
    //chance 1 is for X in the first game
    boolean clicked[] = new boolean[9];
    boolean Xchecker[] = new boolean[9];
    boolean Ochecker[] = new boolean[9];
    boolean checkit = false;
    public  void main()
    {
        ob = new JFrame();
        ob.setSize(1000,640);
        ob.setVisible(true);
        ob.setLayout(null);
        ob.setTitle("Abhinav's TIC-TAC-TOE");
        int x = 0,y = 0;
        i=0;
        timesclicked = 0;
        if(Gmno%2==0)
            chance = 0;
        else
            chance = 1;
        for(;i<9;i++)
        {
            b[i] = new JButton();
            b[i].setBounds(x,y,200,200);
            b[i].setBackground(Color.lightGray);
            x+=200;
            if((i+1)%3==0)
            {
                y+=200;
                x=0;
            }
            ob.add(b[i]);
            clicked[i] = false;
            Xchecker[i] = false;
            Ochecker[i] = false;
        }

        turn = new JLabel((chance==1)?"X":"O");
        turn.setBounds(700,50,150,150);
        turn.setFont(new Font("Ariel", Font.PLAIN, 150));
        turn.setForeground((chance==1)?Color.red:Color.green);
        ob.add(turn);

        JLabel l1 = new JLabel("'s Turn");
        l1.setBounds(810,100,150,150);
        l1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 50));
        l1.setForeground(Color.white);
        ob.add(l1);

        gm = new JLabel("GAME : " + Gmno);
        gm.setBounds(700,160,250,150);
        gm.setFont(new Font("Castellar", Font.PLAIN, 30));
        gm.setForeground(Color.white);
        ob.add(gm);

        xwin = new JLabel("X      :    " + Xwin);
        xwin.setBounds(700,230,450,120);
        xwin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
        xwin.setForeground(Color.white);
        ob.add(xwin);

        owin = new JLabel("O      :    " + Owin);
        owin.setBounds(700,280,450,120);
        owin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
        owin.setForeground(Color.white);
        ob.add(owin);

        Draw = new JLabel("DRAW   :    " + draw);
        Draw.setBounds(700,330,450,120);
        Draw.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
        Draw.setForeground(Color.white);
        ob.add(Draw);

        reset = new JButton("RESET");
        reset.setBounds(620,430,330,35);
        reset.setFont(new Font("Ariel", Font.BOLD, 20));
        reset.setForeground(Color.white);
        reset.setBackground(Color.darkGray);
        ob.add(reset);

        resetThis = new JButton("RESET GAME "+Gmno);
        resetThis.setBounds(620,470,330,35);
        resetThis.setFont(new Font("Ariel", Font.BOLD, 20));
        resetThis.setForeground(Color.white);
        resetThis.setBackground(Color.darkGray);
        ob.add(resetThis);

        exit = new JButton("EXIT");
        exit.setBounds(620,550,330,35);
        exit.setFont(new Font("Ariel", Font.BOLD, 20));
        exit.setForeground(Color.white);
        exit.setBackground(Color.darkGray);
        ob.add(exit);

        menu = new JButton("MAIN MENU");
        menu.setBounds(620,510,330,35);
        menu.setFont(new Font("Ariel", Font.BOLD, 20));
        menu.setForeground(Color.white);
        menu.setBackground(Color.darkGray);
        ob.add(menu);

        Wallpaper = new JLabel();
        Wallpaper.setBounds(0,0,1000,640);
        Wallpaper.setIcon(new ImageIcon("C:\\Users\\deadpool\\Desktop\\abh\\tictactoe\\abc.jpg"));
        ob.add(Wallpaper);

        ob.repaint();

        b[0].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(0);
                }
            });
        b[1].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(1);
                }
            });
        b[2].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(2);
                }
            });
        b[3].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(3);
                }
            });
        b[4].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(4);
                }
            });
        b[5].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(5);
                }
            });
        b[6].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(6);
                }
            });
        b[7].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(7);
                }
            });
        b[8].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    OnClick(8);
                }
            });
        reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure ?","Are you sure",JOptionPane.YES_NO_CANCEL_OPTION);    
                    if(a==0)
                    {
                        ob.dispose();
                        tictactoe1 obj = new tictactoe1();
                        obj.main();
                    }
                }
            });
        exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to leave the game?");
                    if(a==0)
                        ob.dispose();
                }
            });
        resetThis.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure?");
                    if(a==0)
                    {
                        ob.dispose();
                        main();
                    }
                }
            });
        menu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure?");
                    if(a==0)
                    {
                        ob.dispose();
                        mainframe obj = new mainframe();
                        obj.game();
                    }
                }
            });
    }

    void OnClick(int k)
    {
        if(!clicked[k])
        {
            if(chance==1)
            {
                ob.remove(turn);
                turn.setText("O");
                turn.setForeground(Color.green);
                b[k].setText("X");
                b[k].setFont(new Font("Ariel", Font.PLAIN, 200));
                b[k].setBackground(Color.blue);
                b[k].setForeground(Color.white);
                ob.add(turn);
                ob.add(Wallpaper);
                Xchecker[k] = true;
                timesclicked++;
                chance--;
            }
            else
            {
                ob.remove(turn);
                turn.setText("X");
                turn.setForeground(Color.red);
                b[k].setText("O");
                b[k].setFont(new Font("Ariel", Font.PLAIN, 200));
                b[k].setBackground(Color.pink);
                b[k].setForeground(Color.black);
                ob.add(turn);
                ob.add(Wallpaper);
                Ochecker[k] = true;
                timesclicked++;
                chance++;
            }
            clicked[k] = true;
            ob.repaint();
        }
        hasWon(Xchecker,Ochecker);
    }

    void hasWon(boolean a[],boolean b[])
    {
        if(!checkit &&((a[0]&&a[1]&&a[2])||(a[0]&&a[3]&&a[6])||(a[0]&&a[4]&&a[8])||(a[1]&&a[4]&&a[7])||(a[2]&&a[4]&&a[6])||(a[2]&&a[5]&&a[8])||(a[3]&&a[4]&&a[5])||(a[6]&&a[7]&&a[8])))
        {
            JOptionPane.showMessageDialog(null,"Player 'X' Won game "+Gmno);
            ob.dispose();
            Gmno++;
            Xwin++;
            main();
        }
        if(!checkit && ((b[0]&&b[1]&&b[2])||(b[0]&&b[3]&&b[6])||(b[0]&&b[4]&&b[8])||(b[1]&&b[4]&&b[7])||(b[2]&&b[4]&&b[6])||(b[2]&&b[5]&&b[8])||(b[3]&&b[4]&&b[5])||(b[6]&&b[7]&&b[8])))
        {
            JOptionPane.showMessageDialog(null,"Player 'O' Won game "+Gmno);
            ob.dispose();
            Gmno++;
            Owin++;
            main();
        }
        if(!checkit && timesclicked == 9)
        {
            JOptionPane.showMessageDialog(null,"Game Draw");
            ob.dispose();
            Gmno++;
            draw++;
            main();
        }
        if(Xwin == 3)
        {
            ob.dispose();
            JFrame win = new JFrame();
            win.setSize(1000,640);
            win.setVisible(true);
            win.setLayout(null);
            JLabel win1 = new JLabel("Congratulations !!!");
            win1.setBounds(250,100,750,220);
            win1.setFont(new Font("Algerian", Font.ITALIC, 50));
            win1.setForeground(Color.red);

            JLabel win2 = new JLabel("Player X has won the game");
            win2.setBounds(200,300,900,220);
            win2.setFont(new Font("Calibri", Font.PLAIN, 50));
            win2.setForeground(Color.white);

            win.add(win1);
            win.add(win2);
            win.add(Wallpaper);
            return;
        }
        if(Owin == 3)
        {
            ob.dispose();
            JFrame win = new JFrame();
            win.setSize(1000,640);
            win.setVisible(true);
            win.setLayout(null);
            JLabel win1 = new JLabel("Congratulations !!!");
            win1.setBounds(250,100,750,220);
            win1.setFont(new Font("Algerian", Font.ITALIC, 50));
            win1.setForeground(Color.red);

            JLabel win2 = new JLabel("Player O has won the game");
            win2.setBounds(200,300,900,220);
            win2.setFont(new Font("Calibri", Font.PLAIN, 50));
            win2.setForeground(Color.white);

            win.add(win1);
            win.add(win2);
            win.add(Wallpaper);
            return;
        }
        if(Gmno==6)
        {
            ob.dispose();
            checkit = true;
            if(Xwin > Owin)
            {
                Xwin = 3;
                hasWon(a,b);
            }
            else if(Xwin < Owin)
            {
                Owin = 3;
                hasWon(a,b);
            }
            else
            {
                ob.dispose();
                JFrame win = new JFrame();
                win.setSize(1000,640);
                win.setVisible(true);
                win.setLayout(null);
                JLabel win1 = new JLabel("GAME OVER");
                win1.setBounds(250,100,750,220);
                win1.setFont(new Font("Algerian", Font.ITALIC, 50));
                win1.setForeground(Color.blue);

                JLabel win2 = new JLabel("THE MATCH IS TIED");
                win2.setBounds(250,300,900,220);
                win2.setFont(new Font("Calibri", Font.PLAIN, 50));
                win2.setForeground(Color.magenta);

                win.add(win1);
                win.add(win2);
                return;
            }
        }
    }
}