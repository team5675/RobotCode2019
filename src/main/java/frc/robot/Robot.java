/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Drive;

public class Robot extends TimedRobot {

  public static AHRS ahrs; // gyroscope
public static AHRS gyro = new AHRS(SPI.Port.kMXP);

  @Override
  public void robotInit() {
   
  }

 
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
    
    }
  

 
  @Override
  public void teleopPeriodic() {
    while (isOperatorControl() && isEnabled()) {

      // regular operator control
       chassis.driveCartesian();
    }
  }


  @Override
  public void testPeriodic() {
  }
}
