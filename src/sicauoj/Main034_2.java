package sicauoj;

import java.util.Arrays;
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

public class Main034_2
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  scr.nextLine();

  char[] chs;

  while (testCount-- > 0)
  {
   chs = scr.nextLine().toCharArray();
   Arrays.sort(chs);
   int firstLowerCase = -1;
   for (int i = 0; i < chs.length; i++)
   {
    if (chs[i] >= 'a')
    {
     if (firstLowerCase < 0) firstLowerCase = i;
     System.out.print(chs[i]);
     if (firstLowerCase > 0 || i < chs.length - 1) System.out.print(' ');
    }
   }
   if (firstLowerCase < 0) firstLowerCase = chs.length;
   for (int j = 0; j < firstLowerCase; j++)
   {
    System.out.print(chs[j]);
    if (j < firstLowerCase - 1) System.out.print(' ');
   }
   System.out.println();
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }
}
