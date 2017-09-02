/**
 * 
 */
package com.interview.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Raj
 *
 */
public class FileRead {

	public static void main(String[] args) {

		// The name of the file to open.
		String fileName = "C:\\Users\\Raj\\workspace\\prac\\src\\com\\interivew\\practice\\LCByCompany.txt";

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<Obj> result = new ArrayList<>();
			String company = "";
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				String st = formattedString(company, line, result);
				if (st.equals(""))
					continue;
				if (!st.contains("-")) {
					company = st;
					continue;
				}
			}
			Collections.sort(result, new Comparator<Obj>() {
				public int compare(Obj ob1, Obj ob2) {
					if (ob1.company.compareTo(ob2.company) == 0)
						return ob1.level - ob2.level;
					return ob1.company.compareTo(ob2.company);
				}
			});
			for (Obj ob : result)
				System.out.println(ob);

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	private static String formattedString(String company, String str, List<Obj> result) {
		String a[] = str.split(" ");
		if (a.length == 0) {
			return "";
		}
		if (a.length == 1) {
			return a[0];
		}

		int r = str.length() - 1, l = 0;
		while (r >= 0 && str.charAt(r) != ' ') {
			r--;
		}
		String difficulty = str.substring(r + 1);
		r--;
		while (r >= 0 && str.charAt(r) != ' ') {
			r--;
		}

		while (l < str.length() && str.charAt(l) != ' ') {
			l++;
		}
		String qNo = str.substring(0, l);
		String ques = str.substring(l + 1, r);
		StringBuilder sb = new StringBuilder();
		sb.append(company);
		sb.append("-");
		sb.append(qNo);
		sb.append("-");
		sb.append(ques);
		sb.append("-");
		sb.append(difficulty);
		Obj ob = new Obj(company, qNo, ques, difficulty, getLevel(difficulty));
		result.add(ob);
		return sb.toString();
	}

	private static int getLevel(String difficulty) {
		switch (difficulty) {
		case "Easy":
			return 0;
		case "Medium":
			return 1;
		case "Hard":
			return 2;
		}
		return -1;
	}

	static class Obj {
		String company;
		String qNo;
		String question;
		String difficulty;
		int level;

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getqNo() {
			return qNo;
		}

		public void setqNo(String qNo) {
			this.qNo = qNo;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getDifficulty() {
			return difficulty;
		}

		public void setDifficulty(String difficulty) {
			this.difficulty = difficulty;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public Obj(String company, String qNo, String question, String difficulty, int level) {
			super();
			this.company = company;
			this.qNo = qNo;
			this.question = question;
			this.difficulty = difficulty;
			this.level = level;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(company);
			sb.append(",");
			sb.append(qNo);
			sb.append(",");
			sb.append(question);
			sb.append(",");
			sb.append(difficulty);

			return sb.toString();
		}

	}

}