package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.config.Constants;

import frc.robot.DriverController;
import frc.robot.Dashboard;

public class Elevator {
  Dashboard dashboard = new Dashboard();

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
    if (DriverController.getElevatorOverridePressed()) {
      if (overrideActive) {
        overrideActive = false;
        dashboard.setManualModeOn(false);
      } else {
        overrideActive = true;
        dashboard.setManualModeOn(true);
      }
    }

    if (!overrideActive) {
      if (masterElevator.getSelectedSensorPosition() < Constants.ELEVATOR_BOTTOM_LIMIT) { //if elevator below limit
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
        double speed = 1;

        if (masterElevator.getSelectedSensorPosition() > Constants.ELEVATOR_TOP_LIMIT - Constants.ELEVATOR_SLOW_DOWN) {
          speed = (Constants.ELEVATOR_TOP_LIMIT - masterElevator.getSelectedSensorPosition()) * Constants.ELEVATOR_P_GAIN;
        }

        masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator() * speed);
      }

      //4 Bar limits
      if (!DriverController.getElevatorStage0() && !DriverController.getElevatorStage1()) {
        if (masterFourbar.getSelectedSensorPosition() < 0) {
          //System.out.print("trigger");
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
          double speed = 1;

          if (masterFourbar.getSelectedSensorPosition() > Constants.FOURBAR_TOP_LIMIT - Constants.FOURBAR_SLOW_DOWN) {
            speed = (Constants.FOURBAR_TOP_LIMIT - masterFourbar.getSelectedSensorPosition()) * Constants.FOURBAR_P_GAIN;
          }
          
          masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar() * speed);
        }
      } else if (DriverController.getElevatorStage1()) {
        //masterFourbar.set(ControlMode.Position, 1100);
        double speed = (1100 - masterFourbar.getSelectedSensorPosition()) * -0.001;
        masterFourbar.set(ControlMode.PercentOutput, speed);
        dashboard.setOutput1(speed);
      } else {
        double speed = (500 - masterFourbar.getSelectedSensorPosition()) * -0.0007;
        masterFourbar.set(ControlMode.PercentOutput, speed);
        dashboard.setOutput1(speed);
      }
    } else {
      masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
    }
    dashboard.setElevatorEncoder(masterElevator.getSelectedSensorPosition());
    dashboard.setFourbarEncoder(masterFourbar.getSelectedSensorPosition());
  }
}