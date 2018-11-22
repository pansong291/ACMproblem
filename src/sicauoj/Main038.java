package sicauoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 校园内的路灯       -Time Limit Exceeded
 * 
 * ms: 每条路一到天黑就开灯，一开就是一整夜，而电费按道路每米一天要花费1块钱。为了省钱要关掉一些街道的路灯。
 * m   为了确保教师和学生仍然感到安全，在夜晚一些街道变暗之后，在学校的每一个路口，
 * m   仍然会有至少一条照明的路径到其它任何一个路口。在不让川牛们感到不安全的情况下，学校可以节省的最大每日金额是多少?
 * 
 * sr: 输入包含若干测试用例。每个测试用例分别以两个数字m=[1,200000]和n=[m-1,200000]开始，
 * s   分别是学校内路口的数量和道路数量，当m=n=0时终止。接下来有n个整数三元组x=[0,m),y=[0,m),z
 * s   指定路口x和路口y之间有一条长度为z米的双向道路，且x!=y。
 * s   每个测试用例保证了任意两个路口之间一定有一条可达的路线。每个测试用例中所有道路的总长度小于231231。
 * 
 * sc: 每一个测试案例需要输出一行，表示学校每日可以节约的最高金额。
 * 
 * ei: 7 11
 *     0 1 7
 *     0 3 5
 *     1 2 8
 *     1 3 9
 *     1 4 7
 *     2 4 5
 *     3 4 15
 *     3 5 6
 *     4 5 8
 *     4 6 9
 *     5 6 11
 *     0 0
 * 
 * eo: 51
 * 
 * sl: 
 */

public class Main038
{
 static class Node
 {
  LinkedList<Road> roads = new LinkedList<Road>();
 }

 static class Road
 {
  Node n1, n2;
  int length;
  boolean isChecked = false;
 }

 static class Test
 {
  static boolean debug = false;
  static boolean inputEnd = false;
  Node[] node;
  Road[] road;

  public Test(Scanner scr)
  {
   int m, n; // ps: 路口和道路数量
   m = scr.nextInt();
   n = scr.nextInt();
   if (m == 0 && n == 0)
   {
    inputEnd = true;
    return;
   }
   scr.nextLine();
   node = new Node[m];
   road = new Road[n];
   int x, y, z; // ps: 路口编号xy和长度z
   for (int i = 0; i < road.length; i++)
   {
    x = scr.nextInt();
    y = scr.nextInt();
    z = scr.nextInt();
    if (node[x] == null) node[x] = new Node();
    if (node[y] == null) node[y] = new Node();
    road[i] = new Road();
    road[i].n1 = node[x];
    road[i].n2 = node[y];
    road[i].length = z;
    node[x].roads.add(road[i]);
    node[y].roads.add(road[i]);
    scr.nextLine();
   }
  }

  Road getMaxLengthRoad()
  {
   int theMaxIndex = -1;
   for (int i = 0; i < road.length; i++)
   {
    if (!road[i].isChecked)
    {
     theMaxIndex = i;
     break;
    }
   }
   if (theMaxIndex < 0) return null;
   for (int j = theMaxIndex + 1; j < road.length; j++)
   {
    if (road[j].isChecked) continue;
    if (road[theMaxIndex].length < road[j].length)
    {
     theMaxIndex = j;
    }
   }
   return road[theMaxIndex];
  }

  boolean canArrivedExcept(Road road)
  {
   LinkedList<Node> OPEN = new LinkedList<Node>();
   LinkedList<Node> CLOSED = new LinkedList<Node>();
   Node currentNode;
   Node nextNode;

   OPEN.add(road.n1);
   while (!OPEN.isEmpty())
   {
    currentNode = OPEN.removeFirst();
    CLOSED.add(currentNode);
    if (currentNode == road.n2) return true;
    for (Road r : currentNode.roads)
    {
     if (road == r) continue;
     if (r.n1 == currentNode) nextNode = r.n2;
     else nextNode = r.n1;
     if (CLOSED.contains(nextNode) || OPEN.contains(nextNode)) continue;
     OPEN.add(nextNode);
    }
   }
   return false;
  }

  public void run()
  {
   /*
   7 11
   0 1 7
   0 3 5
   1 2 8
   1 3 9
   1 4 7
   2 4 5
   3 4 15
   3 5 6
   4 5 8
   4 6 9
   5 6 11
   0 0
    */
   /*
   7 11
   -------0 0 1 7
   1 0 3 5
   -------2 1 2 8
   -------3 1 3 9
   4 1 4 7
   5 2 4 5
   -------6 3 4 15
   7 3 5 6
   -------8 4 5 8
   9 4 6 9
   -------10 5 6 11
   0 0
    */
   Road maxLenRoad;
   int c1, c2;
   int total = 0;
   while (true)
   {
    maxLenRoad = getMaxLengthRoad();
    if (maxLenRoad == null) break;
    maxLenRoad.isChecked = true;
    c1 = maxLenRoad.n1.roads.size();
    c2 = maxLenRoad.n2.roads.size();
    println("c1=" + c1 + ",c2=" + c2);
    if (c1 < 2 || c2 < 2)// ps: 这条路的路灯必须被保留
    {
     println(getIndexOfRoad(maxLenRoad) + "号路被保留,路口是" + getIndexOfNode(maxLenRoad.n1) + ","
       + getIndexOfNode(maxLenRoad.n2) + ",长度是" + maxLenRoad.length);
     continue;
    }
    if (!canArrivedExcept(maxLenRoad))
    {
     println(getIndexOfRoad(maxLenRoad) + "号路被保留,路口是" + getIndexOfNode(maxLenRoad.n1) + ","
       + getIndexOfNode(maxLenRoad.n2) + ",长度是" + maxLenRoad.length);
     continue;
    }
    println(getIndexOfRoad(maxLenRoad) + "号路被移除,路口是" + getIndexOfNode(maxLenRoad.n1) + ","
      + getIndexOfNode(maxLenRoad.n2) + ",长度是" + maxLenRoad.length);
    maxLenRoad.n1.roads.remove(maxLenRoad);
    maxLenRoad.n2.roads.remove(maxLenRoad);
    total += maxLenRoad.length;
   }
   System.out.println(total);
  }

  int getIndexOfNode(Node n)
  {
   for (int i = 0; i < node.length; i++)
   {
    if (n == node[i])
    {
     return i;
    }
   }
   return -1;
  }

  int getIndexOfRoad(Road r)
  {
   for (int i = 0; i < road.length; i++)
   {
    if (r == road[i])
    {
     return i;
    }
   }
   return -1;
  }

  static void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static LinkedList<Test> test;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new LinkedList<Test>();
  while (true)
  {
   Test t = new Test(scr);
   if (Test.inputEnd) break;
   else test.add(t);
  }
  while (!test.isEmpty())
  {
   test.removeFirst().run();
  }
 }

}
