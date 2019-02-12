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

    final static double kCargo1 = 2048;
    final static double kCargo2 = 40960;
    final static double kCargo3 = 614400;

    final static double kFHatch1 = 100;
    final static double kFHatch2 = 200;
    final static double kFHatch3 = 300;

    final static double kFCargo1 = 15;
    final static double kFCargo2 = 2500;
    final static double kFCargo3 = 35000;

    double[] setValueElevator = {kHatch1, kHatch2, kHatch3, 
        kCargo1, kCargo2, kCargo3};

    double[] setValueFourbar = {kFHatch1, kFHatch2, kFHatch3,
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

        setHeight();
        goToHeight();

        System.out.println(masterElevator.getSelectedSensorPosition());
    }

    public void config(){

        talonConfig.configElevator(masterElevator);
        talonConfig.configElevator(masterFourbar);
    }

    public void setHeight(){


        for (int i = 0; i < controllerSet.length; i++){

            if (!controllerSet[i]){

                eHeight = setValueElevator[i];
                fHeight = setValueFourbar[i];

                i = controllerSet.length;
            }
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

        masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
        masterFourbar.set(ControlMode.PercentOutput, (DriverController.getJeff()));
      }

      else {

        masterElevator.set(ControlMode.Position, eHeight);
        masterFourbar.set(ControlMode.Position, fHeight);
      }
    }
}

