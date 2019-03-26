package frc.robot.auto;

import frc.robot.subsystems.Vision;
import frc.robot.DriverController;
import frc.robot.subsystems.Drive;


public class LineUp {

    Vision vision = new Vision();
    Drive drive = new Drive();
    DriverController driverController = new DriverController();

    double x = 0;
    

    public void run(){

        //double centerXReport = server.centerX;
        //double areaReport = vision.avgArea();
        
        //x = ((centerXReport - 120) / 120) * -.6;
        //double theta = Math.atan(centerXReport / areaReport);

        drive.move(x, driverController.getForward(), 0);
        //System.out.println(centerXReport);
    }
}