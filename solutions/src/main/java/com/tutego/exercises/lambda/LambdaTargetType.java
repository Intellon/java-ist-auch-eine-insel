package com.tutego.exercises.lambda;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaTargetType {

  public static void main( String[] args ) {
    //tag::solution[]
    Runnable run = () -> {};
    ActionListener list = e -> {};
    Supplier<String> sup = () -> "";
    Consumer<Point> con = point -> {};
    Comparator<Rectangle> comp = (o1, o2) -> 0;
    //end::solution[]
  }
}