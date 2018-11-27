package test;

public class Main
{

 public static void main(String[] args)
 {
  long startTime = System.currentTimeMillis();
  test1(3000);
  System.out.printf("%dms\n", System.currentTimeMillis() - startTime);
  startTime = System.currentTimeMillis();
  test2(3000);
  System.out.printf("%dms\n", System.currentTimeMillis() - startTime);
 }

 static void test1(int n)
 {
  //  int n = 50;//素数查找上限，即素数查找范围是2到50，左闭右开
  int count = 0;//素数个数
  int[] num = new int[n];//素数的集合
  double sqrt;//某数的平方根
  for (int i = 2; i < n; i++)
  {
   //   System.out.println("正在检查" + i + ",素数已有" + count + "个");
   num[count++] = i;//不管是不是素数，先放进素数集合，素数个数加1
   sqrt = Math.sqrt(i);//得到它的平方根
   if (num[0] > sqrt) System.out.print(i + " ");
   for (int j = 0; num[j] <= sqrt; j++)
   {
    if (i % num[j] == 0)//如果不是素数
    {
     count--;//素数个数减1
     //     System.out.println(i + "%" + num[j] + "=0,非素数，素数已有" + count + "个");
     break;
    }else if (num[j + 1] > sqrt)//如果是素数
    {
     System.out.print(i + " ");
     //     System.out.println(i + "%" + num[j] + "≠0,是素数,素数已有" + count + "个");
     //    }else//不能确定是不是素数
     //    {
     //     System.out.println(i + "%" + num[j] + "≠0");
    }
   }
  }
  System.out.println();
 }

 static void test2(int n)
 {
  //  int n = 50;
  int[] list = new int[n], num = new int[n];
  for (int i = 2; i < list.length; i++)
  {
   list[i] = i;
  }

  for (int i = 2; i < list.length; i++)
  {
   if (list[i] <= 0) continue;
   list[i] = 0;
   num[i] = i;
   for (int j = i + 1; j < list.length; j++)
   {
    if (list[j] <= 0) continue;
    if (j % i == 0) list[j] = 0;
   }
  }

  for (int i : num)
  {
   if (i > 0) System.out.print(i + " ");
  }
  System.out.println();
 }

}
