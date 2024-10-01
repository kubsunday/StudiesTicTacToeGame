import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JTicTacToe extends JPanel {
    private TileType tileType;
    private String name;
    private int id;
    private TicTacToeRules ticTacToeRules;
    private boolean win;
    private static List<String> ticTacToeName = Arrays.asList("LG", "SG", "PG","LL","SS","PP","LD","SD","PD");
    private static List<Integer> numKeys = Arrays.asList(7,8,9,4,5,6,1,2,3);
    private boolean active;
    protected List<JTicTacToeButton> jTicTacToeButtonList = new ArrayList<>();
    private int numTableKey;



    public JTicTacToe(int id, int numTableKey) {
        this.numTableKey=numTableKey;
        this.tileType=TileType.BLANK;
        this.id=id;
        this.name=nameByTheId(id);
        this.win=false;
        this.active=true;
        setLayout(new GridLayout(3,3,0,0));
        for (int i=0; i< 9; i++) {
            this.jTicTacToeButtonList.add(new JTicTacToeButton(i,numKeys.get(i)));
            this.add(jTicTacToeButtonList.get(i));
        }
        for (int i=0; i< 9; i++) {
            this.jTicTacToeButtonList.get(i).setjTicTacToe(this);
        }
        ticTacToeRules = new TicTacToeRules(this.jTicTacToeButtonList);

    }
    public void checkWinner() {
        if (ticTacToeRules.linesChecker(TileType.CIRCLE)) {
            System.out.println("The winner is circle" + this.getName());
            this.active=false;
            setVisible(true);
            this.tileType=TileType.CIRCLE;

        } else if (ticTacToeRules.linesChecker(TileType.CROSS)) {
            System.out.println("the winner is cross"+ this.getName());
            this.active=false;
            setVisible(true);
            this.tileType=TileType.CROSS;
        } else if (ticTacToeRules.draw()){
            System.out.println("draw"+ this.getName());
            this.active=false;
            this.name=getName();
        }
    }

    public void resetJTicTacToeTable(){
        this.tileType=TileType.BLANK;
        this.win=false;
        this.active=true;
        for (JTicTacToeButton e :jTicTacToeButtonList) {
            e.buttonReset();
        }
    }


    public String nameByTheId(int id) {
        for (int i=0; i<ticTacToeName.size(); i++){
            if (i==id){
                return ticTacToeName.get(i);
            }
        }
        return null;
    }

    public void setTicTacToeRules(TicTacToeRules ticTacToeRules) {
        this.ticTacToeRules = ticTacToeRules;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<JTicTacToeButton> getjTicTacToeButtonList() {
        return jTicTacToeButtonList;
    }

    public void setjTicTacToeButtonList(List<JTicTacToeButton> jTicTacToeButtonList) {
        this.jTicTacToeButtonList = jTicTacToeButtonList;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }
}
