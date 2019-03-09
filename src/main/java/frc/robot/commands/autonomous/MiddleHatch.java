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
    addSequential(new ExtendHatcher(),.1);
    addSequential(new Wait());
    addSequential(new ExtendGripper(),.1);
    addSequential(new AutoForward(78, 15));
    addSequential(new TurnToTarget(), 5);
    addSequential(new DriveFwdToHatch(), 5);
    addSequential(new RetractGripper(),.1);
    addSequential(new Wait());
    addSequential(new AutoReverse(12,3));
    addSequential(new AutoTurn(-90, 3));
    addSequential(new AutoForward(50, 5));
    addSequential(new AutoTurn(-90, 3));

  }
}
