package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Spark;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.DriverController;;


public class Elevator {


  public WPI_TalonSRX masterElevator = new WPI_TalonSRX(5);
  public WPI_TalonSRX masterFourbar = new WPI_TalonSRX(6);
  //Spark leftMotor = new Spark(0);

  //CONSTANTS
  int ELEVATOR_TOP_LIMIT = 980000;
  int FOURBAR_TOP_LIMIT = 5200;

  public void config() {
    masterElevator.setSelectedSensorPosition(0);
    masterFourbar.setSelectedSensorPosition(0);
  }

  public void loop(){
    if (!DriverController.getElevatorOverride()) {
      //Elevator limits
      if (masterElevator.getSelectedSensorPosition() > 0) {
        if (DriverController.getElevator() > 0) {
          masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
         } else {
          masterElevator.set(ControlMode.PercentOutput, 0);
         }
      } else if (masterElevator.getSelectedSensorPosition() <mn ELEVATOR_TOP_LIMIT) {
        if (DriverController.getElevator() > 0) {
          masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
        } else {
          masterElevator.set(ControlMode.PercentOutput, 0);
        }
      } else {
        masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      }

      //4 Bar limits
      if (masterElevator.getSelectedSensorPosition() > 0) {
        if (DriverController.get4Bar() < 0) {
          masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
         } else {
          masterFourbar.set(ControlMode.PercentOutput, 0);
         }
      } else if (masterFourbar.getSelectedSensorPosition() < FOURBAR_TOP_LIMIT) {
        if (DriverController.get4Bar() > 0) {
          masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
        } else {
          masterFourbar.set(ControlMode.PercentOutput, 0);
        }
      } else {
        masterElevator.set(ControlMode.PercentOutput, DriverController.get4Bar());
      }
    } else {
      masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
    }
    System.out.println("Elevator: " + masterElevator.getSelectedSensorPosition() + "Fourbar: " + masterFourbar.getSelectedSensorPosition());
  }
}