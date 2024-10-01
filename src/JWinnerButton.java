import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JWinnerButton extends JButton {
    private JTicTacToe jTicTacToe;
    private TileType tileType;
    private String path;
    private ImageIcon icon;

    public JWinnerButton(JTicTacToe jTicTacToe) {
        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLACK);
        this.jTicTacToe=jTicTacToe;
        this.tileType=this.jTicTacToe.getTileType();
        if (this.tileType==TileType.CROSS){
            this.path="src/Cross.jpg";
        } else if (this.tileType==TileType.CIRCLE) {
            this.path="src/Circle.jpg";
        } else if (tileType==TileType.BLANK) {
            this.path="src/Blank.jpg";
        }
        updateWinnerButton();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWinnerTable();
            }
        });
    }

    public void updateWinnerButton(){
        Image scaledImage = ImageUtils.loadImageAndScale(this.path, 200, 200);
        if (scaledImage != null) {
            icon = new ImageIcon(scaledImage);
            setIcon(icon);
        } else {
            System.err.println("Failed to load image: " + path);
        }
    }
    public void showWinnerTable() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Tic Tac Toe Board");
        dialog.setModal(true);
        dialog.setSize(300, 300);
        dialog.setLayout(new BorderLayout());
        dialog.add(jTicTacToe, BorderLayout.CENTER);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }
}
