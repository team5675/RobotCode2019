/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.config.driveTalonConfig;

public class Drive {
    static WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(3);//Motor Controllers
    static WPI_TalonSRX m_frontRight = new WPI_TalonSRX(4);//for drive train
    static WPI_TalonSRX m_backLeft = new WPI_TalonSRX(2);
    static WPI_TalonSRX m_backRight = new WPI_TalonSRX(1);

    static MecanumDrive chassis = new MecanumDrive(m_frontLeft, m_backLeft, m_frontRight, m_backRight);

    //AHRS gyro = new AHRS(Port.kMXP);

    double currentPosition = 0;
    double degreeIncrease = 0.01;

    public void config(){
        driveTalonConfig.configDrive(m_frontLeft);
        driveTalonConfig.configDrive(m_frontRight);
        driveTalonConfig.configDrive(m_backLeft);
        driveTalonConfig.configDrive(m_backRight);
    }
    
    public void move(double x, double y, double z) {
      //  currentPosition = currentPosition + degreeIncrease * z;
        
       // System.out.println(gyro.getYaw());
        //System.out.println(gyro.getPitch());
        chassis.driveCartesian(x, y, z);
    }
}