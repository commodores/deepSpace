/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class RobotMap {
  //driveTrain devices
  public static WPI_TalonSRX driveTrainLeftMaster;
  public static WPI_TalonSRX driveTrainLeftSlave1;
  public static WPI_TalonSRX driveTrainLeftSlave2;

  public static WPI_TalonSRX driveTrainRightMaster;
  public static WPI_TalonSRX driveTrainRightSlave1;
  public static WPI_TalonSRX driveTrainRightSlave2;

  public static SpeedController ledControllerRevBlinkin;
  
  public static DoubleSolenoid motorShifter;
  
  //climber devices
  public static Solenoid rearLegLock;
  public static DoubleSolenoid frontLegSolenoid;
  public static DoubleSolenoid rearLegSolenoid;
  public static WPI_TalonSRX frontLegMotor;
  public static WPI_TalonSRX rearLegMotor;
  
  //gripper devices
  public static Solenoid solenoidHatcher;
  public static Solenoid solenoidExtender;
  
  //sensors and misc devices
  public static Compressor compressor;

  //constants
  //constants
  public static final int TICKS_PER_REVOLUTION = 4096;
  public static final double WHEEL_DIAMETER = 0.15 * 3.279;   //meters
  public static final double MAX_VELOCITY = 20;   //meters/sec

  public static final double BASE_SPEED = 0.2;

  public static void init(){

    //driveTrain device initialization
    driveTrainLeftMaster = new WPI_TalonSRX(1);
    driveTrainLeftSlave1 = new WPI_TalonSRX(2);
    driveTrainLeftSlave2 = new WPI_TalonSRX(3);

    driveTrainRightMaster = new WPI_TalonSRX(4);
    driveTrainRightSlave1 = new WPI_TalonSRX(5);
    driveTrainRightSlave2 = new WPI_TalonSRX(6);

    driveTrainLeftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,  0);
    driveTrainRightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,  0);

    driveTrainRightMaster.setInverted(false);
    driveTrainRightSlave1.setInverted(false);
    driveTrainRightSlave2.setInverted(false);
    driveTrainLeftMaster.setInverted(false);
    driveTrainLeftSlave1.setInverted(false);
    driveTrainLeftSlave2.setInverted(false);

    driveTrainLeftMaster.setSensorPhase(true);
    driveTrainRightMaster.setSensorPhase(false);

    driveTrainRightMaster.configOpenloopRamp(.35);
    driveTrainLeftMaster.configOpenloopRamp(.35);

    driveTrainLeftSlave1.follow(driveTrainLeftMaster);
    driveTrainLeftSlave2.follow(driveTrainLeftMaster);
    driveTrainRightSlave1.follow(driveTrainRightMaster);
    driveTrainRightSlave2.follow(driveTrainRightMaster);
    
    driveTrainRightMaster.setNeutralMode(NeutralMode.Brake);
    driveTrainRightSlave1.setNeutralMode(NeutralMode.Brake);
    driveTrainRightSlave2.setNeutralMode(NeutralMode.Brake);
    driveTrainLeftMaster.setNeutralMode(NeutralMode.Brake);
    driveTrainLeftSlave1.setNeutralMode(NeutralMode.Brake);
    driveTrainLeftSlave2.setNeutralMode(NeutralMode.Brake);

    // Production Robot
    //motorShifter = new Solenoid(0);

    // Practice Robot
    motorShifter = new DoubleSolenoid(0, 1);
    
    //led device initialization
    ledControllerRevBlinkin = new Spark(6);
    ledControllerRevBlinkin.setInverted(false);

    //climber device initialization
    //rearLegLock = new Solenoid(1);
    rearLegSolenoid = new DoubleSolenoid(2, 3);
    frontLegSolenoid = new DoubleSolenoid(4, 5);
    

    frontLegMotor = new WPI_TalonSRX(8);
    rearLegMotor = new WPI_TalonSRX(7);
    
    //gripper device initialization production
    solenoidExtender = new Solenoid(6);
    solenoidHatcher = new Solenoid(7);

    //gripper device initialization practice
    //solenoidExtender = new DoubleSolenoid(2,3);
    //solenoidHatcher = new DoubleSolenoid(4,5);
    
    //sensors and misc device initialization
    compressor = new Compressor(0);
    
  }
}
