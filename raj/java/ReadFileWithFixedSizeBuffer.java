package com.raj.java;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileWithFixedSizeBuffer {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile(
				"C:\\raj\\study\\univ\\research\\data\\brightkite\\Brightkite_edges.txt", "r");

		FileChannel inChannel = aFile.getChannel();
		// read 15 bytes
		ByteBuffer buffer = ByteBuffer.allocate(15);
		StringBuffer line = new StringBuffer();
		while (inChannel.read(buffer) > 0) {
			buffer.flip();
			for (int i = 0; i < buffer.limit(); i++) {
				char ch = ((char) buffer.get());
				if (ch == '\n') {
					System.out.println(line);
					line = new StringBuffer();
				} else {
					line.append(ch);
				}
			}
			buffer.clear(); // do something with the data and clear/compact it.
		}
		inChannel.close();
		aFile.close();
	}
}