package com.tutego.exercises.util;

import java.util.List;

public class SameNumberOfDoctorsAndMusicians {
  //tag::solution[]
  static class CrewMember {
    enum Profession { CAPTAIN, NAVIGATOR, CARPENTER, DOCTOR, MUSICIAN, COOK }

    String name;
    Profession profession;

    CrewMember( String name, Profession profession ) {
      this.name = name;
      this.profession = profession;
    }
  }

  public static boolean areSameNumberOfDoctorsAndMusicians( List<CrewMember> crewMembers ) {
    int result = 0;
    for ( CrewMember member : crewMembers ) {
      int zeroOneTwo = ((1 << member.profession.ordinal()) & 0b110000) / 16;
      int minusOneZeroPlusOne = (zeroOneTwo / 2) - (zeroOneTwo & 1);
      result += minusOneZeroPlusOne;
    }
    return result == 0;
  }
  //end::solution[]

  public static void main( String[] args ) {
    CrewMember member1 = new CrewMember( "Swedish Chef", CrewMember.Profession.COOK );
    CrewMember member2 = new CrewMember( "Mahna Mahna", CrewMember.Profession.MUSICIAN );
    CrewMember member3 = new CrewMember( "Rowlf", CrewMember.Profession.MUSICIAN );
    CrewMember member4 = new CrewMember( "CiaoCiao", CrewMember.Profession.CAPTAIN );
    CrewMember member5 = new CrewMember( "Smørrebrød", CrewMember.Profession.COOK );

    List<CrewMember> crew1 = List.of( member1, member2 );
    System.out.println( areSameNumberOfDoctorsAndMusicians( crew1 ) ); // true

    List<CrewMember> crew2 = List.of( member1, member2, member3, member4 );
    System.out.println( areSameNumberOfDoctorsAndMusicians( crew2 ) ); // false

    List<CrewMember> crew3 = List.of( member1, member2, member3, member4, member5 );
    System.out.println( areSameNumberOfDoctorsAndMusicians( crew3 ) ); // true
  }
}
