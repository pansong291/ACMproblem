package sicauoj;

import java.util.Scanner;

/*
title:
一排椅子            --finish

description:
有一排n个椅子，0表示这个椅子没人坐，1表示这个椅子有人坐。定义“最大安排”的规则如下：
一、两个人不能相邻而坐
二、在满足上一条规则的情况下，再也坐不下人了
现给你一排椅子，判断是否是“最大安排”。

input:
第一行是一个整数n表示椅子的数量，1<=n<=1000。
第二行是由0和1组成的长度为n的字符串，表示椅子的状态。

output:
是“最大安排”则输出Yes，反之输出No。

sample input:
3
101

sample output:
Yes

sample input 2:
4
1011

sample output 2:
No

hint:
 */

public class Main004
{

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  scr.nextLine();
  String line = scr.nextLine();
  scr.close();
  if (line.contains("11") || line.contains("000") || line.startsWith("00") || line.endsWith("00")
    || line.length() < 2 && line.startsWith("0"))
  {
   System.out.println("No");
  }else
  {
   System.out.println("Yes");
  }
 }

}
