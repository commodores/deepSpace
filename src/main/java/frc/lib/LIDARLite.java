package frc.lib;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;

/**
 * This is the library for use of the LIDAR lite v3 over PWM connection. 
 * See the 2018 wikiCode for a tutorial on how to use it.
 */
public class LIDARLite {
	    
	    public int CALIBRATION_OFFSET = 0;
	    public boolean printWarnings = false;
	    private Counter counter;
	    private int printedWarningCount = 5;
	    
	    /**
	     * Create an object for a LIDAR-Lite attached to some port on the roboRIO
	     * @param port port in DIO that the LIDAR is attached to
	     */
	    public LIDARLite(int port) {
	    	DigitalSource source = new DigitalInput(port);
	    	counter = new Counter(source);
	        counter.setMaxPeriod(1.0);
	        // Configure for measuring rising to falling pulses
	        counter.setSemiPeriodMode(true);
	        counter.reset();
	    }
	    
	    /**
	     * Offsets the distance recorded by the LIDAR in order to calibrate it.
	     * @param offset is the offset wanted
	     */
	    public void setCalibrationOffset(int offset) {
	    	this.CALIBRATION_OFFSET = offset;
	    }
	    
	    /**
	     * Enables or disables the output of warnings from the LIDAR
	     * @param printWarnings do you want warnings or not?
	     */
	    public void enablePrintWarnings(boolean printWarnings) {
	    	this.printWarnings = printWarnings;
	    }

	    /**
	     *  Used to get distance in cm
	     * @param rounded true ? false: Get distance in inches as rounded number?
	     * @return Distance in inches
	     */
	    public double getDistanceCm(boolean rounded) {
	    	double cm;
	    	/* If we haven't seen the first rising to falling pulse, then we have no measurement.
	    	 * This happens when there is no LIDAR-Lite plugged in, btw.
	    	 */
	    	if (counter.get() < 1) {
	    		if (printedWarningCount-- > 0) {
	    			if(printWarnings)
	    			System.out.println("LidarLitePWM: waiting for distance measurement");
	    		}
	    		return 0;
	    	}
	    	/* getPeriod returns time in seconds. The hardware resolution is microseconds.
	    	 * The LIDAR-Lite unit sends a high signal for 10 microseconds per cm of distance.
	    	 */
	    	cm = (counter.getPeriod() * 1000000.0 / 10.0) + CALIBRATION_OFFSET;
	    	if(!rounded) {
	    	return cm;
	    	}else {
	       	return  Math.floor(cm*10)/10;
	    	}
	    }
	    /**
	     *  Used to get distance in Inches
	     * @param rounded true ? false: Get distance in inches as rounded number?
	     * @return Distance in inches
	     */
	    public double getDistanceIn(boolean rounded) {
	    	double in = getDistanceCm(true) * 0.393700787;
	    	if(!rounded) {
	    	return in;
	    	}else {
	    	return  Math.floor(in*10)/10;
	    	}
	    }
	    
	    
	}