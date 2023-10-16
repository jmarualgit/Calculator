import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ButtonHandler extends MyFrame {

    ButtonHandler() {

        addActionListeners();
    }

    public static void addActionListeners() {
        ButtonPanel.getButton("1").addMouseListener(new MouseAdapter() {
        
            @Override
            public void mousePressed(MouseEvent e) {
                // System.out.println("button1 pressed");

                TextFieldPanel.setText(TextFieldPanel.getText() + "1");

                if (isAnAnswer == true) {
                    isAnAnswer = false;
                }

                // to see which input the button should go in
                if (operator == "") {
                    input1 = input1 + "1";
                } else {
                    input2 = input2 + "1";
                }
            }
        });
        

        /* 
        for (int i = 0; i < ButtonPanel.inputButtonsList.length; i++) {

            String position = String.valueOf(i); 
            System.out.println("position is " + position);
            System.out.println(ButtonPanel.getButton(position));

            /* 
            ButtonPanel.getButton(position).addMouseListener(new MouseAdapter() {
            
                
                @Override
                public void mousePressed(MouseEvent e) {
                    // System.out.println("button1 pressed");

                    TextFieldPanel.setText(TextFieldPanel.getText() + "1");

                    if (isAnAnswer == true) {
                        isAnAnswer = false;
                    }

                    // to see which input the button should go in
                    if (operator == "") {
                        input1 = input1 + "1";
                    } else {
                        input2 = input2 + "1";
                    }
                } // end mousePressed
            }); // end addMouseListener
            
        } // end for loop
        */
    } // end addActionListeners
}

