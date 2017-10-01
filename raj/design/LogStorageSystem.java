package com.raj.design;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Raj
 *
 *         You are given several logs that each log contains a unique id and
 *         timestamp. Timestamp is a string that has the following format:
 *         Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59.
 *         All domains are zero-padded decimal numbers.
 * 
 *         Design a log storage system to implement the following functions:
 * 
 *         void Put(int id, string timestamp): Given a log's unique id and
 *         timestamp, store the log in your storage system.
 * 
 * 
 *         int[] Retrieve(String start, String end, String granularity): Return
 *         the id of logs whose timestamps are within the range from start to
 *         end. Start and end all have the same format as timestamp. However,
 *         granularity means the time level for consideration. For example,
 *         start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59",
 *         granularity = "Day", it means that we need to find the logs within
 *         the range from Jan. 1st 2017 to Jan. 2nd 2017.
 * 
 *         Example 1: put(1, "2017:01:01:23:59:59"); put(2,
 *         "2017:01:01:22:59:59"); put(3, "2016:01:01:00:00:00");
 *         retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); //
 *         return [1,2,3], because you need to return all logs within 2016 and
 *         2017. retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
 *         // return [1,2], because you need to return all logs start from
 *         2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the
 *         range. Note: There will be at most 300 operations of Put or Retrieve.
 *         Year ranges from [2000,2017]. Hour ranges from [00,23]. Output for
 *         Retrieve has no order required.
 **/
public class LogStorageSystem {

	static class LogStorageSystemUsingStringComparision {
		static Map<String, Integer> map = new HashMap<>();

		static {
			map.put("Year", 4);
			map.put("Month", 7);
			map.put("Day", 10);
			map.put("Hour", 13);
			map.put("Minute", 16);
			map.put("Second", 19);
		}

		List<String[]> timestamps = new LinkedList<>();

		// Time : O(1)
		public void put(int id, String timestamp) {
			timestamps.add(new String[] { Integer.toString(id), timestamp });
		}

		// Time : O(n)
		public List<Integer> retrieve(String start, String end, String granularity) {
			List<Integer> result = new ArrayList<>();

			int idx = map.get(granularity);
			for (String[] ts : timestamps) {
				if (ts[1].substring(0, idx).compareTo(start.substring(0, idx)) >= 0
						&& ts[1].substring(0, idx).compareTo(end.substring(0, idx)) <= 0) {
					result.add(parseInt(ts[0]));
				}
			}
			return result;
		}
	}

	static class LogStorageSystemUsingMap {
		TreeMap<Long, Integer> map = new TreeMap<>();

		// Time : O(logn)
		public void put(int id, String timestamp) {
			int[] ts = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
			map.put(convertToLongTimeStamp(ts), id);
		}

		// Time :O(1)
		public long convertToLongTimeStamp(int[] st) {
			st[1] = st[1] - (st[1] == 0 ? 0 : 1);
			st[2] = st[2] - (st[2] == 0 ? 0 : 1);
			// Since, we know that the Year's value can start from 2000 only, we
			// subtract 1999 from the Year's value before doing the conversion
			// of the given timestamp into seconds.
			return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60
					+ st[3] * 60 * 60 + st[4] * 60 + st[5];
		}

		// Time : O(start)
		public List<Integer> retrieve(String s, String e, String gra) {
			ArrayList<Integer> res = new ArrayList<>();
			long start = granularity(s, gra, false);
			long end = granularity(e, gra, true);
			for (long key : map.tailMap(start).keySet()) {
				if (key >= start && key < end)
					res.add(map.get(key));
			}
			return res;
		}

		// Time :O(1)
		public long granularity(String s, String gra, boolean end) {
			HashMap<String, Integer> h = new HashMap<>();
			h.put("Year", 0);
			h.put("Month", 1);
			h.put("Day", 2);
			h.put("Hour", 3);
			h.put("Minute", 4);
			h.put("Second", 5);
			String[] res = new String[] { "1999", "00", "00", "00", "00", "00" };
			String[] st = s.split(":");
			for (int i = 0; i <= h.get(gra); i++) {
				res[i] = st[i];
			}
			int[] t = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
			if (end)
				t[h.get(gra)]++;
			return convertToLongTimeStamp(t);
		}

	}

	static class LogStorageSystemUsingLongComparision {
		List<long[]> timestamps = new ArrayList<long[]>();

		// Time :O(1)
		public void put(int id, String timestamp) {
			int[] st = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
			timestamps.add(new long[] { convertToLongTimeStamp(st), id });
		}

		// Time :O(1)
		public long convertToLongTimeStamp(int[] st) {
			st[1] = st[1] - (st[1] == 0 ? 0 : 1);
			st[2] = st[2] - (st[2] == 0 ? 0 : 1);
			return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60
					+ st[3] * 60 * 60 + st[4] * 60 + st[5];
		}

		// Time :O(n)
		public List<Integer> retrieve(String s, String e, String gra) {
			ArrayList<Integer> res = new ArrayList<>();
			long start = granularity(s, gra, false);
			long end = granularity(e, gra, true);
			for (int i = 0; i < timestamps.size(); i++) {
				if (timestamps.get(i)[0] >= start && timestamps.get(i)[0] < end)
					res.add((int) timestamps.get(i)[1]);
			}
			return res;
		}

		// Time :O(1)
		public long granularity(String s, String gra, boolean end) {
			HashMap<String, Integer> h = new HashMap<>();
			h.put("Year", 0);
			h.put("Month", 1);
			h.put("Day", 2);
			h.put("Hour", 3);
			h.put("Minute", 4);
			h.put("Second", 5);
			String[] res = new String[] { "1999", "00", "00", "00", "00", "00" };
			String[] st = s.split(":");
			for (int i = 0; i <= h.get(gra); i++) {
				res[i] = st[i];
			}
			int[] t = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
			if (end)
				t[h.get(gra)]++;
			return convertToLongTimeStamp(t);
		}

	}

	public static void main(String[] args) {
		LogStorageSystemUsingMap obj = new LogStorageSystemUsingMap();
		obj.put(1, "2017:01:01:23:59:59");
		obj.put(2, "2017:01:01:22:59:59");
		obj.put(3, "2016:01:01:00:00:00");

		List<Integer> result = null;
		result = obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
		System.out.println(result);
		result = obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
		System.out.println(result);

	}

}
