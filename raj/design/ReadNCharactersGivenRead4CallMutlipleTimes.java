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
public class ReadNCharactersGivenRead4CallMutlipleTimes {

	char r[] = new char[4];
	int rPtr = 0;
	int size = 0;

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int idx = 0;
		while (idx < n) {
			if (rPtr == 0) {
				size = read4(r);
			}
			while (rPtr < size && idx < n) {
				buf[idx++] = r[rPtr++];
			}
			if (rPtr == size)
				rPtr = 0;
			if (size < 4)
				break;
		}

		return idx;
	}

	private int read4(char[] r) {
		return 0;
	}
}
