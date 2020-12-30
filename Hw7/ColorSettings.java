import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorSettings extends JFrame {

      private static final int WIN_WIDTH = 200;
      private static final int WIN_HEIGHT = 200;
      private static final int WIN_POS_X = 30;
      private static final int WIN_POS_Y = 30;

      private JRadioButton colorGreen;
      private JRadioButton colorRed;
      private JRadioButton colorBlue;
      private JRadioButton colorYellow;
      
  

    ColorSettings() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("Select Color");
        setResizable(true);

        setLayout(new GridLayout(12, 1));
        add(new JLabel( "Select Color1"));
        colorGreen = new JRadioButton("Green", true);
        colorRed = new JRadioButton("Red", true);
        colorBlue = new JRadioButton("Blue", true);
        colorYellow = new JRadioButton("Yellow", true);
        ButtonGroup colorMode = new ButtonGroup();
        colorMode.add(colorGreen);
        colorMode.add(colorRed);
        colorMode.add(colorBlue);
        colorMode.add(colorYellow);
        add(colorGreen);
        add(colorRed);
        add(colorBlue);
        add(colorYellow);

        
        add(new JLabel( "Select Color2"));
        colorGreen = new JRadioButton("Green", true);
        colorRed = new JRadioButton("Red", true);
        colorBlue = new JRadioButton("Blue", true);
        colorYellow = new JRadioButton("Yellow", true);
        ButtonGroup colorMode1 = new ButtonGroup();
        colorMode1.add(colorGreen);
        colorMode1.add(colorRed);
        colorMode1.add(colorBlue);
        colorMode1.add(colorYellow);
        add(colorGreen);
        add(colorRed);
        add(colorBlue);
        add(colorYellow);

        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
                setVisible(false);
            }
        });
        add(btnClose);
        


    }

    private void btnStartClick() {
        String color;
        if (colorGreen.isSelected()) {
            color = "Color.Green";
        } else if (colorRed.isSelected()) {
            color = "Color.RED";
        }else if (colorBlue.isSelected()) {
            color = "Color.Blue";
        }else if (colorYellow.isSelected()) {
            color = "Color.Yellow";
        } else {
            throw new RuntimeException("No Color");
        }
        
    }
  }