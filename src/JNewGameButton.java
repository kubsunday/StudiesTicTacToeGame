import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JNewGameButton extends JButton {
    MyFrame myFrame;
    private JUltimateTicTacToe jUltimateTicTacToe;
    public JNewGameButton(String name, JUltimateTicTacToe jUltimateTicTacToe, MyFrame myFrame) {
        Dimension dimension = new Dimension(200, 100);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.myFrame=myFrame;
        this.jUltimateTicTacToe = jUltimateTicTacToe;
        setText(name);
        this.addActionListener(e -> {
            JOptionsMenu jOptionsMenu = new JOptionsMenu(myFrame, jUltimateTicTacToe, "dkasokdas",true);
        });


    }



}
