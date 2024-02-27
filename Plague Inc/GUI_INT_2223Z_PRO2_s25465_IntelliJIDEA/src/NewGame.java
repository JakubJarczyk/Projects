import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame implements ActionListener {
    JLabel newGame = new JLabel();
    JLabel diffLvl = new JLabel();
    JLabel ifnoLabel = new JLabel();
    ImageIcon newGameIcon = new ImageIcon("NewGame.png");

    ImageIcon diffLvlIcon = new ImageIcon("difflvl.png");
    ImageIcon expert = new ImageIcon("expert.png");
    ImageIcon novice = new ImageIcon("novice.png");
    ImageIcon standart = new ImageIcon("standart.png");

    JButton start = new JButton("Start");

    JComboBox difLvlBox;



    public NewGame() {
        setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
        setSize(420, 420);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
String[] difficultyLevels = {"Novice","Standart","Expert"};
 difLvlBox = new JComboBox(difficultyLevels);
 difLvlBox.addActionListener(this);
newGame.setIcon(newGameIcon);
       diffLvl.setIcon(diffLvlIcon);
newGame.setBounds(120,0,200,50);
        diffLvl.setBounds(5,80,200,30);
add(newGame);
add(diffLvl);

difLvlBox.setSelectedIndex(0);
difLvlBox.addActionListener(this);
difLvlBox.setBackground(Color.RED);
difLvlBox.setBounds(160,70,100,50);
        add(difLvlBox);

        ifnoLabel.setBounds(270,70,200,50);
        ifnoLabel.setIcon(novice);
        add(ifnoLabel);

        start.setBackground(Color.RED);
        start.setBounds(160,160,100,50);
        start.addActionListener(this);
        add(start);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==difLvlBox){
  JComboBox cb = (JComboBox)e.getSource();
  String msg = (String)cb.getSelectedItem();
    switch (msg) {
        case "Novice" -> {
            ifnoLabel.setIcon(novice);
Game.gameMultiplier = 80;
Game.gameMultiplier2 = 30;
        }
        case "Standart" -> {
            ifnoLabel.setIcon(standart);
            Game.gameMultiplier = 100;
            Game.gameMultiplier2 = 25;
        }
        case "Expert" -> {
            ifnoLabel.setIcon(expert);
            Game.gameMultiplier = 150;
            Game.gameMultiplier2 = 30;
        }
    }
} else if (e.getSource()==start) {
    Game game = new Game();
    dispose();
}


}
    }

