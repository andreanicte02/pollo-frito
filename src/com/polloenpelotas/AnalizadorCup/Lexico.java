/* The following code was generated by JFlex 1.4.3 on 25/03/20 16:39 */

/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones
package com.polloenpelotas.AnalizadorCup;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import java_cup.runtime.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 25/03/20 16:39 from the specification file
 * <tt>Lexico.jflex</tt>
 */
public class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int COMENT_SIMPLE = 2;
  public static final int YYINITIAL = 0;
  public static final int COMENT_MULTI = 4;
  public static final int cadena2 = 8;
  public static final int cadena1 = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\31\1\30\1\0\2\31\22\0\1\31\1\52\1\32\1\26"+
    "\1\0\1\50\1\54\1\34\1\42\1\43\1\27\1\44\1\61\1\45"+
    "\1\2\1\46\1\36\11\1\1\56\1\40\1\53\1\41\1\51\1\35"+
    "\1\0\1\12\1\22\1\16\1\21\1\10\1\11\1\3\1\25\1\17"+
    "\1\3\1\23\1\13\1\3\1\15\1\20\2\3\1\6\1\14\1\5"+
    "\1\7\1\37\1\24\3\3\1\57\1\33\1\60\1\47\1\4\1\0"+
    "\1\12\1\22\1\16\1\21\1\10\1\11\1\3\1\25\1\17\1\3"+
    "\1\23\1\13\1\3\1\15\1\20\2\3\1\6\1\14\1\5\1\7"+
    "\1\37\1\24\3\3\1\62\1\55\1\63\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\1\14\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\1\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\2\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\0"+
    "\12\3\1\55\1\56\1\3\1\57\2\3\1\60\1\61"+
    "\1\62\1\63\1\64\1\65\1\66\1\67\5\3\1\70"+
    "\7\3\1\71\1\3\1\72\3\3\1\73\1\74\6\3"+
    "\1\75\3\3\1\76\1\77\1\100\1\3\1\101\4\3"+
    "\1\102\1\103\1\104";

  private static int [] zzUnpackAction() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\64\0\150\0\234\0\320\0\u0104\0\u0138\0\u016c"+
    "\0\u01a0\0\u01d4\0\u0208\0\u023c\0\u0270\0\u02a4\0\u02d8\0\u030c"+
    "\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410\0\u0104\0\u0104\0\u0104"+
    "\0\u0104\0\u0104\0\u0444\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104"+
    "\0\u0104\0\u0478\0\u04ac\0\u04e0\0\u0514\0\u0104\0\u0104\0\u0104"+
    "\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104"+
    "\0\u0548\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104"+
    "\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u057c"+
    "\0\u05b0\0\u05e4\0\u0618\0\u064c\0\u0680\0\u06b4\0\u06e8\0\u071c"+
    "\0\u0750\0\u0784\0\u01a0\0\u01a0\0\u07b8\0\u01a0\0\u07ec\0\u0820"+
    "\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u0104\0\u057c"+
    "\0\u0854\0\u0888\0\u08bc\0\u08f0\0\u0924\0\u01a0\0\u0958\0\u098c"+
    "\0\u09c0\0\u09f4\0\u0a28\0\u0a5c\0\u0a90\0\u01a0\0\u0ac4\0\u01a0"+
    "\0\u0af8\0\u0b2c\0\u0b60\0\u01a0\0\u01a0\0\u0b94\0\u0bc8\0\u0bfc"+
    "\0\u0c30\0\u0c64\0\u0c98\0\u01a0\0\u0ccc\0\u0d00\0\u0d34\0\u01a0"+
    "\0\u01a0\0\u01a0\0\u0d68\0\u01a0\0\u0d9c\0\u0dd0\0\u0e04\0\u0e38"+
    "\0\u01a0\0\u01a0\0\u01a0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\1\7\1\10\1\11\1\6\1\12\1\13\1\11"+
    "\1\14\1\15\2\11\1\16\1\17\1\20\1\21\1\11"+
    "\1\22\1\23\1\11\1\24\1\11\1\25\1\26\2\27"+
    "\1\30\2\6\1\31\1\7\1\11\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\30\56\1\57\33\56\27\60\1\61\1\56\33\60"+
    "\30\62\1\27\1\62\1\63\1\64\30\62\5\6\1\65"+
    "\1\66\1\67\1\6\1\70\1\71\2\6\1\72\4\6"+
    "\1\73\5\6\2\27\1\74\1\75\1\76\1\77\1\67"+
    "\1\71\24\6\65\0\1\7\1\100\33\0\1\7\30\0"+
    "\1\11\1\0\21\11\11\0\1\11\25\0\25\11\10\0"+
    "\2\11\25\0\5\11\1\101\17\11\10\0\2\11\25\0"+
    "\7\11\1\102\15\11\10\0\2\11\25\0\12\11\1\103"+
    "\12\11\10\0\2\11\25\0\6\11\1\104\2\11\1\105"+
    "\5\11\1\106\5\11\10\0\2\11\25\0\23\11\1\107"+
    "\1\11\10\0\2\11\25\0\6\11\1\110\16\11\10\0"+
    "\2\11\25\0\11\11\1\111\5\11\1\112\5\11\10\0"+
    "\2\11\25\0\10\11\1\113\3\11\1\114\10\11\10\0"+
    "\2\11\25\0\7\11\1\115\7\11\1\116\5\11\10\0"+
    "\2\11\25\0\5\11\1\117\17\11\10\0\2\11\25\0"+
    "\24\11\1\120\10\0\2\11\53\0\1\121\75\0\1\122"+
    "\7\0\1\123\62\0\1\124\54\0\1\125\63\0\1\126"+
    "\63\0\1\127\50\0\1\57\36\0\1\130\34\0\1\130"+
    "\26\0\6\11\1\131\16\11\10\0\2\11\25\0\4\11"+
    "\1\132\20\11\10\0\2\11\25\0\13\11\1\133\11\11"+
    "\10\0\2\11\25\0\14\11\1\134\10\11\10\0\2\11"+
    "\25\0\12\11\1\135\12\11\10\0\2\11\25\0\5\11"+
    "\1\136\17\11\10\0\2\11\25\0\16\11\1\137\6\11"+
    "\10\0\2\11\25\0\12\11\1\140\12\11\10\0\2\11"+
    "\25\0\13\11\1\141\11\11\10\0\2\11\25\0\14\11"+
    "\1\142\10\11\10\0\2\11\25\0\10\11\1\143\14\11"+
    "\10\0\2\11\25\0\7\11\1\144\15\11\10\0\2\11"+
    "\25\0\16\11\1\145\6\11\10\0\2\11\25\0\7\11"+
    "\1\146\15\11\10\0\2\11\25\0\6\11\1\147\16\11"+
    "\10\0\2\11\25\0\7\11\1\150\15\11\10\0\2\11"+
    "\25\0\15\11\1\151\7\11\10\0\2\11\25\0\13\11"+
    "\1\152\11\11\10\0\2\11\25\0\4\11\1\153\20\11"+
    "\10\0\2\11\25\0\12\11\1\154\12\11\10\0\2\11"+
    "\25\0\7\11\1\155\15\11\10\0\2\11\25\0\4\11"+
    "\1\156\20\11\10\0\2\11\25\0\11\11\1\157\13\11"+
    "\10\0\2\11\25\0\11\11\1\160\13\11\10\0\2\11"+
    "\25\0\12\11\1\161\12\11\10\0\2\11\25\0\5\11"+
    "\1\162\17\11\10\0\2\11\25\0\4\11\1\163\20\11"+
    "\10\0\2\11\25\0\7\11\1\164\15\11\10\0\2\11"+
    "\25\0\15\11\1\165\7\11\10\0\2\11\25\0\16\11"+
    "\1\166\6\11\10\0\2\11\25\0\6\11\1\167\16\11"+
    "\10\0\2\11\25\0\22\11\1\170\2\11\10\0\2\11"+
    "\25\0\7\11\1\171\15\11\10\0\2\11\25\0\14\11"+
    "\1\172\10\11\10\0\2\11\25\0\16\11\1\173\6\11"+
    "\10\0\2\11\25\0\24\11\1\174\10\0\2\11\25\0"+
    "\14\11\1\175\10\11\10\0\2\11\25\0\12\11\1\176"+
    "\12\11\10\0\2\11\25\0\17\11\1\177\5\11\10\0"+
    "\2\11\25\0\6\11\1\200\16\11\10\0\2\11\25\0"+
    "\4\11\1\201\20\11\10\0\2\11\25\0\14\11\1\202"+
    "\10\11\10\0\2\11\25\0\7\11\1\203\15\11\10\0"+
    "\2\11\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3692];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\17\1\5\11\1\1\6\11\4\1\13\11"+
    "\1\1\16\11\1\0\20\1\7\11\54\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    String cadenita ="";
    //-------> Codigo de usuario en sintaxis java


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 174) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 6: 
          { /* Espacios en blanco, se ignoran */
          }
        case 69: break;
        case 45: 
          { return new Symbol(Simbolos.iff, yyline, yycolumn, yytext());
          }
        case 70: break;
        case 12: 
          { return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());
          }
        case 71: break;
        case 52: 
          { return new Symbol(Simbolos.mayorIgualQue, yycolumn, yyline, yytext());
          }
        case 72: break;
        case 67: 
          { return new Symbol(Simbolos.function, yyline, yycolumn, yytext().toLowerCase());
          }
        case 73: break;
        case 43: 
          { cadenita+= "'"; yybegin(cadena1);
          }
        case 74: break;
        case 5: 
          { return new Symbol(Simbolos.por, yycolumn, yyline, yytext());
          }
        case 75: break;
        case 66: 
          { return new Symbol(Simbolos.defaultt, yyline, yycolumn, yytext());
          }
        case 76: break;
        case 53: 
          { return new Symbol(Simbolos.difQue, yycolumn, yyline, yytext());
          }
        case 77: break;
        case 21: 
          { return new Symbol(Simbolos.or, yycolumn, yyline, yytext());
          }
        case 78: break;
        case 63: 
          { return new Symbol(Simbolos.whilee, yyline, yycolumn, yytext());
          }
        case 79: break;
        case 16: 
          { return new Symbol(Simbolos.potenciar, yycolumn, yyline, yytext());
          }
        case 80: break;
        case 24: 
          { return new Symbol(Simbolos.cbra, yycolumn, yyline, yytext());
          }
        case 81: break;
        case 22: 
          { return new Symbol(Simbolos.dosp, yycolumn, yyline, yytext());
          }
        case 82: break;
        case 11: 
          { return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());
          }
        case 83: break;
        case 50: 
          { return new Symbol(Simbolos.arrow, yycolumn, yyline, yytext());
          }
        case 84: break;
        case 35: 
          { cadenita+= '\r'; yybegin(cadena1);
          }
        case 85: break;
        case 68: 
          { return new Symbol(Simbolos.continuee, yyline, yycolumn, yytext());
          }
        case 86: break;
        case 29: 
          { yybegin(YYINITIAL);
          }
        case 87: break;
        case 47: 
          { return new Symbol(Simbolos.doo, yyline, yycolumn, yytext());
          }
        case 88: break;
        case 58: 
          { return new Symbol(Simbolos.elsee, yyline, yycolumn, yytext());
          }
        case 89: break;
        case 62: 
          { return new Symbol(Simbolos.breakk, yyline, yycolumn, yytext());
          }
        case 90: break;
        case 48: 
          { yybegin(COMENT_MULTI);
          }
        case 91: break;
        case 44: 
          { cadenita+= "?"; yybegin(cadena1);
          }
        case 92: break;
        case 34: 
          { cadenita+= '\t'; yybegin(cadena1);
          }
        case 93: break;
        case 2: 
          { return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());
          }
        case 94: break;
        case 51: 
          { return new Symbol(Simbolos.modulo, yycolumn, yyline, yytext());
          }
        case 95: break;
        case 15: 
          { return new Symbol(Simbolos.dividir, yycolumn, yyline, yytext());
          }
        case 96: break;
        case 56: 
          { return new Symbol(Simbolos.forr, yyline, yycolumn, yytext());
          }
        case 97: break;
        case 19: 
          { return new Symbol(Simbolos.menorQue, yycolumn, yyline, yytext());
          }
        case 98: break;
        case 23: 
          { return new Symbol(Simbolos.abra, yycolumn, yyline, yytext());
          }
        case 99: break;
        case 40: 
          { cadenita+= '\b'; yybegin(cadena1);
          }
        case 100: break;
        case 64: 
          { return new Symbol(Simbolos.returnn, yyline, yycolumn, yytext());
          }
        case 101: break;
        case 4: 
          { yybegin(COMENT_SIMPLE);
          }
        case 102: break;
        case 30: 
          { /* Omitir como es un comentario :D */
          }
        case 103: break;
        case 27: 
          { return new Symbol(Simbolos.clla, yycolumn, yyline, yytext());
          }
        case 104: break;
        case 38: 
          { yybegin(cadena1);
          }
        case 105: break;
        case 59: 
          { return new Symbol(Simbolos.nothing, yyline, yycolumn, yytext());
          }
        case 106: break;
        case 10: 
          { return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());
          }
        case 107: break;
        case 1: 
          { ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(yycolumn,yyline),
                                    new SemanticException("Error lexico: "+ yytext())));
                                System.out.println("Error Lexico: <<"+yytext()+">> Linea: "+yyline+" ,Columna: "+yycolumn);
          }
        case 108: break;
        case 60: 
          { return new Symbol(Simbolos.casee, yyline, yycolumn, yytext());
          }
        case 109: break;
        case 18: 
          { return new Symbol(Simbolos.not, yycolumn, yyline, yytext());
          }
        case 110: break;
        case 49: 
          { return new Symbol(Simbolos.igualQue, yycolumn, yyline, yytext());
          }
        case 111: break;
        case 39: 
          { cadenita+= "\n"; yybegin(cadena1);
          }
        case 112: break;
        case 3: 
          { return new Symbol(Simbolos.identifier, yycolumn, yyline, yytext().toLowerCase());
          }
        case 113: break;
        case 33: 
          { yybegin (cadena2);
          }
        case 114: break;
        case 65: 
          { return new Symbol(Simbolos.switchh, yyline, yycolumn, yytext());
          }
        case 115: break;
        case 37: 
          { cadenita+= '\f'; yybegin(cadena1);
          }
        case 116: break;
        case 26: 
          { return new Symbol(Simbolos.alla, yycolumn, yyline, yytext());
          }
        case 117: break;
        case 42: 
          { cadenita+= "\\"; yybegin(cadena1);
          }
        case 118: break;
        case 57: 
          { return new Symbol(Simbolos.truee, yyline, yycolumn, yytext());
          }
        case 119: break;
        case 7: 
          { yybegin (cadena1); cadenita="";
          }
        case 120: break;
        case 8: 
          { return new Symbol(Simbolos.tern, yycolumn, yyline, yytext());
          }
        case 121: break;
        case 41: 
          { cadenita+= "\""; yybegin(cadena1);
          }
        case 122: break;
        case 54: 
          { return new Symbol(Simbolos.menorIgualQue, yycolumn, yyline, yytext());
          }
        case 123: break;
        case 13: 
          { return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());
          }
        case 124: break;
        case 9: 
          { return new Symbol(Simbolos.pComa, yycolumn, yyline, yytext());
          }
        case 125: break;
        case 17: 
          { return new Symbol(Simbolos.mayorQue, yycolumn, yyline, yytext());
          }
        case 126: break;
        case 14: 
          { return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());
          }
        case 127: break;
        case 32: 
          { yybegin (YYINITIAL);  return new Symbol(Simbolos.cadena,yyline,yycolumn,cadenita.replace("\"",""));
          }
        case 128: break;
        case 31: 
          { cadenita+= yytext();
          }
        case 129: break;
        case 61: 
          { return new Symbol(Simbolos.falsee, yyline, yycolumn, yytext());
          }
        case 130: break;
        case 46: 
          { return new Symbol(Simbolos.inn, yyline, yycolumn, yytext());
          }
        case 131: break;
        case 25: 
          { return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
          }
        case 132: break;
        case 20: 
          { return new Symbol(Simbolos.and, yycolumn, yyline, yytext());
          }
        case 133: break;
        case 55: 
          { return new Symbol(Simbolos.decimal, yycolumn, yyline, yytext());
          }
        case 134: break;
        case 36: 
          { cadenita+= '\0'; yybegin(cadena1);
          }
        case 135: break;
        case 28: 
          { 
          }
        case 136: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(Simbolos.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
