/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;


public class RightHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RightHatch() {
    //Extend Hatcher and Gripper
    addSequential(new ExtendHatcher(), .1);
    addSequential(new ExtendGripper(), .1);
    
    //Drive forward veering right
    addSequential(new AutoForward(25,25));
    addSequential(new AutoTurn(-45, 13));
    addSequential(new TurnToTarget());

    //Turn left ~ 90 degrees and Forward to score
    addSequential(new DriveFwdToHatch());

    //Retract Gripper
    addSequential(new RetractGripper(), .1);

    //Reverse
    addSequential(new AutoReverse(16,3));

    //Drive forward veering left
    addSequential(new AutoTurn(110,13));
    //Turn to hatch
    addSequential(new TurnToTarget(), 25);
    //Forward to retrieve Hatch
    addSequential(new DriveFwdToHatch(), 25);
    addSequential(new ExtendGripper(), .1);
  }
}
