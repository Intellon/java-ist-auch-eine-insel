package com.tutego.exercises.optim;

public class Konto implements Cloneable
{
  private String name;
  private String vorName;
  private String kontoNummer;

  public Konto()
  {  
  }

  public Konto( String einName, String einVorName, String eineKontoNummer )
  {
    name = einName;
    vorName = einVorName;
    kontoNummer = eineKontoNummer;
  }

  public Object clone()
  {
    try {
      return super.clone();
    }
    catch ( CloneNotSupportedException e ) {
      throw new Error();
    }
  }

  public Object cloneWithConstructor()
  {
    return new Konto( name, vorName, kontoNummer );
  }

  public Object cloneWithDefaultConstructor()
  {
    Konto k = new Konto();

    k.name = name;
    k.vorName = vorName;
    k.kontoNummer = kontoNummer;

    return k;
  }
}

