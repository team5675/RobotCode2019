/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.DriverController;
import frc.robot.auto.LineUp;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Jeff;
import frc.robot.subsystems.Light;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Ham;


public class Robot extends TimedRobot {
  Vision vision = new Vision();
  Gyro gyro = new Gyro();
  LineUp lineUp = new LineUp();
  DriverController driverController = new DriverController();
  Dashboard dashboard = new Dashboard();
  Light light = new Light();
  Drive drive = new Drive();
  Elevator elevator = new Elevator();
  Jeff jeff = new Jeff();
  Ham ham = new Ham();


  @Override
  public void robotInit() {
    drive.config();
    elevator.config();
    vision.config();
    lineUp.config();
    gyro.config();

    light.set(-0.85); //Update the color of the epic LEDs (tells when the robot is done loading)
  }


  @Override
  public void robotPeriodic() {
    dashboard.loop();
    elevator.updateDashboard();
  }


  @Override
  public void autonomousInit() {
  }


  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }
  

  @Override
  public void teleopPeriodic() {
    //Checks to see if robot is lining up with vision, if not, update drive train from controls
    if (driverController.lineUp()){
      lineUp.run();
    } else {
      drive.move(driverController.getStrafe(), driverController.getForward(), driverController.getRotation());
    }

    //Loops
    elevator.loop();
    jeff.loop();
    ham.loop();
  }

  
  @Override
  public void testPeriodic() {
  }
}