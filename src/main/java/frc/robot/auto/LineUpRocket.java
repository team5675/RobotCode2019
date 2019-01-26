/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auto;

import frc.robot.subsystems.Drive;
import frc.robot.DriverController;

public class LineUpRocket {
    int varSet = 0;
    double left = 0;
    double right = 0;

    Drive drive = new Drive();
    DriverController driverController = new DriverController();

    public void run(double centerX){
        if (varSet == 0){
            varSet++;
            left = centerX;
        } else {
            varSet--;
            right = centerX;

            drive.move((left + ((right - left)/2) - 80)/80 + driverController.getStrafe(), 0, 0);
        }
    }
}
