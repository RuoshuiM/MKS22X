# Class: Recursion
Includes methods to:

  * [calculate fibbonaci number](#fib)
  * [make Sums](#makeallsums)
  * For recursive square root, see [Class: RecursiveSqrt](#class-recursivesqrt)
  
## fib
The default method only works for n < 93. After that, the output overflows a long. The method computes fib recursively by working from 0 up to n, and thus it should be linear time.

	public static long fib(int n)

A better recursive implementation has no integer overflow problem. But stack overflow does occur. On my home laptop, it occurs around n = 9840.

	public static BigInteger betterFib(int n)

Both of the recursive implementation use one other helper function.
The looping version has no overflow problem, because loop does not use extra stacks. However, the output can be too large that it can't be printed out by System.out.println(). The largest tested n that works is 21000.

	public static BigInteger loopFib(int n)
	
## makeAllSums
This method follow all class requirements

	public static List<Integer> makeAllSums(int n)
	
# Class: RecursiveSqrt
For a tolerance of 0.001%, use:

	public static double sqrt(double n)
	
To specify your own tolerance, use:

	public static double sqrt(double n, double tolerance)
	