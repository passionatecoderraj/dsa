package com.raj.pramp;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a dictionary, write a function to flatten it. Consider the following input/output scenario for better understanding:
 * 
 * https://www.pramp.com/question/AMypWAprdmUlaP2gPVLZ
 */
public class BusinessTimeInTheMall {
	public static void main(String[] args) {

		BusinessTimeInTheMall obj = new BusinessTimeInTheMall();

	}

	enum Type {
		ENTRY, EXIT
	};

	class Record {
		int time;
		int count;
		Type type;
	}

	public void findBusiestType(Record[] records) {
		Arrays.sort(records, new Comparator<Record>() {
			public int compare(Record r1, Record r2) {
				return r1.time - r2.time;
			}
		});

		int start = 0, end = 0;
		int count = 0;
		int curBusiest = Integer.MIN_VALUE;
		int busiestStart = 0, busiestEnd = 0;
		for (Record rec : records) {
			if (rec.type == Type.ENTRY) {
				start = rec.time;
				count += rec.count;
			} else {
				end = rec.time;
				if (count > curBusiest) {
					curBusiest = count;
					busiestStart = start;
					busiestEnd = end;
				}
				count -= rec.count;
			}
		}
	}
}