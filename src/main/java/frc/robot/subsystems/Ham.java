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
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Spark;

import frc.robot.DriverController;

public class Ham {

    Drive drive = new Drive();

    DigitalInput HAMLimit = new DigitalInput(9);
    DigitalInput HAMLimit2 = new DigitalInput(7);
    DigitalInput HAMSlideLimit = new DigitalInput(8);

    DriverController controller = new DriverController();

    WPI_VictorSPX ham1 = new WPI_VictorSPX(10);
    WPI_VictorSPX ham2 = new WPI_VictorSPX(11);

    Spark hamSlide = new Spark(8);

    boolean isDone = false;


    public void Climb(){

        ham2.follow(ham1);


        while (controller.getClimb3A() && controller.getClimb3B() && !isDone) {

            DriverController.xbox1.setRumble(RumbleType.kLeftRumble, .5);
            DriverController.xbox2.setRumble(RumbleType.kRightRumble, .5);

            if (!HAMLimit.get() && !HAMSlideLimit.get()){

                ham1.set(ControlMode.PercentOutput, -.75);
            }

            if (HAMLimit.get()) {

                ham1.set(ControlMode.PercentOutput, 0);

                if (!HAMSlideLimit.get()){

                    hamSlide.set(1);

                    drive.move(0, .50, 0);

                    ham1.set(ControlMode.PercentOutput, 0);
                }

                if (HAMSlideLimit.get()){
                    
                    hamSlide.set(0); 
                    
                    ham1.set(ControlMode.PercentOutput, .75);
                } 
            }

            if (HAMSlideLimit.get()) {
 
                    if (!HAMLimit2.get()) {

                        ham1.set(ControlMode.PercentOutput, .75);
                    }

                    if (HAMLimit2.get()) { 

                        ham1.set(ControlMode.PercentOutput, 0);

                        isDone = true;

                        break;
                    }
            }
        }

        ham1.set(ControlMode.PercentOutput, 0);
        hamSlide.set(0);
    } 
}
