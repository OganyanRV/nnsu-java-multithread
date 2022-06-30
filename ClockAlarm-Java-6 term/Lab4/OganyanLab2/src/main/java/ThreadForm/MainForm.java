package ThreadForm;

import ThreadForm.MyForm2.MyForm2;

import javax.swing.*;

public class MainForm{
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
