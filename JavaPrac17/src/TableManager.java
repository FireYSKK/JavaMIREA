import java.util.HashMap;
import java.util.Objects;

public class TableManager {
    private int size = 0;
    private Table[] tableArray = new Table[5];
    private OrderManager orderManager;

    public boolean add(Table table) {
        if (size >= tableArray.length - 1){
            Table[] newTables = new Table[size * 2];
            System.arraycopy(tableArray, 0, newTables, 0, size);
            tableArray = newTables;
        }
        tableArray[size] = table;
        size += 1;
        return true;
    }

    public void makeOrder(String tableName, Order order) throws Exception {
        boolean found = false;
        for (Table addedTable : tableArray) {
            if (Objects.equals(addedTable.getName(), tableName)){
                found = true;
                orderManager.add(addedTable.getName(), order);
            }
        }
        if (!found){
            throw new Exception("IllegalTableNumber");
        }
    }
}