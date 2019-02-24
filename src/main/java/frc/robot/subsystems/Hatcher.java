/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;


/**
 * Add your docs here.
 */
public class Hatcher extends Subsystem {
  private final Solenoid solenoidHatcher = RobotMap.solenoidHatcher;
  private final Solenoid solenoidExtender = RobotMap.solenoidExtender;
  private final SpeedController revBlinkin = RobotMap.ledControllerRevBlinkin;
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void extendHatcher(){
    solenoidExtender.set(true);
    
  }

  public void retractHatcher(){
    solenoidExtender.set(false);
  }

  public void gripHatch(){
    solenoidHatcher.set(true);
  }

  public void releaseHatch(){
    solenoidHatcher.set(false);
  }
}
