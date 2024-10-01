import java.util.List;

public class TicTacToeRules {
    private List<JTicTacToeButton> jTicTacToeButtonList;
    private List<JTicTacToe> jTicTacToeList;



    public TicTacToeRules(List<JTicTacToeButton> jTicTacToeButtonList) {
        this.jTicTacToeButtonList = jTicTacToeButtonList;
    }



    public boolean draw() {
        for (JTicTacToeButton button : jTicTacToeButtonList) {
            if (button.getTileType() == TileType.BLANK) {
                return false;
            }
        }
        if (!linesChecker(TileType.CIRCLE) && !linesChecker(TileType.CROSS)) {
            return true;
        }
        return false;
    }

    public boolean linesChecker(TileType tileType) {
        return (lineX(0, tileType) || lineX(1, tileType) || lineX(2, tileType) ||
                lineY(0, tileType) || lineY(1, tileType) || lineY(2, tileType) ||
                lineDiagonal(tileType));
    }

    private boolean lineX(int i, TileType tileType){
        return (this.jTicTacToeButtonList.get(0 + i * 3).getTileType() == tileType &&
                this.jTicTacToeButtonList.get(1 + i * 3).getTileType() == tileType &&
                this.jTicTacToeButtonList.get(2 + i * 3).getTileType() == tileType);
    }

    private boolean lineY(int i, TileType tileType){
        return (this.jTicTacToeButtonList.get(i).getTileType() == tileType &&
                this.jTicTacToeButtonList.get(3 + i).getTileType() == tileType &&
                this.jTicTacToeButtonList.get(6 + i).getTileType() == tileType);
    }

    private boolean lineDiagonal(TileType tileType){
        return ((this.jTicTacToeButtonList.get(0).getTileType() == tileType &&
                this.jTicTacToeButtonList.get(4).getTileType() == tileType &&
                this.jTicTacToeButtonList.get(8).getTileType() == tileType) ||
                (this.jTicTacToeButtonList.get(2).getTileType() == tileType &&
                        this.jTicTacToeButtonList.get(4).getTileType() == tileType &&
                        this.jTicTacToeButtonList.get(6).getTileType() == tileType));
    }
}