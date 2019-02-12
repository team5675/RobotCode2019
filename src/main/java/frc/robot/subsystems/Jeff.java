/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;

public class Jeff {

    
    Spark cargoIntake = new Spark(4); //wheel motor
    DigitalInput cargoSwitch = new DigitalInput(1);




    public void setIntakeSpeed(double speed) {
        if (speed <= 0){
            cargoIntake.set(speed);
        } 
        else if (cargoSwitch.get()) {
            cargoIntake.set(speed);
        }
    }


}
