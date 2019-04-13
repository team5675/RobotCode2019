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

    //Chassis controls
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

    //HAM controls
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

    public boolean getHam180() {
        return xbox2.getXButton();
    }

    //JEFF controls
    public double getCargoIntake() {
        return xbox2.getTriggerAxis(Hand.kLeft);
    }

    public double getCargoRelease() {
        return xbox2.getTriggerAxis(Hand.kRight);
    }

    //Elevator controls
    public static double getElevator() {
        return xbox2.getRawAxis(1);
    }

    public static double get4Bar() {
        return xbox2.getRawAxis(5);
    }

    public static boolean getElevatorOverridePressed() {
        return xbox2.getAButtonPressed();
    }

    public static boolean getElevatorOverrideReleased() {
        return xbox2.getAButtonReleased();
    }

    public static boolean getElevatorStage0() {
        return xbox2.getXButton();
    }

    public static boolean getElevatorStage1() {
        return xbox2.getYButton();
    }

    public static boolean getFourbarEncoderReset() {
        return xbox2.getRawButtonPressed(8);
    }
}