import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JTicTacToeButton extends JButton {


    static int moveCounter=1;
    private TileType tileType;
    private static int counter = 0;
    private int id;
    private static int imageCounter = 2;
    private boolean state;
    private String name;
    protected JTicTacToe jTicTacToe;
    private List<JTicTacToe> jTicTacToeList = new ArrayList<>();
    private static List<String> ticTacToeButtonName = Arrays.asList("LG", "SG", "PG","LL","SS","PP","LD","SD","PD");
    private int numButtonKey;
    private JUltimateTicTacToe jUltimateTicTacToe;
    private BotMechanism botMechanism;

    private String imagePath = "src/Blank.jpg";
    public JTicTacToeButton(int id, int numButtonKey) {
        this.setEnabled(false);
        this.numButtonKey=numButtonKey;
        this.name=nameByTheId(id);
        this.id=id;
        this.state=true;
        this.tileType=TileType.BLANK;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(state==true){
                    buttonAction();
                    if (botMechanism.isStatus()==true){
                        botMechanism.botMove(jTicTacToeList, JTicTacToeButton.this);
                    }
                }
            }
        });

        updateIcon();
        Dimension dimension = new Dimension(70, 70);
        setBackground(Color.BLACK);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        counter ++;

        System.out.println("Created button " + counter);
    }


    public void buttonAction(){
        buttonImageSwitcher();
        updateIcon();
        jTicTacToe.checkWinner();
        buttonSwitcher();
        jUltimateTicTacToe.checkWinnerTable();
        jUltimateTicTacToe.addMoveToHistory(
                moveCounter,
                tileType == TileType.CROSS ? "x" : "o",
                jTicTacToe.getName(),
                name
        );
        moveCounter++;
        UltimateTicTacToeRules rules = new UltimateTicTacToeRules(jTicTacToeList);
        TileType winner = rules.getUltimateWinner();
        if (winner != TileType.BLANK) {
            showWinnerDialog(winner);
            disableAllButtons();
        }
    }

    public void updateIcon() {
        Image scaledImage = ImageUtils.loadImageAndScale(imagePath, 70,70);
        if (scaledImage != null) {
            setIcon(new ImageIcon(scaledImage));
        } else {
            System.err.println("Failed to load image: " + imagePath);
        }
    }

    public void buttonImageSwitcher() {
        if (imageCounter%2==0) {
            this.imagePath = "src/Circle.jpg";
            this.tileType=TileType.CIRCLE;
        }else{
            this.imagePath = "src/Cross.jpg";
            this.tileType=TileType.CROSS;
        }
        imageCounter++;
        state=false;
    }
    public void buttonSwitcher(){
        disableAllButtons();
        int targetBoardIndex = id % 9;
        JTicTacToe targetBoard = jTicTacToeList.get(targetBoardIndex);

        if (targetBoard.isActive()) {
            for (JTicTacToeButton button : targetBoard.getjTicTacToeButtonList()) {
                button.setEnabled(true);
            }
        } else {
            for (JTicTacToe jTicTacToe : jTicTacToeList) {
                if (jTicTacToe.isActive()) {
                    for (JTicTacToeButton button : jTicTacToe.getjTicTacToeButtonList()) {
                        button.setEnabled(true);
                    }
                }
            }
        }
        for (JTicTacToe jTicTacToe : jTicTacToeList) {
            for (JTicTacToeButton button : jTicTacToe.getjTicTacToeButtonList()){
                if (button.tileType!=TileType.BLANK){
                    button.setEnabled(true);
                }
            }
        }
        }

    public void buttonReset() {
        this.setEnabled(true);
        this.state=true;
        this.imagePath="src/Blank.jpg";
        this.tileType=TileType.BLANK;
        this.updateIcon();
        imageCounter=2;
        for (int i=0; i<9; i++) {
            getjTicTacToeList().get(i).setActive(true);
        }
        moveCounter=1;
    }
    public String nameByTheId(int id) {
        for (int i=0; i<ticTacToeButtonName.size(); i++){
            if (i==id){
                return ticTacToeButtonName.get(i);
            }
        }
        return null;
    }
    private void showWinnerDialog(TileType winner) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Game Over");
        JLabel label = new JLabel("The winner is " + (winner == TileType.CIRCLE ? "Circle" : "Cross") + "!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(label);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
    private void disableAllButtons() {
        for (JTicTacToe jTicTacToe : jTicTacToeList) {
            for (JTicTacToeButton button : jTicTacToe.getjTicTacToeButtonList()) {
                button.setEnabled(false);
            }
        }
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public JTicTacToe getjTicTacToe() {
        return jTicTacToe;
    }

    public void setjTicTacToe(JTicTacToe jTicTacToe) {
        this.jTicTacToe = jTicTacToe;
    }


    public void setjTicTacToeList(List<JTicTacToe> jTicTacToeList) {
        this.jTicTacToeList = jTicTacToeList;
    }

    public List<JTicTacToe> getjTicTacToeList() {
        return jTicTacToeList;
    }

    public JUltimateTicTacToe getjUltimateTicTacToe() {
        return jUltimateTicTacToe;
    }

    public void setjUltimateTicTacToe(JUltimateTicTacToe jUltimateTicTacToe) {
        this.jUltimateTicTacToe = jUltimateTicTacToe;
    }

    public void setBotMechanism(BotMechanism botMechanism) {
        this.botMechanism = botMechanism;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }
}
