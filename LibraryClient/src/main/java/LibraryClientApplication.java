
import form.MainForm;

import javax.swing.*;


public class LibraryClientApplication{
    public static void main(String[] args) {

        JFrame frame = new JFrame("Клиентское приложение для библиотеки");
        frame.setContentPane(new MainForm().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.pack();
        frame.setVisible(true);
    }
}
