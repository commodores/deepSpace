/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;

public class LimeLight extends Subsystem {


  @Override
  public void initDefaultCommand() {

  }

  public boolean targetExists() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tv = table.getEntry("tv");

    return tv.getDouble(0.0) == 1.0;
  }
  
  public double getX() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");

    return tx.getDouble(0.0);
  }

   public double getY() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");

    return ty.getDouble(0.0);
  }

   public double getArea() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ta = table.getEntry("ta");

    return ta.getDouble(0.0);
  }

  public double getDistance() {
    return (32.06125-28.5) / Math.tan(Math.toRadians(16.9 - getY()));
  }

  public double getAngle() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry thor = table.getEntry("thor");
    NetworkTableEntry tvert = table.getEntry("tvert");
    double currentRatio = thor.getDouble(0.0) / tvert.getDouble(0.0);
    // double originalRatio = 15.27 / 6.125;
    double originalRatio = 77.0 / 35.0;

    double ratio = Math.min(1, currentRatio/originalRatio);

    return Math.toDegrees(Math.acos(ratio));
  }

  public double steerCmd() {
    final double STEER_K = 0.03;                    // how hard to turn toward the target
    return getX() * STEER_K;
  }

  public double driveCmd() {
    final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
    final double DESIRED_TARGET_AREA = 13.0;        // Area of the target when the robot reaches the wall
    return (DESIRED_TARGET_AREA - getArea()) * DRIVE_K;
  }

}