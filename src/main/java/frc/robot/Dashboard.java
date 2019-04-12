/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Gyro;

public class Dashboard {
    Gyro gyro = new Gyro();

    public void loop(){
        //SmartDashboard.putNumber("voltage", RobotController.getBatteryVoltage());
        //SmartDashboard.putNumber("gyro", gyro.getAngle());
    }

    public void setElevatorEncoder(int ticks) {
        SmartDashboard.putNumber("encoderElevator", ticks);
    }

    public void setFourbarEncoder(int ticks) {
        SmartDashboard.putNumber("fourbarElevator", ticks);
    }

    public void setOutput1(double value) {
        SmartDashboard.putNumber("output1", value);
    }

    public void setManualModeOn(boolean value) {
        SmartDashboard.putBoolean("manualMode", value);
    }
}
