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

    DigitalInput HAMLimit = new DigitalInput(9);
    DigitalInput HAMLimit2 = new DigitalInput(7);
    DigitalInput HAMSlideLimit = new DigitalInput(8);

    DriverController controller = new DriverController();

    WPI_VictorSPX ham1 = new WPI_VictorSPX(10);
    WPI_VictorSPX ham2 = new WPI_VictorSPX(11);

    Spark hamSlide = new Spark(8);


    public void Climb(){

        ham2.follow(ham1);

<<<<<<< HEAD
        System.out.println(HAMLimit.get());

        while (controller.getClimb3A() && controller.getClimb3B()) {

            //DriverController.xbox1.setRumble(RumbleType.kLeftRumble, .5);
            //DriverController.xbox2.setRumble(RumbleType.kRightRumble, .5);

            if (!HAMLimit.get() && (!HAMSlideLimit.get())){

                ham1.set(ControlMode.PercentOutput, -.5);
            }

            if (HAMLimit.get()) {

                ham1.set(ControlMode.PercentOutput, 0);

                if (!HAMSlideLimit.get()){

                    //hamSlide.set(1);

                    ham1.set(ControlMode.PercentOutput, 0);
                }

                if (HAMSlideLimit.get()){
                    
                    hamSlide.set(0); 
                    
                    ham1.set(ControlMode.PercentOutput, .5);
                } 
            }

            if (HAMSlideLimit.get()) {
 
                    if (!HAMLimit2.get()) {

                        ham1.set(ControlMode.PercentOutput, .5);
                    }

                    if (HAMLimit2.get()) { 

                        ham1.set(ControlMode.PercentOutput, 0);
                    }
            }
        }

        ham1.set(ControlMode.PercentOutput, 0);
        hamSlide.set(0);
=======
        if (controller.getClimb3A() && controller.getClimb3B()) {
            while (HAMLimit.get() == false){
                ham1.set(ControlMode.PercentOutput, -0.5);
            }
        } else if (controller.getHamRetract()) {
            ham1.set(1);
        } else {
            ham1.set(ControlMode.PercentOutput, 0);
        }

       pullPork.set(DriverController.getElevator());
>>>>>>> a2c5a89005e086e82cad5776bab202c07f839260
    } 
}
