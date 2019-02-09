/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class MotorShifter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final DoubleSolenoid motorShifter = RobotMap.motorShifter;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LowGear());
  }
  public void highGear(){
    motorShifter.set(DoubleSolenoid.Value.kForward);
  }

  public void lowGear(){
    motorShifter.set(DoubleSolenoid.Value.kReverse);
  }

  public void turnOffSolenoids(){
    motorShifter.set(DoubleSolenoid.Value.kOff);
  }
}
