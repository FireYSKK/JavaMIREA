import orders.OrderManager;
import tables.Table;
import tables.TableManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UI extends JFrame implements ActionListener {
    JFrame mainFrame = new JFrame();
    JButton addNewTableBtn = new JButton("Add New Table");
    Image tableImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/stand.png")));
    ArrayList<JButton> buttonList = new ArrayList<>();

    OrderManager orderManager;
    TableManager tableManager;

    public UI(OrderManager orderManager, TableManager tableManager) throws IOException {
        this.orderManager = orderManager;
        this.tableManager = tableManager;

        // Само как-то плавает
        mainFrame.setLayout(new FlowLayout());
        // Кнопка добавления стола
        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/plus.png")));
        addNewTableBtn.setIcon(new ImageIcon(img));
        addNewTableBtn.setFocusable(false);
        addNewTableBtn.setLayout(null);
        addNewTableBtn.setSize(100, 120);
        addNewTableBtn.addActionListener(this);
        mainFrame.add(addNewTableBtn);
        // Свойства окна
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 500);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Добавление нового стола
        if (e.getSource() == addNewTableBtn){
            // Ввод имени + проверка ошибок
            String tableName = JOptionPane.showInputDialog("Enter Table Name:");
            if (tableName == null) return;
            if (Objects.equals(tableName, "")){
                JOptionPane.showMessageDialog(null, "Name can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            try{
                // Добавление стола к менеджеру
                tableManager.add(new Table(tableName));

                // Кнопка добавления стола будет перемещена в конец ряда
                // Сначала она убирается
                mainFrame.remove(addNewTableBtn);
                // Создание кнопки для нового стола
                JButton newTableButton = new JButton(tableName);
                newTableButton.setIcon(new ImageIcon(tableImage));
                newTableButton.setFocusable(false);
                newTableButton.setSize(100, 100);
                newTableButton.addActionListener(this);
                mainFrame.add(newTableButton);
                buttonList.add(newTableButton);
                // Возвращение кнопки добавления стола
                mainFrame.add(addNewTableBtn);
                // Обновление окна
                mainFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
            catch (IllegalArgumentException illegalArgumentException){
                // Стол уже существует
                JOptionPane.showMessageDialog(null, "Table with such name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Открытие окна стола
        else if (e.getSource() instanceof JButton && buttonList.contains(e.getSource())){
            try {
                new TableOrderUI((JButton) e.getSource(), orderManager);
                ((JButton) e.getSource()).setEnabled(false);
            } catch (IOException ex) {
                // Там иконка на кнопку кретипся, но видимо может не открыться файл
                System.out.println("Icon file got lost!");
            }
        }
    }
}
