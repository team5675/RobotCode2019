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
import frc.robot.auto.LineUpRocket;

public class Vision {
    LineUpRocket LineUpRocket = new LineUpRocket();

    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("visionReport");
    NetworkTableEntry centerXData = table.getEntry("centerX");

    public void runFrontVision(){
        System.out.println("yeet");
        double[] centerX = centerXData.getDoubleArray(new double[0]);
        for (double x : centerX){
            LineUpRocket.run(x);
        }
    }
}
