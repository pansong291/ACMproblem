package nyoj.top;

import java.util.Scanner;

/*
 * tm: 喷水装置（一）      --finish
 * 
 * ms: 现有一块草坪，长为20米，宽为2米，要在横中心线上放置半径为Ri的喷水装置，
 * m   每个喷水装置的效果都会让以它为中心的半径为实数Ri(0<Ri<15)的圆被湿润，这有充足的喷水装置i（1<i<600)个，
 * m   并且一定能把草坪全部湿润，你要做的是：选择尽量少的喷水装置，把整个草坪的全部湿润。
 * 
 * sr: 第一行m表示有m组测试数据，每一组测试数据的第一行有一个整数数n，
 *     n表示共有n个喷水装置，随后的一行，有n个实数ri，ri表示该喷水装置能覆盖的圆的半径。
 * 
 * sc: 输出所用装置的个数
 * 
 * ei: 2
 *     5
 *     2 3.2 4 4.5 6 
 *     10
 *     1 2 3 1 2 1.2 3 1.1 1 2
 * 
 * eo: 2
 *     5
 * 
 * sl: 
 */

public class Main6
{

 static class Test
 {
  static boolean debug = true;
  float psr[];

  public Test(Scanner scr)
  {
   psr = new float[scr.nextInt()];
   scr.nextLine();
   for (int i = 0; i < psr.length; i++)
   {
    psr[i] = scr.nextFloat();
   }
  }

  float opPsr()
  {
   int maxInd = 0;
   float maxR = -1;
   for (int i = 1; i < psr.length; i++)
   {
    if (psr[maxInd] < psr[i]) maxInd = i;
   }
   maxR = psr[maxInd];
   psr[maxInd] = -1;
   return maxR;
  }

  public void run()
  {
   float len = 20;
   int count = 0;
   float maxR = -1;
   while (len > 0)
   {
    maxR = opPsr();
    if (maxR < 0) break;
    len -= Math.sqrt(Math.pow(maxR * 2, 2) - 4);
    count++;
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
