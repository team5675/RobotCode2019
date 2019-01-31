package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.talonConfig.*;
import frc.robot.DriverController;;


public class Elevator {

    public WPI_TalonSRX masterElevator = new WPI_TalonSRX(1);
    public WPI_TalonSRX slaveElevator = new WPI_TalonSRX(2);

    public WPI_TalonSRX masterForebar = new WPI_TalonSRX(3);

    final static int kMasterElevatorId = 1;

    //emperically measured encoder values here 
    //****4096 ticks is full encoder revolution****
    final static double kHatch1 = 0;
    final static double kHatch2 = 0;
    final static double kHatch3 = 0;

    final static double kCargo1 = 0;
    final static double kCargo2 = 0;
    final static double kCargo3 = 0;

    final static double kFHatch1 = 0;
    final static double kFHatch2 = 0;
    final static double kFHatch3 = 0;

    final static double kFCargo1 = 0;
    final static double kFCargo2 = 0;
    final static double kFCargo3 = 0;

    double[] setValueElevator = {kHatch1, kHatch2, kHatch3, 
        kCargo1, kCargo2, kCargo3};

    double[] setValueForeBar = {kFHatch1, kFHatch2, kFHatch3,
        kFCargo1, kFCargo2, kFCargo3};

    boolean[] controllerSet = {DriverController.getHatch1(), 
        DriverController.getHatch2(), DriverController.getHatch3(),
        DriverController.getCargo1(),DriverController.getCargo2(), 
        DriverController.getCargo3()};

    double eHeight = 0;
    double fHeight = 0;

    public void run(){

        setHeight();
        whatHeight();
    }

    public void config(){

        talonConfig.configElevator(masterElevator);
        talonConfig.configElevator(slaveElevator);
        talonConfig.configElevator(masterForebar);
        
        slaveElevator.follow(masterElevator);
    }

    public void setHeight(){

        for (int i = 0; i < controllerSet.length; i++){

            if (controllerSet[i]){

                eHeight = setValueElevator[i];
                fHeight = setValueForeBar[i];

                i = controllerSet.length;
            }
        }
    }

    public void whatHeight(){

      masterElevator.set(ControlMode.Position, eHeight);
      slaveElevator.set(ControlMode.Follower, kMasterElevatorId);

      masterForebar.set(ControlMode.Position, fHeight);

      if ((DriverController.getElevator() > .2) || (DriverController.getElevator() < -.2)){

        masterElevator.set(ControlMode.PercentOutput, DriverController.getElevator());
      }
    }
}

