import java.util.List;
import java.util.Random;

public class BotMechanism {
    private boolean status;
    private TileType tileType;
    private Random random;
    public BotMechanism(boolean status, TileType tileType) {
        this.random=new Random();
        this.status=status;
        this.tileType=tileType;
    }
    public void botMove(List<JTicTacToe> jTicTacToeList, JTicTacToeButton lastButtonClicked) {
        boolean botMoved = false;
        while (!botMoved) {
            int targetBoardIndex = lastButtonClicked.getId() % 9;
            JTicTacToe targetBoard = jTicTacToeList.get(targetBoardIndex);

            if (!targetBoard.isActive()) {
                targetBoard = getNextActiveBoard(jTicTacToeList);
            }

            int botMoveIndex = botSetTile();
            JTicTacToeButton targetButton = targetBoard.getjTicTacToeButtonList().get(botMoveIndex);

            if (targetButton.isState()) {
                targetButton.buttonAction();
                botMoved = true;
            }
        }
    }

    private JTicTacToe getNextActiveBoard(List<JTicTacToe> jTicTacToeList) {
        for (JTicTacToe board : jTicTacToeList) {
            if (board.isActive()) {
                return board;
            }
        }
        return null;
    }
    public int botSetTile(){
        return random.nextInt(9);
    }

    public boolean isStatus() {
        return status;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Random getRandom() {
        return random;
    }
}
