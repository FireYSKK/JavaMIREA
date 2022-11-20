package tables;

import java.util.Objects;

public class TableManager {
    private int size = 0;
    private Table[] tableArray = new Table[5];

    public void add(Table table) {
        // Проверка, что стол существует
        for (Table iter: tableArray){
            if (iter == null) break;
            if (Objects.equals(table.name(), iter.name())){
                throw new IllegalArgumentException("Table already exists");
            }
        }

        // Добавление стола
        if (size >= tableArray.length - 1){
            Table[] newTables = new Table[size * 2];
            System.arraycopy(tableArray, 0, newTables, 0, size);
            tableArray = newTables;
        }
        tableArray[size] = table;
        size += 1;
    }
}