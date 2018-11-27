package sicauoj;

import java.util.Scanner;

/*
tm:
梧桐大道            --finish

ms:
在梧桐大道上，从北到南分别坐落着999棵梧桐树高度分别为 1, (1+2), (1+2+3),...,(1+2+3+...+999)米。
大雪过后，梧桐大道上被覆盖了积雪，对于两棵相邻的梧桐树，我们测量了它们的高度（从树顶到被覆盖了积雪的梧桐大道）分别为 a和 b米。
假定积雪的厚度在各处都是一样的，找出积雪的厚度。积雪厚度至少为一米。

sr:
1≤a<b<499500(=1+2+3+...+999)
所有输入数据均为正整数

sc:
输出积雪厚度

ei:
8 13

eo:
2

sl:
 */

public class Main008
{

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int tree1 = scr.nextInt(), tree2 = scr.nextInt();

  tree1 = tree2 - tree1;
  tree1 = (1 + tree1) * tree1 / 2;
  System.out.println(tree1 - tree2);

  scr.close();
 }

}
