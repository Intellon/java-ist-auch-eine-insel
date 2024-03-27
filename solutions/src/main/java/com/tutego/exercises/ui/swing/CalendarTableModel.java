package com.tutego.exercises.ui.swing;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.AbstractTableModel;

public class CalendarTableModel extends AbstractTableModel {
  private static final long serialVersionUID = 4863280675634819820L;

  final static String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

  private Calendar calendar;
  private int baseDayOfWeek;
  private int maxDaysInMonth;
  private String[] notesOfTheDay = new String[33];  // 33 = ;-)

  public CalendarTableModel( int month, int year ) {
    calendar = new GregorianCalendar( year, month - 1, 1 );
    baseDayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
    maxDaysInMonth = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
  }

  private int getDayOfWeek( int day ) {
    return (baseDayOfWeek + day - 2) % 7;
  }

  @Override
  public int getRowCount() {
    return 16;
  }

  @Override
  public int getColumnCount() {
    return 6;
  }

  @Override
  public Object getValueAt( int rowIndex, int columnIndex ) {
    switch ( columnIndex ) {
      case 0:
        return Integer.valueOf( rowIndex + 1 );

      case 1:
        return days[ getDayOfWeek( rowIndex + 1 ) ];

      case 4:
        if ( rowIndex + 17 <= maxDaysInMonth )
          return days[ getDayOfWeek( rowIndex + 17 ) ];

        break;

      case 3:
        if ( rowIndex + 17 <= maxDaysInMonth )
          return Integer.valueOf( rowIndex + 17 );
        break;

      case 5:
        rowIndex += 17;  // Besonders nett (b�se)

      case 2:
        return notesOfTheDay[ rowIndex ];
    }

    return "";
  }

  @Override
  public boolean isCellEditable( int rowIndex, int columnIndex ) {
    return (columnIndex == 2 || columnIndex == 5);
  }

  @Override
  public void setValueAt( Object aValue, int rowIndex, int columnIndex ) {
    notesOfTheDay[ rowIndex + (columnIndex == 5 ? 17 : 0) ] = aValue.toString();
  }
}
