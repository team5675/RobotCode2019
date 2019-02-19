package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.talonConfig.*;
import frc.robot.DriverController;;


public class Elevator {


    public WPI_TalonSRX masterElevator = new WPI_TalonSRX(5);
    public WPI_TalonSRX masterFourbar = new WPI_TalonSRX(6);

    final static double TOP_4BAR_LIMIT = 0;
    final static double BOTTOM_4BAR_LIMIT = 0;

    //emperically measured encoder values here 
    //****4096 ticks is full encoder revolution****
    final static double kHatch1 = 0;
    final static double kHatch2 = 4096;
    final static double kHatch3 = 8192;

    final static double kCargo1 = 122388;
    final static double kCargo2 = 600000;
    final static double kCargo3 = 614400;

    final static double kFHatch1 = 100;
    final static double kFHatch2 = 200;
    final static double kFHatch3 = 300;

    final static double kFCargo1 = -6033;
    final static double kFCargo2 = 2500;
    final static double kFCargo3 = 35000;


    double eHeight = 0;
    double fHeight = 0;

    int accumManual = 1;
    boolean manualMode = true;

    public void run(){

        setHeight();
        goToHeight();

        if (DriverController.getDefense()) {

          masterFourbar.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
        }

        //System.out.println(masterFourbar.getSelectedSensorPosition(0));
    }

    public void config(){

        talonConfig.configElevator(masterElevator);
        talonConfig.configElevator(masterFourbar);
    }

    public void setHeight(){

      if (DriverController.getCargo1()) {

        fHeight = kFCargo1;
        eHeight = kCargo1;
        }

      if (DriverController.getCargo2()) {

        fHeight = kFCargo2;
        eHeight = kCargo2;
      }

      if (DriverController.getCargo3()) {

        fHeight = kFCargo3;
        eHeight = kCargo3;
      }

      if (DriverController.getHatch1()) {

        fHeight = kFHatch1;
        eHeight = kHatch1;
      }

      if (DriverController.getHatch2()) {

        fHeight = kFHatch2;
        eHeight = kHatch2;
      }

      if (DriverController.getHatch3()) {

        fHeight = kFHatch3;
        eHeight = kHatch3;
      }
    }


    public void goToHeight(){

        if (DriverController.manualMode()){

            accumManual += 1;
            manualMode = true;

            if (accumManual >= 2) {

                accumManual = 0;
                manualMode = false;
            }
        }

      if (manualMode){

          masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
          masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      }

      else{

        masterElevator.set(ControlMode.Position, eHeight);
        masterFourbar.set(ControlMode.Position, fHeight);
      }
    }
}