package nyoj.top;

import java.util.Scanner;

/*
title:
A+B Problem      --finish

description:

input:

output:

sample input:

sample output:

hint:
 */

public class Main1
{
 static class Test
 {
  int a, b;

  public Test(Scanner scr)
  {
   a = scr.nextInt();
   b = scr.nextInt();
  }

  public void run()
  {
   System.out.println(a + b);
  }
 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  new Test(scr).run();
 }

}
