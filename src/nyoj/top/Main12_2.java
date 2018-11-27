package nyoj.top;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * tm: 喷水装置（二）          --finish
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

public class Main12_2
{
 static boolean debug = false;
 static int w, h;
 static Round round[];
 static final RoundComparator roundComparator = new RoundComparator();

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  float start;
  int selectCount, first;
  Round best;

  while (testCount-- > 0)
  {
   round = new Round[scr.nextInt()];
   w = scr.nextInt();
   h = scr.nextInt();
   for (int i = 0; i < round.length; i++)
   {
    round[i] = new Round(scr.nextInt(), scr.nextInt());
   }

   start = 0;
   selectCount = 0;
   first = 0;
   best = null;

   Arrays.sort(round, roundComparator);

   while (start < w)
   {
    for (int i = first; i < round.length; i++)
    {
     if (round[i].right <= start)
     {
      first = i + 1;
      continue;
     }
     if (round[i].left > start)
     {
      first = i;
      break;
     }
     if (best == null || best.right < round[i].right)
     {
      best = round[i];
     }
    }
    if (best == null) break;
    start = best.right;
    logPrintln("已选:" + best.x);
    selectCount++;
    best = null;
   }

   if (start < w) selectCount = 0;
   System.out.println(selectCount);

  }

  scr.close();
 }

 static class Round
 {
  int x, r;
  float left, right; // 能够覆盖到的x范围
  float xlen; // 覆盖宽度
  //  boolean checked = false; // 已被选中
  //  boolean outed = false; // 已被排除

  public Round(int x, int r)
  {
   this.x = x;
   this.r = r;
   if (2 * r <= h)
   {
    xlen = 0;
    left = right = x;
   }else
   {
    xlen = (float) Math.sqrt(4 * r * r - h * h) / 2;
    left = x - xlen;
    right = x + xlen;
    if (left < 0) left = 0;
    if (right > w) right = w;
    xlen = right - left;
   }
  }
 }

 static class RoundComparator implements Comparator<Round>
 {
  @Override
  public int compare(Round o1, Round o2)
  {
   if (o1.left < o2.left)
   {
    return -1;
   }else if (o1.left > o2.left)
   {
    return 1;
   }else if (o1.right > o2.right)
   {
    return -1;
   }else if (o1.right < o2.right)
   {
    return 1;
   }
   return 0;
  }
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
