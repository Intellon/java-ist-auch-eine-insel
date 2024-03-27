package com.tutego.exercises.ui.swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CalendarTableCellRenderer extends DefaultTableCellRenderer {
  private static final long serialVersionUID = -3740941877803403544L;

  @Override
  public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected,
                                                  boolean hasFocus, int row, int column ) {
    JLabel res = (JLabel) super.getTableCellRendererComponent( table, value, isSelected, hasFocus,
                                                               row, column );

    switch ( column ) {
      case 0:
      case 1:
      case 3:
      case 4:
        res.setBackground( Color.LIGHT_GRAY );
        res.setHorizontalAlignment( JLabel.CENTER );
        break;

      default :
        res.setBackground( Color.WHITE );
        res.setHorizontalAlignment( JLabel.LEFT );
    }
    return res;
  }
}
