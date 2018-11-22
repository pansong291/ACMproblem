package org.poj;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main2386
{
 static Robot rbt;

 static void clear()
 {
  try
  {
   if (rbt == null) rbt = new Robot();
   rbt.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键
   rbt.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键
   rbt.keyPress(KeyEvent.VK_CONTROL); // 按下Ctrl键
   rbt.keyPress(KeyEvent.VK_R); // 按下R键
   rbt.keyRelease(KeyEvent.VK_R); // 释放R键
   rbt.keyRelease(KeyEvent.VK_CONTROL); // 释放Ctrl键
   rbt.delay(100);
  }catch (Exception e)
  {
   e.printStackTrace();
  }
 }

 static void printField()
 {
  //clear();
  for (int i = 0; i < field.length; i++)
  {
   for (int j = 0; j < lie; j++)
   {
    System.out.print(field[i][j]);
   }
   System.out.println();
  }
  try
  {
   Thread.sleep(1000);
  }catch (InterruptedException e)
  {
   e.printStackTrace();
  }
 }

 //ps: 现在位置(x,y)
 static void dfs(int x, int y)
 {
  //ps: 将现在所在位置替换为.
  field[x][y] = '.';

  printField();

  //ps: 循环遍历移动的8个方向
  for (int dx = -1; dx <= 1; dx++)
  {
   for (int dy = -1; dy <= 1; dy++)
   {
    //ps: 向x方向移动dx，向y方向移动dy，移动的结果为（nx,ny）
    int nx = x + dx, ny = y + dy;
    //ps: 判断(nx,ny)是不是在园子内，以及是否有积水
    if (0 <= nx && nx < field.length && 0 <= ny && ny < lie && field[nx][ny] == 'W') dfs(nx, ny);
   }
  }
 }

 static char[][] field;
 static int lie;

 /*
 10 12
 W........WW.
 .WWW.....WWW
 ....WW...WW.
 .........WW.
 .........W..
 ..W......W..
 .W.W.....WW.
 W.W.W.....W.
 .W.W......W.
 ..W.......W.
 */
 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  field = new char[scr.nextInt()][];
  lie = scr.nextInt();
  String temp = scr.nextLine();
  for (int i = 0; i < field.length; i++)
  {
   field[i] = new char[lie];
   temp = scr.nextLine();
   for (int j = 0; j < lie; j++)
   {
    field[i][j] = temp.charAt(j);
   }
  }
  scr.close();

  int res = 0;
  for (int i = 0; i < field.length; i++)
  {
   for (int j = 0; j < lie; j++)
   {
    if (field[i][j] == 'W')
    {
     //ps: 从有W的地方开始dfs
     dfs(i, j);
     res++;
    }
   }
  }
  System.out.println(res);
 }

}
