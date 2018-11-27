import java.util.Scanner;

/*
tm:

ms:

sr:

sc:

ei:

eo:

sl:
 */

public class Example
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();

  while (testCount-- > 0)
  {
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
