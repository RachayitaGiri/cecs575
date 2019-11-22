import java.awt.event.*;
import javax.swing.*;

public class MessageListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "You clicked the Add button.");
    }
}
