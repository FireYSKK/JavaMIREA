import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public interface IDocument {
    default JFrame document() {
        JFrame frame = new JFrame();
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu menu_new = new JMenu("New");
        JMenu menu_open = new JMenu("Open");

        JMenuItem new_text = new JMenuItem("text");
        JMenuItem open_text = new JMenuItem("text");
        JMenuItem new_image = new JMenuItem("PNG");
        JMenuItem open_image = new JMenuItem("PNG");
        JMenuItem new_music = new JMenuItem("mp3");
        JMenuItem open_music = new JMenuItem("mp3");

        file.add(menu_new);
        file.add(menu_open);

        // Создать документ
        menu_new.add(new_text);
        menu_new.add(new_image);
        menu_new.add(new_music);

        // Открыть документ
        menu_open.add(open_text);
        menu_open.add(open_image);
        menu_open.add(open_music);

        // Новый текстовый документ
        new_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ((TextDocument) new CreateTextDocument().CreateNew()).document1();
            }
        });
        open_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ((TextDocument) new CreateTextDocument().CreateNew()).document1();
            }
        });

        // Новое изображение
        new_image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ((ImageDocument) new CreateImageDocument().CreateNew()).document1();
            }
        });
        open_image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ((ImageDocument) new CreateImageDocument().CreateNew()).document1();
            }
        });

        // Новый музыкальный документ
        new_music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    ((MusicDocument) new CreateMusicDocument().CreateNew()).document1();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        open_music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    ((MusicDocument) new CreateMusicDocument().CreateNew()).document1();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jMenuBar.add(file);
        frame.setJMenuBar(jMenuBar);
        frame.setSize(530, 580);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}