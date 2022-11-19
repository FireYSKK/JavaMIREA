import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MusicDocument implements IDocument{
    public void document1() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("music.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();

        JFrame jFrame = (IDocument.super.document());
        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("music.png");
        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }
}