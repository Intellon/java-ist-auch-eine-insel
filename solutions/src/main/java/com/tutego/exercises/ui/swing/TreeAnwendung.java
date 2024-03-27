package com.tutego.exercises.ui.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeAnwendung extends JFrame {
  public TreeAnwendung() {
    DefaultMutableTreeNode top = new DefaultMutableTreeNode( "Unterhaltung" );

    DefaultMutableTreeNode category1 = null;
    DefaultMutableTreeNode category2 = null;
    DefaultMutableTreeNode book = null;

    category1 = new DefaultMutableTreeNode( "Buch" );
    top.add( category1 );
    book = new DefaultMutableTreeNode( "Inselrennen" );
    category1.add( book );

    category2 = new DefaultMutableTreeNode( "Musik" );
    top.add( category2 );
    book = new DefaultMutableTreeNode( "Blues" );
    category2.add( book );
    book = new DefaultMutableTreeNode( "Klassik" );
    category2.add( book );
    book = new DefaultMutableTreeNode( "Rock" );
    category2.add( book );

    final JTree tree = new JTree( top );
    JScrollPane treeView = new JScrollPane( tree );

    getContentPane().add( treeView );

    pack();
    setVisible( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args ) {
    new TreeAnwendung();
  }
}
