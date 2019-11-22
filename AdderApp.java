import java.awt.*;      // for the Layout Manager
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;   // for the GUI Components

public class AdderApp implements ActionListener {

    public static void main(String[] args) {
        AdderApp gui = new AdderApp();
    }

    // onscreen components stored as fields
    private JTextField addField1;
    private JTextField addField2;
    private JTextField sumField;


    public AdderApp() {
        JFrame addFrame;
        JButton addButton;
        // create the Frame object and set its properties
        addFrame = new JFrame();
        addFrame.setTitle("Adder App");
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setResizable(true);
        addFrame.setForeground(Color.WHITE);
        addFrame.setLocation(new Point(500, 350));
        addFrame.setSize(new Dimension(450, 100));
        addFrame.setLayout(new FlowLayout());

        // create the TextField objects and their corresponding labels
        addField1 = new JTextField(5);
        addFrame.add(new JLabel("Addend1"));
        addFrame.add(addField1);

        addField2 = new JTextField(5);
        addFrame.add(new JLabel(" Addend2"));
        addFrame.add(addField2);

        sumField = new JTextField(5);
        addFrame.add(new JLabel(" Sum"));
        addFrame.add(sumField);

        // create the Button object and set its properties
        addButton = new JButton();
        addButton.setText("Add");
        addFrame.add(addButton);


        addButton.addActionListener(this);

        // addFrame.pack();
        addFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        int add1 = Integer.parseInt( addField1.getText() );
        int add2 = Integer.parseInt( addField2.getText() );
        int sum = add1 + add2;
        sumField.setText(Integer.toString(sum));
    }
}
