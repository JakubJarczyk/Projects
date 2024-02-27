import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener {
    JButton newGameButton = new JButton("New Game");
    JButton highScoresButton = new JButton("High Scores");
    JButton exitButton = new JButton("Exit");

    JLabel imageLabel = new JLabel();
    JLabel imageLabel2 = new JLabel();
    JLabel imageLabel3 = new JLabel();

   ImageIcon icon = new ImageIcon("title04.png");
    ImageIcon icon2 = new ImageIcon("The.png");
    ImageIcon icon3 = new ImageIcon("against.png");


    Menu() {
        setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setResizable(false);
        setSize(420, 420);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);

        newGameButton.setBounds(120, 150, 150, 50);
        newGameButton.setBackground(Color.red);
        add(newGameButton);
        newGameButton.addActionListener(this);
        highScoresButton.setBounds(120, 210, 150, 50);
        highScoresButton.setBackground(Color.red);
        add(highScoresButton);
       highScoresButton.addActionListener(this);
        exitButton.setBounds(120, 270, 150, 50);
       exitButton.setBackground(Color.red);
        add(exitButton);
        exitButton.addActionListener(this);

imageLabel.setIcon(icon);
        imageLabel2.setIcon(icon2);
        imageLabel3.setIcon(icon3);
imageLabel.setBounds(110,60,300,100);
        imageLabel2.setBounds(155,30,300,100);
        imageLabel3.setBounds(95,0,300,100);
add(imageLabel);
add(imageLabel2);
        add(imageLabel3);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newGameButton){
            NewGame newGame = new NewGame();
            dispose();
        } else if (e.getSource()==highScoresButton) {
            HighScores highScores = new HighScores();
            dispose();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}