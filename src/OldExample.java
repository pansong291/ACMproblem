import java.util.Scanner;

/*
title:

description:

input:

output:

sample input:

sample output:

hint:
 */

public class OldExample
{

 static class Test
 {
  static boolean debug = true;

  public Test(Scanner scr)
  {
  }

  public void run()
  {
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
