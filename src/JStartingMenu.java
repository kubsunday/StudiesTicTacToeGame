import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JStartingMenu extends JPanel {
    MyFrame myFrame;
    JMainPanel jMainPanel;
    List<JButton> jButtonList;
    public JStartingMenu(MyFrame myFrame, JMainPanel jMainPanel) {
        this.jButtonList= new ArrayList<>();
        Dimension dimension = new Dimension(200, 100);
        this.jMainPanel=jMainPanel;
        this.myFrame=myFrame;
        JButton newGame = new JButton("Nowa Gra");
        JButton exitGame = new JButton("Zamknij");
        jButtonList.add(newGame);
        jButtonList.add(exitGame);
        for (JButton e:jButtonList) {
            e.setPreferredSize(dimension);
            e.setMinimumSize(dimension);
            e.setMaximumSize(dimension);
        }

        add(newGame);
        add(exitGame);
        setBackground(Color.GRAY);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.getContentPane().remove(JStartingMenu.this);
                myFrame.add(jMainPanel);
                myFrame.revalidate();
                myFrame.repaint();
                myFrame.setVisible(true);
                JOptionsMenu jOptionsMenu = new JOptionsMenu(myFrame,jMainPanel.jUltimateTicTacToe,"dkjasiojdasid",true);

            }
        });


        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }
}
