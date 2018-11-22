package top.nyoj;

import java.util.Scanner;

/*
 * tm: A+B Problem      --finish
 * 
 * ms: 
 * 
 * sr: 
 * 
 * sc: 
 * 
 * ei: 
 * 
 * eo: 
 * 
 * sl: 
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
