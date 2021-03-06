/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoTurn extends Command {
  
  private double degrees;
  private double timeOut;

  public AutoTurn(double getDegrees, double getTimeOut) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_driveTrain);
    degrees = getDegrees;
    timeOut = getTimeOut;
    setTimeout(timeOut);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_driveTrain.resetAngle();
    Robot.m_driveTrain.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(degrees > 0){
      Robot.m_driveTrain.driveTank(-.65, .65);
    } else {
      Robot.m_driveTrain.driveTank(.65, -.65);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(degrees > 0){
      return Robot.m_driveTrain.getYaw() > degrees || isTimedOut();
    } else {
      return Robot.m_driveTrain.getYaw() < degrees || isTimedOut();
    }
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
