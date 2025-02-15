/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI.Port;


public class Gyro {
    AHRS navX = new AHRS(Port.kMXP);
    double subtractDegree = 0;

    public void config() {
        //navX = new AHRS(Port.kMXP);
    }

    public double getAngle() {
        return navX.getAngle();
    }
}