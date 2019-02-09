/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;

public class Jeff {

    
    public Spark cargoIntake = new Spark(4); //wheel motor

    public Spark hatchPickup = new Spark(5); //For the ground pickup



    public void setIntakeSpeed(double speed) {

        cargoIntake.set(speed);
    }

    public void hatchPickup() {

        hatchPickup.set(0.8); //Speed is temporary
    }

}
