import javax.swing.*;
import java.awt.*;

public class JRightPanel extends JPanel {
    JUltimateTicTacToe jUltimateTicTacToe;
    MyFrame myFrame;
    JHistoryTableModel jHistoryTableModel;
    JTable jHistoryTable;

    public JRightPanel(JUltimateTicTacToe jUltimateTicTacToe, MyFrame myFrame) {
        this.jHistoryTableModel = jUltimateTicTacToe.getjHistoryTableModel();
        this.jHistoryTable = jUltimateTicTacToe.getjHistoryTable();
        this.myFrame = myFrame;
        this.jUltimateTicTacToe = jUltimateTicTacToe;
        setPreferredSize(new Dimension(800, getHeight()));
        setLayout(new BorderLayout());
//        (new GridLayout(2, 1, 60, 60)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,1,50,50));
        JNewGameButton button1 = new JNewGameButton("Nowa Gra", jUltimateTicTacToe, myFrame);
        JExitButton button2 = new JExitButton("Zamknij", myFrame );
        button1.setPreferredSize(new Dimension(80, 50));
        button2.setPreferredSize(new Dimension(80, 50));
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(jHistoryTable),BorderLayout.CENTER);

        this.setVisible(true);
    }
}

