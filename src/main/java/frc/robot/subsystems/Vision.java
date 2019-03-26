/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Vision {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("/GRIP/visionReport");
    NetworkTableEntry centerXData = table.getEntry("centerX");
    NetworkTableEntry areaData = table.getEntry("area");

    public double[] runFrontVisionCenterX() {

        double[] centerX = centerXData.getDoubleArray(new double[0]);
        
        double[] returnValue = {centerX[0], centerX[1]};

        return returnValue;
    }
}

