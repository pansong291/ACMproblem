import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 
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

public class Example2
{

 static class Test
 {
  static boolean debug = true;
  static boolean inputEnd = false;

  public Test(Scanner scr)
  {
   if (scr.nextInt() == 0)
   {
    inputEnd = true;
    return;
   }
  }

  public void run()
  {
  }

  void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static LinkedList<Test> test;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new LinkedList<Test>();
  while (true)
  {
   Test t = new Test(scr);
   if (Test.inputEnd) break;
   else test.add(t);
  }
  while (!test.isEmpty())
  {
   test.removeFirst().run();
  }
 }

}
