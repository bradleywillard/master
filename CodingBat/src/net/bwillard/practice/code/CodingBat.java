package net.bwillard.practice.code;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CodingBat {
	
	private String name;
	private boolean hasName;
	
	void method() {
		Runnable run = () -> System.out.println("Run"); System.out.println("2");
	}

	public static void main(String[] args) {
		CodingBat cb = new CodingBat();
		System.out.println("name="+ cb.name);
		System.out.println("hasName="+cb.hasName);
		// TODO Auto-generated method stub

		/*
		 * System.out.println(makeBricks(3, 1, 8));
		 * System.out.println(makeBricks(6, 0, 11));
		 * System.out.println(makeBricks(7, 1, 13));
		 * System.out.println(makeBricks(40, 2, 52));
		 * System.out.println(makeBricks(3, 2, 10));
		 * System.out.println(makeBricks(3, 2, 8));
		 * System.out.println(makeBricks(6, 1, 11));
		 * System.out.println(makeBricks(1, 4, 12));
		 * System.out.println(makeBricks(40, 2, 47));
		 * System.out.println(makeBricks(3, 2, 9));
		 * System.out.println(makeBricks(2, 1000000, 100003));
		 */

		// System.out.println(roundSum(16,12,13));
		// System.out.println(roundSum(16, 17, 18));
		// System.out.println(closeFar(1, 2, 3));
		// System.out.println(makeChocolate(6, 1, 10));
		// System.out.println(makeChocolate(60, 100, 550));
		// System.out.println(endOther("Hiabc", "abc"));
		// System.out.println(xyBalance("xaxxbbyx"));
		// System.out.println(mixString("2/", "27 around"));
		// System.out.println(starOut("ab**cd"));
		// System.out.println(plusOut("12xy34", "xy"));
		// System.out.println(plusOut("12xy34xyabcxy", "xy"));
		// System.out.println(wordEnds("XY123XY", "XY"));
		// System.out.println(wordEnds("abcXY123XYijk", "XY"));
		// System.out.println(countYZ("DAY abc XYZ"));
		// System.out.println(withoutString("This is a FISH", "IS"));
		// System.out.println(equalIsNot("isisnotno7Not"));
		// System.out.println(gHappy("xxgggxyg"));
		// System.out.println(gHappy("xxggxx"));
		// System.out.println(sameEnds("javaXYZjava"));
		// System.out.println(mirrorEnds("aba"));
		// System.out.println(maxBlock("abbCCCddBBBxx"));
		// System.out.println(maxBlock("xyzz"));
		// System.out.println(sumNumbers("aa11b33"));
		// System.out.println(notReplace("isis"));
		// int nums[] = {1, 2, 3, 4, 100};
		// System.out.println(centeredAverage(nums));
		/*
		 * int nums2[] = {2, 10, 3, 4, 20, 5}; int[] tenRunNums = tenRun(nums2);
		 * for(int i = 0; i < tenRunNums.length; i++)
		 * System.out.print(tenRunNums[i] +", ");
		 */
		/*int[] arr3 = { 2, 4, 1, 2 };
		System.out.println(post4(arr3));*/
		/*int[] arr4 = {1, 0, 0, 1};
		System.out.println(zeroFront(arr4));*/
		/*int[] arr5 = {1, 0, 1, 0, 0, 1, 1};
		System.out.println(evenOdd(arr5));*/
		//fizzBuzz(1, 6);
		//int[] arr = {1, 3, 1, 4, 4, 3, 1};
		//fix34(arr);
		//int[] arr = {10, 10, 1};
		//canBalance(arr);
		//squareUp(3);
		//int[] outer = {1, 2, 4, 6}, inner = {2, 3, 4};
		//linearIn(outer, inner);
		method1a();
		
	}
	
	public static void method1a() {
		String s = "Java";
		s = s.concat(" SE 6");
		s = s.replace('6','7');
		System.out.print(s);
	
	}
	
	public static int[] fix34(int[] nums) {
	    for(int i = 0; i < nums.length - 1; i++) {
	        int rThree = -1, temp = -1;
	        if(nums[i] == 3) {
	            rThree = nums[i+1];
	            if(rThree != 4) {
	                for(int j = i; j < nums.length; j++) {
	                    if(nums[j] == 4) {
	                        temp = nums[j];
	                        nums[j] = rThree;
	                        nums[i+1] = temp;
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    return nums;
	}
	
	public static boolean linearIn(int[] outer, int[] inner) {
	    boolean good = false;
	    if(inner.length == 0) return true;
	    for(int i = 0; i < inner.length; i++) {
	        for(int j = 0; j < outer.length; j++) {
	            if(inner[i] == outer[j]) {
	                good = true;
	                break;
	            } else{
	                good = false;
	            }
	            if(j == outer.length - 1 && good == false)
	            	return false;
	        }
	    }
	    return good;
	}

	public static int[] squareUp(int n) {
	    int[] arr = new int[n*n];
	    int[] sub = new int[-2];
	    for(int i = 1; i <= n; i++) {
	    	if(Math.abs(i-n) > i) {
	    		sub[i - 1] = 0;
	    	} else {
	    		sub[i - 1] = i;
	    	}
	    }
	    
	    return sub;
	}
	static int back, front;
	public static boolean canBalance(int[] nums) {
		
	    for(int i = 0; i < nums.length; i++) {
	    	int left = 0, right = 0;
	        for(int j = 0; j <= i; j++) {
	            left += nums[j];
	        }
	        for(int k = nums.length - 1; k > i; k--) {
	            right += nums[k];
	        } 
	        if(left == right) return true;
	    }
	    System.out.println("back" + back);
	    System.out.println("front" + front);
	    return false;
	}

	
	
	public static String[] fizzBuzz(int start, int end) {
	    String[] sArr = new String[end - start];
	    for(int i = start; i < end; i++) {
	        if(i % 3 == 0 && i % 5 == 0)
	            sArr[i - start] = "FizzBuzz";
	        else if(i % 3 == 0)
	            sArr[i - start] = "Fizz";
	        else if(i % 5 == 0)
	            sArr[i - start] = "Buzz";
	        else
	            sArr[i - start] = String.valueOf(i);
	    }
	    return sArr;
	}

	public static int[] evenOdd(int[] nums) {
		int left = 0, right = 0, len = nums.length;
	    int[] nums2 = new int[len];
	    for(int i = 0; i < len; i++) {
	        if(nums[i] % 2 == 0) {
	        	nums2[left] = nums[i];
	        	left++;
	        } else {
	        	nums2[len - 1 - right] = nums[i];
	        	right++;
	        }
	    }
	    return nums2;
	}

	
	public static int[] withoutTen(int[] nums) {
		int[] noTens = new int[nums.length];
		int count = 0;
	    for(int i = 0; i < nums.length; i++) {
	    	if(nums[i] != 10) {
	    		noTens[count] = nums[i];
	    		count++;
	    	}
	    }
	    
	    return noTens;
	}

	public static int[] zeroFront(int[] nums) {
		int[] arr = new int[nums.length];
		int zeros = 0, nonZeros = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				arr[zeros] = nums[i];
				zeros++;
			} else {
				arr[arr.length - 1 - nonZeros] = nums[i];
				nonZeros++;
			}
		}
		return arr;
	}

	public static int[] post4(int[] nums) {
		int len = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] == 4)
				break;
			else
				len++;
		}
		int[] arr = new int[len];
		int j = 0;
		for (int i = nums.length - len; i < nums.length; i++) {
			arr[j] = nums[i];
			j++;
		}
		return arr;
	}

	public int[] pre4(int[] nums) {
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] == 4)
				break;
		}
		int[] arr = new int[i];
		for (int j = 0; j < arr.length; j++)
			arr[j] = nums[j];

		return arr;
	}

	public static int[] tenRun(int[] nums) {
		boolean changeOn = false;
		int multiple = -1;
		for (int i = 0; i < nums.length; i++) {
			if (!changeOn && nums[i] % 10 == 0) {
				changeOn = true;
				multiple = nums[i];
				continue;
			} else if (changeOn) {
				if (nums[i] % 10 != 0) {
					nums[i] = multiple;
				} else {
					multiple = nums[i];
				}
			}
		}
		return nums;
	}

	public static int centeredAverage(int[] nums) {
		int sum = 0, smallest = nums[0], largest = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < smallest)
				smallest = nums[i];
			if (nums[i] > largest)
				largest = nums[i];
			sum += nums[i];
		}
		return (sum - largest - smallest) / (nums.length - 2);
	}

	public static String notReplace(String str) {
		if (str.length() < 2 || !str.contains("is"))
			return str;
		else if ("is".equals(str))
			return "is not";
		List<String> chunks = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			if (i <= str.length() - 2 && "is".equals(str.substring(i, i + 2))) {
				chunks.add("is");
				if (i == 0) {
					if (!Character.isLetter(str.charAt(i + 2))) {
						chunks.add(" not");
					}
				} else if (i == str.length() - 2) {
					if (!Character.isLetter(str.charAt(i - 1))) {
						chunks.add(" not");
					}
				} else if (i > 0 && i < str.length() - 2) {
					if (!Character.isLetter(str.charAt(i - 1))
							&& !Character.isLetter(str.charAt(i + 2))) {
						chunks.add(" not");
					}
				}

				i += 1;
			} else {
				chunks.add(str.substring(i, i + 1));
			}
		}
		String result = "";
		for (int i = 0; i < chunks.size(); i++) {
			result += chunks.get(i);
		}
		return result;
	}

	public static int sumNumbers(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			String intStr = "";
			if (Character.isDigit(c1)) {
				intStr += c1;
				int j;
				for (j = i + 1; j < str.length(); j++) {
					char c2 = str.charAt(j);
					if (Character.isDigit(c2))
						intStr += c2;
					else
						break;
				}
				i = j;
				sum += Integer.parseInt(intStr);
			}
		}
		return sum;
	}

	public static int maxBlock(String str) {
		if (str.length() < 2)
			return str.length();
		String block = "";
		for (int i = 0; i < str.length(); i++) {
			String first = str.substring(i, i + 1);
			String temp = first;
			for (int j = i + 1; j < str.length(); j++) {
				String next = str.substring(j, j + 1);
				if (first.equals(next))
					temp += next;
				else
					break;
			}
			if (temp.length() > block.length())
				block = temp;
		}
		return block.length();
	}

	public static String mirrorEnds(String string) {
		String rev = "";
		int count = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			rev += string.substring(i, i + 1);
		}
		for (int i = 0; i < string.length(); i++) {
			char c1 = string.charAt(i);
			char c2 = rev.charAt(i);
			if (c1 != c2) {
				break;
			} else {
				count++;
			}
		}

		return string.substring(0, count);
	}

	public static String sameEnds(String string) {
		int mid = string.length() / 2;
		if (string.length() <= 3) {
			if (string.length() <= 1) {
				return "";
			} else if (string.length() == 3
					&& string.charAt(0) == string.charAt(2)) {
				return string.substring(0, 1);
			}
		}
		for (int i = 0; i < mid; i++) {
			String front = string.substring(0, mid - i);
			int backstart = string.length() % 2 == 1 ? mid + 1 : mid;
			String back = string.substring(backstart + i, string.length());
			if (front.equals(back)) {
				return front;
			}

		}
		return "";
	}

	public static boolean gHappy(String str) {
		int len = str.length();
		if (len < 2 && !"g".equals(str))
			return true;
		else if ("g".equals(str))
			return false;
		boolean happy = false;
		for (int i = 0; i < len; i++) {
			String ltr = str.substring(i, i + 1);

			if ("g".equals(ltr)) {
				if (i == 0 && str.charAt(i + 1) == 'g') {
					happy = true;
				} else if (i == len - 1 && str.charAt(i - 1) == 'g') {
					happy = true;
				} else if (i < len - 1
						&& (str.charAt(i - 1) == 'g' || str.charAt(i + 1) == 'g')) {
					happy = true;
				} else {
					return false;
				}
			}
		}
		return happy;
	}

	public static boolean equalIsNot(String str) {
		int isCount = 0, notCount = 0, len = str.length();
		for (int i = 0; i <= len - 2; i++) {
			String sub = str.substring(i, i + 2);
			if ("is".equals(sub))
				isCount++;
		}
		for (int i = 0; i <= len - 3; i++) {
			String sub = str.substring(i, i + 3);
			if ("not".equals(sub))
				notCount++;
		}
		return isCount == notCount;
	}

	public static String withoutString(String base, String remove) {
		StringBuilder sb = new StringBuilder();
		int bl = base.length(), rl = remove.length();
		for (int i = 0; i < bl; i++) {
			if (i <= bl - rl
					&& remove.equalsIgnoreCase(base.substring(i, i + rl))) {
				i += rl - 1;
			} else {
				sb.append(base.substring(i, i + 1));
			}
		}
		return sb.toString();
	}

	public static int countYZ(String str) {
		int count = 0, len = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= len; i++) {
			if (i < len && Character.isLetter(str.charAt(i))) {
				sb.append(str.charAt(i));
			} else {
				if (sb.length() > 0
						&& ("y".equalsIgnoreCase(sb.substring(sb.length() - 1)) || "z"
								.equalsIgnoreCase(sb.substring(sb.length() - 1)))) {
					count++;
					sb = new StringBuilder();
				}
			}
		}
		return count;
	}

	public static String wordEnds(String str, String word) {
		StringBuilder sb = new StringBuilder();
		int sl = str.length(), wl = word.length();
		for (int i = 0; i <= sl - wl; i++) {
			if (word.equals(str)) {
				return "";
			} else if (word.equals(str.substring(i, i + wl))) {
				if (i == 0) {
					sb.append(str.substring(i + wl, i + wl + 1));
				} else if (i < sl - wl) {
					sb.append(str.substring(i - 1, i));
					sb.append(str.substring(i + wl, i + wl + 1));
				} else if (i == sl - wl) {
					sb.append(str.substring(i - 1, i));
				}
			}
		}

		return sb.toString();
	}

	public static String plusOut(String str, String word) {
		StringBuilder sb = new StringBuilder();
		int wl = word.length(), sl = str.length();
		for (int i = 0; i < sl; i++) {
			if (i <= sl - wl && word.equals(str.substring(i, i + wl))) {
				sb.append(word);
				i += wl - 1;
			} else {
				sb.append("+");
			}
		}
		return sb.toString();
	}

	public static String starOut(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			boolean isStar = str.charAt(i) == '*';
			boolean lastIsStar = i > 0 && str.charAt(i - 1) == '*';
			boolean nextIsStar = i < str.length() - 1
					&& str.charAt(i + 1) == '*';
			if (!isStar && !nextIsStar && !lastIsStar) {
				sb.append(str.substring(i, i + 1));
			}
		}
		return sb.toString();
	}

	public static String zipZap(String str) {
		if (str.length() < 3) {
			return str;
		} else {
			StringBuilder sb = new StringBuilder();
			int len = str.length();
			for (int i = 0; i < len; i++) {
				String s = str.substring(i, len);
				if (s.length() < 3) {
					sb.append(s);
					break;
				} else {
					if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
						sb.append("zp");
						i += 2;
					} else {
						sb.append(str.substring(i, i + 1));
					}
				}
			}
			return sb.toString();
		}
	}

	public static String oneTwo(String str) {
		StringBuilder sb = new StringBuilder();
		if (str.length() >= 3) {
			for (int i = 0; i <= str.length() - 3; i += 3) {
				String lastTwo = str.substring(i + 1, i + 3);
				String firstOne = str.substring(i, i + 1);
				sb.append(lastTwo).append(firstOne);
			}
		}
		return sb.toString();
	}

	public static boolean sameStarChar(String str) {
		boolean starValid = true;
		if (!str.contains("*"))
			return true;
		for (int i = 0; i < str.length(); i++) {
			boolean isStar = str.charAt(i) == '*';
			if (isStar) {
				if (i == 0 || i == str.length() - 1) {
					starValid = true;
				} else if (str.charAt(i - 1) == str.charAt(i + 1)) {
					starValid = true;
				} else {
					return false;
				}
			}
		}
		return starValid;
	}

	public static String getSandwich(String str) {
		int start = -1, end = -1;
		for (int i = 0; i < str.length() - 5; i++) {
			String sub = str.substring(i, i + 5);
			if ("bread".equals(sub)) {
				start = i + 5;
				for (int j = start; j < str.length() - 4; j++) {
					String sub2 = str.substring(j, j + 5);
					if ("bread".equals(sub2)) {
						end = j;
						String result = str.substring(start, end);
						if (result.length() == 0 || "bread".equals(result))
							continue;
						else
							return result;

					}
				}
			}
		}
		return "";
	}

	public static boolean xyzMiddle(String str) {
		if (str.length() < 3)
			return false;
		else if (str.length() == 3 && "xyz".equals(str))
			return true;
		int mid = str.length() / 2;
		for (int i = mid - 2; i < mid; i++) {
			String sub = str.substring(i, i + 3);
			if ("xyz".equals(sub)) {
				String left = str.substring(0, i);
				String right = str.substring(i + 3, str.length());
				int diff = Math.abs(right.length() - left.length());
				if (diff == 0 || diff == 1)
					return true;
			}
		}
		return false;
	}

	public static boolean prefixAgain(String str, int n) {
		String sub = str.substring(0, n);
		for (int i = n; i < str.length() - n; i++) {
			String sub2 = str.substring(i, i + n);
			if (sub.equals(sub2))
				return true;
		}
		return false;
	}

	public static String repeatFront(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 0; i--) {
			sb.append(str.substring(0, i));
		}
		return sb.toString();
	}

	public static String mixString(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		StringBuilder result = new StringBuilder();
		if (aLen <= bLen) {
			int i = 0;
			for (; i < aLen; i++) {
				result.append(a.charAt(i)).append(b.charAt(i));
			}
			if (aLen < bLen)
				result.append(b.substring(i));
		} else {
			int i = 0;
			for (; i < bLen; i++) {
				result.append(a.charAt(i)).append(b.charAt(i));
			}
			result.append(a.substring(i));
		}
		return result.toString();
	}

	public static boolean xyBalance(String str) {
		boolean balanced = true, x = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'x') {
				x = true;
				balanced = false;
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(j) == 'y') {
						balanced = true;
						break;
					}
				}
			}
		}
		return balanced || !x;
	}

	public static boolean endOther(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		String aEnd = "", bEnd = "";
		if (aLen > bLen) {
			aEnd = a.substring(aLen - bLen);
			if (aEnd.equals(b))
				return true;
		} else {
			bEnd = b.substring(bLen - aLen);
			if (bEnd.equals(a))
				return true;
		}
		return false;
	}

	public static int makeChocolate(int small, int big, int goal) {
		if (big * 5 + small < goal)
			return -1;
		else if (small < goal % 5)
			return -1;
		else {
			int portionForSmalls = goal - (big * 5);
			if (portionForSmalls >= 5)
				return portionForSmalls;
			else
				return goal % 5;
		}

	}

	public static boolean closeFar(int a, int b, int c) {
		if (Math.abs(a - b) <= 1)
			if (Math.abs(a - c) > 1)
				return true;
		if (Math.abs(a - c) <= 1)
			if (Math.abs(a - b) > 1)
				return true;
		return false;
	}

	public static int roundSum(int a, int b, int c) {
		return round10(a) + round10(b) + round10(c);
	}

	public static int round10(int num) {
		int rem = num % 10;
		if (rem >= 5)
			num += 10 - rem;
		else
			num -= rem;
		return num;
	}

	public static boolean makeBricks(int small, int big, int goal) {
		int capacity = big * 5 + small;
		int remainder = goal % 5;
		int neededBigs = goal / 5;
		// Do we have enough bricks overall and do we have enough small
		// bricks?...
		if (capacity > goal || small < remainder)
			return false;
		else if (big >= neededBigs)
			return true;
		// Otherwise, check if the smalls can accommodate where we didn't have
		// enough big bricks as well as covering the needed small bricks...
		else if (small >= goal - big * 5)
			return true;

		return false;
	}

}
