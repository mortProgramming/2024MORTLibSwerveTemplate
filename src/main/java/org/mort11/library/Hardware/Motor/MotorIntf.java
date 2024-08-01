package org.mort11.library.Hardware.Motor;

public interface MotorIntf {

    public void setCurrentLimit(double limit);
    
    public void setDirection(boolean direction);

    public void setPIDValues(double kP, double kI, double kD);

    public void setPercent(double percent);

    public void setVoltage(double voltage);

    public void setPositionRotations(double setpoint);

    public void setCanivore(String canivore);



    public double getPositionRotations();

    public double getVelocityRPM();
}