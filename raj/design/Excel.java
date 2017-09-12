package com.raj.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 */
public class Excel {
	int[][] excel;
	// A1 -> (B2,2), B2-> (C2,1)
	Map<String, HashMap<String, Integer>> map;

	public Excel(int H, char W) {
		excel = new int[H][value(W) + 1];
		map = new HashMap<>();
	}

	public void set(int r, char c, int new_value) {
		String cell = convert(r, c);
		// if it's value is dependent before from other cells then remove that
		// dependency
		removeFormulaDependencyIfExist(cell);

		int old_val = excel[r - 1][value(c)];
		excel[r - 1][value(c)] = new_value;
		// update dependent cells values from old value to new value
		update(cell, old_val, new_value);
	}

	public int get(int r, char c) {
		return excel[r - 1][value(c)];
	}

	public int sum(int row, char c, String[] strs) {
		String cell = convert(row, c);
		// if it's value is dependent before from other cells then remove that
		// dependency
		removeFormulaDependencyIfExist(cell);

		List<String> list = new ArrayList<>();
		populateAllCellsInFormula(strs, list);

		int sum = 0;
		for (String st : list) {
			map.compute(st, (k, v) -> {
				if (null == v) {
					v = new HashMap<>();
				}
				v.compute(cell, (key, value) -> {
					if (null == value) {
						value = 0;
					}
					return value + 1;
				});
				return v;
			});
			Cell cell1 = convert(st);
			sum += excel[cell1.row - 1][value(cell1.col)];
		}

		int cur_val = excel[row - 1][value(c)];
		excel[row - 1][value(c)] = sum;
		update(cell, cur_val, sum);
		return sum;
	}

	private void update(String key, int old_val, int new_val) {
		if (!map.containsKey(key)) {
			return;
		}

		for (Map.Entry<String, Integer> entry : map.get(key).entrySet()) {
			Cell cell = convert(entry.getKey());
			int cur_val = excel[cell.row - 1][value(cell.col)];

			int old_value = old_val * entry.getValue();
			int new_value = new_val * entry.getValue();
			int updated_val = cur_val - old_value + new_value;

			excel[cell.row - 1][value(cell.col)] = updated_val;
			update(entry.getKey(), cur_val, updated_val);
		}
	}

	private void populateAllCellsInFormula(String[] strs, List<String> list) {
		for (String str : strs) {
			if (!str.contains(":")) {
				list.add(str);
			} else {
				String a[] = str.split(":");
				generateCellsInRange(a[0], a[1], list);
			}
		}
	}

	private void removeFormulaDependencyIfExist(String cell) {
		map.forEach((k, v) -> {
			if (v.containsKey(cell)) {
				v.remove(cell);
			}
		});
	}

	private void generateCellsInRange(String from, String to, List<String> list) {
		Cell from_cell = convert(from);
		Cell to_cell = convert(to);
		for (int i = from_cell.row; i <= to_cell.row; i++) {
			for (char j = from_cell.col; j <= to_cell.col; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(j);
				sb.append(i);
				list.add(sb.toString());
			}
		}
	}

	private int value(char ch) {
		return ch - 'A';
	}

	// convert 1, A to A1
	private String convert(int r, char c) {
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		sb.append(r);
		return sb.toString();
	}

	// convert A1 to 1,A
	private Cell convert(String str) {
		char col = str.charAt(0);
		int row = Integer.parseInt(str.substring(1));
		return new Cell(row, col);
	}

	public static void main(String args[]) {
		Excel obj = new Excel(3, 'C');
		int res = -1;
		obj.set(1, 'A', 2);
		res = obj.get(1, 'A');
		System.out.println(res);
		String a[] = { "A1", "A1:B2" };
		obj.sum(3, 'C', a);
		res = obj.get(3, 'C');
		System.out.println(res);
		obj.set(2, 'B', 1);
		res = obj.get(3, 'C');
		System.out.println(res);
		CommonUtil.print2DArray(obj.excel, obj.excel.length, obj.excel[0].length);
	}
}

class Cell {
	int row;
	char col;

	public Cell(int row, char col) {
		this.row = row;
		this.col = col;
	}

}
