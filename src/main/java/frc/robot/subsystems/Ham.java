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
import frc.robot.DriverController;

/**
 * Add your docs here.
 */
public class Ham {

    DigitalInput HAMLimit = new DigitalInput(0);
    DriverController controller = new DriverController();

    WPI_VictorSPX ham1 = new WPI_VictorSPX(10);
    WPI_VictorSPX ham2 = new WPI_VictorSPX(11);


    public void Climb(){

        ham2.follow(ham1);

        if (controller.getClimb3A() && controller.getClimb3B()) {

            while (HAMLimit.get()){
                ham1.set(ControlMode.PercentOutput, 1);
                ham2.set(ControlMode.Follower, 10);
            }

            ham1.set(ControlMode.PercentOutput, 0);
            ham2.set(ControlMode.Follower, 10);
        }

        ham1.set(ControlMode.PercentOutput, 0);
        ham2.set(ControlMode.Follower, 10);
    }
}
