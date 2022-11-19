import javax.swing.*;
import java.awt.*;

public class TextDocument extends JFrame implements IDocument{
    public void document1() {
        JFrame jFrame = (IDocument.super.document());
        JTextField textField = new JTextField();
        textField.setBackground(Color.lightGray);
        textField.setText("Введите текст");
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        jFrame.add(textField);
        jFrame.setVisible(true);
    }
}