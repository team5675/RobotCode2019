
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.DriverController;

public class Jeff {

    Spark cargo = new Spark(7); //wheel motor
    //Spark hatch = new Spark(8); //hatch motor

    DriverController controller = new DriverController();
    DigitalInput cargoSwitch = new DigitalInput(6);

    double jeffSpeed = 0;

    int accumManualHatch = 0;

    public void run(){

        setSpeed();
    }


    public void setSpeed() {
        
        jeffSpeed = controller.getCargoRelease() - controller.getCargoIntake();

        if (cargoSwitch.get()) {

            if (jeffSpeed < 0) {

                jeffSpeed = 0;
            }
        }

        cargo.set(jeffSpeed);
        
    }
}