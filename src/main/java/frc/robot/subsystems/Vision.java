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

    public double CenterX() {

        double centerX = table.getEntry("centerX").getDouble(0);

        return centerX;
    }

    public double avgArea() {

        double avgArea = table.getEntry("avgArea").getDouble(0);

        return avgArea;
    }
}

