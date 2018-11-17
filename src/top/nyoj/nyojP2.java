package top.nyoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 括号配对问题       --finish
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

public class nyojP2
{
 static class Test
 {
  boolean debug = false;
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
