package com.tutego.exercises.device.ewslfg;

//tag::solution[]
import java.util.Objects;

public class Radio {

  public enum Modulation {
    AM, FM
  }

  private boolean isOn;
  private int volume;
  private double frequency;
  private Modulation modulation = Modulation.AM;

  public void setModulation( Modulation modulation ) {
    this.modulation = Objects.requireNonNull( modulation );
  }

  public Modulation getModulation() {
    return modulation;
  }

  // methods for volume, frequency and isOn and toString omitted
}
//end::solution[]
