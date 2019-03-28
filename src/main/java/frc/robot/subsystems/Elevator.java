package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.config.Constants;

import frc.robot.DriverController;

public class Elevator {
  public WPI_TalonSRX masterElevator = new WPI_TalonSRX(5);
  public WPI_TalonSRX masterFourbar = new WPI_TalonSRX(6);

  boolean overrideActive = false;

  public void config() {
    masterElevator.setSelectedSensorPosition(0);
    masterFourbar.setSelectedSensorPosition(0);
  }

  //-1 to motor controller makes it go up
  //As elevator goes up, encoder is positive
  /*
    Logic for limits:
    if elevator/4bar below bottom limit, only let it go up
    if elevator/4bar above top limit, only let it go down
    else let it do whatever
  */

  public void loop(){
    //Toggle override control
    if (DriverController.getElevatorOverride() && !overrideActive) {
      overrideActive = true;
    } else if (!DriverController.getElevatorOverride() && overrideActive) {
      overrideActive = false;
    }

    if (!overrideActive) {
      if (masterElevator.getSelectedSensorPosition() < 0) { //if elevator below limit
        if (DriverController.getElevator() < 0) {
          masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
        } else {
          masterElevator.set(ControlMode.PercentOutput, 0);
        }
      } else if (masterElevator.getSelectedSensorPosition() > Constants.ELEVATOR_TOP_LIMIT) { //if elevator above limit
        if (DriverController.getElevator() > 0) {
          masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
        } else {
          masterElevator.set(ControlMode.PercentOutput, 0);
        }
      } else {
        masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      }

      //4 Bar limits
      if (masterElevator.getSelectedSensorPosition() < 0) {
        if (DriverController.get4Bar() < 0) {
          masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
         } else {
          masterFourbar.set(ControlMode.PercentOutput, 0);
         }
      } else if (masterFourbar.getSelectedSensorPosition() > Constants.FOURBAR_TOP_LIMIT) {
        if (DriverController.get4Bar() > 0) {
          masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
        } else {
          masterFourbar.set(ControlMode.PercentOutput, 0);
        }
      } else {
        masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
      }
    } else {
      masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
    }
  }
}