/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Drive;
import frc.robot.DriverController;
import frc.robot.auto.LineUp;
import frc.robot.subsystems.Jeff;
import frc.robot.subsystems.Light;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Ham;


public class Robot extends TimedRobot {

  LineUp lineUp = new LineUp();
  Drive drive = new Drive();
  DriverController driverController = new DriverController();
  Jeff jeff = new Jeff();
  Light light = new Light();
  Elevator elevator = new Elevator();
  Ham ham = new Ham();

  @Override
  public void robotInit() {

    elevator.config();
    drive.config();

    light.set(123); //Update the color of the epic LEDs (tells when the robot is done loading)
  }

  @Override
  public void robotPeriodic() {
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

    //Cargo intake/outtake
    if (driverController.getCargoIntake()) {
      jeff.setIntakeSpeed(0.5);  //Temporary; This will need testing to decide on a speed for the intake wheels
    } else {
      jeff.setIntakeSpeed(driverController.getCargoRelease()); //Placeholder speed
    }
    //elevator controls
    //elevator.run();

    elevator.masterElevator.set(ControlMode.PercentOutput, driverController.getElevator());
    //ham controls
    ham.Climb();
  }

  

  @Override
  public void testPeriodic() {
  }
}