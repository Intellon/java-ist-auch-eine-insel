package com.tutego.exercises.oop.form;

import java.util.ArrayList;
import java.util.List;

public class Group extends Form {

  private final List<Form> forms = new ArrayList<>();

  public void add( Form form ) {
    forms.add( form );
  }

  @Override
  public double area() {
    return forms.stream().mapToDouble( Form::area ).sum();
  }

  @Override
  public String toString() {
    return "Group[" + forms + "]";
  }
}
