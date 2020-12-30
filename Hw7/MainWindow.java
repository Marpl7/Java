import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 500;
    private static final int WIN_POS_X = 0;
    private static final int WIN_POS_Y = 0;

    private ColorSettings colorSettings;
    
    

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("Color Me");
        setResizable(true);

        colorSettings = new ColorSettings();

        JPanel panelBottom = new JPanel();
        
        JPanel panelCenter = new JPanel();

        JButton btnColor1 = new JButton("Color1");
        btnColor1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              panelCenter.setBackground(Color.BLUE);
            }
        });
        JButton btnColor2 = new JButton("Color2");
        btnColor2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              panelCenter.setBackground(Color.RED);
            }
        });

        JButton btnChange = new JButton("Change Color");
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              colorSettings.setVisible(true);
            }
        });

        

        panelBottom.setLayout(new GridLayout(3,1));
        
        panelBottom.add(btnColor1);
        panelBottom.add(btnColor2);
        panelBottom.add(btnChange);

        

        add(panelBottom, BorderLayout.NORTH);
        add(panelCenter);
        setVisible(true);
    }

    // void changeColor (String color){

    // }
}