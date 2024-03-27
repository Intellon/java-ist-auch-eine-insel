package com.tutego.exercises.jsp;

public class Person
{
	String forname;
	
	String surname;
	
	String nameFont;
	
	int nameFontSize;
	
	boolean nameBold;
	
	boolean nameItalic;
	/**
	 * @return Returns the forname.
	 */
	public String getForname() {
		return forname;
	}

	/**
	 * @param forname The forname to set.
	 */
	public void setForname(String forname) {
		this.forname = forname;
	}

	/**
	 * @return Returns the nameBold.
	 */
	public boolean isNameBold() {
		return nameBold;
	}

	/**
	 * @param nameBold The nameBold to set.
	 */
	public void setNameBold(boolean nameBold) {
		this.nameBold = nameBold;
	}

	/**
	 * @return Returns the nameFont.
	 */
	public String getNameFont() {
		return nameFont;
	}

	/**
	 * @param nameFont The nameFont to set.
	 */
	public void setNameFont(String nameFont) {
		this.nameFont = nameFont;
	}

	/**
	 * @return Returns the nameFontSize.
	 */
	public int getNameFontSize() {
		return nameFontSize;
	}

	/**
	 * @param nameFontSize The nameFontSize to set.
	 */
	public void setNameFontSize(int nameFontSize) {
		this.nameFontSize = nameFontSize;
	}

	/**
	 * @return Returns the nameItalic.
	 */
	public boolean isNameItalic() {
		return nameItalic;
	}

	/**
	 * @param nameItalic The nameItalic to set.
	 */
	public void setNameItalic(boolean nameItalic) {
		this.nameItalic = nameItalic;
	}

	/**
	 * @return Returns the surname.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname The surname to set.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
  public String toString()
	{
		return getForname() + " " + getSurname() + "" + getNameFont() + " " + getNameFontSize() +
		       isNameBold() + " " + isNameItalic();
	}
}
