package nyoj.top;

import java.util.Scanner;

/*
title:
Binary String Matching       --finish

description:
Given two strings A and B, whose alphabet consist only ‘0’ and ‘1’.
Your task is only to tell how many times does A appear as a substring of B?
For example, the text string B is ‘1001110110’ while the pattern string A is ‘11’,
you should output 3, because the pattern A appeared at the posit

input:
The first line consist only one integer N, indicates N cases follows.
In each case, there are two lines, the first line gives the string A, length (A) <= 10,
and the second line gives the string B, length (B) <= 1000.
And it is guaranteed that B is always longer than A.

output:
For each case, output a single line consist a single integer,
tells how many times do B appears as a substring of A.

sample input:
3
11
1001110110
101
110010010010001
1010
110100010101011

sample output:
3
0
3

hint:
 */

public class Main5
{

 static class Test
 {
  static boolean debug = true;
  String A, B;

  public Test(Scanner scr)
  {
   A = scr.nextLine();
   B = scr.nextLine();
  }

  public void run()
  {
   int count = 0;
   for (int i = 0; i < B.length(); i++)
   {
    if (B.indexOf(A, i) == i)
    {
     count++;
    }
   }
   System.out.println(count);
  }

  static void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static Test test[];

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new Test[scr.nextInt()];
  scr.nextLine();
  for (int i = 0; i < test.length; i++)
  {
   test[i] = new Test(scr);
  }
  for (int i = 0; i < test.length; i++)
  {
   test[i].run();
  }
 }

}
