import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JUltimateTicTacToe extends JPanel {
    private  JTable jHistoryTable;
    private JHistoryTableModel jHistoryTableModel;
    private List<Component> componentList;
    protected List<JTicTacToe> jTicTacToeList;
    private static List<Integer> numKeys = Arrays.asList(7,8,9,4,5,6,1,2,3);
    UltimateTicTacToeRules ultimateTicTacToeRules;


    public JUltimateTicTacToe() {
        this.ultimateTicTacToeRules=new UltimateTicTacToeRules(jTicTacToeList);
        this.componentList = new ArrayList<>();
        this.jTicTacToeList = new ArrayList<>();
        this.jHistoryTableModel = new JHistoryTableModel();
        this.jHistoryTable = new JTable(jHistoryTableModel);
        setBackground(Color.BLACK);
        setLayout(new GridLayout(3, 3, 4, 4));
        for (int i = 0; i < 9; i++) {
            JTicTacToe jTicTacToe = new JTicTacToe(i, numKeys.get(i));
            this.jTicTacToeList.add(jTicTacToe);
            this.componentList.add(jTicTacToe);
            this.add(jTicTacToe);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.jTicTacToeList.get(i).jTicTacToeButtonList.get(j).setjTicTacToeList(this.jTicTacToeList);
                this.jTicTacToeList.get(i).jTicTacToeButtonList.get(j).setjUltimateTicTacToe(this);
            }
        }
    }

    public void checkWinnerTable() {
        for (int i = 0; i < jTicTacToeList.size(); i++) {
            JTicTacToe e = jTicTacToeList.get(i);
            if ((e.getTileType() == TileType.CIRCLE || e.getTileType() == TileType.CROSS)&&e.isWin()==false) {
                e.setWin(true);
                remove(e);
                JWinnerButton jWinnerButton = new JWinnerButton(e);
                this.componentList.add(jWinnerButton);
                add(jWinnerButton, i);
                revalidate();
                repaint();
            }
        }
    }
    public void addMoveToHistory(int lp, String gracz, String glownaPlansza, String miejsce) {
        jHistoryTableModel.addMove(lp, gracz, glownaPlansza, miejsce);
    }

    public JTable getjHistoryTable() {
        return jHistoryTable;
    }

    public JHistoryTableModel getjHistoryTableModel() {
        return jHistoryTableModel;
    }

    public void setNewJHistoryTableModel() {
        this.jHistoryTableModel = new JHistoryTableModel();
        this.jHistoryTable.setModel(this.jHistoryTableModel);
    }
    public void setjHistoryTableModel(JHistoryTableModel jHistoryTableModel) {
        this.jHistoryTableModel = jHistoryTableModel;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public List<JTicTacToe> getjTicTacToeList() {
        return jTicTacToeList;
    }

    public void setjTicTacToeList(List<JTicTacToe> jTicTacToeList) {
        this.jTicTacToeList = jTicTacToeList;
    }
}
