
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JButton stopButton = new JButton("Stop");
    JButton weekResetButton = new JButton("Reset Week");
    JLabel timeLabel = new JLabel();
    JLabel weekTimeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;

    int totalElapsedTime = 0;
    int weekSeconds = 0;
    int weekMinutes = 0;
    int weekHours = 0;

    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);

    String weekSecondsString = String.format("%02d", weekSeconds);
    String weekMinutesString = String.format("%02d", weekMinutes);
    String weekHoursString = String.format("%02d", weekHours);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent ae) {

            elapsedTime += 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            secondsString = String.format("%02d", seconds);
            minutesString = String.format("%02d", minutes);
            hoursString = String.format("%02d", hours);
            timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);

            totalElapsedTime += 1000;
            weekHours = (totalElapsedTime / 3600000);
            weekMinutes = (totalElapsedTime / 60000) % 60;
            weekSeconds = (totalElapsedTime / 1000) % 60;

            weekSecondsString = String.format("%02d", weekSeconds);
            weekMinutesString = String.format("%02d", weekMinutes);
            weekHoursString = String.format("%02d", weekHours);
            weekTimeLabel.setText(weekHoursString + ":" + weekMinutesString + ":" + weekSecondsString);
        }
    });

    Stopwatch() {

        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        timeLabel.setBounds(25, 25, 300, 100);
        timeLabel.setFont(new Font("Harrington", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(2));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setBackground(Color.white);

        weekTimeLabel.setText(weekHoursString + ":" + weekMinutesString + ":" + weekSecondsString);
        weekTimeLabel.setBounds(25, 250, 300, 50);
        weekTimeLabel.setFont(new Font("Harrington", Font.PLAIN, 35));
        weekTimeLabel.setBorder(BorderFactory.createBevelBorder(2));
        weekTimeLabel.setOpaque(true);
        weekTimeLabel.setHorizontalAlignment(JTextField.CENTER);
        weekTimeLabel.setBackground(Color.white);

        startButton.setBounds(25, 125, 100, 50);
        startButton.setFont(new Font("Harrington", Font.BOLD, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBackground(new Color(204, 204, 255));

        stopButton.setBounds(125, 125, 100, 50);
        stopButton.setFont(new Font("Harrington", Font.BOLD, 20));
        stopButton.setFocusable(false);
        stopButton.addActionListener(this);
        stopButton.setBackground(new Color(204, 204, 255));

        resetButton.setBounds(225, 125, 100, 50);
        resetButton.setFont(new Font("Harrington", Font.BOLD, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(204, 204, 255));

        weekResetButton.setBounds(75, 225, 200, 25);
        weekResetButton.setFont(new Font("Harrington", Font.BOLD, 20));
        weekResetButton.setFocusable(false);
        weekResetButton.addActionListener(this);
        weekResetButton.setBackground(new Color(204, 204, 255));

        ImageIcon image = new ImageIcon("stopwatch1.png");

        frame.getContentPane().setBackground(Color.white);
        frame.setIconImage(image.getImage());
        frame.setTitle("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(365, 365);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(stopButton);
        frame.add(resetButton);
        frame.add(weekTimeLabel);
        frame.add(weekResetButton);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            start();
        }
        if (ae.getSource() == stopButton) {
            stop();
        }
        if (ae.getSource() == resetButton) {
            reset();
        }
        if (ae.getSource() == weekResetButton) {
            reset();
            totalElapsedTime = 0;
            weekSeconds = 0;
            weekMinutes = 0;
            weekHours = 0;
            weekSecondsString = String.format("%02d", weekSeconds);
            weekMinutesString = String.format("%02d", weekMinutes);
            weekHoursString = String.format("%02d", weekHours);
            weekTimeLabel.setText(weekHoursString + ":" + weekMinutesString + ":" + weekSecondsString);
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {

        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        secondsString = String.format("%02d", seconds);
        minutesString = String.format("%02d", minutes);
        hoursString = String.format("%02d", hours);
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);

    }
}
