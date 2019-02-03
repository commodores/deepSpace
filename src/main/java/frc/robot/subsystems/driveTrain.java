/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManual;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final WPI_TalonSRX leftMaster = RobotMap.driveTrainLeftMaster;
  private final WPI_TalonSRX leftSlave1 = RobotMap.driveTrainLeftSlave1;
  private final WPI_TalonSRX leftSlave2 = RobotMap.driveTrainLeftSlave2;

  private final WPI_TalonSRX rightMaster = RobotMap.driveTrainRightMaster;
  private final WPI_TalonSRX rightSlave1 = RobotMap.driveTrainRightSlave1;
  private final WPI_TalonSRX rightSlave2 = RobotMap.driveTrainRightSlave2;

  private final DoubleSolenoid motorShifter = RobotMap.motorShifter;

  double lastFeet_r = 0;
	double lastTime = 0;
	double lastVelocity_r = 0;
	double lastAcceleration_r = 0;
	double lastFeet_l = 0;
	double lastVelocity_l = 0;
  double lastAcceleration_l = 0;
  
  public DriveTrain() {
      rightMaster.setInverted(true);
      rightSlave1.setInverted(true);
      rightSlave2.setInverted(true);
      leftSlave1.follow(leftMaster);
      leftSlave2.follow(leftMaster);
      rightSlave1.follow(rightMaster);
      rightSlave2.follow(rightMaster);
      //leftEncoder.setReverseDirection(true);
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManual());
  }

  public void drive(double speed, double rotation) {
    setSpeed(-speed+rotation, -speed-rotation);
  }

  public void setSpeed(double leftSpeed, double rightSpeed) {
		setSpeedLeft(leftSpeed);
		setSpeedRight(rightSpeed);
  }
  
  public void setSpeedLeft(double leftSpeed) {
		leftMaster.set(ControlMode.PercentOutput, leftSpeed);
	}
	
	public void setSpeedRight(double rightSpeed) {
		 rightMaster.set(ControlMode.PercentOutput, rightSpeed);
	}
  
  public void stop() {
    setSpeed(0, 0);
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
