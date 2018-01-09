package com.raj.design;

/**
 * 
 * @author Raj The API: int read4(char *buf) reads 4 characters at a time from a
 *         file.
 * 
 *         The return value is the actual number of characters read. For
 *         example, it returns 3 if there is only 3 characters left in the file.
 * 
 *         By using the read4 API, implement the function int read(char *buf,
 *         int n) that reads n characters from the file.
 * 
 *         Note: The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 {

	public int read(char[] buf, int n) {
		char r[] = new char[4];
		int idx = 0;
		while (idx < n) {
			int size = read4(r);
			int rPtr = 0;
			while (rPtr < size && idx < n) {
				buf[idx++] = r[rPtr++];
			}
			if (size < 4)
				break;
		}

		return idx;
	}

	public int read2(char[] buf, int n) {
		int idx = 0;
		char r[] = new char[4];
		boolean eof = false;
		while (!eof && idx < n) {
			int size = read4(r);
			if (size < 4)
				eof = true;
			if (size + idx > n) {
				size = n - idx;
			}
			System.arraycopy(r, 0, buf, idx, size);
			idx += size;
		}

		return idx;
	}

	private int read4(char[] r) {
		return 0;
	}
}
