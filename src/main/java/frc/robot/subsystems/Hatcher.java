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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 * Add your docs here.
 */
public class Hatcher extends Subsystem {
  private final Solenoid solenoidHatcher = RobotMap.solenoidHatcher;
  private final Solenoid solenoidExtender = RobotMap.solenoidExtender;  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void extendHatcher(){
    solenoidExtender.set(true);
    //solenoidExtender.set(Value.kForward);
  }

  public void retractHatcher(){
    solenoidExtender.set(false);
    //solenoidExtender.set(Value.kReverse);
  }

  public void gripHatch(){
    solenoidHatcher.set(true);
    //solenoidHatcher.set(Value.kForward);
  }

  public void releaseHatch(){
    solenoidHatcher.set(false);
    //solenoidHatcher.set(Value.kReverse);
  }

  public void stopExtend(){
    //solenoidExtender.set(Value.kOff);
  }

  public void stopGrip(){
    //solenoidHatcher.set(Value.kOff);
  }
}
