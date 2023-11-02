import java.awt.*;
import javax.swing.*;

/* 
        /* 
         *  methods to implement
         *  sin, cos, tan
         *  various square root functions
         *  log, ln, e, pi
         *  custom parentheses
         *  option to switch out between radians and degree
         *  factorials
        */

        /* 
         *  Layout for calculator (future) (to be implemented)
         *  taken from google calculator (as of 2023-10-09) (YY/MM/DD)
         *  
         *  rad/deg       (       )     C   Neg %   /
         *  sin    cos    tan     pi    7   8   9   x
         *  x!     x^2    x^3     x^y   4   5   6   -
         *  1/x    sqrtx  y^sqrtx EE    1   2   3   +
         *  log    ln     e^x     e     0     .   =
         *  
        */

public class MyFrame extends JFrame {

    // separate classes for my panels and one for action listeners
    private ButtonPanel buttonPanel;
    private TextFieldPanel textFieldPanel;
    private ButtonHandler buttonHandler;

    // constructor
    MyFrame() {

        this.setLayout(new BorderLayout(0, 0));
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonHandler = new ButtonHandler();
        buttonPanel = new ButtonPanel();
        textFieldPanel = new TextFieldPanel();

        this.add(textFieldPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        buttonHandler.addActionListeners();
        this.setVisible(true);
    } // end constructor
}