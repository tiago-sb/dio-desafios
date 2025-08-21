package ui.custom.input;

import java.util.List;
import java.util.Objects;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberTextLimit extends PlainDocument{
  private final List<String> NUMBERS = List.of("1","2","3", "4","5","6","7","8","9");

  public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
    if(Objects.isNull(str) || (!NUMBERS.contains(str))) return;
    if(getLength() + str.length() <= 1) super.insertString(offs, str, null);
  }
}
