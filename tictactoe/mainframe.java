import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class mainframe
{
    static void game()
    {
        final JFrame main = new JFrame();
        main.setSize(1000,640);
        main.setLayout(null);
        main.setVisible(true);
        main.setTitle("Abhinav's TIC-TAC-TOE");
        
        JLabel head = new JLabel("Let's play Tic-Tac-Toe");
        head.setBounds(100,50,800,150);
        head.setFont(new Font("Forte", Font.PLAIN, 90));
        head.setForeground(Color.white);
        
        JButton vsFriend = new JButton("vs FRIEND");
        vsFriend.setFont(new Font("Ariel", Font.PLAIN, 20));
        vsFriend.setBounds(400,250,200,75);
        vsFriend.setBackground(Color.lightGray);
        vsFriend.setForeground(Color.black);
        
        JButton vsComp = new JButton("vs COMPUTER");
        vsComp.setFont(new Font("Ariel", Font.PLAIN, 20));
        vsComp.setBounds(400,350,200,75);
        vsComp.setBackground(Color.lightGray);
        vsComp.setForeground(Color.black);
        
        JButton Exit = new JButton("EXIT GAME");
        Exit.setFont(new Font("Ariel", Font.PLAIN, 20));
        Exit.setBounds(400,450,200,70);
        Exit.setBackground(Color.lightGray);
        Exit.setForeground(Color.black);
        
        JLabel Wallpaper = new JLabel();
        Wallpaper.setBounds(0,0,1000,640);
        Wallpaper.setIcon(new ImageIcon("C:\\Users\\deadpool\\Desktop\\abh\\tictactoe\\abc.jpg"));
        
        main.add(vsFriend);
        main.add(vsComp);
        main.add(Exit);
        main.add(head);
        main.add(Wallpaper);
        main.repaint();
        
        vsFriend.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    main.dispose();
                    tictactoe1 ob = new tictactoe1();
                    ob.main();
                }
            });
        vsComp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    main.dispose();
                    tictactoe2 ob = new tictactoe2();
                    ob.player();
                }
            });
        Exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    int a = JOptionPane.showConfirmDialog(null,"Are you afraid of playing ?");
                    if(a==0)
                    {
                        JOptionPane.showMessageDialog(null,"Good-Bye.");
                        main.dispose();
                    }
                }
            });
    }
}
        