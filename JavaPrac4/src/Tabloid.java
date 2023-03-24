import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabloid extends JFrame implements ActionListener{

    private int milanScore = 0;
    private int realScore = 0;
    private int sec = 10;
    private final Timer timer;

    JButton milanBtn, realBtn;
    JLabel result, last, time, winner;

    public Tabloid() {
        super("Milan X Real");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 200);
        this.setResizable(false);

        milanBtn = new JButton("AC Milan");
        milanBtn.setBounds(10,10,120,40);

        realBtn = new JButton("Real Madrid");
        realBtn.setBounds(150,10,120,40);

        result = new JLabel("Result: 0 X 0", JLabel.CENTER);
        result.setBounds(90, 50, 100, 30);

        last = new JLabel("Last Scorer: N/A", JLabel.CENTER);
        last.setBounds(70, 80, 150, 30);

        time = new JLabel("Time: "+sec, JLabel.CENTER);
        time.setBounds(50, 110, 50, 30);

        winner = new JLabel("Winner: DRAW", JLabel.CENTER);
        winner.setBounds(100, 110, 180, 30);

        timer = new Timer(1000, this);

        milanBtn.addActionListener(this);
        milanBtn.setFocusable(false);

        realBtn.addActionListener(this);
        realBtn.setFocusable(false);

        this.add(milanBtn);
        this.add(realBtn);
        this.add(result);
        this.add(last);
        this.add(time);
        this.add(winner);
        timer.start();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer){
            if (sec == 0) {
                timer.stop();
                if (milanScore > realScore) winner.setText("Winner: AC Milan");
                else if (milanScore < realScore) winner.setText("Winner: Real Madrid");
                else winner.setText("Winner: DRAW");
                winner.setForeground(Color.GREEN);
                milanBtn.setEnabled(false);
                realBtn.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Time is up",
                        "Result",JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                sec -= 1;
                time.setText("Time: " + String.valueOf(sec));
            }
        }

        if (e.getSource() == milanBtn) {
            milanScore += 1;
            last.setText("Last Scorer: AC Milan");
        }
        else if (e.getSource() == realBtn) {
            realScore += 1;
            last.setText("Last Scorer: Real Madrid");
        }
        result.setText("Result: " + milanScore + " X " + realScore);
    }
}
