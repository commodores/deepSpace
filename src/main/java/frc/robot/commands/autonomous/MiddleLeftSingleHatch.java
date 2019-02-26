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
    addParallel(new ExtendHatcher());
    addParallel(new ExtendGripper());
    addSequential(new DriveForwardToFrontLeftCargoScoreFromMiddle());
    addSequential(new RetractGripper(), 0.1);
  }
}