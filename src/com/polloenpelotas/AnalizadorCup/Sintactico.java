
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Feb 15 20:53:39 CST 2020
//----------------------------------------------------

package com.polloenpelotas.AnalizadorCup;

import java_cup.runtime.Symbol;
import java.util.ArrayList;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat Feb 15 20:53:39 CST 2020
  */
public class Sintactico extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\020\000\002\002\004\000\002\002\003\000\002\004" +
    "\006\000\002\004\005\000\002\005\004\000\002\005\003" +
    "\000\002\006\003\000\002\003\005\000\002\003\005\000" +
    "\002\003\005\000\002\003\005\000\002\003\005\000\002" +
    "\003\005\000\002\003\003\000\002\003\003\000\002\003" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\033\000\012\013\006\016\013\017\011\020\012\001" +
    "\002\000\014\002\ufffb\013\ufffb\016\ufffb\017\ufffb\020\ufffb" +
    "\001\002\000\016\004\024\005\025\006\020\007\022\010" +
    "\021\021\033\001\002\000\012\013\006\016\013\017\011" +
    "\020\012\001\002\000\014\002\ufffc\013\ufffc\016\ufffc\017" +
    "\ufffc\020\ufffc\001\002\000\004\002\016\001\002\000\034" +
    "\002\ufff4\004\ufff4\005\ufff4\006\ufff4\007\ufff4\010\ufff4\013" +
    "\ufff4\014\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021\ufff4" +
    "\001\002\000\034\002\ufff2\004\ufff2\005\ufff2\006\ufff2\007" +
    "\ufff2\010\ufff2\013\ufff2\014\ufff2\015\ufff2\016\ufff2\017\ufff2" +
    "\020\ufff2\021\ufff2\001\002\000\034\002\ufff3\004\ufff3\005" +
    "\ufff3\006\ufff3\007\ufff3\010\ufff3\013\ufff3\014\ufff3\015\ufff3" +
    "\016\ufff3\017\ufff3\020\ufff3\021\ufff3\001\002\000\014\002" +
    "\000\013\006\016\013\017\011\020\012\001\002\000\014" +
    "\002\ufffd\013\ufffd\016\ufffd\017\ufffd\020\ufffd\001\002\000" +
    "\004\002\001\001\002\000\016\004\024\005\025\006\020" +
    "\007\022\010\021\014\023\001\002\000\012\013\006\016" +
    "\013\017\011\020\012\001\002\000\012\013\006\016\013" +
    "\017\011\020\012\001\002\000\012\013\006\016\013\017" +
    "\011\020\012\001\002\000\034\002\ufff5\004\ufff5\005\ufff5" +
    "\006\ufff5\007\ufff5\010\ufff5\013\ufff5\014\ufff5\015\ufff5\016" +
    "\ufff5\017\ufff5\020\ufff5\021\ufff5\001\002\000\012\013\006" +
    "\016\013\017\011\020\012\001\002\000\012\013\006\016" +
    "\013\017\011\020\012\001\002\000\034\002\ufff9\004\ufff9" +
    "\005\ufff9\006\020\007\022\010\021\013\ufff9\014\ufff9\015" +
    "\ufff9\016\ufff9\017\ufff9\020\ufff9\021\ufff9\001\002\000\034" +
    "\002\ufffa\004\ufffa\005\ufffa\006\020\007\022\010\021\013" +
    "\ufffa\014\ufffa\015\ufffa\016\ufffa\017\ufffa\020\ufffa\021\ufffa" +
    "\001\002\000\034\002\ufff7\004\ufff7\005\ufff7\006\ufff7\007" +
    "\ufff7\010\021\013\ufff7\014\ufff7\015\ufff7\016\ufff7\017\ufff7" +
    "\020\ufff7\021\ufff7\001\002\000\034\002\ufff6\004\ufff6\005" +
    "\ufff6\006\ufff6\007\ufff6\010\ufff6\013\ufff6\014\ufff6\015\ufff6" +
    "\016\ufff6\017\ufff6\020\ufff6\021\ufff6\001\002\000\034\002" +
    "\ufff8\004\ufff8\005\ufff8\006\ufff8\007\ufff8\010\021\013\ufff8" +
    "\014\ufff8\015\ufff8\016\ufff8\017\ufff8\020\ufff8\021\ufff8\001" +
    "\002\000\012\013\006\016\013\017\011\020\012\001\002" +
    "\000\030\002\ufffe\004\024\005\025\006\020\007\022\010" +
    "\021\013\ufffe\015\035\016\ufffe\017\ufffe\020\ufffe\001\002" +
    "\000\014\002\uffff\013\uffff\016\uffff\017\uffff\020\uffff\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\033\000\014\002\007\003\004\004\003\005\013\006" +
    "\006\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\003\016\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\003\004\004\003\006\014\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\003\031\001\001" +
    "\000\004\003\030\001\001\000\004\003\027\001\001\000" +
    "\002\001\001\000\004\003\026\001\001\000\004\003\025" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\033" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public String salida="";

    //-------------------> Metodo al que se llama automaticamente ante algun error sintactico.
    public void syntax_error(Symbol s)
    {
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;

        System.out.println("!!!!!!! Error Sintactico Recuperado !!!!!!!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);
    }


    //-------------------> Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores.
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;

        System.out.println("!!!!!!! Error Sintactico, Panic Mode!!!!!!!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);
    }


    public void semantic(Symbol cur_token, String n)
    {
        System.out.println("error semantico ");
    }


    public void semantic(String msg, Object obj) {}


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Sintactico$actions {



  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // exp ::= identifier 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // exp ::= numero 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // exp ::= decimal 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // exp ::= apar exp cpar 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // exp ::= exp potenciar exp 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // exp ::= exp dividir exp 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // exp ::= exp por exp 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // exp ::= exp menos exp 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // exp ::= exp mas exp 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("exp",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // sentenciaPrueba ::= assignVar 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("sentenciaPrueba",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // sentenciasPrueba ::= sentenciaPrueba 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("sentenciasPrueba",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sentenciasPrueba ::= sentenciasPrueba sentenciaPrueba 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("sentenciasPrueba",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // assignVar ::= exp igual exp 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("assignVar",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // assignVar ::= exp igual exp pComa 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("assignVar",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= sentenciasPrueba 
            {
              String RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

