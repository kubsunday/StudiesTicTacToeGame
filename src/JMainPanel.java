import javax.swing.*;
import java.awt.*;

public class JMainPanel extends JPanel {
    MyFrame myFrame;
    JUltimateTicTacToe jUltimateTicTacToe;
    JRightPanel jRightPanel;
    JCenterPanel jCenterPanel;

    public JMainPanel(MyFrame myFrame) {
        this.myFrame=myFrame;
        this.jUltimateTicTacToe=new JUltimateTicTacToe();
        setLayout(new GridLayout(1,2,1,1));
        jRightPanel = new JRightPanel(jUltimateTicTacToe, myFrame);
        jCenterPanel = new JCenterPanel(jUltimateTicTacToe);
        setBackground(Color.GREEN);
        this.add(jCenterPanel);
        this.add(jRightPanel);
        setVisible(true);
    }
}
