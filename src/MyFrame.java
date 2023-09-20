import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame implements ActionListener {
    int[][] mat=new int[3][3];
    int moves_made=0;
    boolean player1turn=true;
    JFrame frame;
    JPanel panel1,panel2;
    JLabel label1;
    JButton button1,button2,button3,button4,button5,button6,button7,button8,button9;
    public MyFrame(){


        //INTERFACE DESIGN
        //FRAME
        ImageIcon ic=new ImageIcon("logo.png");
        frame=new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500,540);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setIconImage(ic.getImage());
        frame.setTitle("Tic-Tac-Toe");

        //PANELS
        //Panel1
        panel1=new JPanel();
        panel1.setBounds(0,0,500,60);
        panel1.setPreferredSize(new Dimension(600,100));
        panel1.setBackground(Color.BLACK);

        //Panel2
        panel2=new JPanel();
        panel2.setBounds(0,60,500,440);
        panel2.setPreferredSize(new Dimension(600,400));
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new GridLayout(3,3,0,0));

        //LABELS
        //Label1
        label1=new JLabel();
        label1.setFont(new Font("INK FREE", Font.BOLD,40));
        label1.setForeground(Color.green);
        label1.setText("TIC-TAC-TOE");


        //BUTTONS
        //Button1
        button1 =new JButton();
        button2=new JButton();
        button3 =new JButton();
        button4=new JButton();
        button5 =new JButton();
        button6=new JButton();
        button7 =new JButton();
        button8=new JButton();
        button9 =new JButton();

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);


        //Adding components
        panel1.add(label1);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);

        frame.add(panel1);
        frame.add(panel2);


        //GAME BACKEND
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                mat[i][j]=-1;
            }
        }
    }
    boolean checkplayer1(int i,int j){

        //check horizontal
        int count=0;
        for(int x=0;x<3;x++){
            if(mat[i][x]==1) count++;
        }
        if(count==3) return true;
        count=0;
        //check vertical
        for(int x=0;x<3;x++){
            if(mat[x][j]==1) count++;
        }
        if(count==3) return true;
        count=0;
        //check left diagonal
        for(int x=0;x<3;x++){
            if(mat[x][x]==1) count++;
        }
        if(count==3) return true;
        count=0;
        //check right diagonal
        int x=0,y=2;
        while(x<3 && y>=0){
            if(mat[x][y]==1) count++;
            x++;
            y--;
        }
        if(count==3) return true;
        return false;
    }
    boolean checkplayer2(int i,int j){

        //check horizontal
        int count=0;
        for(int x=0;x<3;x++){
            if(mat[i][x]==2) count++;
        }
        if(count==3) return true;
        count=0;
        //check vertical
        for(int x=0;x<3;x++){
            if(mat[x][j]==2) count++;
        }
        if(count==3) return true;
        count=0;
        //check left diagonal
        for(int x=0;x<3;x++){
            if(mat[x][x]==2) count++;
        }
        if(count==3) return true;
        count=0;
        //check right diagonal
        int x=0,y=2;
        while(x<3 && y>=0){
            if(mat[x][y]==2) count++;
            x++;
            y--;
        }
        if(count==3) return true;
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            int i=0,j=0;
            moves_made++;
            if(player1turn==true){
                label1.setText("Player 2's turn");
                button1.setText("X");
                button1.setFont(new Font("INK FREE",Font.BOLD,35));
                button1.setForeground(Color.BLACK);
                button1.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button1.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button1.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }

        if(e.getSource()==button2){
            int i=0,j=1;
            moves_made++;
            if(player1turn==true){
                label1.setText("Player 2's turn");
                button2.setText("X");
                button2.setFont(new Font("INK FREE",Font.BOLD,35));
                button2.setForeground(Color.BLACK);
                button2.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button2.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button2.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button3){
            int i=0,j=2;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button3.setText("X");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button3.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button3.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button3.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button4){
            int i=1,j=0;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button4.setText("X");
                button4.setFont(new Font("INK FREE",Font.BOLD,35));
                button4.setForeground(Color.BLACK);
                button4.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button4.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button4.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button5){
            int i=1,j=1;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button5.setText("X");
                button5.setFont(new Font("INK FREE",Font.BOLD,35));
                button5.setForeground(Color.BLACK);
                button5.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button5.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button5.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button6){
            int i=1,j=2;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button6.setText("X");
                button6.setFont(new Font("INK FREE",Font.BOLD,35));
                button6.setForeground(Color.BLACK);
                button6.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button6.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button6.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button7){
            int i=2,j=0;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button7.setText("X");
                button7.setFont(new Font("INK FREE",Font.BOLD,35));
                button7.setForeground(Color.BLACK);
                button7.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button7.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button7.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button8){
            int i=2,j=1;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button8.setText("X");
                button8.setFont(new Font("INK FREE",Font.BOLD,35));
                button8.setForeground(Color.BLACK);
                button8.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button8.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button8.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
        if(e.getSource()==button9){
            int i=2,j=2;
            moves_made++;
            if(player1turn){
                label1.setText("Player 2's turn");
                button9.setText("X");
                button9.setFont(new Font("INK FREE",Font.BOLD,35));
                button9.setForeground(Color.BLACK);
                button9.setEnabled(false);
                mat[i][j]=1;
                if(checkplayer1(i,j)){
                    label1.setText("PLAYER 1 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=false;
            }
            else{
                label1.setText("Player 1's turn");
                button9.setText("O");
                button3.setFont(new Font("INK FREE",Font.BOLD,35));
                button3.setForeground(Color.BLACK);
                button9.setEnabled(false);
                mat[i][j]=2;
                if(checkplayer2(i,j)){
                    label1.setText("PLAYER 2 WINS");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setEnabled(false);
                    button6.setEnabled(false);
                    button7.setEnabled(false);
                    button8.setEnabled(false);
                    button9.setEnabled(false);
                }
                else{
                    if(moves_made==9){
                        label1.setText("DRAW");
                    }
                }
                player1turn=true;
            }
        }
    }
}