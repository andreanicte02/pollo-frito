/* Generated By:JavaCC: Do not edit this line. Gramatica.java */
/** Analizador de expresiones aritmeticas sencillas. */

package com.polloenpelotas.AnalizadorJCC;

import java.util.ArrayList;
import java.util.List;
import com.polloenpelotas.language.nodes.*;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.Instructions.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.*;
import com.polloenpelotas.language.nodes.CreateZTypes.*;


public class Gramatica implements GramaticaConstants {

/** Producción inicial
    Analizar -> (Instruccion)+ EOF
*/
  final public List<AstNode> Analizar() throws ParseException {
 AstNode e; List<AstNode> l = new ArrayList<AstNode>();
    label_1:
    while (true) {
      e = Instruccion();
                    l.add(e);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRINT:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
                                        {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode Instruccion() throws ParseException {
 AstNode e, e1;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(PARENI);
      e = ExpresionOr();
      jj_consume_token(PAREND);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PCOMA:
        jj_consume_token(PCOMA);
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
                                                          {if (true) return new PrintAstNode(new FileLocation(token.beginColumn, token.beginLine),e);}
      break;
    case IDENTIFIER:
      e = ExpsLeft();
      jj_consume_token(IGUAL);
      e1 = ExpresionOr();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PCOMA:
        jj_consume_token(PCOMA);
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
                                                    {if (true) return new AssignAstNode(new FileLocation(token.beginColumn, token.beginLine),e, e1);}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionOr() throws ParseException {
 AstNode e, e1;
    e = ExpresionAnd();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      jj_consume_token(OR);
      e1 = ExpresionAnd();
                                 e = new OrAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionAnd() throws ParseException {
 AstNode e, e1;
    e = ExpresionIgualdad();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      jj_consume_token(AND);
      e1 = ExpresionIgualdad();
                                       e = new AndAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionIgualdad() throws ParseException {
 AstNode e, e1;
    e = ExpresionRelacional();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUALACION:
      case DIFERENCIACION:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUALACION:
        jj_consume_token(IGUALACION);
        e1 = ExpresionRelacional();
                                                e = new EqualToAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case DIFERENCIACION:
        jj_consume_token(DIFERENCIACION);
        e1 = ExpresionRelacional();
                                                    e = new NotEqualToAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionRelacional() throws ParseException {
 AstNode e, e1;
    e = ExpresionSuma();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MENORQUE:
      case MAYORQUE:
      case MENORIGUAL:
      case MAYORIGUAL:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAYORQUE:
        jj_consume_token(MAYORQUE);
        e1 = ExpresionSuma();
                                        e = new MayorAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case MENORQUE:
        jj_consume_token(MENORQUE);
        e1 = ExpresionSuma();
                                        e = new MenorAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case MAYORIGUAL:
        jj_consume_token(MAYORIGUAL);
        e1 = ExpresionSuma();
                                          e = new MayorIgualAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case MENORIGUAL:
        jj_consume_token(MENORIGUAL);
        e1 = ExpresionSuma();
                                          e = new MenorIgualAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionSuma() throws ParseException {
 AstNode e, e1;
    e = ExpresionMultiplicativa();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAS:
      case MENOS:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAS:
        jj_consume_token(MAS);
        e1 = ExpresionMultiplicativa();
                                             e = new AddAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case MENOS:
        jj_consume_token(MENOS);
        e1 = ExpresionMultiplicativa();
                                               e = new RestAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionMultiplicativa() throws ParseException {
 AstNode e, e1;
    e = ExpPotencia();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POR:
      case DIV:
      case MODULAR:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POR:
        jj_consume_token(POR);
        e1 = ExpPotencia();
                                 e = new MultAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case DIV:
        jj_consume_token(DIV);
        e1 = ExpPotencia();
                                 e = new DivAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      case MODULAR:
        jj_consume_token(MODULAR);
        e1 = ExpPotencia();
                                     e = new ModAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpPotencia() throws ParseException {
 AstNode e, e1;
    e = ExpresionUnaria();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POT:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_8;
      }
      jj_consume_token(POT);
      e1 = ExpresionUnaria();
                                      e = new PotAstNode(new FileLocation(token.beginColumn, token.beginLine),e,e1);
    }
     {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpresionUnaria() throws ParseException {
 AstNode e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENOS:
      jj_consume_token(MENOS);
      e = ExpresionUnaria();
                                  {if (true) return new UnaryMinusNode(new FileLocation(token.beginColumn, token.beginLine), e);}
      break;
    case NOT:
      jj_consume_token(NOT);
      e = ExpresionUnaria();
                                  {if (true) return new NotAstNode(new FileLocation(token.beginColumn, token.beginLine), e);}
      break;
    case NUMERO:
    case DECIMAL:
    case PARENI:
    case TRUE:
    case FALSE:
    case C:
    case LIST:
    case IDENTIFIER:
    case STRING:
      e = ExpAccess();
                   {if (true) return e;}
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpAccess() throws ParseException {
 AstNode e, e1;
    e = Primitives();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ABRA:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_9;
      }
      if (jj_2_1(2)) {
        jj_consume_token(ABRA);
        e1 = ExpresionOr();
        jj_consume_token(CBRA);
         e = new AccessStructAstNode (new FileLocation(token.beginColumn, token.beginLine),e,e1);
      } else if (jj_2_2(2)) {
        jj_consume_token(ABRA);
        jj_consume_token(ABRA);
        e1 = ExpresionOr();
        jj_consume_token(CBRA);
        jj_consume_token(CBRA);
         e = new Access2ListAstNode (new FileLocation(token.beginColumn, token.beginLine),e,e1);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
       {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode Primitives() throws ParseException {
 AstNode e; Token t;   List<AstNode> e1;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PARENI:
      jj_consume_token(PARENI);
      e = ExpresionOr();
      jj_consume_token(PAREND);
                                            {if (true) return e;}
      break;
    case NUMERO:
      jj_consume_token(NUMERO);
                {if (true) return new CreateZIntegerNode(new FileLocation(token.beginColumn, token.beginLine),Integer.parseInt( token.image ));}
      break;
    case DECIMAL:
      jj_consume_token(DECIMAL);
                {if (true) return new CreateZNumericNode (new FileLocation(token.beginColumn, token.beginLine), Double.parseDouble(token.image ));}
      break;
    case TRUE:
      jj_consume_token(TRUE);
              {if (true) return new CreateZBooleanNode(new FileLocation(token.beginColumn, token.beginLine),true);}
      break;
    case FALSE:
      jj_consume_token(FALSE);
              {if (true) return new CreateZBooleanNode(new FileLocation(token.beginColumn, token.beginLine),false);}
      break;
    case STRING:
      t = jj_consume_token(STRING);
                 {if (true) return new CreateZStringNode(new FileLocation(token.beginColumn, token.beginLine), t.image.substring(1,t.image.length()-1) );}
      break;
    case C:
    case LIST:
      e = OtherFunctions();
                        {if (true) return e;}
      break;
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                    {if (true) return new FindIDAstNode(new FileLocation(t.beginColumn, t.beginLine), t.image );}
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public AstNode OtherFunctions() throws ParseException {
  List<AstNode> l = new ArrayList<AstNode>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case C:
      jj_consume_token(C);
      jj_consume_token(PARENI);
      l = ListExp();
      jj_consume_token(PAREND);
                                               {if (true) return new FunctionCAstNode(new FileLocation(token.beginColumn, token.beginLine), l );}
      break;
    case LIST:
      jj_consume_token(LIST);
      jj_consume_token(PARENI);
      l = ListExp();
      jj_consume_token(PAREND);
                                              {if (true) return new CreateZListNode(new FileLocation(token.beginColumn, token.beginLine), l) ;}
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public List<AstNode> ListExp() throws ParseException {
  List<AstNode> l = new ArrayList<AstNode>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
    case DECIMAL:
    case PARENI:
    case MENOS:
    case NOT:
    case TRUE:
    case FALSE:
    case C:
    case LIST:
    case IDENTIFIER:
    case STRING:
      l = Exps();
                  {if (true) return l;}
      break;
    default:
      jj_la1[19] = jj_gen;
                  {if (true) return l;}
    }
    throw new Error("Missing return statement in function");
  }

  final public List<AstNode> Exps() throws ParseException {
  AstNode e,e1;  List<AstNode> l = new ArrayList<AstNode>();
    e = ExpresionOr();
                      l.add(e);
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMA:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_10;
      }
      jj_consume_token(COMA);
      e1 = ExpresionOr();
                                  l.add(e1);
    }
        {if (true) return l;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode ExpsLeft() throws ParseException {
 AstNode e, e1;
    e = PrimitivesLeft();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ABRA:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_11;
      }
      if (jj_2_3(2)) {
        jj_consume_token(ABRA);
        e1 = ExpresionOr();
        jj_consume_token(CBRA);
         e = new LeftAccess1AstNode (new FileLocation(token.beginColumn, token.beginLine),e,e1);
      } else if (jj_2_4(2)) {
        jj_consume_token(ABRA);
        jj_consume_token(ABRA);
        e1 = ExpresionOr();
        jj_consume_token(CBRA);
        jj_consume_token(CBRA);
         e = new LeftAccess2AstNode (new FileLocation(token.beginColumn, token.beginLine),e,e1);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  final public AstNode PrimitivesLeft() throws ParseException {
 Token t;
    t = jj_consume_token(IDENTIFIER);
                    {if (true) return new FindIDLeftAstNode(new FileLocation(t.beginColumn, t.beginLine), t.image );}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_3R_23() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_35() {
    if (jj_scan_token(LIST)) return true;
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_scan_token(NOT)) return true;
    return false;
  }

  private boolean jj_3R_34() {
    if (jj_scan_token(C)) return true;
    return false;
  }

  private boolean jj_3R_33() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_34()) {
    jj_scanpos = xsp;
    if (jj_3R_35()) return true;
    }
    return false;
  }

  private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_scan_token(MENOS)) return true;
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_31() {
    if (jj_3R_33()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_scan_token(STRING)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(ABRA)) return true;
    if (jj_scan_token(ABRA)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(ABRA)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(DECIMAL)) return true;
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(NUMERO)) return true;
    return false;
  }

  private boolean jj_3R_25() {
    if (jj_scan_token(PARENI)) return true;
    return false;
  }

  private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) return true;
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(ABRA)) return true;
    if (jj_scan_token(ABRA)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(ABRA)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public GramaticaTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x100,0x100,0x80,0x1000000,0x800000,0x600000,0x600000,0xf0000,0xf0000,0x1800,0x1800,0x4006000,0x4006000,0x8000,0x62001260,0x8000000,0x60000260,0x0,0x62001260,0x80000000,0x8000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x4,0x0,0x0,0x4,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x27,0x0,0x27,0x3,0x27,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[4];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Gramatica(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Gramatica(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GramaticaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Gramatica(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GramaticaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Gramatica(GramaticaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(GramaticaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        exists = true;
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
