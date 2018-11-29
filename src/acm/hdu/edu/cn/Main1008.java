package acm.hdu.edu.cn;

import java.util.Scanner;

/*
title:
Elevator            --finish

description:
The highest building in our city has only one elevator. A request list is made up with N positive numbers.
The numbers denote at which floors the elevator will stop, in specified order.
It costs 6 seconds to move the elevator up one floor, and 4 seconds to move down one floor.
The elevator will stay for 5 seconds at each stop.
For a given request list, you are to compute the total time spent to fulfill the requests on the list.
The elevator is on the 0th floor at the beginning and does not have to return to the ground floor when the requests are fulfilled.

input:
There are multiple test cases. Each case contains a positive integer N, followed by N positive numbers.
All the numbers in the input are less than 100. A test case with N = 0 denotes the end of input. This test case is not to be processed.

output:
Print the total time on a single line for each test case.

sample input:
1 2
3 2 3 1
0

sample output:
17
41

hint:
 */

public class Main1008
{
 static boolean debug = true;

 static class Elevator
 {
  int spendTime = 0;
  int currentFloor = 0;

  void moveTo(int floor)
  {
   int t;
   if (floor > currentFloor)
   {
    t = floor - currentFloor;
    t *= 6;
   }else
   {
    t = currentFloor - floor;
    t *= 4;
   }
   spendTime += t + 5;
   currentFloor = floor;
  }

  void reset()
  {
   spendTime = 0;
   currentFloor = 0;
  }
 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int N;
  Elevator elevator = new Elevator();

  while (true)
  {
   N = scr.nextInt();
   if (N == 0) break;

   for (; N > 0; N--)
    elevator.moveTo(scr.nextInt());
   System.out.println(elevator.spendTime);
   elevator.reset();
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
