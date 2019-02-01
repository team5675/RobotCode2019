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
        double[] area = areaData.getDoubleArray(new double[0]);

        double biggestArea = 0;
        int biggestAreaId = 0;
        int biggestAreaId2 = 0;

        double[] returnValue = {0, 0};

        if (centerX.length > 1){
            for (int i = 0; i < area.length; i++){
                if (area[i] >= biggestArea) {
                    biggestAreaId2 = biggestAreaId;
                    biggestAreaId = i;
                    biggestArea = area[i];
                }
            }

            if (centerX[biggestAreaId] > centerX[biggestAreaId2]) {
                returnValue = new double[] {centerX[biggestAreaId2], centerX[biggestAreaId]};
            } else {
                returnValue = new double[] {centerX[biggestAreaId], centerX[biggestAreaId2]};
            }
        }
       // System.out.println("left: " + returnValue[0]);
        //System.out.println("right: " + returnValue[1]);
        return returnValue;
    }
}