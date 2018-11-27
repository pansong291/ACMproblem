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

public class Example2
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int inputEnd;

  while (true)
  {
   inputEnd = scr.nextInt();
   if (inputEnd == 0) break;
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
