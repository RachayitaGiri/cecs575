package microwave;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *  @author: Rachayita Giri
 *  @campusID: 017524687
 *  @purpose: Lab 6 for CECS 575
 */

public class Oven implements ActionListener {

    // component variables
    private Buzzer buzzer = new Buzzer();
    private CancelButton cancelButton = new CancelButton();
    private CookButton cookButton = new CookButton();
    private Door door = new Door();
    private Light light = new Light();
    private PowerTube ptube = new PowerTube();
    private MyTimer myTimer = new MyTimer(this);

    // components for the GUI
    JButton doorBtnGUI = new JButton();
    JButton cookBtnGUI = new JButton();
    JButton cancelBtnGUI = new JButton();

    // component classes
    /* ---- CLASS - BUZZER ----*/
    public class Buzzer {
        public void beep(int n) {
            for (int i=0; i<n; i++)
                System.out.println("Beep!");
        }

    }

    /* ---- CLASS - DOOR BUTTON ----*/
    public class Door {
        public boolean isopen;

        public void toggleDoorOpenClose() {
            if (isopen) {
                isopen = false;
                System.out.println("Door is closed");
            }
            else if (!myTimer.isRunning()){
                System.out.println("Door is open");
                isopen = true;
            }
            else if (!isopen && myTimer.isRunning()) {
                System.out.println("Door is open");
                System.out.println("Cooking cancelled by opening door");
                light.turnLightOn();
                myTimer.Cancel();
                isopen = true;
            }
        }

    }

    /* ---- CLASS - COOK BUTTON ----*/
    public class CookButton {
        public void pressButton() {
            if (!door.isopen) {
                if (!myTimer.isRunning()) {
                    light.turnLightOn();
                    ptube.turnPowerTubeOn();
                    buzzer.beep(1);
                    myTimer.Add1Minute();
                }
                else {
                    myTimer.AddExtraMinute();
                }
            }
            else {
                buzzer.beep(1);
            }
        }
    }

    /* ---- CLASS - CANCEL BUTTON ----*/
    public class CancelButton {
        public void pressButton() {
            if (myTimer.isRunning()) {
                light.turnLightOff();
                buzzer.beep(1);
                ptube.turnPowerTubeOff();
                System.out.println("Cooking cancelled by pressing Cancel");
                myTimer.Cancel();
            }
            else {
                buzzer.beep(1);
            }
        }
    }

    /* ---- CLASS - LIGHT ----*/
    public class Light {
        public void turnLightOn() {
            System.out.println("Light is on");
        }
        public void turnLightOff() {
            System.out.println("Light is off");
        }
    }

    /* ---- CLASS - POWER TUBE ----*/
    public class PowerTube {
        public void turnPowerTubeOn() { System.out.println("Power tube is on"); }
        public void turnPowerTubeOff() {
            System.out.println("Power tube is off");
        }
    }

    /* helper methods */
    public void TimerExpired() {
        light.turnLightOff();
        buzzer.beep(3);
    }

    public Oven() {
        // create the Frame object and set its properties
        JFrame addFrame = new JFrame();
        addFrame.setTitle("Microwave Oven");
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setResizable(true);
        addFrame.setForeground(Color.WHITE);
        addFrame.setLocation(new Point(500, 350));
        addFrame.setSize(new Dimension(450, 100));
        addFrame.setLayout(new FlowLayout());
        addFrame.setVisible(true);

        doorBtnGUI.setText("Toggle Door");
        cookBtnGUI.setText("Cook");
        cancelBtnGUI.setText("Cancel");

        addFrame.add(doorBtnGUI);
        addFrame.add(cookBtnGUI);
        addFrame.add(cancelBtnGUI);

        doorBtnGUI.addActionListener(this);
        cookBtnGUI.addActionListener(this);
        cancelBtnGUI.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == doorBtnGUI) {
            this.door.toggleDoorOpenClose();
        }
        else if (event.getSource() == cookBtnGUI) {
            this.cookButton.pressButton();
        }
        else if (event.getSource() == cancelBtnGUI) {
            this.cancelButton.pressButton();
        }
    }

    public static void main(String[] args) {
        Oven oven = new Oven();

        System.out.println("\nAt any time, choose from one of the actions below:");
        System.out.println("--> Type d to toggle the door open or closed.\n" +
                "--> Type p to press the Cook button.\n" +
                "--> Type c to press the Cancel button.\n" +
                "--> Type x to exit the simulation.");
        Scanner choiceScn = new Scanner(System.in);

        while (choiceScn.hasNext()) {
            String str = choiceScn.next(".");
            char choice = str.charAt(0);
            if (choice == 'd')
                oven.door.toggleDoorOpenClose();
            else if (choice == 'p')
                oven.cookButton.pressButton();
            else if (choice == 'c')
                oven.cancelButton.pressButton();
            else if (choice == 'x')
                System.exit(0);
        }
    }
}
