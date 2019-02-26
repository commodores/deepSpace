/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DMC60;

/**
 * Add your docs here.
 */
public class Flipper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final DMC60 Flipper = RobotMap.flipperDmc60;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
public void flipperUp(){
  Flipper.set(.5);
}
public void flipperDown(){
  Flipper.set(-.5);
}

}
