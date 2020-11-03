import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel increaseLabel;
  JLabel counterLabel;

  JTextField increaseInput;
  JTextField counterInput;
  
  JButton increaseButton;
  JButton resetButton;

  Font biggerText;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    //initialize the labels
    increaseLabel = new JLabel("Increase By:");
    counterLabel = new JLabel("Counter:");
    // set the location and setSize
    increaseLabel.setBounds(100, 170, 100, 70);
    counterLabel.setBounds(100, 290, 100, 70);
    // add the JLabels to the main panel
    mainPanel.add(increaseLabel);
    mainPanel.add(counterLabel);

    // initialize the text areas
    increaseInput = new JTextField("0");
    counterInput = new JTextField("0");
    // set the location and size
    increaseInput.setBounds(210, 170, 150, 50);
    counterInput.setBounds(210, 290, 150, 50);
    // add the text areas to the main panel
    mainPanel.add(increaseInput);
    mainPanel.add(counterInput);

    // initialize the JButtons
    increaseButton = new JButton("Increase");
    resetButton = new JButton("Reset");
    // set the location and size
    increaseButton.setBounds(100, 100, 100, 20);
    resetButton.setBounds(215, 100, 100, 20);
    // add an action listener to the buttons
    increaseButton.addActionListener(this);
    resetButton.addActionListener(this);
    // set the action command on the buttons
    increaseButton.setActionCommand("Increase");
    resetButton.setActionCommand("Reset");
    // add the JButtons to the main panel
    mainPanel.add(increaseButton);
    mainPanel.add(resetButton);

    // disable the text area counter so the user can not type in it
    counterInput.setEnabled(false);

    // create a bigger font to use
    biggerText = new Font("arial",Font.PLAIN, 16);
    // set the font on the area I want to use it
    increaseLabel.setFont(biggerText);    
    counterLabel.setFont(biggerText);
    increaseInput.setFont(biggerText);
    counterInput.setFont(biggerText);
    increaseButton.setFont(biggerText);
    resetButton.setFont(biggerText);

    // add the main panel to the window
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("Increase")){
      // get the increase text from the text box
      String increaseText = increaseInput.getText();

      // change the string into an integer
      int increaseInteger = Integer.parseInt(increaseText);

      // get the counter text from the text box
      String counterText = counterInput.getText();

      // change the string into an integer
      int counterInteger = Integer.parseInt(counterText);
      
      if( counterInteger >= 10 ){
        // set the counter input to same as before
       counterInput.setText(counterInput + " ");

      }else{
        // add the increase value to the counter
       int sum = increaseInteger + counterInteger;

       // set the counter input to sum
       counterInput.setText("" + sum);
      }

    }else if(command.equals("Reset")){
      counterInput.setText("0");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
