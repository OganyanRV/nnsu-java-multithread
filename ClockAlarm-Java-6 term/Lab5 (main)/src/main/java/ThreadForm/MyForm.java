package ThreadForm;

import ClockManage.ClockManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm extends JPanel {
    private JPanel panel1;
    private JLabel time;
    private JButton startButton;
    private JButton stopButton;
    private JButton pauseButton;
    private JButton resumeButton;

    private ClockManage clock;

    public MyForm() {
        clock = new ClockManage(()->time.setText(clock.GetWatch().Format()));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.start();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.pause();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.resume();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.stop();
            }
        });
    }


}
