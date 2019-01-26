/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive {
    Spark m_frontLeft = new Spark(0);//Motor Controllers
    Spark m_frontRight = new Spark(1);//for drive train
    Spark m_backLeft = new Spark(2);
    Spark m_backRight = new Spark(3);

    MecanumDrive chassis = new MecanumDrive(m_frontLeft, m_backLeft, m_frontRight, m_backRight);
    
    public void move(double x, double y, double z) {
        chassis.driveCartesian(x, y, z);
    }
}