/* The following code was generated by JFlex 1.4.1 on 19/03/19 5:05 */


package com.polloenpelotas.Extras;
import java.io.*;   
import javax.swing.text.Segment;   
   
import org.fife.ui.rsyntaxtextarea.*;   
   

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 19/03/19 5:05 from the specification file
 * <tt>C:/Users/nicte/Desktop/Proyectocompi/Proyecto1/src/Imagenes/Otros/Lexico.jflex</tt>
 */
public class ExampleTokenMaker extends AbstractJFlexCTokenMaker {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int MLC = 1;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\10\1\11\1\0\1\10\1\6\22\0\1\10\1\46\1\4"+
    "\1\7\1\0\1\47\1\51\1\3\2\15\1\13\1\52\1\6\1\43"+
    "\1\14\1\12\12\2\1\46\1\6\1\53\1\50\1\54\1\46\1\0"+
    "\1\26\1\37\1\16\1\23\1\22\1\35\1\41\1\36\1\27\1\45"+
    "\1\1\1\34\1\30\1\20\1\17\1\31\1\44\1\24\1\42\1\21"+
    "\1\40\1\25\1\1\1\32\1\33\1\1\1\15\1\5\1\15\1\46"+
    "\1\1\1\0\1\26\1\37\1\16\1\23\1\22\1\35\1\41\1\36"+
    "\1\27\1\45\1\1\1\34\1\30\1\20\1\17\1\31\1\44\1\24"+
    "\1\42\1\21\1\40\1\25\1\1\1\32\1\33\1\1\1\15\1\55"+
    "\1\15\1\46\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\2\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\2\7\1\10\14\1\1\11\4\1\7\7\1\12\1\13"+
    "\1\12\1\14\1\0\1\3\1\15\1\3\1\0\1\16"+
    "\2\4\1\17\1\20\50\1\1\11\1\21\1\2\1\22"+
    "\1\23\26\1\1\24\106\1\1\0\7\1\1\25\20\1"+
    "\1\0\24\1\1\0\16\1\1\0\12\1\1\0\7\1"+
    "\1\0\6\1\1\0\5\1\1\0\5\1\1\0\4\1"+
    "\1\0\3\1\1\0\3\1\1\0\2\1\1\11\4\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[309];
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
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0142"+
    "\0\u0170\0\134\0\u019e\0\u01cc\0\134\0\u01fa\0\u0228\0\u0256"+
    "\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398\0\u03c6"+
    "\0\u03f4\0\212\0\u0422\0\u0450\0\u047e\0\u04ac\0\u04da\0\134"+
    "\0\u0508\0\u0536\0\u0564\0\u0592\0\u05c0\0\u05ee\0\134\0\u061c"+
    "\0\u064a\0\u0678\0\u06a6\0\134\0\u06d4\0\u0702\0\134\0\u0730"+
    "\0\u075e\0\u078c\0\134\0\u07ba\0\u07e8\0\u0816\0\u0844\0\u0872"+
    "\0\u08a0\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986\0\u09b4\0\u09e2"+
    "\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0af6\0\u0b24\0\u0b52"+
    "\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a\0\u0c38\0\u0c66\0\u0c94\0\u0cc2"+
    "\0\u0cf0\0\u0d1e\0\u0d4c\0\u0d7a\0\u0da8\0\u0dd6\0\u0e04\0\u0e32"+
    "\0\u0e60\0\u0e8e\0\u0ebc\0\u0eea\0\134\0\u0f18\0\134\0\134"+
    "\0\u0f46\0\u0f74\0\u0fa2\0\u0fd0\0\u0ffe\0\u102c\0\u105a\0\u1088"+
    "\0\u10b6\0\u10e4\0\u1112\0\u1140\0\u116e\0\u119c\0\u11ca\0\u11f8"+
    "\0\u1226\0\u1254\0\u1282\0\u12b0\0\u12de\0\u130c\0\212\0\u133a"+
    "\0\u1368\0\u1396\0\u13c4\0\u13f2\0\u1420\0\u144e\0\u147c\0\u14aa"+
    "\0\u14d8\0\u1506\0\u1534\0\u1562\0\u1590\0\u15be\0\u15ec\0\u161a"+
    "\0\u1648\0\u1676\0\u16a4\0\u16d2\0\u1700\0\u172e\0\u175c\0\u178a"+
    "\0\u17b8\0\u17e6\0\u1814\0\u1842\0\u1870\0\u189e\0\u18cc\0\u18fa"+
    "\0\u1928\0\u1956\0\u1984\0\u0eea\0\u19b2\0\u19e0\0\u1a0e\0\u1a3c"+
    "\0\u1a6a\0\u1a98\0\u1ac6\0\u1af4\0\u1b22\0\u1b50\0\u1b7e\0\u1bac"+
    "\0\u1bda\0\u1c08\0\u1c36\0\u1c64\0\u1c92\0\u1cc0\0\u1cee\0\u1d1c"+
    "\0\u1d4a\0\u1d78\0\u1da6\0\u1dd4\0\u1e02\0\u1e30\0\u1e5e\0\u1e8c"+
    "\0\u1eba\0\u1ee8\0\u1f16\0\u1f44\0\u1f72\0\u1fa0\0\u1fce\0\u1ffc"+
    "\0\u202a\0\u2058\0\u2086\0\u20b4\0\u20e2\0\212\0\u2110\0\u213e"+
    "\0\u216c\0\u219a\0\u21c8\0\u21f6\0\u2224\0\u2252\0\u2280\0\u22ae"+
    "\0\u22dc\0\u230a\0\u2338\0\u2366\0\u2394\0\u23c2\0\u23f0\0\u241e"+
    "\0\u244c\0\u247a\0\u24a8\0\u24d6\0\u2504\0\u2532\0\u2560\0\u258e"+
    "\0\u25bc\0\u25ea\0\u2618\0\u2646\0\u2674\0\u26a2\0\u26d0\0\u26fe"+
    "\0\u272c\0\u275a\0\u2788\0\u27b6\0\u27e4\0\u2812\0\u2840\0\u286e"+
    "\0\u289c\0\u28ca\0\u28f8\0\u2926\0\u2954\0\u2982\0\u29b0\0\u29de"+
    "\0\u2a0c\0\u2a3a\0\u2a68\0\u2a96\0\u2ac4\0\u2af2\0\u2b20\0\u2b4e"+
    "\0\u2b7c\0\u2baa\0\u2bd8\0\u2c06\0\u2c34\0\u2c62\0\u2c90\0\u2cbe"+
    "\0\u2cec\0\u2d1a\0\u2d48\0\u2d76\0\u2da4\0\u2dd2\0\u2e00\0\u2e2e"+
    "\0\u2e5c\0\u2e8a\0\u2eb8\0\u2ee6\0\u2f14\0\u2f42\0\u2f70\0\u2f9e"+
    "\0\u2fcc\0\u2ffa\0\u3028\0\u3056\0\u3084\0\u30b2\0\u30e0\0\u310e"+
    "\0\u313c\0\u316a\0\u3198\0\u31c6\0\u31f4\0\u3222\0\u3250\0\u327e"+
    "\0\u32ac\0\u32da\0\u3308\0\u3336\0\u3364\0\u3392\0\u33c0\0\u33ee"+
    "\0\134\0\u341c\0\u344a\0\u3478\0\u34a6";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[309];
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
    "\1\3\1\4\1\5\1\6\1\7\2\3\1\10\1\11"+
    "\1\12\1\13\1\14\1\3\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\2\32\1\33\1\34\1\4\1\35\2\4\1\36"+
    "\1\37\2\4\1\40\2\14\1\41\1\42\1\43\1\44"+
    "\1\45\11\46\1\47\1\46\1\50\42\46\57\0\2\4"+
    "\13\0\25\4\1\0\2\4\10\0\2\51\1\5\2\0"+
    "\1\51\1\0\1\51\4\0\1\52\1\0\25\51\1\0"+
    "\2\51\10\0\3\53\1\54\1\53\1\55\3\53\1\56"+
    "\44\53\4\7\1\57\1\60\3\7\1\61\44\7\7\0"+
    "\1\62\56\0\1\11\57\0\1\62\1\63\34\0\1\40"+
    "\55\0\1\40\6\0\2\4\13\0\1\4\1\64\4\4"+
    "\1\65\1\4\1\66\7\4\1\67\1\4\1\70\2\4"+
    "\1\0\2\4\11\0\2\4\13\0\21\4\1\71\3\4"+
    "\1\0\2\4\11\0\2\4\13\0\1\4\1\72\2\4"+
    "\1\73\20\4\1\0\2\4\11\0\2\4\13\0\10\4"+
    "\1\74\1\75\13\4\1\0\2\4\11\0\2\4\13\0"+
    "\2\4\1\76\22\4\1\0\2\4\11\0\2\4\13\0"+
    "\1\4\1\77\2\4\1\100\3\4\1\101\14\4\1\0"+
    "\2\4\11\0\2\4\13\0\4\4\1\102\20\4\1\0"+
    "\2\4\11\0\2\4\13\0\4\4\1\103\3\4\1\104"+
    "\14\4\1\0\2\4\11\0\2\4\13\0\1\105\1\4"+
    "\1\106\13\4\1\107\3\4\1\110\1\4\1\111\1\0"+
    "\2\4\11\0\2\4\13\0\2\4\1\112\2\4\1\32"+
    "\4\4\1\113\12\4\1\0\2\4\11\0\2\4\13\0"+
    "\10\4\1\114\1\115\10\4\1\116\2\4\1\0\2\4"+
    "\11\0\2\4\13\0\6\4\1\117\1\4\1\120\14\4"+
    "\1\0\2\4\11\0\2\4\13\0\4\4\1\121\4\4"+
    "\1\122\13\4\1\0\2\4\11\0\2\4\13\0\1\4"+
    "\1\123\4\4\1\124\2\4\1\125\4\4\1\126\3\4"+
    "\1\127\2\4\1\0\2\4\11\0\2\4\13\0\1\4"+
    "\1\130\13\4\1\131\7\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\132\3\4\1\133\4\4\1\134\13\4\1\0"+
    "\2\4\53\0\1\40\4\0\1\40\56\0\1\40\54\0"+
    "\1\40\1\0\1\40\56\0\1\14\56\0\1\14\56\0"+
    "\1\40\11\46\1\0\1\46\1\0\42\46\12\0\1\135"+
    "\43\0\3\51\2\0\1\51\1\0\1\51\6\0\25\51"+
    "\1\0\2\51\12\0\1\136\53\0\3\55\1\137\5\55"+
    "\1\0\47\55\1\54\5\55\1\0\44\55\3\0\1\137"+
    "\52\0\11\61\1\0\50\61\1\140\1\60\50\61\11\62"+
    "\1\0\44\62\1\0\2\4\13\0\2\4\1\141\13\4"+
    "\1\142\6\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\143\20\4\1\0\2\4\11\0\2\4\13\0\24\4"+
    "\1\144\1\0\2\4\11\0\2\4\13\0\10\4\1\145"+
    "\14\4\1\0\2\4\11\0\2\4\13\0\6\4\1\146"+
    "\16\4\1\0\2\4\11\0\2\4\13\0\3\4\1\147"+
    "\21\4\1\0\2\4\11\0\2\4\13\0\12\4\1\150"+
    "\12\4\1\0\2\4\11\0\2\4\13\0\23\4\1\151"+
    "\1\4\1\0\2\4\11\0\2\4\13\0\12\4\1\32"+
    "\12\4\1\0\2\4\11\0\2\4\13\0\13\4\1\144"+
    "\11\4\1\0\2\4\11\0\2\4\13\0\7\4\1\152"+
    "\15\4\1\0\2\4\11\0\2\4\13\0\22\4\1\153"+
    "\2\4\1\0\2\4\11\0\2\4\13\0\3\4\1\154"+
    "\13\4\1\155\4\4\1\111\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\144\21\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\156\13\4\1\157\5\4\1\0\2\4"+
    "\11\0\2\4\13\0\2\4\1\160\22\4\1\0\2\4"+
    "\11\0\2\4\13\0\6\4\1\32\16\4\1\0\2\4"+
    "\11\0\2\4\13\0\1\161\24\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\162\24\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\163\2\4\1\144\17\4\1\164\1\4\1\0"+
    "\2\4\11\0\2\4\13\0\3\4\1\165\21\4\1\0"+
    "\2\4\11\0\2\4\13\0\1\166\24\4\1\0\2\4"+
    "\11\0\2\4\13\0\3\4\1\167\3\4\1\170\15\4"+
    "\1\0\2\4\11\0\2\4\13\0\13\4\1\171\11\4"+
    "\1\0\2\4\11\0\2\4\13\0\13\4\1\32\1\172"+
    "\10\4\1\0\2\4\11\0\2\4\13\0\2\4\1\172"+
    "\22\4\1\0\2\4\11\0\2\4\13\0\16\4\1\173"+
    "\6\4\1\0\2\4\11\0\2\4\13\0\11\4\1\174"+
    "\13\4\1\0\2\4\11\0\2\4\13\0\3\4\1\175"+
    "\21\4\1\0\2\4\11\0\2\4\13\0\4\4\1\176"+
    "\20\4\1\0\2\4\11\0\2\4\13\0\24\4\1\177"+
    "\1\0\2\4\11\0\2\4\13\0\13\4\1\200\11\4"+
    "\1\0\2\4\11\0\2\4\13\0\4\4\1\201\20\4"+
    "\1\0\2\4\11\0\2\4\13\0\16\4\1\202\6\4"+
    "\1\0\2\4\11\0\2\4\13\0\1\4\1\203\23\4"+
    "\1\0\2\4\11\0\2\4\13\0\2\4\1\204\1\4"+
    "\1\205\20\4\1\0\2\4\11\0\2\4\13\0\3\4"+
    "\1\206\2\4\1\207\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\210\21\4\1\0\2\4\11\0\2\4"+
    "\13\0\10\4\1\211\14\4\1\0\2\4\11\0\2\4"+
    "\13\0\16\4\1\212\6\4\1\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\144\22\4\1\0\2\4\10\0\2\51"+
    "\1\136\2\0\1\51\1\0\1\51\6\0\25\51\1\0"+
    "\2\51\11\0\2\4\13\0\3\4\1\213\21\4\1\0"+
    "\2\4\11\0\2\4\13\0\1\4\1\104\23\4\1\0"+
    "\2\4\11\0\2\4\13\0\10\4\1\214\14\4\1\0"+
    "\2\4\11\0\2\4\13\0\1\4\1\32\23\4\1\0"+
    "\2\4\11\0\2\4\13\0\6\4\1\167\16\4\1\0"+
    "\2\4\11\0\2\4\13\0\24\4\1\215\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\216\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\21\4\1\217\3\4\1\0\2\4"+
    "\11\0\2\4\13\0\6\4\1\220\16\4\1\0\2\4"+
    "\11\0\2\4\13\0\11\4\1\221\13\4\1\0\2\4"+
    "\11\0\2\4\13\0\21\4\1\222\3\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\223\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\224\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\1\4\1\225\23\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\226\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\3\4\1\227\21\4\1\0\2\4"+
    "\11\0\2\4\13\0\11\4\1\230\13\4\1\0\2\4"+
    "\11\0\2\4\13\0\20\4\1\144\4\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\231\3\4\1\232\5\4"+
    "\1\233\6\4\1\0\2\4\11\0\2\4\13\0\22\4"+
    "\1\234\2\4\1\0\2\4\11\0\2\4\13\0\1\4"+
    "\1\235\23\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\236\20\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\237\20\4\1\0\2\4\11\0\2\4\13\0\1\4"+
    "\1\240\4\4\1\241\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\11\4\1\242\13\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\243\21\4\1\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\244\22\4\1\0\2\4\11\0\2\4"+
    "\13\0\20\4\1\32\4\4\1\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\245\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\246\21\4\1\0\2\4\11\0\2\4"+
    "\13\0\4\4\1\247\20\4\1\0\2\4\11\0\2\4"+
    "\13\0\10\4\1\250\14\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\251\21\4\1\0\2\4\11\0\2\4"+
    "\13\0\10\4\1\252\14\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\253\24\4\1\0\2\4\11\0\2\4\13\0"+
    "\2\4\1\254\22\4\1\0\2\4\11\0\2\4\13\0"+
    "\1\4\1\255\23\4\1\0\2\4\11\0\2\4\13\0"+
    "\5\4\1\256\17\4\1\0\2\4\11\0\2\4\13\0"+
    "\4\4\1\167\20\4\1\0\2\4\11\0\2\4\13\0"+
    "\2\4\1\257\22\4\1\0\2\4\11\0\2\4\13\0"+
    "\4\4\1\260\20\4\1\0\2\4\11\0\2\4\13\0"+
    "\4\4\1\261\1\4\1\262\16\4\1\0\2\4\11\0"+
    "\2\4\13\0\6\4\1\263\16\4\1\0\2\4\11\0"+
    "\2\4\13\0\11\4\1\264\13\4\1\0\2\4\11\0"+
    "\2\4\13\0\2\4\1\265\22\4\1\0\2\4\11\0"+
    "\2\4\13\0\6\4\1\256\16\4\1\0\2\4\11\0"+
    "\2\4\13\0\11\4\1\266\13\4\1\0\2\4\11\0"+
    "\2\4\13\0\10\4\1\104\14\4\1\0\2\4\11\0"+
    "\2\4\13\0\16\4\1\210\6\4\1\0\2\4\11\0"+
    "\2\4\13\0\2\4\1\267\22\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\101\24\4\1\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\270\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\271\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\10\4\1\272\14\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\4\1\273\23\4\1\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\251\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\274\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\11\4\1\275\13\4\1\0\2\4\11\0\2\4"+
    "\13\0\25\4\1\276\2\4\11\0\2\4\13\0\2\4"+
    "\1\277\22\4\1\0\2\4\11\0\2\4\13\0\6\4"+
    "\1\300\16\4\1\0\2\4\11\0\2\4\13\0\6\4"+
    "\1\301\16\4\1\0\2\4\11\0\2\4\13\0\11\4"+
    "\1\302\13\4\1\0\2\4\11\0\2\4\13\0\12\4"+
    "\1\144\12\4\1\0\2\4\11\0\2\4\13\0\11\4"+
    "\1\303\13\4\1\0\2\4\11\0\2\4\13\0\3\4"+
    "\1\257\21\4\1\0\2\4\11\0\2\4\13\0\23\4"+
    "\1\304\1\4\1\0\2\4\11\0\2\4\13\0\10\4"+
    "\1\305\14\4\1\0\2\4\11\0\2\4\13\0\2\4"+
    "\1\306\22\4\1\0\2\4\11\0\2\4\13\0\5\4"+
    "\1\306\17\4\1\0\2\4\11\0\2\4\13\0\6\4"+
    "\1\221\16\4\1\0\2\4\11\0\2\4\13\0\3\4"+
    "\1\167\21\4\1\0\2\4\11\0\2\4\13\0\11\4"+
    "\1\206\13\4\1\0\2\4\11\0\2\4\13\0\3\4"+
    "\1\256\21\4\1\0\2\4\11\0\2\4\13\0\2\4"+
    "\1\32\22\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\32\20\4\1\0\2\4\11\0\2\4\13\0\17\4"+
    "\1\306\5\4\1\0\2\4\11\0\2\4\13\0\1\307"+
    "\24\4\1\0\2\4\11\0\2\4\13\0\2\4\1\310"+
    "\22\4\1\0\2\4\11\0\2\4\13\0\1\4\1\311"+
    "\23\4\1\0\2\4\11\0\2\4\13\0\1\312\2\4"+
    "\1\313\1\4\1\314\1\315\1\316\1\317\1\320\7\4"+
    "\1\321\3\4\1\0\2\4\11\0\2\4\13\0\7\4"+
    "\1\322\15\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\323\20\4\1\0\2\4\11\0\2\4\13\0\3\4"+
    "\1\322\12\4\1\324\6\4\1\0\2\4\11\0\2\4"+
    "\13\0\4\4\1\104\20\4\1\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\221\22\4\1\0\2\4\11\0\2\4"+
    "\13\0\4\4\1\325\20\4\1\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\322\22\4\1\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\326\22\4\1\0\2\4\11\0\2\4"+
    "\13\0\23\4\1\221\1\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\32\24\4\1\0\2\4\34\0\1\327\32\0"+
    "\2\4\13\0\5\4\1\330\17\4\1\0\2\4\11\0"+
    "\2\4\13\0\3\4\1\331\21\4\1\0\2\4\11\0"+
    "\2\4\13\0\3\4\1\221\21\4\1\0\2\4\11\0"+
    "\2\4\13\0\12\4\1\331\12\4\1\0\2\4\11\0"+
    "\2\4\13\0\12\4\1\332\12\4\1\0\2\4\11\0"+
    "\2\4\13\0\14\4\1\333\10\4\1\0\2\4\11\0"+
    "\2\4\13\0\5\4\1\334\17\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\335\24\4\1\0\2\4\11\0\2\4"+
    "\13\0\4\4\1\336\20\4\1\0\2\4\11\0\2\4"+
    "\13\0\16\4\1\32\6\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\4\1\337\6\4\1\340\14\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\341\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\342\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\343\20\4\1\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\103\4\4\1\344\13\4"+
    "\1\0\2\4\11\0\2\4\13\0\6\4\1\345\16\4"+
    "\1\0\2\4\11\0\2\4\13\0\12\4\1\346\12\4"+
    "\1\0\2\4\11\0\2\4\13\0\1\4\1\347\23\4"+
    "\1\0\2\4\11\0\2\4\13\0\10\4\1\32\14\4"+
    "\1\0\2\4\11\0\2\4\13\0\6\4\1\350\16\4"+
    "\1\0\2\4\11\0\2\4\13\0\16\4\1\322\6\4"+
    "\1\0\2\4\11\0\2\4\13\0\2\4\1\351\22\4"+
    "\1\0\2\4\11\0\2\4\13\0\11\4\1\352\5\4"+
    "\1\353\5\4\1\0\2\4\32\0\1\354\34\0\2\4"+
    "\13\0\4\4\1\205\20\4\1\0\2\4\11\0\2\4"+
    "\13\0\11\4\1\104\13\4\1\0\2\4\11\0\2\4"+
    "\13\0\4\4\1\355\20\4\1\0\2\4\11\0\2\4"+
    "\13\0\12\4\1\311\12\4\1\0\2\4\11\0\2\4"+
    "\13\0\10\4\1\356\14\4\1\0\2\4\11\0\2\4"+
    "\13\0\11\4\1\357\13\4\1\0\2\4\11\0\2\4"+
    "\13\0\5\4\1\142\17\4\1\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\360\22\4\1\0\2\4\11\0\2\4"+
    "\13\0\25\4\1\0\1\4\1\361\11\0\2\4\13\0"+
    "\14\4\1\101\10\4\1\0\2\4\11\0\2\4\13\0"+
    "\24\4\1\362\1\0\2\4\11\0\2\4\13\0\13\4"+
    "\1\363\11\4\1\0\2\4\11\0\2\4\13\0\5\4"+
    "\1\364\17\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\361\1\4\1\365\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\10\4\1\366\14\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\206\21\4\1\0\2\4\11\0\2\4"+
    "\13\0\13\4\1\367\11\4\1\0\2\4\11\0\2\4"+
    "\13\0\1\370\24\4\1\0\2\4\11\0\2\4\13\0"+
    "\2\4\1\371\22\4\1\0\2\4\11\0\2\4\13\0"+
    "\11\4\1\372\13\4\1\0\2\4\41\0\1\373\25\0"+
    "\2\4\13\0\5\4\1\370\17\4\1\0\2\4\11\0"+
    "\2\4\13\0\3\4\1\374\21\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\4\1\272\23\4\1\0\2\4\11\0"+
    "\2\4\13\0\3\4\1\375\21\4\1\0\2\4\11\0"+
    "\2\4\13\0\10\4\1\376\14\4\1\0\2\4\11\0"+
    "\2\4\13\0\13\4\1\377\11\4\1\0\2\4\11\0"+
    "\2\4\13\0\6\4\1\u0100\16\4\1\0\2\4\11\0"+
    "\2\4\13\0\4\4\1\144\20\4\1\0\2\4\11\0"+
    "\2\4\13\0\10\4\1\u0101\14\4\1\0\2\4\11\0"+
    "\2\4\13\0\23\4\1\u0102\1\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\4\1\u0103\23\4\1\0\2\4\11\0"+
    "\2\4\13\0\11\4\1\322\13\4\1\0\2\4\11\0"+
    "\2\4\13\0\11\4\1\u0104\13\4\1\0\2\4\11\0"+
    "\2\4\13\0\2\4\1\u0105\22\4\1\0\2\4\34\0"+
    "\1\u0106\32\0\2\4\13\0\1\4\1\u0107\23\4\1\0"+
    "\2\4\11\0\2\4\13\0\4\4\1\261\1\4\1\u0108"+
    "\16\4\1\0\2\4\11\0\2\4\13\0\3\4\1\313"+
    "\21\4\1\0\2\4\11\0\2\4\13\0\16\4\1\u0109"+
    "\6\4\1\0\2\4\11\0\2\4\13\0\1\4\1\u010a"+
    "\23\4\1\0\2\4\11\0\2\4\13\0\15\4\1\u010b"+
    "\7\4\1\0\2\4\11\0\2\4\13\0\4\4\1\255"+
    "\20\4\1\0\2\4\11\0\2\4\13\0\6\4\1\u010c"+
    "\16\4\1\0\2\4\11\0\2\4\13\0\1\u010d\24\4"+
    "\1\0\2\4\11\0\2\4\13\0\10\4\1\311\14\4"+
    "\1\0\2\4\27\0\1\u010e\37\0\2\4\13\0\24\4"+
    "\1\32\1\0\2\4\11\0\2\4\13\0\1\4\1\u010f"+
    "\23\4\1\0\2\4\11\0\2\4\13\0\4\4\1\u0110"+
    "\20\4\1\0\2\4\11\0\2\4\13\0\5\4\1\u0111"+
    "\17\4\1\0\2\4\11\0\2\4\13\0\5\4\1\u0112"+
    "\17\4\1\0\2\4\11\0\2\4\13\0\2\4\1\u0113"+
    "\1\4\1\u0114\20\4\1\0\2\4\11\0\2\4\13\0"+
    "\11\4\1\u0105\13\4\1\0\2\4\33\0\1\u0115\33\0"+
    "\2\4\13\0\16\4\1\u0116\6\4\1\0\2\4\11\0"+
    "\2\4\13\0\23\4\1\u0117\1\4\1\0\2\4\11\0"+
    "\2\4\13\0\22\4\1\u0118\2\4\1\0\2\4\11\0"+
    "\2\4\13\0\4\4\1\u0119\20\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\4\1\72\23\4\1\0\2\4\11\0"+
    "\2\4\13\0\3\4\1\u011a\21\4\1\0\2\4\50\0"+
    "\1\u011b\16\0\2\4\13\0\2\4\1\u011c\22\4\1\0"+
    "\2\4\11\0\2\4\13\0\10\4\1\u011d\14\4\1\0"+
    "\2\4\11\0\2\4\13\0\1\u011e\24\4\1\0\2\4"+
    "\11\0\2\4\13\0\24\4\1\u011f\1\0\2\4\11\0"+
    "\2\4\13\0\11\4\1\u0120\13\4\1\0\2\4\26\0"+
    "\1\u0121\40\0\2\4\13\0\22\4\1\u0122\2\4\1\0"+
    "\2\4\11\0\2\4\13\0\21\4\1\u0123\3\4\1\0"+
    "\2\4\11\0\2\4\13\0\3\4\1\142\21\4\1\0"+
    "\2\4\11\0\2\4\13\0\5\4\1\u0124\17\4\1\0"+
    "\2\4\11\0\2\4\13\0\25\4\1\0\1\u0125\1\4"+
    "\26\0\1\u0126\40\0\2\4\13\0\12\4\1\u0127\12\4"+
    "\1\0\2\4\11\0\2\4\13\0\16\4\1\256\6\4"+
    "\1\0\2\4\11\0\2\4\13\0\4\4\1\u0128\20\4"+
    "\1\0\2\4\11\0\2\4\13\0\22\4\1\u0129\2\4"+
    "\1\0\2\4\37\0\1\u012a\27\0\2\4\13\0\4\4"+
    "\1\u012b\20\4\1\0\2\4\11\0\2\4\13\0\10\4"+
    "\1\u012c\14\4\1\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\u012d\20\4\1\0\2\4\27\0\1\u012e\37\0\2\4"+
    "\13\0\6\4\1\u012f\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\u0130\16\4\1\0\2\4\11\0\2\4"+
    "\13\0\3\4\1\322\21\4\1\0\2\4\30\0\1\u0131"+
    "\36\0\2\4\13\0\11\4\1\u0132\13\4\1\0\2\4"+
    "\11\0\2\4\13\0\1\u0133\24\4\1\0\2\4\11\0"+
    "\2\4\13\0\1\144\24\4\1\0\2\4\11\0\2\4"+
    "\13\0\20\4\1\u0134\4\4\1\0\2\4\11\0\2\4"+
    "\13\0\11\4\1\u0135\13\4\1\0\2\4\11\0\2\4"+
    "\13\0\7\4\1\144\15\4\1\0\2\4\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[13524];
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
    "\2\0\1\11\6\1\1\11\2\1\1\11\22\1\1\11"+
    "\6\1\1\11\2\1\1\0\1\1\1\11\1\1\1\0"+
    "\1\11\3\1\1\11\51\1\1\11\1\1\2\11\135\1"+
    "\1\0\30\1\1\0\24\1\1\0\16\1\1\0\12\1"+
    "\1\0\7\1\1\0\6\1\1\0\5\1\1\0\5\1"+
    "\1\0\4\1\1\0\3\1\1\0\3\1\1\0\2\1"+
    "\1\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[309];
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

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

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

