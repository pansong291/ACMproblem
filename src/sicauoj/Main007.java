package sicauoj;

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

public class Main007
{

 static class Apples
 {
  LinkedList<Integer> list = new LinkedList<Integer>();
  int sum = 0;

  void addApple(int i)
  {
   list.add(i);
   sum += i;
  }

  int removeLightApple()
  {
   int smallIndex = 0;
   for (int i = 1; i < list.size(); i++)
   {
    if (list.get(smallIndex) > list.get(i)) smallIndex = i;
   }
   smallIndex = list.remove(smallIndex);
   sum -= smallIndex;
   return smallIndex;
  }

  void print()
  {
   System.out.println("sum=" + sum);
   for (int i : list)
   {
    System.out.print(i + " ");
   }
   System.out.println();
  }

 }

 static void sort(int[] i)
 {
  int t;
  for (int j = i.length - 1; j > 0; j--)
  {
   for (int k = 0; k < j; k++)
   {
    if (i[k] < i[k + 1])
    {
     t = i[k];
     i[k] = i[k + 1];
     i[k + 1] = t;
    }
   }
  }
 }

 /*
 1 2 3 4 5
 5 2 1
 4 3
 7 3 1
 6 5
 */
 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int apple[] = new int[scr.nextInt()];
  for (int i = 0; i < apple.length; i++)
  {
   apple[i] = scr.nextInt();
  }
  scr.close();
  sort(apple);
  Apples ap1 = new Apples(), ap2 = new Apples();
  for (int i = 0; i < apple.length; i += 2)
  {
   if (ap1.sum < ap2.sum)
   {
    ap1.addApple(apple[i]);
    if (i + 1 < apple.length) ap2.addApple(apple[i + 1]);
   }else
   {
    ap2.addApple(apple[i]);
    if (i + 1 < apple.length) ap1.addApple(apple[i + 1]);
   }
  }
  //  ap1.print();
  //  ap2.print();
  int diff1 = Math.abs(ap1.sum - ap2.sum), diff2;

  if (ap1.sum > ap2.sum) ap2.addApple(ap1.removeLightApple());
  else ap1.addApple(ap2.removeLightApple());
  diff2 = Math.abs(ap1.sum - ap2.sum);
  //  ap1.print();
  //  ap2.print();

  //  System.out.println(diff1);
  //  System.out.println(diff2);
  System.out.println(Math.min(diff1, diff2));
 }
}
