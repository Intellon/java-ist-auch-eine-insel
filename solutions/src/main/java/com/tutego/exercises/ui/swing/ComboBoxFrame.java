package com.tutego.exercises.ui.swing;

import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

@SuppressWarnings( "all" ) public class ComboBoxFrame extends JFrame {
  private static final long serialVersionUID = 3976191673461236551L;

  public ComboBoxFrame() {
    JComboBox cbxZahlen = new JComboBox( new String[]{ "1", "2", "3", "4", "5" } );
    JComboBox cbxTexte = new JComboBox( new String[]{ "gelb", "blau", "weiß", "rot", "schwarz" } );

    cbxZahlen.addItemListener( new ItemListener() {
      @Override public void itemStateChanged( java.awt.event.ItemEvent e ) {
        System.out.println( "Auswahl:" + ((JComboBox) e.getSource()).getSelectedItem() );
      }
    } );
    cbxZahlen.setKeySelectionManager( new MySelectionManager() );

    cbxTexte.addItemListener( new ItemListener() {
      @Override public void itemStateChanged( java.awt.event.ItemEvent e ) {
        System.out.println( "Auswahl:" + ((JComboBox) e.getSource()).getSelectedItem() );
      }
    } );
    cbxTexte.setKeySelectionManager( new MySelectionManager2() );

    getContentPane().setLayout( new GridLayout( 1, 0 ) );
    getContentPane().add( cbxZahlen );
    getContentPane().add( cbxTexte );
  }

  static class MySelectionManager implements JComboBox.KeySelectionManager {
    @Override public int selectionForKey( char aKey, javax.swing.ComboBoxModel aModel ) {
      int index = aKey - '1';
      System.out.println( "vor Char:" + aKey + "  Index:" + index );
      if ( index < 0 || index >= aModel.getSize() )
        index = -1;
      System.out.println( "nach Char:" + aKey + "  Index:" + index );
      return index;
    }
  }

  static class MySelectionManager2 implements JComboBox.KeySelectionManager {
    @Override public int selectionForKey( char aKey, javax.swing.ComboBoxModel aModel ) {
      int index = -1;
      for ( int i = 0; i < aModel.getSize(); i++ ) {
        if ( aModel.getElementAt( i ).toString().startsWith( "" + aKey ) ) {
          index = i;
          break;
        }
      }
      return index;
    }
  }
}