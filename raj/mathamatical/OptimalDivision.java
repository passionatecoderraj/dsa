/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         Given a list of positive integers, the adjacent integers will perform
 *         the float division. For example, [2,3,4] -> 2 / 3 / 4.
 * 
 *         However, you can add any number of parenthesis at any position to
 *         change the priority of operations. You should find out how to add
 *         parenthesis to get the maximum result, and return the corresponding
 *         expression in string format. Your expression should NOT contain
 *         redundant parenthesis.
 * 
 *         Example: Input: [1000,100,10,2] Output: "1000/(100/10/2)"
 *         Explanation: 1000/(100/10/2) = 1000/((100/10)/2) = 200 However, the
 *         bold parenthesis in "1000/((100/10)/2)" are redundant, since they
 *         don't influence the operation priority. So you should return
 *         "1000/(100/10/2)".
 * 
 *         Other cases: 1000/(100/10)/2 = 50 1000/(100/(10/2)) = 50
 *         1000/100/10/2 = 0.5 1000/100/(10/2) = 2
 */
public class OptimalDivision {

	/* @formatter:off
	 * 
	 * (100/10/2) will have two options (a) (100/10)/2 or (b)100/(10/2)
	 *  (a) (100/10)/2 is nothing but(100/10*2) because (100/10)/2=> (10/2) => 5 is also can be written as (100/20)
	 *  (b) 100/(10/2) is nothing but (2*100/2) because 100/(10/2)=> (200/10) => 20 is also can be written as (200/10)
	 *  putting brackets from second number maximizes the result
	 *  similarly, putting brackets from second to nth number maximizes the result 
	 */
	public String optimalDivision(int a[]) {
		StringBuilder result = new StringBuilder();
		if (a.length == 0 || a == null) {
			return result.toString();
		} else if (a.length == 1) {
			result.append(a[0]);
			return result.toString();
		} else if (a.length == 2) {
			result.append(a[0]);
			result.append("/");
			result.append(a[1]);
			return result.toString();
		}
		result.append(a[0]);
		result.append("/");
		result.append("(");
		for (int i = 1; i < a.length; i++) {
			result.append(a[i]);
			if (i != a.length - 1)
				result.append("/");
		}
		result.append(")");

		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OptimalDivision obj = new OptimalDivision();
		String res = null;
		int a[] = { 1000, 100, 10, 2 };
		res = obj.optimalDivision(a);
		System.out.println(res);
	}

}
