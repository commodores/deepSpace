/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class MiddleHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public MiddleHatch() {
    
    addSequential(new AutoForward(25,3));
    addSequential(new TurnToTargetLimelight());
    addSequential(new ExtendGripper(),.1);
    addSequential(new ExtendHatcher(),.1);
    addSequential(new DriveFwdToHatch(5));
    addSequential(new RetractGripper(),.1);
    addSequential(new Pause());
    addSequential(new AutoReverse(16,3));

  }
}
