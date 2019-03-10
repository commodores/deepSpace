/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class MiddleHatchLeft extends CommandGroup {
  /**
   * Add your docs here.
   */
  public MiddleHatchLeft() {
    addSequential(new ExtendHatcher(),.1);
    addSequential(new Pause());
    addSequential(new AutoForward(75,25));
    addSequential(new TurnToTarget(), 25);
    addSequential(new ExtendGripper(),.1);
    addSequential(new DriveFwdToHatch(), 25);
    addSequential(new RetractGripper(),.1);
    addSequential(new Pause());
    addSequential(new AutoReverse(16,3));
    addSequential(new AutoTurn(-90, 13));
    addSequential(new AutoForward(105, 25));
    addSequential(new AutoTurn(-86, 30));
    addSequential(new AutoForward(100, 25));
    addSequential(new TurnToTarget(), 25);
    addSequential(new DriveFwdToHatch(), 25);
    addSequential(new RetractHatcher(), .1);
    //addSequential(new ExtendGripper(), 25);

  }
}
