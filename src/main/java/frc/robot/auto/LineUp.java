/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auto;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Vision;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.DriverController;
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

        double midpoint = (centerXReport[0] + centerXReport[1]) / 2;
        double c = (midpoint - 320) / 320;

        double g = (30 - gyro.getAngle()) * -0.03;
        System.out.println("Speed: " + g);
        System.out.println("Gyro: " + gyro.getAngle());
        drive.move(c * -1.2, driverController.getForward(), g); //i forgot what side is rotate and im to lazy to look it up
        //doing * 2 kind of like a nitrous boost
    }
}