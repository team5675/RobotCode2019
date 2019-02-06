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

    public Spark hatchIntake = new Spark(5); //Drop down hatch pickup
    public Spark hatchRelease = new Spark(6); //For the cam outtake



    public void setIntakeSpeed(double speed) {

        cargoIntake.set(speed);
    }

    public void hatchRelease() {

        hatchRelease.set(0.8); //Speed is temporary
    }

}
