/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Add your docs here.
 */
public class DriverController {
    XboxController xbox1 = new XboxController(0);//main driver
    XboxController xbox2 = new XboxController(1);//aux driver

    public double getForward() {
        return -xbox1.getRawAxis(0);
    }

    public double getStrafe() {
        return xbox1.getRawAxis(0);
    }

    public double getRotation() {
        return -xbox1.getRawAxis(4);
    }

    public boolean getFloorVision() {
        return xbox1.getAButton();
    }

    public boolean getWallVision() {
        return xbox1.getBButton();
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
}
