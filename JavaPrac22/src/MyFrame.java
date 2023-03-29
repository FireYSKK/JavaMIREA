import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MyFrame extends JFrame {
    public MyFrame() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        ImageIcon[] imageIcons = new ImageIcon[24];
        String filename;

        for (int i = 0; i < 24; i++) {
            filename = "fire/frame_" + new DecimalFormat( "00" ).format(i) + ".png";
            //System.out.println(filename);
            imageIcons[i] = new ImageIcon(filename);
        }

        Timer timer = new Timer(40, new ActionListener() {
            int framePosition = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(imageIcons[framePosition % 24]);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                framePosition++;
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setTitle("Тёплая Ламповость");
        frame.add(label);
        frame.setVisible(true);
        timer.start();
    }
}
