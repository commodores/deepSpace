/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveManual extends Command {
  public DriveManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_driveTrain);
    requires(Robot.m_limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double speed = Robot.m_oi.getJoystick1().getRawAxis(1);
    double rotation = Robot.m_oi.getJoystick1().getRawAxis(2);
    
    //double left = Robot.m_oi.getJoystick1().getRawAxis(1);
    //double right = Robot.m_oi.getJoystick1().getRawAxis(5);
/*
   

    if (left > -0.2 && left <0.2){
      left = 0;
    }

    if (right > -0.2 && right <0.2){
      right = 0;
    }

    Robot.m_driveTrain.driveTank(left, right);
  */
    

    if( speed > -0.2 && speed < 0.2){
      speed = 0;
    }

    if( rotation > -0.2 && rotation < 0.2){
      rotation = 0;
    }

    Robot.m_driveTrain.driveArcade(-speed, -rotation);

    /*if (Robot.m_oi.getJoystick2().getRawButton(7)){
      left += Robot.m_limelight.steerCmd();
      right -= Robot.m_limelight.steerCmd();
    }
    */
  
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
