package nyoj.top;

import java.util.Arrays;
import java.util.Scanner;

public class Main7_2
{

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int x[], y[], n = scr.nextInt(), minDist;

  while (n-- > 0)
  {
   x = new int[scr.nextInt()];
   y = new int[x.length];

   for (int i = 0; i < x.length; i++)
   {
    x[i] = scr.nextInt();
    y[i] = scr.nextInt();
   }

   Arrays.sort(x);
   Arrays.sort(y);

   minDist = 0;
   for (int i = 0; i < x.length / 2; i++)
   {
    minDist += x[x.length - 1 - i] - x[i] + y[x.length - 1 - i] - y[i];
   }
   System.out.println(minDist);

  }
  scr.close();
 }

}
