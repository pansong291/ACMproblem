package top.nyoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 括号配对问题       --finish
 * 
 * ms: 现在，有一行括号序列，请你检查这行括号是否配对。
 * 
 * sr: 第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，
 * s   每组输入数据都是一个字符串S(S的长度小于10000，且S不是空串），测试数据组数少于5组。数据保证S中只含有"[", "]", "(", ")" 四种字符
 * 
 * sc: 每组输入数据的输出占一行，如果该字符串中所含的括号是配对的，则输出Yes,如果不配对则输出No
 * 
 * ei: 3
 *     [(])
 *     (])
 *     ([[]()])
 * 
 * eo: No
 *     No
 *     Yes
 * 
 * sl: 
 */

public class Main2
{
 static class Test
 {
  static boolean debug = false;
  String line;
  LinkedList<Character> charList = new LinkedList<Character>();

  public Test(Scanner scr)
  {
   line = scr.nextLine();
  }

  public void run()
  {
   Character c;
   for (int i = 0; i < line.length(); i++)
   {
    c = line.charAt(i);
    if (c == '(' || c == '[')
    {
     println("add " + c);
     charList.add(c);
    }else if (charList.isEmpty())
    {
     println("empty");
     System.out.println("No");
     return;
    }else if (getAnother(c).equals(charList.getLast()))
    {
     println("op " + charList.getLast());
     charList.removeLast();
    }else
    {
     println("error " + c);
     break;
    }
   }
   if (charList.size() == 0) System.out.println("Yes");
   else System.out.println("No");
  }

  Character getAnother(Character ch)
  {
   switch (ch)
   {
    case '(':
     return ')';
    case ')':
     return '(';
    case '[':
     return ']';
    case ']':
     return '[';
    default:
     return null;
   }
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
