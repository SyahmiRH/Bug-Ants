package bugants;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.InputMismatchException;
import java.awt.event.*;
import bugants.Maze;
import bugants.Movement;
import bugants.CheckLocation;

public class Exec extends JFrame
{
  JFrame frame;                      //Frame of the simulator
  JPanel contentPane;               //Main panel which contains 2 more child panel
  JPanel MapLayout;                 //Map layour panel
  JPanel Menu;                     //Menu Layout Panel
  JLabel Welcome;                  //Welcome means instruction on what to click label
  JButton Start;                   // The only button to view the simulation
  JTextField noAnts;               //Number of ants left view
  JTextField noBugs;                   //Number of Bugs left view
  JTextField noSteps;              // How many turns view
  JLabel viewSteps;                //Label text for view steps
  JLabel viewAnts;                  //Label text for view number of ants left
  JLabel viewBugs;                  //Label text for view number of bugs left
  private int steps = 0;         //Number of steps
  GridBagConstraints c;             //Grid that will allow alligning
  Movement move;                    //Instance of movement class
  String str3;                  // For calculating the textfield value
  CheckLocation chk;
  Maze m;


  public Exec()
  {
    chk = new CheckLocation();               //Instance of CheckLocation Class
    frame = new JFrame("Bugs & Ants");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Allow the program to close when click exit

    //WELCOME LABEL COMPONENT
    Welcome =  new JLabel("Click Start To Start The Simulation");        //Set text
    Welcome.setBounds(100, 100, 100, 100);                         //Set padding
    contentPane = new JPanel(new GridLayout(1,2));                 //Set position in grid

    //MAP 2D COMPONENT
    MapLayout = new JPanel(new BorderLayout());
    MapLayout.setBorder(BorderFactory.createEmptyBorder(25, 25, 25,25));
    MapLayout.setBackground(Color.WHITE);

    //Add maze
    m = new Maze();
    m.repaint();                          //Call the function to create/update the map
  	MapLayout.add(m);                     //add to component

    //Add Text Field
    noSteps = new JTextField(7);                       //Number of Steps
    noSteps.setEditable(false);                          //Disable input
    noSteps.setHorizontalAlignment(JTextField.CENTER);

    noAnts = new JTextField (7);                      // Number of Ants left
    noAnts.setEditable(false);                        //Disable input
    noAnts.setHorizontalAlignment(JTextField.CENTER);        //Allign to center


    noBugs = new JTextField (7);                      //Number of bugs left
    noBugs.setEditable(false);                        //Disable input
    noBugs.setHorizontalAlignment(JTextField.CENTER);

    str3 = String.valueOf(m.getNoAnts());             //Change the int to string
    noAnts.setText(str3);                             //Put it inside the text field
    str3 = String.valueOf(m.getNoBugs());
    noBugs.setText(str3);

    //Add the labels
    viewSteps =  new JLabel("Number of Steps: ");          //Set texts for labels
    viewAnts = new JLabel ("Number of Ants Left: ");
    viewBugs = new JLabel ("Number of Bugs Left: ");


    //MENU COMPONENT
    Menu = new JPanel(new GridBagLayout());                            //Create grid for Menu (button and label side)
    Menu.setBorder(BorderFactory.createEmptyBorder(50, 50, 50,50));
    c =  new GridBagConstraints();
    Menu.add(Welcome);
    Menu.setBackground(Color.LIGHT_GRAY);
    JButton Start=new JButton("Start");
    Start.addActionListener(new StartM());
    c.insets= new Insets(10,10,10,5);
    c.gridx=0;
    c.gridy=1;
    Menu.add(Start,c);                                            //Set the allignment for the components
    c.gridx=0;
    c.gridy=2;
    Menu.add(viewSteps,c);
    c.gridx=0;
    c.gridy=3;
    Menu.add(noSteps,c);
    c.gridx=0;
    c.gridy=4;
    Menu.add(viewAnts,c);
    c.gridx=0;
    c.gridy=5;
    Menu.add(noAnts,c);
    c.gridx=0;
    c.gridy=6;
    Menu.add(viewBugs,c);
    c.gridx=0;
    c.gridy=7;
    Menu.add(noBugs,c);


    //ADD TO CONTENT PANEL
    contentPane.add(Menu);                         //Add menu to contentpane(main panel)
    contentPane.add(MapLayout);                    //Add map to contentpane(main panel)


    //ADD TO FRAME
    frame.setContentPane(contentPane);               //Add the contentpane to the frame
    frame.setSize(1000,600);
    frame.setVisible(true);


  }

  public void updateValue()                         //Update the number of steps and number of organisms left on the map
  {
    steps= steps+1;
    str3 = String.valueOf(steps);
    noSteps.setText(str3);
    str3 = String.valueOf(m.getNoAnts());
    noAnts.setText(str3);
    str3 = String.valueOf(m.getNoBugs());
    noBugs.setText(str3);

  }




  public class StartM implements ActionListener           //On start button was clicked
  {
    public void actionPerformed (ActionEvent e)
    {
      startgame();
      updateValue();
    }
  }


  public void startgame()
  {
     chk.checkmaptomove();                        //Call the function to calculate where to move that has Movement functionality
     m.repaint();                                 //Update/refresh the map
  }


  public static void main(String args[])             //Void main function
  {
    Exec e = new Exec();                             //Create instance of this class to execute the constructor
  }


}
