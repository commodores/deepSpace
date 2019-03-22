package frc.util;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDOutputInterface implements PIDOutput{
    double output;

    @Override
    public void pidWrite(double output) {
        // TODO Auto-generated method stub
        this.output = output;
    }

    public double getPIDOutput(){
        return output;
    }

}