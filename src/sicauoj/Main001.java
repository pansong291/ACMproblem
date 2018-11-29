package sicauoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
title:

description:

input:

output:

sample input:

sample output:

hint:
 */

public class Main001
{

 static LinkedList<Integer> res;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  res = new LinkedList<Integer>();

  while (true)
  {
   try
   {
    res.add(scr.nextInt() + scr.nextInt());
   }catch (Exception e)
   {
    scr.close();
    break;
   }
  }
  while (res.size() > 0)
  {
   System.out.println(res.removeFirst());
  }
 }

}
