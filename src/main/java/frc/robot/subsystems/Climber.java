/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final DoubleSolenoid frontLegSolenoid = RobotMap.frontLegSolenoid;
  private final DoubleSolenoid rearLegSolenoid = RobotMap.rearLegSolenoid;
  private final WPI_TalonSRX frontLegMotor = RobotMap.frontLegMotor;
  private final WPI_TalonSRX rearLegMotor = RobotMap.rearLegMotor;  

  public Climber(){
    frontLegMotor.setNeutralMode(NeutralMode.Brake);
    rearLegMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand();
  }
  
  public void extendAllLifters(){
    frontLegSolenoid.set(DoubleSolenoid.Value.kForward);
    rearLegSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void extendFrontLifter(){
    frontLegSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void extendRearLifter(){
    rearLegSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retractAllLifters(){
    frontLegSolenoid.set(DoubleSolenoid.Value.kReverse);
    rearLegSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void retractFrontLifter(){
    frontLegSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void retractRearLifter(){
    rearLegSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopFrontLifters(){
    frontLegSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  public void stopRearLifters(){
    rearLegSolenoid.set(DoubleSolenoid.Value.kOff);
  }
  
  public void driveFwd(){
    frontLegMotor.set(-.5);
    rearLegMotor.set(.5);
  }
  
  public void driveBwd(){
    frontLegMotor.set(.5);
    rearLegMotor.set(-.5);
  }
  
  public void stopDrive(){
    frontLegMotor.set(0);
    rearLegMotor.set(0);
  }
}
