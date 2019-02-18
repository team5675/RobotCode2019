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

/**
 * Add your docs here.
 */
public class Ham {
    DigitalInput HAMLimit = new DigitalInput(4);
    DigitalInput HAMLimit2 = new DigitalInput(5);
    DigitalInput HAMSlideLimit = new DigitalInput(3);

    DriverController controller = new DriverController();

    WPI_VictorSPX ham1 = new WPI_VictorSPX(10);
    WPI_VictorSPX ham2 = new WPI_VictorSPX(11);
    Spark pullPork = new Spark(8);

    Spark hamSlide = new Spark(6);


    public void Climb(){

        ham2.follow(ham1);

        if (controller.getClimb3A() && controller.getClimb3B()) {
<<<<<<< HEAD
            System.out.println("hham" + HAMLimit.get());
            while (HAMLimit.get() == false){
                ham1.set(ControlMode.PercentOutput, -0.5);
            }
        } else if (controller.getHamRetract()) {
            ham1.set(1);
            System.out.println("setting to 0.5");
        } else {
=======

            DriverController.xbox1.setRumble(RumbleType.kLeftRumble, .5);
            DriverController.xbox2.setRumble(RumbleType.kRightRumble, .5);

            while (!HAMLimit.get()){

                ham1.set(ControlMode.PercentOutput, 1);
            }

            while (HAMLimit.get()) {

                if (!HAMSlideLimit.get()){

                    hamSlide.set(1);
                }

                hamSlide.set(0);

                if (HAMSlideLimit.get()) {

                    if (!HAMLimit2.get()) {

                        ham1.set(ControlMode.PercentOutput, -1);
                    }
                }
            }

            if (HAMLimit2.get()) {

                ham1.set(ControlMode.PercentOutput, 0);

            }

>>>>>>> b4ef20a18037a2ff2f82297b3a5ef8a16ed9db04
            ham1.set(ControlMode.PercentOutput, 0);
            System.out.println("setting to 0");
        }

       // pullPork.set(DriverController.getElevator());
        ham1.set(ControlMode.PercentOutput, 0);
    } 
}
