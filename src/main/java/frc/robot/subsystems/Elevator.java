package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.config.*;
import frc.robot.DriverController;;


public class Elevator {

    DriverController controller = new DriverController();

    public WPI_TalonSRX masterElevator = new WPI_TalonSRX(5);
    public WPI_TalonSRX masterFourbar = new WPI_TalonSRX(6);

    final static double HATCH_RELEASE_CONSTANT = 340;

    static double hatchReleaseHeight;

    int accumManual = 1;
    boolean manualMode = true;

    public void run(){

        goToHeight();
        //hatchRelease();
    }

    public void config(){

        talonConfig.configElevator(masterElevator);
        talonConfig.configElevator(masterFourbar);
    }


    public void goToHeight(){

        masterElevator.set(ControlMode.PercentOutput, controller.getElevator());
        masterFourbar.set(ControlMode.PercentOutput, controller.get4Bar());
      }

    public void hatchRelease() {

      hatchReleaseHeight = masterFourbar.getSelectedSensorPosition() - HATCH_RELEASE_CONSTANT;

      if (controller.getHatchRelease()) {

        masterFourbar.set(ControlMode.Position, hatchReleaseHeight);
      }
    }
}