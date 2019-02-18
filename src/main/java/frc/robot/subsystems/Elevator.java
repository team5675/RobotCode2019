package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.config.*;
import frc.robot.DriverController;;


public class Elevator {


    public WPI_TalonSRX masterElevator = new WPI_TalonSRX(5);
    public WPI_TalonSRX masterFourbar = new WPI_TalonSRX(6);

    //emperically measured encoder values here 
    //****4096 ticks is full encoder revolution****
    final static double kHatch1 = 0;
    final static double kHatch2 = 4096;
    final static double kHatch3 = 8192;

    final static double kCargo1 = 588460;
    final static double kCargo2 = 40960;
    final static double kCargo3 = 614400;

    final static double kFHatch1 = 100;
    final static double kFHatch2 = 200;
    final static double kFHatch3 = 300;

    final static double kFCargo1 = 15;
    final static double kFCargo2 = 2500;
    final static double kFCargo3 = 35000;


    double eHeight = 0;
    double fHeight = 0;

    int accumManual = 1;
    boolean manualMode = true;

    public void run(){

        //setHeight();
        goToHeight();

        if (DriverController.getCargo1()) {

        masterFourbar.set(ControlMode.Position, kCargo1);
        }

        //System.out.println(masterFourbar.getSelectedSensorPosition());
    }

    public void config(){

        talonConfig.configElevator(masterElevator);
        talonConfig.configElevator(masterFourbar);
    }

    public void setHeight(){

       
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

        masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
        masterFourbar.set(ControlMode.PercentOutput, DriverController.get4Bar());
      }

      else{

        //masterElevator.set(ControlMode.MotionMagic, eHeight);
        masterFourbar.set(ControlMode.MotionMagic, fHeight);
      }
    }
}