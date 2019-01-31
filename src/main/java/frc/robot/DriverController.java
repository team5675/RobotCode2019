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
    static XboxController xbox1 = new XboxController(0); //main driver
    static XboxController xbox2 = new XboxController(1); //aux driver

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

    public boolean getDefense() {
        return xbox1.getYButton();
    }

    public boolean getClimb2() {
        return xbox1.getBumper(Hand.kLeft);
    }

    public boolean getClimb3() {
        return xbox1.getBumper(Hand.kRight);
    }

    public boolean getHatchIntake() {
        return xbox2.getBumper(Hand.kLeft);
    }

    public boolean getHatchRelease() {
        return (xbox2.getTriggerAxis(Hand.kLeft)) == 1; 
    }

    public boolean getCargoIntake() {
        return xbox2.getBumper(Hand.kRight);
    }

    public boolean getCargoRelease() {
        return (xbox2.getTriggerAxis(Hand.kRight)) == 1;
    }

    public static double getElevator() {
        return -(xbox2.getRawAxis(0));
    }

    public static boolean getCargo1() {
        return xbox2.getAButton();
    }

    public static boolean getCargo2() {
        return xbox2.getBButton();
    }

    public static boolean getCargo3() {
        return xbox2.getYButton();
    }

    public static boolean getHatch1() {
        return xbox2.getRawAxis(7) == 1;
    }

    public static boolean getHatch2() {
        return xbox2.getRawAxis(6) == -1;
    }

    public static boolean getHatch3() {
        return xbox2.getRawAxis(7) == -1;
    }
}