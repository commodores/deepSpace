/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoDriveToTarget extends Command {
  public AutoDriveToTarget() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_limelight);
    requires(Robot.m_driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double KpAim = -0.1;
    double KpDistance = -0.1;
    double min_aim_command = 0.05;

    double tx = Robot.m_limelight.getX();
    double ty = Robot.m_limelight.getY();
    
    double heading_error = -tx;
    double distance_error = -ty;
    double steering_adjust = 0.0;

    double left = 0.0;
    double right = 0.0;

    if (tx > 1.0)
    {
      steering_adjust = KpAim*heading_error - min_aim_command;
    }
    else if (tx < 1.0)
    {
      steering_adjust = KpAim*heading_error + min_aim_command;
    }

    double distance_adjust = KpDistance * distance_error;

    left += steering_adjust + distance_adjust;
    right -= steering_adjust + distance_adjust;

    if (Robot.m_limelight.targetExists()){
      Robot.m_driveTrain.driveTank(left, right);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
