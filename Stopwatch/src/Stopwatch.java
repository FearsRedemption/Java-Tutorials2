import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

public class Stopwatch implements ActionListener {
    JFrame frame = new JFrame();
    JButton start = new JButton("START");
    JButton reset = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime, seconds, minutes, hours;
    boolean started = false;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;

            hoursString = String.format("%02d", hours);
            minutesString = String.format("%02d", minutes);
            secondsString = String.format("%02d", seconds);

            timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        }
    });

    Stopwatch() {
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        start.setBounds(100, 200, 100, 50);
        start.setFont(new Font("Ink Free", Font.PLAIN, 20));
        start.setFocusable(false);
        start.addActionListener(this);

        reset.setBounds(200, 200, 100, 50);
        reset.setFont(new Font("Ink Free", Font.PLAIN, 20));
        reset.setFocusable(false);
        reset.addActionListener(this);

        frame.add(start);
        frame.add(reset);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {

            if (!started) {
                started = true;
                start.setText("STOP");
                Start();
            } else {
                started = false;
                start.setText("START");
                Stop();
            }
        }

        if (e.getSource() == reset) {
            started = false;
            start.setText("START");
            Reset();
        }
    }

    void Start() {
        timer.start();
    }

    void Stop() {
        timer.stop();
    }

    void Reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        hoursString = String.format("%02d", hours);
        minutesString = String.format("%02d", minutes);
        secondsString = String.format("%02d", seconds);

        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
    }
}
