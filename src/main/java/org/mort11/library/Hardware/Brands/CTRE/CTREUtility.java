package org.mort11.library.Hardware.Brands.CTRE;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CTREUtility {

    //add the final back later
    public static class Falcon500{
        // public static final double SWERVE_STEER_KP = SmartDashboard.getNumber("Spinny Wheels", 0);
        public static final double SWERVE_STEER_KP = 3;
        public static final double SWERVE_STEER_KI = 0;
        public static final double SWERVE_STEER_KD = 0;

        public static final double MAX_RPM = 6380;
    }

    public static final class Krakenx60{
        public static final double SWERVE_STEER_KP = 1.26;
        public static final double SWERVE_STEER_KI = 0;
        public static final double SWERVE_STEER_KD = 0.063;

        public static final double MAX_RPM = 6000;
    }
}
