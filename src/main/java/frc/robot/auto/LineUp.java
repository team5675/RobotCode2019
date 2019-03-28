package frc.robot.auto;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Vision;
import frc.robot.DriverController;


public class LineUp {
    Drive drive = new Drive();
    Vision vision = new Vision();
    Gyro gyro = new Gyro();
    DriverController driverController = new DriverController();

    public void config() {

    }

    public void run() {
        drive.move(0, driverController.getForward(), 0);
    }
}