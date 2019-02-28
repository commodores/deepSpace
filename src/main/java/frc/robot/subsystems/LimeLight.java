/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;
import frc.robot.commands.*;

public class LimeLight extends Subsystem {


  @Override
  public void initDefaultCommand() {
  }

  public double getK() {
    return .01;
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

}
