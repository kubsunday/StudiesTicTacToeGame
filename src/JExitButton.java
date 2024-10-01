import javax.swing.*;
import java.awt.*;

public class JExitButton extends JButton {
    MyFrame myFrame;
    public JExitButton( String name, MyFrame myFrame ) {
        this.myFrame=myFrame;
        Dimension dimension = new Dimension(200, 100);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        setText(name);
        this.addActionListener(e -> {
            System.exit(0);
        });
    }
}
