/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class MiddleLeftSingleHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public MiddleLeftSingleHatch() {
    addSequential(new ExtendHatcher(),.1);
    addSequential(new wait());
    addSequential(new ExtendGripper(),.1);
    addSequential(new AutoForward(78, 5));
    addSequential(new AutoTurn(-10, 10));
    addSequential(new AutoForward(12,1));
    addSequential(new AutoTurn(10, 10));
    addSequential(new TurnToTarget());
    addSequential(new DriveFwdToHatch());
    addSequential(new RetractGripper(),.1);
    addSequential(new wait());
    addSequential(new AutoReverse(12,3));
  }
}
