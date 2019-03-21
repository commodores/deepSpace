/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnToTargetLimelight extends Command {
  double lastError = 0;
  double error_sum = 0;
  double kp = 0.021;
  double ki = 0.0;
  double kd = 0.15;

  boolean reachedTarget;

  public TurnToTargetLimelight() {
    requires(Robot.m_driveTrain);
    requires(Robot.m_limelight);
  }

  @Override
  protected void initialize() {
    setTimeout(1.5);
    error_sum = 0;
    reachedTarget = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      if(!Robot.m_limelight.targetExists()) return;

      double changeInError = lastError - Robot.m_limelight.getX();
      error_sum += Robot.m_limelight.getX();

      double P = kp * Robot.m_limelight.getX();
      double I = ki * error_sum;
      double D = kd * changeInError;
      lastError = Robot.m_limelight.getX();
      double output = P + I - D;

      if(output > 0) output += 0.1;
      else output -= 0.1;

      Robot.m_driveTrain.driveTank(output, -output);
  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(!Robot.m_limelight.targetExists()) return true;

    if(Math.abs(Robot.m_limelight.getX()) < 1 && !reachedTarget) {
      setTimeout(0.5);
      reachedTarget = true;
      return false;
    }
    else if(reachedTarget && isTimedOut()) {
      Robot.m_driveTrain.stop();
      return true;
    }
    return isTimedOut();
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
