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

/**
 * Add your docs here.
 */
public class hatcher extends Subsystem {
  private final Solenoid solenoidHatcher = RobotMap.solenoidHatcher;
  private final Solenoid solenoidExtender = RobotMap.solenoidExtender;
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  //public void extendHatcher(){
   // solenoidHatcher.set(Solenoid.value.);
   // rearLegSolenoid.set(DoubleSolenoid.Value.kForward);
  //}

  //public void retractFrontLifter(){
  //  frontLegSolenoid.set(DoubleSolenoid.Value.kReverse);
  //}

  //public void retractRearLifter(){
  //  rearLegSolenoid.set(DoubleSolenoid.Value.kReverse);
  //}

  //public void stopFrontLifters(){
  //  frontLegSolenoid.set(DoubleSolenoid.Value.kOff);
  //}

  //public void stopRearLifters(){
   // rearLegSolenoid.set(DoubleSolenoid.Value.kOff);
  //}
}
