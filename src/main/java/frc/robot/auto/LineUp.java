package frc.robot.auto;

import frc.robot.subsystems.Vision;
import frc.robot.DriverController;


public class LineUp {

    Vision vision = new Vision();
    Drive drive = new Drive();
    DriverController driverController = new DriverController();

    Vision vision = new Vision();

    public void run(){
        double centerXReport = vision.runFrontVisionCenterX();
        System.out.println(centerXReport);
    }
}