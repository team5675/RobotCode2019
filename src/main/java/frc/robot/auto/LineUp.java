/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auto;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Vision;
import frc.robot.DriverController;

public class LineUp {

    Drive drive = new Drive();
    DriverController driverController = new DriverController();
    Vision vision = new Vision();

    public void run(){
        double centerXReport = vision.runFrontVisionCenterX();
        System.out.println(centerXReport);
    }
}