/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Drive;
import frc.robot.DriverController;
import frc.robot.auto.LineUp;
import frc.robot.subsystems.Jeff;

public class Robot extends TimedRobot {
  LineUp lineUp = new LineUp();
  Drive drive = new Drive();
  DriverController driverController = new DriverController();
  Jeff jeff = new Jeff();

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
    drive.move(driverController.getStrafe(), driverController.getForward(), driverController.getRotation());

    if (driverController.lineUp()){
      lineUp.run();
    }
    
    //Cargo intake/outtake
    if (driverController.getCargoIntake()) {
      jeff.setIntakeSpeed(0.5);  //Temporary; This will need testing to decide on a speed for the intake wheels
    }

    else if (driverController.getCargoRelease()) {
      jeff.setIntakeSpeed(-0.5); //Placeholder speed
    }

    else {
      jeff.setIntakeSpeed(0);
    }

  }

  @Override
  public void testPeriodic() {
  }
}