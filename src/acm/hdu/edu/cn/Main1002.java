package acm.hdu.edu.cn;

import java.math.BigInteger;
import java.util.Scanner;

/*
title:
A + B Problem II            --finish

description:
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.

input:
The first line of the input contains an integer T(1<=T<=20) which means the number of test cases.
Then T lines follow, each line consists of two positive integers, A and B.
Notice that the integers are very large, that means you should not process them by using 32-bit integer.
You may assume the length of each integer will not exceed 1000.

output:
For each test case, you should output two lines. The first line is "Case #:", # means the number of the test case.
The second line is the an equation "A + B = Sum", Sum means the result of A + B. Note there are some spaces int the equation.
Output a blank line between two test cases.

sample input:
2
1 2
112233445566778899 998877665544332211

sample output:
Case 1:
1 + 2 = 3

Case 2:
112233445566778899 + 998877665544332211 = 1111111111111111110

hint:
 */

public class Main1002
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  BigInteger i1, i2;

  for (int i = 1; i <= testCount; i++)
  {
   i1 = scr.nextBigInteger();
   i2 = scr.nextBigInteger();
   System.out.println("Case " + i + ":");
   System.out.println(i1 + " + " + i2 + " = " + i1.add(i2));
   if (i != testCount) System.out.println();
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
