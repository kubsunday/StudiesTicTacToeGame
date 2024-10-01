import java.util.List;

public class UltimateTicTacToeRules {
    private List<JTicTacToe> jTicTacToeList;

    public UltimateTicTacToeRules(List<JTicTacToe> jTicTacToeList) {
        this.jTicTacToeList = jTicTacToeList;
    }

    public boolean ultimateDraw() {
        for (JTicTacToe ticTacToe : jTicTacToeList) {
            if (ticTacToe.getTileType() == TileType.BLANK) {
                return false;
            }
        }
        if (!ultimateLinesChecker(TileType.CIRCLE) && !ultimateLinesChecker(TileType.CROSS)) {
            return true;
        }
        return false;
    }

    public boolean ultimateLinesChecker(TileType tileType) {
        return (ultimateLineX(0, tileType) || ultimateLineX(1, tileType) || ultimateLineX(2, tileType) ||
                ultimateLineY(0, tileType) || ultimateLineY(1, tileType) || ultimateLineY(2, tileType) ||
                ultimateLineDiagonal(tileType));
    }

    private boolean ultimateLineX(int i, TileType tileType) {
        return (this.jTicTacToeList.get(0 + i * 3).getTileType() == tileType &&
                this.jTicTacToeList.get(1 + i * 3).getTileType() == tileType &&
                this.jTicTacToeList.get(2 + i * 3).getTileType() == tileType);
    }

    private boolean ultimateLineY(int i, TileType tileType) {
        return (this.jTicTacToeList.get(i).getTileType() == tileType &&
                this.jTicTacToeList.get(3 + i).getTileType() == tileType &&
                this.jTicTacToeList.get(6 + i).getTileType() == tileType);
    }

    private boolean ultimateLineDiagonal(TileType tileType) {
        return ((this.jTicTacToeList.get(0).getTileType() == tileType &&
                this.jTicTacToeList.get(4).getTileType() == tileType &&
                this.jTicTacToeList.get(8).getTileType() == tileType) ||
                (this.jTicTacToeList.get(2).getTileType() == tileType &&
                        this.jTicTacToeList.get(4).getTileType() == tileType &&
                        this.jTicTacToeList.get(6).getTileType() == tileType));
    }

    public TileType getUltimateWinner() {
        if (ultimateLinesChecker(TileType.CIRCLE)) {
            return TileType.CIRCLE;
        } else if (ultimateLinesChecker(TileType.CROSS)) {
            return TileType.CROSS;
        } else {
            return TileType.BLANK;
        }
    }
}