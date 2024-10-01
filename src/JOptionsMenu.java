import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JOptionsMenu extends JDialog {
    private JUltimateTicTacToe jUltimateTicTacToe;
    private List<JTicTacToe> jTicTacToeList;
    private JHistoryTableModel jHistoryTableModel;
    private MyFrame myFrame;
    private String title;
    private boolean modal;
    private BotMechanism botMechanism;
    private JRadioButton botEnabledRadioButton;
    private JRadioButton botDisabledRadioButton;
    private ButtonGroup botButtonGroup;
    public JOptionsMenu(MyFrame myFrame,JUltimateTicTacToe jUltimateTicTacToe, String title, boolean modal) {
        this.jUltimateTicTacToe=jUltimateTicTacToe;
        this.jTicTacToeList=jUltimateTicTacToe.getjTicTacToeList();
        this.myFrame=myFrame;
        this.title=title;
        this.modal=modal;
        this.setLayout(new FlowLayout());
        this.setSize(700,300);
        this.setLocationRelativeTo(myFrame);
        JLabel label = new JLabel("Wybierz grę");
        JButton startButton = new JButton("Start");
        startButton.setEnabled(false);
        botEnabledRadioButton = new JRadioButton("Gra z komputerem");
        botDisabledRadioButton = new JRadioButton("Gra Multiplayer");
        botButtonGroup = new ButtonGroup();
        botButtonGroup.add(botEnabledRadioButton);
        botButtonGroup.add(botDisabledRadioButton);
        ActionListener radioButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botEnabledRadioButton) {
                    botMechanism = new BotMechanism(true, TileType.CROSS);
                    startButton.setEnabled(true);
                } else if (e.getSource() == botDisabledRadioButton) {
                    botMechanism =  new BotMechanism(false, TileType.CROSS);
                    startButton.setEnabled(true);
                }
            }
        };
        botEnabledRadioButton.addActionListener(radioButtonListener);
        botDisabledRadioButton.addActionListener(radioButtonListener);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAll();
                for (int i=0; i<9;i++){
                    for (int j=0; j<9;j++){
                        jTicTacToeList.get(i).jTicTacToeButtonList.get(j).setBotMechanism(botMechanism);
                    }
                }
                dispose();
            }
        });

        this.add(label);
        this.add(botEnabledRadioButton);
        this.add(botDisabledRadioButton);
        this.add(startButton);

        this.setVisible(true);
    }
    public void resetAll(){
        for (Component e : jUltimateTicTacToe.getComponentList()){
            jUltimateTicTacToe.remove(e);
        }
        for (JTicTacToe k : jUltimateTicTacToe.jTicTacToeList){
            k.resetJTicTacToeTable();
            jUltimateTicTacToe.add(k);
            jUltimateTicTacToe.revalidate();
            jUltimateTicTacToe.repaint();
        }
        jUltimateTicTacToe.setNewJHistoryTableModel();
        jUltimateTicTacToe.revalidate();
        jUltimateTicTacToe.repaint();

    }

    public void setBotMechanism(BotMechanism botMechanism) {
        this.botMechanism = botMechanism;
    }
}