  /* user code: */
   
   /**   
    * Constructor.  This must be here because JFlex does not generate a   
    * no-parameter constructor.   
    */   
   public ExampleTokenMaker() {   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param tokenType The token's type.   
    * @see #addToken(int, int, int)   
    */   
   private void addHyperlinkToken(int start, int end, int tokenType) {   
      int so = start + offsetShift;   
      addToken(zzBuffer, start,end, tokenType, so, true);   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param tokenType The token's type.   
    */   
   private void addToken(int tokenType) {   
      addToken(zzStartRead, zzMarkedPos-1, tokenType);   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param tokenType The token's type.   
    * @see #addHyperlinkToken(int, int, int)   
    */   
   private void addToken(int start, int end, int tokenType) {   
      int so = start + offsetShift;   
      addToken(zzBuffer, start,end, tokenType, so, false);   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param array The character array.   
    * @param start The starting offset in the array.   
    * @param end The ending offset in the array.   
    * @param tokenType The token's type.   
    * @param startOffset The offset in the document at which this token   
    *        occurs.   
    * @param hyperlink Whether this token is a hyperlink.   
    */   
   public void addToken(char[] array, int start, int end, int tokenType,   
                  int startOffset, boolean hyperlink) {   
      super.addToken(array, start,end, tokenType, startOffset, hyperlink);   
      zzStartRead = zzMarkedPos;   
   }   
   
   /**   
    * Returns the text to place at the beginning and end of a   
    * line to "comment" it in a this programming language.   
    *   
    * @return The start and end strings to add to a line to "comment"   
    *         it out.   
    */   
   public String[] getLineCommentStartAndEnd() {   
      return new String[] { "//", null };   
   }   
   
   /**   
    * Returns the first token in the linked list of tokens generated   
    * from <code>text</code>.  This method must be implemented by   
    * subclasses so they can correctly implement syntax highlighting.   
    *   
    * @param text The text from which to get tokens.   
    * @param initialTokenType The token type we should start with.   
    * @param startOffset The offset into the document at which   
    *        <code>text</code> starts.   
    * @return The first <code>Token</code> in a linked list representing   
    *         the syntax highlighted text.   
    */   
   public Token getTokenList(Segment text, int initialTokenType, int startOffset) {   
   
      resetTokenList();   
      this.offsetShift = -text.offset + startOffset;   
   
      // Start off in the proper state.   
      int state = Token.NULL;   
      switch (initialTokenType) {   
                  case Token.COMMENT_MULTILINE:   
            state = MLC;   
            start = text.offset;   
            break;   
   
         /* No documentation comments */   
         default:   
            state = Token.NULL;   
      }   
   
      s = text;   
      try {   
         yyreset(zzReader);   
         yybegin(state);   
         return yylex();   
      } catch (IOException ioe) {   
         ioe.printStackTrace();   
         return new TokenImpl();   
      }   
   
   }   
   
   /**   
    * Refills the input buffer.   
    *   
    * @return      <code>true</code> if EOF was reached, otherwise   
    *              <code>false</code>.   
    */   
   private boolean zzRefill() {   
      return zzCurrentPos>=s.offset+s.count;   
   }   
   
   /**   
    * Resets the scanner to read from a new input stream.   
    * Does not close the old reader.   
    *   
    * All internal variables are reset, the old input stream    
    * <b>cannot</b> be reused (internal buffer is discarded and lost).   
    * Lexical state is set to <tt>YY_INITIAL</tt>.   
    *   
    * @param reader   the new input stream    
    */   
   public final void yyreset(Reader reader) {   
      // 's' has been updated.   
      zzBuffer = s.array;   
      /*   
       * We replaced the line below with the two below it because zzRefill   
       * no longer "refills" the buffer (since the way we do it, it's always   
       * "full" the first time through, since it points to the segment's   
       * array).  So, we assign zzEndRead here.   
       */   
      //zzStartRead = zzEndRead = s.offset;   
      zzStartRead = s.offset;   
      zzEndRead = zzStartRead + s.count - 1;   
      zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;   
      zzLexicalState = YYINITIAL;   
      zzReader = reader;   
      zzAtBOL  = true;   
      zzAtEOF  = false;   
   }   
   


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ExampleTokenMaker(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public ExampleTokenMaker(java.io.InputStream in) {
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
    while (i < 186) {
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public org.fife.ui.rsyntaxtextarea.Token yylex() throws java.io.IOException {
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

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


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
          { addNullToken(); return firstToken;
          }
        case 22: break;
        case 18: 
          { addToken(Token.LITERAL_CHAR);
          }
        case 23: break;
        case 16: 
          { start = zzMarkedPos-2; yybegin(MLC);
          }
        case 24: break;
        case 5: 
          { addToken(Token.WHITESPACE);
          }
        case 25: break;
        case 19: 
          { addToken(Token.ERROR_STRING_DOUBLE);
          }
        case 26: break;
        case 9: 
          { addToken(Token.RESERVED_WORD);
          }
        case 27: break;
        case 8: 
          { addToken(Token.SEPARATOR);
          }
        case 28: break;
        case 1: 
          { addToken(Token.IDENTIFIER);
          }
        case 29: break;
        case 21: 
          { addToken(Token.FUNCTION);
          }
        case 30: break;
        case 3: 
          { addToken(Token.ERROR_CHAR); addNullToken(); return firstToken;
          }
        case 31: break;
        case 4: 
          { addToken(Token.ERROR_STRING_DOUBLE); addNullToken(); return firstToken;
          }
        case 32: break;
        case 20: 
          { addToken(Token.DATA_TYPE);
          }
        case 33: break;
        case 17: 
          { yybegin(YYINITIAL); addToken(start,zzStartRead+2-1, Token.COMMENT_MULTILINE);
          }
        case 34: break;
        case 13: 
          { addToken(Token.ERROR_CHAR);
          }
        case 35: break;
        case 14: 
          { addToken(Token.LITERAL_STRING_DOUBLE_QUOTE);
          }
        case 36: break;
        case 15: 
          { addToken(Token.COMMENT_EOL); addNullToken(); return firstToken;
          }
        case 37: break;
        case 12: 
          { addToken(Token.ERROR_NUMBER_FORMAT);
          }
        case 38: break;
        case 2: 
          { addToken(Token.LITERAL_NUMBER_DECIMAL_INT);
          }
        case 39: break;
        case 7: 
          { addToken(Token.OPERATOR);
          }
        case 40: break;
        case 10: 
          { 
          }
        case 41: break;
        case 11: 
          { addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken;
          }
        case 42: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case YYINITIAL: {
              addNullToken(); return firstToken;
            }
            case 310: break;
            case MLC: {
              addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken;
            }
            case 311: break;
            default:
            return null;
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
