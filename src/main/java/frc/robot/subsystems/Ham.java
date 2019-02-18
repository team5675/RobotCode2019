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
import frc.robot.DriverController;

/**
 * Add your docs here.
 */
public class Ham {
    DigitalInput HAMLimit = new DigitalInput(4);
    DigitalInput HAMLimit2 = new DigitalInput(5);

    DriverController controller = new DriverController();

    WPI_VictorSPX ham1 = new WPI_VictorSPX(10);
    WPI_VictorSPX ham2 = new WPI_VictorSPX(11);


    public void Climb(){

        ham2.follow(ham1);

        if (controller.getClimb3A() && controller.getClimb3B()) {

            while (HAMLimit.get()){

                DriverController.xbox1.setRumble(RumbleType.kLeftRumble, .5);
                DriverController.xbox2.setRumble(RumbleType.kRightRumble, .5);

                ham1.set(ControlMode.PercentOutput, 1);
            }

            while (!HAMLimit.get()) {

                ham1.set(ControlMode.PercentOutput, -1);

                DriverController.xbox1.setRumble(RumbleType.kLeftRumble, .5);
                DriverController.xbox2.setRumble(RumbleType.kRightRumble, .5);


                if (HAMLimit2.get()) {

                    ham1.set(ControlMode.PercentOutput, 0);
                }
            }

            DriverController.xbox1.setRumble(RumbleType.kLeftRumble, 0);
            DriverController.xbox2.setRumble(RumbleType.kRightRumble, 0);

            ham1.set(ControlMode.PercentOutput, 0);
        }

        ham1.set(ControlMode.PercentOutput, 0);
    } 
}
