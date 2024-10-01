import javax.swing.*;
import java.awt.*;

public class JCenterPanel extends JPanel {
    private JUltimateTicTacToe jUltimateTicTacToe;
    private JRightPanel jRightPanel;
    public JCenterPanel(JUltimateTicTacToe jUltimateTicTacToe) {
        this.jUltimateTicTacToe=jUltimateTicTacToe;
        setBackground(Color.DARK_GRAY);
        setLayout(new FlowLayout());
        this.add(jUltimateTicTacToe);
        this.setVisible(true);

    }

}
