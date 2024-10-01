import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private JMainPanel jMainPanel;
    private JStartingMenu jStartingMenu;

    public MyFrame() throws HeadlessException {
        setSize(1500,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jMainPanel = new JMainPanel(this);
        jStartingMenu = new JStartingMenu(this,jMainPanel);
        getContentPane().setBackground(Color.BLACK);
        this.add(jStartingMenu);

        setVisible(true);




    }

}
