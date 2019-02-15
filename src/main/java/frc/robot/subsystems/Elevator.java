package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.talonConfig.*;
import frc.robot.DriverController;;


public class Elevator {


    public WPI_TalonSRX masterElevator = new WPI_TalonSRX(5);
    public WPI_TalonSRX masterFourbar = new WPI_TalonSRX(6);

    //emperically measured encoder values here 
    //****4096 ticks is full encoder revolution****
    final static double kHatch1 = 0;
    final static double kHatch2 = 4096;
    final static double kHatch3 = 8192;

    final static double kCargo1 = 20480;
    final static double kCargo2 = 40960;
    final static double kCargo3 = 614400;

    final static double kFHatch1 = 100;
    final static double kFHatch2 = 200;
    final static double kFHatch3 = 300;

    final static double kFCargo1 = 15;
    final static double kFCargo2 = 2500;
    final static double kFCargo3 = 35000;

    double[] setElevator = {kHatch1, kHatch2, kHatch3, 
        kCargo1, kCargo2, kCargo3};

    double[] setFourbar = {kFHatch1, kFHatch2, kFHatch3,
        kFCargo1, kFCargo2, kFCargo3};

    boolean[] controllerSet = {DriverController.getHatch1(), 
        DriverController.getHatch2(), DriverController.getHatch3(),
        DriverController.getCargo1(),DriverController.getCargo2(), 
        DriverController.getCargo3()};

    double eHeight = 0;
    double fHeight = 0;

    int accumManual = 0;
    boolean manualMode = false;

    public void run(){

        //setHeight();
        goToHeight();


        System.out.println(masterElevator.getSelectedSensorPosition());
        System.out.println(DriverController.getCargo1());
    }

    public void config(){

        talonConfig.configElevator(masterElevator);
        talonConfig.configElevator(masterFourbar);
    }

    public void setHeight(){

        if (controllerSet[1]) {

            eHeight = setElevator[1];
            fHeight = setFourbar[1];
        }

        else if (controllerSet[2]) {

            eHeight = setElevator[2];
            fHeight = setFourbar[2];
        }

        else if (controllerSet[3]) {

            eHeight = setElevator[3];
            fHeight = setFourbar[3];
        }

        else if (controllerSet[4]) {

            eHeight = setElevator[4];
            fHeight = setFourbar[4];
        }

        else if (controllerSet[5]) {

            eHeight = setElevator[5];
            fHeight = setFourbar[5];
        }

        else {

            eHeight = setElevator[0];
            fHeight = setFourbar[0];
        }

       /* for (int i = 0; i < controllerSet.length; i++){

            if (controllerSet[i] = true){

                eHeight = setElevator[i];
                fHeight = setFourbar[i];

                break;
            }
        } */
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

        masterElevator.set(ControlMode.MotionMagic, eHeight);
        masterFourbar.set(ControlMode.MotionMagic, fHeight);
      }
    }
}