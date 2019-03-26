
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.DriverController;

public class Jeff {

    Spark cargo = new Spark(7); //wheel motor
    //Spark hatch = new Spark(8); //hatch motor

    DriverController controller = new DriverController();
    DigitalInput cargoSwitch = new DigitalInput(6);
    Encoder hatchEncoder = new Encoder(13, 14);

    double jeffSpeed = 0;

    final double HATCH_DOWN = 0; //encoder value for hatch all the way down
    final double HATCH_UP = 0; //encoder value for hatch all the way up

    public void run(){

        setSpeed();
        hatchGround();
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

    public void hatchGround() {

        if (controller.getHatchDown()) {

            if (hatchEncoder.get() > HATCH_DOWN) {

            //hatch.set(-1);
            }

            else { //hatch.set(0); 
            }
        }

        if (controller.getHatchUp()) {

            if (hatchEncoder.get() < HATCH_UP) {

                //hatch.set(1);
            }

            else { //hatch.set(0); 
            }
        }
    }
}