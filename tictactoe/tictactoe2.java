import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class tictactoe2
{
    JFrame ob;
    JLabel turn, gm, xwin, owin, Draw, Wallpaper;
    String sign = "";
    JButton b[] = new JButton[9];
    JButton reset, resetThis, exit, playasX, playasO, back, menu;
    int chance = 1,i = 0,Gmno = 1,Xwin = 0,Owin = 0,draw = 0,timesclicked = 0;
    int fp = 0,sp = 0;
    boolean computerIsX = false;
    //chance 1 is for X in the first game
    boolean clicked[] = new boolean[9];
    boolean Xchecker[] = new boolean[9];
    boolean Ochecker[] = new boolean[9];
    boolean checkit = false;
    boolean start = false;
    int N = 1;

    void player()
    {
        ob = new JFrame();
        ob.setSize(1000,640);
        ob.setVisible(true);
        ob.setLayout(null);
        ob.setTitle("Abhinav's TIC-TAC-TOE");

        JLabel head = new JLabel("Select your side");
        head.setBounds(200,50,1000,150);
        head.setFont(new Font("Forte", Font.PLAIN, 90));
        head.setForeground(Color.white);
        ob.add(head);

        playasX = new JButton("PLAY AS 'X'");
        playasX.setFont(new Font("Ariel", Font.PLAIN, 20));
        playasX.setBounds(400,250,200,75);
        playasX.setBackground(Color.lightGray);
        playasX.setForeground(Color.black);
        ob.add(playasX);

        playasO = new JButton("PLAY AS 'O'");
        playasO.setFont(new Font("Ariel", Font.PLAIN, 20));
        playasO.setBounds(400,350,200,75);
        playasO.setBackground(Color.lightGray);
        playasO.setForeground(Color.black);
        ob.add(playasO);

        back = new JButton("BACK TO MENU");
        back.setFont(new Font("Ariel", Font.PLAIN, 20));
        back.setBounds(400,450,200,75);
        back.setBackground(Color.lightGray);
        back.setForeground(Color.black);
        ob.add(back);

        Wallpaper = new JLabel();
        Wallpaper.setBounds(0,0,1000,640);
        Wallpaper.setIcon(new ImageIcon("C:\\Users\\deadpool\\Desktop\\abh\\tictactoe\\abc.jpg"));
        ob.add(Wallpaper);

        playasX.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    ob.dispose();
                    main();
                }
            });
        playasO.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    computerIsX = true;
                    ob.dispose();
                    main();
                }
            });
        back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    ob.dispose();
                    mainframe obj = new mainframe();
                    obj.game();
                }
            });
    }

    void main()
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

        double a = Math.random();
        if(a<=0.25) fp = 2;
        else if(a>0.25 && a<=0.5)   fp = 6;
        else if(a>0.5 && a<=0.75)   fp = 8;

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

        turn = new JLabel((!computerIsX)?"X":"O");
        turn.setBounds(700,50,150,150);
        turn.setFont(new Font("Ariel", Font.PLAIN, 150));
        turn.setForeground((!computerIsX)?Color.red:Color.green);
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

        if(computerIsX)
        {
            ob.remove(turn);
            turn.setText("O");
            turn.setForeground(Color.green);
            b[fp].setText("X");
            b[fp].setFont(new Font("Ariel", Font.PLAIN, 200));
            b[fp].setBackground(Color.blue);
            b[fp].setForeground(Color.white);
            ob.add(turn);
            ob.add(Wallpaper);
            Xchecker[fp] = true;
            timesclicked++;
            chance--;
            clicked[fp] = true;
        }

        ob.repaint();

        reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure ?","Are you sure",JOptionPane.YES_NO_CANCEL_OPTION);    
                    if(a==0)
                    {
                        ob.dispose();
                        tictactoe2 obj = new tictactoe2();
                        obj.player();
                    }
                }
            });
        exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to leave the game?");
                    if(a==0)
                    {
                        int b = JOptionPane.showConfirmDialog(null,"Does it mean that you are afraid of playing?","You are afraid!!",JOptionPane.YES_NO_CANCEL_OPTION);
                        if(b==0)
                            ob.dispose();
                    }
                }
            });
        resetThis.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you sure?");
                    if(a==0)
                    {
                        ob.dispose();
                        fp = 0;sp = 0;N = 1;
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
    }

    void OnClick(int a)
    {
        if(!clicked[a])
        {
            if(computerIsX)
            {
                b[a].setText("O");
                b[a].setFont(new Font("Ariel", Font.PLAIN, 200));
                b[a].setBackground(Color.pink);
                b[a].setForeground(Color.black);
                Ochecker[a] = true;
                timesclicked++;
                chance++;
                clicked[a] = true;
                if(N == 1)
                {
                    sp = ((fp == 0)?8:((fp == 2)?6:((fp == 6)?2:0)));

                    if(sp == a)
                    {
                        sp = ((fp == 0)?6:((fp == 2)?0:((fp == 6)?8:2)));
                    }

                    b[sp].setText("X");
                    b[sp].setFont(new Font("Ariel", Font.PLAIN, 200));
                    b[sp].setBackground(Color.blue);
                    b[sp].setForeground(Color.white);
                    Xchecker[sp] = true;
                    timesclicked++;
                    chance--;
                    clicked[sp] = true;
                    N++;
                }
                else if(N == 2)
                {
                    String arr[] = {"0,1,2","0,3,6","0,4,8","1,4,7","2,5,8","2,4,6","3,4,5","6,7,8"};
                    for(int i = 0;i<8;i++)
                    {
                        String temp = arr[i];
                        int x1 = Integer.parseInt(temp.split(",")[0]);
                        int x2 = Integer.parseInt(temp.split(",")[1]);
                        int x3 = Integer.parseInt(temp.split(",")[2]);

                        if((Xchecker[x1] && Xchecker[x2]) || (Xchecker[x2] && Xchecker[x3]) || (Xchecker[x1] && Xchecker[x3]))
                        {
                            int t = ((Xchecker[x1] && Xchecker[x2])?x3:((Xchecker[x1] && Xchecker[x3])?x2:x1));
                            if(!Ochecker[t])
                            {
                                b[t].setText("X");
                                b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                                b[t].setBackground(Color.blue);
                                b[t].setForeground(Color.white);
                                Xchecker[t] = true;
                                timesclicked++;
                                chance--;
                                clicked[t] = true;
                                hasWon(Xchecker,Ochecker);
                                return;
                            }
                        }
                    }
                    for(int i = 0;i<8;i++)
                    {
                        String temp = arr[i];
                        int x1 = Integer.parseInt(temp.split(",")[0]);
                        int x2 = Integer.parseInt(temp.split(",")[1]);
                        int x3 = Integer.parseInt(temp.split(",")[2]);

                        if((Ochecker[x1] && Ochecker[x2]) || (Ochecker[x2] && Ochecker[x3]) || (Ochecker[x1] && Ochecker[x3]))
                        {
                            int t = ((Ochecker[x1] && Ochecker[x2])?x3:((Ochecker[x1] && Ochecker[x3])?x2:x1));
                            if(!Xchecker[t])
                            {
                                b[t].setText("X");
                                b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                                b[t].setBackground(Color.blue);
                                b[t].setForeground(Color.white);
                                Xchecker[t] = true;
                                timesclicked++;
                                chance--;
                                clicked[t] = true;
                                hasWon(Xchecker,Ochecker);
                                return;
                            }
                        }
                    }
                    for(int i = 0;i<8;i++)
                    {
                        String temp = arr[i];
                        int x1 = Integer.parseInt(temp.split(",")[0]);
                        int x2 = Integer.parseInt(temp.split(",")[1]);
                        int x3 = Integer.parseInt(temp.split(",")[2]);
                        if(fp == 0 && sp == 6)
                        {
                            int t = ((Ochecker[2])?8:2);
                            b[t].setText("X");
                            b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                            b[t].setBackground(Color.blue);
                            b[t].setForeground(Color.white);
                            Xchecker[t] = true;
                            timesclicked++;
                            chance--;
                            clicked[t] = true;
                            break;
                        }
                        else if(fp == 2 && sp == 0)
                        {
                            int t = ((Ochecker[6])?8:6);
                            b[t].setText("X");
                            b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                            b[t].setBackground(Color.blue);
                            b[t].setForeground(Color.white);
                            Xchecker[t] = true;
                            timesclicked++;
                            chance--;
                            clicked[t] = true;
                            break;
                        }
                        else if(fp == 8 && sp == 2)
                        {
                            int t = ((Ochecker[0])?6:0);
                            b[t].setText("X");
                            b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                            b[t].setBackground(Color.blue);
                            b[t].setForeground(Color.white);
                            Xchecker[t] = true;
                            timesclicked++;
                            chance--;
                            clicked[t] = true;
                            break;
                        }
                        else if(fp == 6 && sp == 8)
                        {
                            int t = ((Ochecker[2])?0:2);
                            b[t].setText("X");
                            b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                            b[t].setBackground(Color.blue);
                            b[t].setForeground(Color.white);
                            Xchecker[t] = true;
                            timesclicked++;
                            chance--;
                            clicked[t] = true;
                            break;
                        }
                        hasWon(Xchecker,Ochecker);
                    }
                }
            }
            else
            {
                b[a].setText("X");
                b[a].setFont(new Font("Ariel", Font.PLAIN, 200));
                b[a].setBackground(Color.blue);
                b[a].setForeground(Color.white);
                ob.add(Wallpaper);
                Xchecker[a] = true;
                timesclicked++;
                clicked[a] = true;
                if(N==1)
                {
                    N++;
                    if(!Xchecker[fp])
                    {
                        b[fp].setText("O");
                        b[fp].setFont(new Font("Ariel", Font.PLAIN, 200));
                        b[fp].setBackground(Color.pink);
                        b[fp].setForeground(Color.black);
                        ob.add(Wallpaper);
                        Ochecker[fp] = true;
                        timesclicked++;
                        clicked[fp] = true;
                    }
                    else
                    {
                        fp = ((fp == 0)?8:((fp == 2)?6:((fp == 6)?2:0)));
                        b[fp].setText("O");
                        b[fp].setFont(new Font("Ariel", Font.PLAIN, 200));
                        b[fp].setBackground(Color.pink);
                        b[fp].setForeground(Color.black);
                        ob.add(Wallpaper);
                        Ochecker[fp] = true;
                        timesclicked++;
                        clicked[fp] = true;
                    }
                }
                else if(N==2)
                {
                    String arr[] = {"0,1,2","0,3,6","0,4,8","1,4,7","2,5,8","2,4,6","3,4,5","6,7,8"};
                    for(int i = 0;i<8;i++)
                    {
                        String temp = arr[i];
                        int x1 = Integer.parseInt(temp.split(",")[0]);
                        int x2 = Integer.parseInt(temp.split(",")[1]);
                        int x3 = Integer.parseInt(temp.split(",")[2]);

                        if((Ochecker[x1] && Ochecker[x2]) || (Ochecker[x2] && Ochecker[x3]) || (Ochecker[x1] && Ochecker[x3]))
                        {
                            int t = ((Ochecker[x1] && Ochecker[x2])?x3:((Ochecker[x1] && Ochecker[x3])?x2:x1));
                            if(!Xchecker[t])
                            {
                                b[t].setText("O");
                                b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                                b[t].setBackground(Color.pink);
                                b[t].setForeground(Color.black);
                                Ochecker[t] = true;
                                timesclicked++;
                                clicked[t] = true;
                                hasWon(Xchecker,Ochecker);
                                return;
                            }
                        }
                    }
                    for(int i = 0;i<8;i++)
                    {
                        String temp = arr[i];
                        int x1 = Integer.parseInt(temp.split(",")[0]);
                        int x2 = Integer.parseInt(temp.split(",")[1]);
                        int x3 = Integer.parseInt(temp.split(",")[2]);

                        if((Xchecker[x1] && Xchecker[x2]) || (Xchecker[x2] && Xchecker[x3]) || (Xchecker[x1] && Xchecker[x3]))
                        {
                            int t = ((Xchecker[x1] && Xchecker[x2])?x3:((Xchecker[x1] && Xchecker[x3])?x2:x1));
                            if(!Ochecker[t])
                            {
                                b[t].setText("O");
                                b[t].setFont(new Font("Ariel", Font.PLAIN, 200));
                                b[t].setBackground(Color.pink);
                                b[t].setForeground(Color.black);
                                Ochecker[t] = true;
                                timesclicked++;
                                clicked[t] = true;
                                hasWon(Xchecker,Ochecker);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }    

    void hasWon(boolean a[],boolean b[])
    {
        if(!checkit &&((a[0]&&a[1]&&a[2])||(a[0]&&a[3]&&a[6])||(a[0]&&a[4]&&a[8])||(a[1]&&a[4]&&a[7])||(a[2]&&a[4]&&a[6])||(a[2]&&a[5]&&a[8])||(a[3]&&a[4]&&a[5])||(a[6]&&a[7]&&a[8])))
        {
            JOptionPane.showMessageDialog(null,"Player 'X' Won game "+Gmno);
            ob.dispose();
            Gmno++;
            Xwin++;
            fp = 0;sp = 0;N = 1;
            main();
        }
        if(!checkit && ((b[0]&&b[1]&&b[2])||(b[0]&&b[3]&&b[6])||(b[0]&&b[4]&&b[8])||(b[1]&&b[4]&&b[7])||(b[2]&&b[4]&&b[6])||(b[2]&&b[5]&&b[8])||(b[3]&&b[4]&&b[5])||(b[6]&&b[7]&&b[8])))
        {
            JOptionPane.showMessageDialog(null,"Player 'O' Won game "+Gmno);
            ob.dispose();
            Gmno++;
            Owin++;
            fp = 0;sp = 0;N = 1;
            main();
        }
        if(!checkit && timesclicked == 9)
        {
            JOptionPane.showMessageDialog(null,"Game Draw");
            ob.dispose();
            Gmno++;
            draw++;
            fp = 0;sp = 0;N = 1;
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
            win2.setBounds(220,300,900,220);
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
            win2.setBounds(220,300,900,220);
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

