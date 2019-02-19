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

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;

public class LineUp {

    Drive drive = new Drive();
    DriverController driverController = new DriverController();
    Vision vision = new Vision();
    
    AHRS gyro = new AHRS(SerialPort.Port.kMXP);

    public void config() {
        gyro.reset();
    }

    public void run(){
        double[] centerXReport = vision.runFrontVisionCenterX();
        
        double x = (((centerXReport[0] + centerXReport[1]) / 2) - 320) / 320;

        drive.move(x * -1.2, driverController.getForward(), 0);

        System.out.println(x);
    }
}