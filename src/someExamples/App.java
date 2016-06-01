package someExamples;

import javax.swing.*;
import java.awt.*;

/**
 * Created by poskotinova-ls on 30.05.2016.
 * это главный класс из которого будет запускаться приложение
 */
public class App {
    public static void main(String[] args) {
        JFrame mainJFrame = new JFrame();
        mainJFrame.setTitle("Sort File");
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.setSize(500, 400);
        mainJFrame.setBackground(Color.GREEN);
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.setPreferredSize(new Dimension(500, 400));

        Container contentPane = new Container();
        //Container contentPane = mainJFrame.getContentPane();
        // тут есть ещё другие layout, для красоты как бы лучше наверное что-то другое
        //contentPane.setLayout(new BorderLayout());
        //contentPane.add(new JButton("Select File"), BorderLayout.WEST);
        //contentPane.add(new JButton("Select File"), BorderLayout.SOUTH);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mainJFrame.add(contentPane);
        /*
        contentPane.add(new JButton("Select File1"),2);
        contentPane.add(new JButton("Select File2"));
        contentPane.add(new JButton("Select File3"));
        contentPane.add(new JButton("Select File4"));
        contentPane.add(new JButton("Select File5"));
        contentPane.add(new JButton("Select File6"));*/

        // TO_DO: разобраться с этим!
        JButton button;
        GridBagConstraints c = new GridBagConstraints();

        button = new JButton("Button 1");
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.fill = GridBagConstraints.VERTICAL;
        //c.gridwidth = 1;//сколько клеток занимает в строке
        //c.gridx = -1;
        //c.gridy = 3;
        //c.weightx = 1;
        //c.weighty = 2;
        contentPane.add(button, c);

        mainJFrame.pack();
        mainJFrame.setVisible(true);
    }
}
