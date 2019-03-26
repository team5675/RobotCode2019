/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class DriverController {
    public static XboxController xbox1 = new XboxController(0); //main driver
    public static XboxController xbox2 = new XboxController(1); //aux driver

    public double getForward() {
        return xbox1.getRawAxis(1);
    }

    public double getStrafe() {
        return -xbox1.getRawAxis(0);
    }

    public double getRotation() {
        return -xbox1.getRawAxis(4);
    }

    public boolean lineUp() {
        return xbox1.getAButton();
    }

    public static boolean getDefense() {
        return xbox1.getYButton();
    }

    public boolean getHAMForward() {
        return xbox1.getBumper(Hand.kLeft);
    }

    public boolean getHAMBackwards() {
        return xbox1.getBumper(Hand.kRight);
    }

    public boolean getHAMDown() {
        return xbox2.getBumper(Hand.kLeft);
    }

    public boolean getHAMUp() {
        return xbox2.getBumper(Hand.kRight); 
    }

    public double getCargoIntake() {
        return xbox2.getTriggerAxis(Hand.kLeft);
    }

    public double getCargoRelease() {
        return xbox2.getTriggerAxis(Hand.kRight);
    }

    public double getElevator() {
        return (xbox2.getRawAxis(1) * -1);
    }

    public double get4Bar() {
        return (xbox2.getRawAxis(5) * -1);
    }

    public boolean getCargo1() {

        return xbox2.getAButton();
    }

    public boolean getCargo2() {
    
        return (xbox2.getBButton());
    }

    public boolean getCargo3() {
     
        return (xbox2.getYButton());
    }

    public static boolean manualMode() {
        return xbox2.getXButtonPressed();
    }

    public static boolean getHatch1() {

        if (xbox2.getRawAxis(7) == 1) {
            return true;
        }

        else {return false;}
    }

    public static boolean getHatch2() {
        
        if (xbox2.getRawAxis(6) == -1) {
            return true;
        }

        else {return false;}
    }

    public static boolean getHatch3() {
        
        if (xbox2.getRawAxis(7) == -1) {
            return true;
        }

        else {return false;}
    }

    public boolean getHamRetract() {
        return xbox2.getBackButton();
    }
}