/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.lib.LIDARLite;
import frc.robot.Robot;
import frc.robot.subsystems.LIDAR;

public class AutoClimb extends Command {
  public AutoClimb() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_climber);
    requires(Robot.m_rearLegLock);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_climber.extendFrontLifter();
    Robot.m_climber.extendRearLifter();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_lidar.getDistance() > 59;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
