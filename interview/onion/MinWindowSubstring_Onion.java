package com.interview.onion;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class MinWindowSubstring_Onion {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<Integer> subSequenceTags(List<String> availableList, List<String> targetList) {
		List<Integer> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String word : availableList) {
			map.compute(word, (key, value) -> {
				if (null == value) {
					value = 0;
				}
				return 1 + value;
			});
		}
		int left_result = -1, right_result = -1;
		int l = 0, minLen = Integer.MAX_VALUE;
		int counter = availableList.size();
		for (int r = 0; r < targetList.size(); r++) {
			String cur = targetList.get(r);
			if (map.containsKey(cur)) {
				if (map.get(cur) > 0) {
					counter--;
				}
				map.put(cur, map.get(cur) - 1);
			}

			while (counter == 0) {
				if (r - l < minLen) {
					minLen = r - l;
					left_result = l;
					right_result = r;
				}
				String left = targetList.get(l++);
				if (map.containsKey(left)) {
					map.put(left, map.get(left) + 1);
					if (map.get(left) == 1) {
						counter++;
					}
				}
			}
		}

		if (minLen == Integer.MAX_VALUE) {
			res.add(0);
		} else {
			res.add(left_result);
			res.add(right_result);
		}

		return res;
	}
	// METHOD SIGNATURE ENDS
}