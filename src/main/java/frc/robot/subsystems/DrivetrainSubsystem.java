// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class DrivetrainSubsystem extends SubsystemBase {
  private TalonFX frontRightFalconMotor = new TalonFX(-1);
  private TalonFX frontLeftFalconMotor = new TalonFX(-7);
  private TalonFX backRightFalconMotor = new TalonFX(-1);
  private TalonFX backLeftFalconMotor = new TalonFX(-1);
  
  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    setupMotors();
  }

  /**
   * Configure all the motors to our ideal setup
   */
  private void setupMotors(){
    frontRightFalconMotor.configFactoryDefault();
    frontLeftFalconMotor.configFactoryDefault(); 
    backRightFalconMotor.configFactoryDefault();
    backLeftFalconMotor.configFactoryDefault();

    backRightFalconMotor.follow(frontRightFalconMotor);
    backLeftFalconMotor.follow(frontLeftFalconMotor);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
