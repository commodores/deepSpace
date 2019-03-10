/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.*;
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrain m_driveTrain;
  public static Climber m_climber;
  public static Hatcher m_hatcher;
  public static LimeLight m_limelight;
  public static IMU m_gyro;
  public static LIDAR m_lidar;
  public static MotorShifter m_motorShifter;
  public static RearLegLock m_rearLegLock;
  public static PSensor m_pressure;
  public static LedBlinkinController m_ledBlinkinController;
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  CameraServer server;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();
    
    m_driveTrain = new DriveTrain();
    m_climber = new Climber();
    m_hatcher = new Hatcher();
    m_gyro = new IMU();
    m_limelight = new LimeLight();
    m_lidar = new LIDAR();
    m_motorShifter = new MotorShifter();
    m_ledBlinkinController = new LedBlinkinController();
    m_rearLegLock = new RearLegLock();
    m_pressure = new PSensor();
    m_oi = new OI();
    
    CameraServer.getInstance().startAutomaticCapture();

    m_chooser.setDefaultOption("Just Drive", new DriveManual());
    m_chooser.addOption("Left Hab", new LeftHatch());
    m_chooser.addOption("Middle Hab Left Cargo", new MiddleHatchLeft());
    m_chooser.addOption("Middle Hab Right Cargo", new MiddleHatchRight());
    m_chooser.addOption("Right Single", new RightHatch());
    
    SmartDashboard.putData("Auto mode", m_chooser);
    
    //Commands to Dashboard
    SmartDashboard.putData("Turn To Target", new TurnToTarget());

    //SmartDashboard.putData("All Wheels Forward", new AllWheelsFwd());
    //SmartDashboard.putData("All Wheels Reverse", new AllWheelsRev());
    SmartDashboard.putData("Drive Train Slow Forward", new DriveTrainSlowFwd());
    SmartDashboard.putData("Drive Train Slow Reverse", new DriveTrainSlowRev());

    //SmartDashboard.putData("Extend Both Legs", new ExtendBothLegs());
    //SmartDashboard.putData("Extend Front Leg", new ExtendFrontLeg());
    //SmartDashboard.putData("Extend Rear Leg", new ExtendRearLeg());
    //SmartDashboard.putData("Retract Both Legs", new RetractBothLegs());
    //SmartDashboard.putData("Retract Front Leg", new RetractFrontLeg());
    //SmartDashboard.putData("Retract Rear Leg", new RetractRearLeg());

    SmartDashboard.putData("Extend Hatcher", new ExtendHatcher());
    SmartDashboard.putData("Retract Hatcher", new RetractHatcher());
    SmartDashboard.putData("Extend Gripper", new ExtendGripper());
    SmartDashboard.putData("Retract Gripper", new RetractGripper());

    //SmartDashboard.putData("Extend Rear Leg Lock", new ExtendLock());
    //SmartDashboard.putData("Retract Rear Leg Lock", new RetractLock());

    SmartDashboard.putData("Low Gear", new LowGear());
    SmartDashboard.putData("High Gear", new HighGear());
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("tx", m_limelight.getX());
    SmartDashboard.putNumber("ty", m_limelight.getY());
    SmartDashboard.putBoolean("tv", m_limelight.targetExists());

    SmartDashboard.putNumber("Lidar Distance", m_lidar.getDistance());
    
    SmartDashboard.putNumber("Gyro Angle", m_gyro.getYaw());

    SmartDashboard.putNumber("Left Encoder Distance", m_driveTrain.getLeftEncoderInches());
    SmartDashboard.putNumber("Pressure", m_pressure.getPressure());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
