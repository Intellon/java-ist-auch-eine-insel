package com.tutego.exercises.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

//tag::solution[]
public class Receipt {
  public static class Item {
    public final String name;
    public final BigDecimal price;
    public final int occurrence;

    public Item( String name, BigDecimal price, int occurrence ) {
      this.name = Objects.requireNonNull( name );
      this.price = Objects.requireNonNull( price );
      this.occurrence = occurrence;
    }

    public Item( String name, String price ) {
      this( name, new BigDecimal( price ) );
    }

    public Item( String name, BigDecimal price ) {
      this( name, price, 1 );
    }

    public Item incrementOccurrence() {
      return new Item( name, price, occurrence + 1 );
    }

    @Override public boolean equals( Object other ) {
      if ( this == other )
        return true;
      if ( other == null || getClass() != other.getClass() )
        return false;

      Item item = (Item) other;
      return item.price.equals( price ) && name.equals( item.name );
    }

    @Override public int hashCode() {
      return name.hashCode() * 31 + price.hashCode();
    }
  }

  private final Collection<Item> items = new ArrayList<>();

  public void addItem( Item item ) {
    if ( items.contains( item ) ) {
      items.remove( item );
      item = item.incrementOccurrence();
    }
    items.add( item );
  }

  @Override public String toString() {
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    StringBuilder result = new StringBuilder( 512 );
    BigDecimal sum = BigDecimal.ZERO;

    for ( Item item : items ) {
      BigDecimal itemPriceTotal = item.price.multiply( BigDecimal.valueOf( item.occurrence ) );
      sum = sum.add( itemPriceTotal );

      String line = String.format( "%dx  %-20s%10s%10s%n",
                                   item.occurrence,
                                   item.name,
                                   currencyFormatter.format( item.price ),
                                   currencyFormatter.format( itemPriceTotal ) );
      result.append( line );
    }

    result.append( "\nSumme: " ).append( currencyFormatter.format( sum ) ).append( "\n" );

    return result.toString();
  }
}
//end::solution[]

class ReceiptDemo {
  public static void main( String[] args ) {
    Receipt receipt = new Receipt();
    receipt.addItem( new Receipt.Item( "Erdnüsse", "2.22" ) );
    receipt.addItem( new Receipt.Item( "Kompass", "199.99" ) );
    receipt.addItem( new Receipt.Item( "Erdnüsse", "2.22" ) );
    receipt.addItem( new Receipt.Item( "Logbuch", "10" ) );
    System.out.println( receipt );
  }
}