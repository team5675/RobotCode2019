/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;

import frc.robot.DriverController;
import frc.robot.subsystems.Elevator;

public class Ham {

    Drive drive = new Drive();
    Elevator elevator = new Elevator();

    DigitalInput HAMDownLimit = new DigitalInput(9);
    DigitalInput HAMUpLimit = new DigitalInput(7);

    DriverController controller = new DriverController();

    WPI_VictorSPX ham1 = new WPI_VictorSPX(10);
    WPI_VictorSPX ham2 = new WPI_VictorSPX(11);

    Spark hamFootDrive = new Spark(8);


    public void Climb(){

        ham2.follow(ham1);

        if (controller.getHAMDown()){

            if (!HAMDownLimit.get()){

                ham1.set(ControlMode.PercentOutput, .75);
            }

            else { ham1.set(ControlMode.PercentOutput, 0); }
        }

        else if (controller.getHAMUp()) {

            if (!HAMUpLimit.get()){

                ham1.set(ControlMode.PercentOutput, -.75);
            }

            else { ham1.set(ControlMode.PercentOutput, 0); }
        }

        else {ham1.set(ControlMode.PercentOutput, 0);}

        if (controller.getHAMForward()) {

            hamFootDrive.set(1);
        }

        else if (controller.getHAMBackwards()) {

            hamFootDrive.set(1);
        }

        else {hamFootDrive.set(0);}
    } 
}
