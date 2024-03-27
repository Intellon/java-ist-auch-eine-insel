package com.tutego.exercises.ui.swing;

import java.util.Locale;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

class LocaleListModel extends AbstractListModel<String> {

  private Locale[] mylocales = Locale.getAvailableLocales();

  @Override
  public int getSize() {
    return mylocales.length;
  }

  @Override
  public String getElementAt( int i ) {
    Locale loc = mylocales[ i ];
    String val = loc.getDisplayCountry();

    return !val.equals( "" ) ? val : ":" + loc.getDisplayLanguage();
  }
}

class ListeSimpleModel extends JFrame {

  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    ListModel<?> listModel = new LocaleListModel();

    JList<?> list = new JList<>( listModel );
    list.setVisibleRowCount( 10 );

    f.getContentPane().add( new JScrollPane( list ) );
    f.pack();

    f.setVisible( true );
  }
}