import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame {
    public Menu() {
        setLayout(new BorderLayout());

        // Создание элементнов меню
        JPanel toppanel = new JPanel();
        toppanel.setBackground(Color.blue);
        toppanel.setLayout(new BorderLayout());

        JLabel northlabel = new JLabel();
        northlabel.setText("North");
        northlabel.setHorizontalAlignment(JLabel.CENTER);
        northlabel.setVerticalAlignment(JLabel.CENTER);

        JPanel bottompanel = new JPanel();
        bottompanel.setBackground(Color.green);
        bottompanel.setLayout(new BorderLayout());

        JLabel southlabel = new JLabel();
        southlabel.setText("South");
        southlabel.setHorizontalAlignment(JLabel.CENTER);
        southlabel.setVerticalAlignment(JLabel.CENTER);

        JPanel leftpanel = new JPanel();
        leftpanel.setBackground(Color.yellow);
        leftpanel.setLayout(new BorderLayout());

        JLabel westlabel = new JLabel();
        westlabel.setText("West");
        westlabel.setHorizontalAlignment(JLabel.CENTER);
        westlabel.setVerticalAlignment(JLabel.CENTER);

        JPanel rightpanel = new JPanel();
        rightpanel.setBackground(Color.red);
        rightpanel.setLayout(new BorderLayout());

        JLabel eastlabel = new JLabel();
        eastlabel.setText("East");
        eastlabel.setHorizontalAlignment(JLabel.CENTER);
        eastlabel.setVerticalAlignment(JLabel.CENTER);

        JLabel center = new JLabel();
        center.setText("Добро пожаловать в");
        center.setVerticalAlignment(JLabel.CENTER);
        center.setHorizontalAlignment(JLabel.CENTER);

        // Добавление функционала в меню
        toppanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
                center.setText("Добро пожаловать в");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                center.setText("Добро пожаловать на Север");
            }
        });

        bottompanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
                center.setText("Добро пожаловать в");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                center.setText("Добро пожаловать на Юг");
            }
        });

        leftpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
                center.setText("Добро пожаловать в");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                center.setText("Добро пожаловать на Восток");
            }
        });

        rightpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
                center.setText("Добро пожаловать в");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                center.setText("Добро пожаловать на Запад");
            }
        });

        toppanel.add(northlabel);
        add(toppanel, BorderLayout.NORTH);
        bottompanel.add(southlabel);
        add(bottompanel, BorderLayout.SOUTH);
        leftpanel.add(westlabel);
        add(leftpanel, BorderLayout.WEST);
        rightpanel.add(eastlabel);
        add(rightpanel, BorderLayout.EAST);
        add(center, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }
}