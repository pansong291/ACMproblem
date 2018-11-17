package sicauoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 括号匹配
 * 
 * ms: 现在有一串合法的括号，川牛将依次从左往右拿走一个左括号，与此同时你需要拿走一个右括号，
 * m   每次拿走之后剩下的需保证括号依然是合法的，直到取完所有括号，那么请问你有多少种不同的拿取方法呢？
 * m   （拿走不一样的括号即算一种）
 * 
 * sr: 第一行将输入一个整数N=(0,300]。随后将有N行测试用例，每一行都将给出一串合法的括号序列S，S的长度l=[2,200]。
 * 
 * sc: 输出每个测试用例一共有多少种拿法MOD 1000000007 的结果，各占一行。
 * 
 * ei: 3
 *     [][]
 *     [[]]
 *     [[[[]]]][][]
 * 
 * eo: 1
 *     2
 *     24
 * 
 * sl: 
 */

public class P040
{

 static class Test
 {
  boolean debug = true;
  LinkedList<Character> charList;
  int count = 0, total = 1;

  public Test(Scanner scr)
  {
   String line = scr.nextLine();
   charList = new LinkedList<Character>();
   for (int i = 0; i < line.length(); i++)
   {
    charList.add(line.charAt(i));
   }
  }

  public void run()
  {
   int i;
   while (charList.size() > 0)
   {
    charList.removeFirst();
    for (i = 0, count = 0; i < charList.size(); i++)
    {
     if (charList.get(i).equals(']'))
     {
      println("first] " + i);
      if (isCorrect(charList, i))
      {
       count++;
       println("count=" + count);
      }
     }
    }
    total *= count;
   }
   System.out.println(total);
  }

  boolean isCorrect(LinkedList<Character> cl, int i)
  {
   LinkedList<Character> cList = new LinkedList<Character>();
   char c;
   for (int j = 0; j < cl.size(); j++)
   {
    if (i == j) continue;
    c = cl.get(j);
    if (c == '[')
    {
     println("add [");
     cList.add(c);
    }else if (cList.isEmpty())
    {
     println("empty");
     return false;
    }else if (cList.getLast().equals('['))
    {
     println("close ]");
     cList.removeLast();
    }else
    {
     println("error " + c);
     break;
    }
   }
   return cList.size() == 0;
  }

  void println(Object o)
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
