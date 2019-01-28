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
        double[] centerXReport = vision.runFrontVisionCenterX();
        if (centerXReport.length < 3){
            double x = (centerXReport[0] + ((centerXReport[1] - centerXReport[0])/2) - 80)/80; //Center between vision targets
            
            double[] areaReport = vision.runFrontVisionArea();
            double left = areaReport[0];
            double right = areaReport[1];
            double y = (left - (left + right)/2)/((left + right)/2);

            drive.move(x * 2, y, 0); //i forgot what side is rotate and im to lazy to look it up
            //doing * 2 kind of like a nitrous boost
        } else {
            System.out.println("MORE THAN TWO CONTOURS!!!");
        }
    }
}
