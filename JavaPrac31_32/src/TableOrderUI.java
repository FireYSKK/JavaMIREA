import items.Dish;
import items.Drink;
import items.Item;
import orders.OrderManager;
import orders.RestaurantOrder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TableOrderUI extends JFrame implements ActionListener {
    JFrame tableFrame = new JFrame(); // Непосредственно окно
    JComboBox<String> typeComboBox, itemComboBox; // Выбиралки: тип и название
    JTextField price; // Поле ввода цены
    JButton addItemBtn; // Кнопка добавления элемента к заказу
    JPanel[][] panelHolder; // Массив панелей для таблицы с заказом
    // Иконка кнопки удаления
    Image removeTableIcon = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/bin.png")));
    // Все кнопки удаления хранятся тут
    ArrayList<JButton> removeItemBtns = new ArrayList<>();
    // Непосредственно менб ресторана
    String[] drinks = {"BEER", "WINE", "VODKA", "BRANDY", "CHAMPAGNE", "WHISKEY", "TEQUILA", "RUM", "VERMUTH", "LIQUOR",
                        "JAGERMEISTER", "JUICE", "COFFEE", "GREEN TEA", "BLACK TEA", "MILK", "WATER", "SODA"};
    String[] dishes = {"STEAK", "RISOTTO ALLA MILANESE", "POLENTA", "LASAGNA", "RAVIOLI", "OSSO BUCO", "ARANCINI",
                        "RIBOLLITA", "SPAGHETTI ALLA CARBONARA", "NEAPOLITAN PIZZA", "GNOCCHI", "SWORDFISH",
                        "PARMIGIANA", "TIRAMISU"};
    // Обработчик заказов
    OrderManager orderManager;
    // Кнопка, которой открывалось это окно
    JButton tableButton;
    // Название стола
    String tableName;
    // Заказ, связанный со столом
    RestaurantOrder restaurantOrder;
    // Элементы заказа
    Item[] orderItems;
    int totalCost = 0;

    public TableOrderUI(JButton tableButton, OrderManager orderManager) throws IOException {
        this.orderManager = orderManager;
        this.tableName = tableButton.getText();
        this.tableButton = tableButton;

        this.restaurantOrder = (RestaurantOrder) orderManager.get(tableName);

        // 2 панели: в верхней добавление блюда, в нижней - отображение всего заказа
        tableFrame.setLayout(new GridLayout(2,1));
        tableFrame.setTitle(tableName);

        // Верхняя панель
        JPanel newItemPanel = new JPanel();
        newItemPanel.setLayout(null);
        // Нижняя панель (Заполняется как таблица)
        JPanel orderInfo = new JPanel();
        orderInfo.setLayout(new GridLayout(10, 2));
        int orderGridHeight = 10, orderGridWidth = 3;
        this.panelHolder = new JPanel[orderGridHeight][orderGridWidth];
        for(int i = 0; i < orderGridHeight; i++) {
            for(int j = 0; j < orderGridWidth; j++) {
                this.panelHolder[i][j] = new JPanel();
                this.panelHolder[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                orderInfo.add(this.panelHolder[i][j]);
            }
        }
        this.panelHolder[0][0].add(new JLabel("Item")); // Верх-лево
        this.panelHolder[0][1].add(new JLabel("Price")); // Верх-центр
        this.panelHolder[0][2].add(new JLabel("Remove")); // Верх-право
        this.panelHolder[9][0].add(new JLabel("TOTAL")); // Низ-лево
        this.panelHolder[9][1].add(new JLabel(String.valueOf(totalCost))); // Низ-центр

        // Сборка верхней панели (для добавления блюда)
        // Выбор типа Напиток/Еда
        typeComboBox = new JComboBox<>(new String[]{"", "Drink", "Dish"});
        typeComboBox.addActionListener(this);
        typeComboBox.setSize(100, 30);
        typeComboBox.setBounds(100, 30, 300, 30);
        newItemPanel.add(typeComboBox);
        // Выбор конктретного пункта из меню
        itemComboBox = new JComboBox<>(new String[]{"Select the type first"});
        itemComboBox.addActionListener(this);
        itemComboBox.setSize(100, 30);
        itemComboBox.setBounds(100, 70, 300, 30);
        newItemPanel.add(itemComboBox);
        // Поле ввода цены
        price = new JTextField("0");
        price.setBounds(100, 110, 300, 30);
        newItemPanel.add(price);
        // Кнопка добавления
        addItemBtn = new JButton("Add Item to Order");
        addItemBtn.setFocusable(false);
        addItemBtn.setBounds(100, 150, 300, 30);
        addItemBtn.addActionListener(this);
        newItemPanel.add(addItemBtn);

        // Установка параметров окна
        tableFrame.add(newItemPanel);
        tableFrame.add(orderInfo);
        tableFrame.setSize(500, 800);
        tableFrame.setVisible(true);
        // При закрытии кнопка вызова этого окна должна снова активироваться
        tableFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                tableButton.setEnabled(true);
            }
        });

        // Обновление содержимого таблицы
        UpdateOrderContentsUI();
    }

    private void UpdateOrderContentsUI(){
        if (restaurantOrder == null) return;

        // Получение всего заказа
        this.orderItems = restaurantOrder.getArray();
        int DISPLAY_ITEMS = (orderItems.length > 8) ? 7 : orderItems.length;
        // Очистка всего
        for (int i = 1; i < 9; i++) {
            panelHolder[i][0].removeAll();
            panelHolder[i][1].removeAll();
            panelHolder[i][2].removeAll();
        }
        removeItemBtns.clear();
        // Заполнение таблицы заказа
        for (int i = 0; i < DISPLAY_ITEMS; i++) {
            panelHolder[i + 1][0].add(new JLabel(orderItems[i].getTitle()));
            panelHolder[i + 1][1].add(new JLabel(String.valueOf(orderItems[i].getPrice())));
            JButton removeItemBtn = new JButton();
            removeItemBtn.setIcon(new ImageIcon(removeTableIcon));
            removeItemBtn.setFocusable(false);
            removeItemBtn.addActionListener(this);
            removeItemBtns.add(removeItemBtn);
            panelHolder[i + 1][2].add(removeItemBtn);
        }
        // Если пунктов в заказе слишком много, то показываются не все :Р
        if (orderItems.length > 8){
            panelHolder[8][0].add(new JLabel("..."));
            panelHolder[8][1].add(new JLabel("..."));
            panelHolder[8][2].add(new JLabel("..."));
        }
        // Обновление итоговой стоимости
        this.totalCost = restaurantOrder.totalCost();
        panelHolder[9][1].removeAll();
        panelHolder[9][1].add(new JLabel(String.valueOf(totalCost)));
        // Обновление окна
        tableFrame.setVisible(false);
        tableFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Выбран тип блюда (Еда/Напиток)
        if (e.getSource() == typeComboBox){
            // Если Напиток
            if (Objects.equals(typeComboBox.getSelectedItem(),"Drink")){
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( drinks );
                itemComboBox.setModel( model );
            }
            // Если Еда
            else if (Objects.equals(typeComboBox.getSelectedItem(),"Dish")){
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( dishes );
                itemComboBox.setModel( model );
            }
            // Если задержка в развитии
            else{
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( new String[]{"Select the type first"} );
                itemComboBox.setModel( model );
            }
        }
        // К заказу добаляется блюдо
        else if (e.getSource() == addItemBtn) {
            // Добавление напитка
            if (Objects.equals(typeComboBox.getSelectedItem(),"Drink") ||
                    price.getText().length() != 0 && price.getText().matches("[0-9]+")){
                Drink newItem = new Drink((String) Objects.requireNonNull(itemComboBox.getSelectedItem()),
                        "No description",
                        Integer.parseInt(price.getText()));

                // Заказ существует
                if(orderManager.get(tableName) != null){
                    orderManager.addToOrder(tableName, newItem);
                }
                // Новый заказ
                else{
                    restaurantOrder = new RestaurantOrder();
                    restaurantOrder.add(newItem);
                    try {
                        orderManager.add(tableName, restaurantOrder);
                    } catch (Exception ex) {
                        System.out.println("Order already exists!");
                    }
                }
            }
            // Добавление блюда
            else if (Objects.equals(typeComboBox.getSelectedItem(),"Dish") ||
                    price.getText().length() != 0 && price.getText().matches("[0-9]+")){
                Dish newItem = new Dish((String) Objects.requireNonNull(itemComboBox.getSelectedItem()),
                        "No description",
                        Integer.parseInt(price.getText()));

                // Заказ существует
                if(orderManager.get(tableName) != null){
                    orderManager.addToOrder(tableName, newItem);
                }
                // Новый заказ
                else{
                    restaurantOrder = new RestaurantOrder();
                    restaurantOrder.add(newItem);
                    try {
                        orderManager.add(tableName, restaurantOrder);
                    } catch (Exception ex) {
                        System.out.println("Order already exists!");
                    }
                }
            }
            // Поля заполнены неверно
            else{
                System.out.println("Please fill the fields correctly");
            }
            // Обновление содержимого таблицы
            UpdateOrderContentsUI();
        }
        // Удаление пункта из заказа
        else if (e.getSource() instanceof JButton && removeItemBtns.contains(e.getSource())) {
            // Получение номера пункта
            int BtnIndex = removeItemBtns.indexOf(e.getSource());

            // Удаляем элемента
            orderManager.removeFromOrder(tableName, orderItems[BtnIndex]);
            removeItemBtns.remove(e.getSource());
            // Обновляем содержимое заказа
            restaurantOrder = (RestaurantOrder) orderManager.get(tableName);
            orderItems = restaurantOrder.getArray();

            // Обновление содержимого таблицы
            UpdateOrderContentsUI();
        }
    }
}
