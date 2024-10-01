import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class JHistoryTableModel extends AbstractTableModel {
    private List<String[]> data;
    private final String[] columnNames = {"L.p.", "Gracz", "Główna Plansza", "Miejsce na Konkretnej Planszy"};

    public JHistoryTableModel() {
        this.data = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }
    public void addMove(int lp, String gracz, String glownaPlansza, String miejsce) {
        data.add(new String[]{String.valueOf(lp), gracz, glownaPlansza, miejsce});
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
