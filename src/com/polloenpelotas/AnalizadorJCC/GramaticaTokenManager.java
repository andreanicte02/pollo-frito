/* Generated By:JavaCC: Do not edit this line. GramaticaTokenManager.java */
/** Analizador de expresiones aritmeticas sencillas. */

package com.polloenpelotas.AnalizadorJCC;
import java.util.ArrayList;
import java.util.List;
import com.polloenpelotas.language.nodes.*;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.Instructions.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.*;
import com.polloenpelotas.language.nodes.CreateZTypes.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.ArithmeticOperations.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.EqualityOperations.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.LogicalOperations.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations.*;
import com.polloenpelotas.language.nodes.ExpressionsOperations.RelationalOperations.*;

/** Token Manager. */
public class GramaticaTokenManager implements GramaticaConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x1ffe0c0000000L) != 0L)
         {
            jjmatchedKind = 49;
            return 3;
         }
         return -1;
      case 1:
         if ((active0 & 0x1020000000000L) != 0L)
            return 3;
         if ((active0 & 0xfde0c0000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 1;
            return 3;
         }
         return -1;
      case 2:
         if ((active0 & 0xfde0c0000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 2;
            return 3;
         }
         return -1;
      case 3:
         if ((active0 & 0x242040000000L) != 0L)
            return 3;
         if ((active0 & 0xd9c080000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 3;
            return 3;
         }
         return -1;
      case 4:
         if ((active0 & 0x91c000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 4;
            return 3;
         }
         if ((active0 & 0x480080000000L) != 0L)
            return 3;
         return -1;
      case 5:
         if ((active0 & 0x818000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 5;
            return 3;
         }
         if ((active0 & 0x104000000000L) != 0L)
            return 3;
         return -1;
      case 6:
         if ((active0 & 0x808000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 6;
            return 3;
         }
         if ((active0 & 0x10000000000L) != 0L)
            return 3;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 26;
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 34:
         return jjStopAtPos(0, 50);
      case 37:
         return jjMoveStringLiteralDfa1_0(0x8000000L);
      case 38:
         return jjStopAtPos(0, 24);
      case 40:
         return jjStopAtPos(0, 9);
      case 41:
         return jjStopAtPos(0, 10);
      case 42:
         return jjStopAtPos(0, 13);
      case 43:
         return jjStopAtPos(0, 11);
      case 44:
         return jjStopAtPos(0, 32);
      case 45:
         return jjStopAtPos(0, 12);
      case 47:
         return jjStopAtPos(0, 14);
      case 58:
         return jjStopAtPos(0, 36);
      case 59:
         return jjStopAtPos(0, 8);
      case 60:
         jjmatchedKind = 16;
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 61:
         jjmatchedKind = 20;
         return jjMoveStringLiteralDfa1_0(0x600000L);
      case 62:
         jjmatchedKind = 17;
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 63:
         return jjStopAtPos(0, 35);
      case 91:
         return jjStopAtPos(0, 28);
      case 93:
         return jjStopAtPos(0, 29);
      case 94:
         return jjStopAtPos(0, 15);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_0(0x80000000000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_0(0xa00000000000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa1_0(0x1010000000000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0x8080000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_0(0x2000000000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x4000000000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_0(0x100000000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 123:
         return jjStopAtPos(0, 33);
      case 124:
         return jjStopAtPos(0, 25);
      case 125:
         return jjStopAtPos(0, 34);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 37:
         if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(1, 27);
         break;
      case 61:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(1, 18);
         else if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(1, 19);
         else if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(1, 22);
         else if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(1, 23);
         break;
      case 62:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(1, 21);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x200080000000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x14000000000L);
      case 70:
      case 102:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 41, 3);
         break;
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000000L);
      case 79:
      case 111:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 48, 3);
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x80040000000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0xa000000000L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000000L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x500000000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x2080000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x808000000000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x240000000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x90000000000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000L);
      case 69:
      case 101:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(3, 30, 3);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 42, 3);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 45, 3);
         break;
      case 76:
      case 108:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 37, 3);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x900000000000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000000000L);
      case 69:
      case 101:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(4, 31, 3);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 46, 3);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000000000L);
      case 75:
      case 107:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 43, 3);
         break;
      case 82:
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 72:
      case 104:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 44, 3);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000000L);
      case 78:
      case 110:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 38, 3);
         return jjMoveStringLiteralDfa6_0(active0, 0x800000000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 79:
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000000L);
      case 84:
      case 116:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 40, 3);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 47, 3);
         break;
      case 78:
      case 110:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 39, 3);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 10;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 46)
                     jjstateSet[jjnewStateCnt++] = 2;
                  else if (curChar == 35)
                  {
                     if (kind > 5)
                        kind = 5;
                     jjCheckNAdd(1);
                  }
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjCheckNAdd(1);
                  break;
               case 3:
                  if ((0x3ff400000000000L & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 4:
                  if (curChar == 46)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddStates(0, 2);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(7, 8);
                  break;
               case 8:
                  if (curChar == 46)
                     jjCheckNAdd(9);
                  break;
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAdd(9);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 2:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  jjCheckNAdd(3);
                  break;
               case 1:
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 3:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  jjCheckNAdd(3);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 10 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjStopStringLiteralDfa_1(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_1(int pos, long active0)
{
   return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
}
private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 34:
         return jjStopAtPos(0, 52);
      default :
         return jjMoveNfa_1(0, 0);
   }
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 1;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     kind = 51;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  kind = 51;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((jjbitVec0[i2] & l2) != 0L && kind > 51)
                     kind = 51;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 1 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   6, 7, 8, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\73", "\50", "\51", "\53", 
"\55", "\52", "\57", "\136", "\74", "\76", "\74\75", "\76\75", "\75", "\75\76", 
"\75\75", "\41\75", "\46", "\174", "\41", "\45\45", "\133", "\135", null, null, "\54", 
"\173", "\175", "\77", "\72", null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "STRING_STATE",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   1, -1, 0, 
};
static final long[] jjtoToken = {
   0x13ffffffffffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
static final long[] jjtoMore = {
   0xc000000000000L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[10];
private final int[] jjstateSet = new int[20];
protected char curChar;
/** Constructor. */
public GramaticaTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public GramaticaTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 10; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
