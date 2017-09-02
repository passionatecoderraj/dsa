package com.interview.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
	private float location = 0;
	private Direction direction = Direction.UP;
	private State state = State.STOPPED;
	private Door door = Door.CLOSED;
	private Thread processingThread;
	private Thread listeningThread;

	public class Request {
		public long time;
		public Integer floor;
		public Direction direction;

		public Request(long time, Integer floor, Direction direction) {
			this.time = time;
			this.floor = floor;
			this.direction = direction;
		}
	}

	public enum Direction {
		UP, DOWN
	}

	public enum State {
		MOVING, STOPPED
	}

	public enum Door {
		OPEN, CLOSED
	}

	public Comparator<Request> upComparator = new Comparator<Request>() {
		public int compare(Request u1, Request u2) {
			return u1.floor.compareTo(u2.floor);
		}
	};

	public Comparator<Request> downComparator = upComparator.reversed();

	private Queue<Request> upQueue = new PriorityQueue<>(upComparator);
	private Queue<Request> currentQueue = upQueue;
	private Queue<Request> downQueue = new PriorityQueue<>(downComparator);

	public void call(int floor, Direction direction) {
		if (direction == Direction.UP) {
			if (floor >= location) {
				currentQueue.add(new Request(System.currentTimeMillis(), floor, direction));
			} else {
				upQueue.add(new Request(System.currentTimeMillis(), floor, direction));
			}
		} else {
			if (floor <= location) {
				currentQueue.add(new Request(System.currentTimeMillis(), floor, direction));
			} else {
				downQueue.add(new Request(System.currentTimeMillis(), floor, direction));
			}
		}
	}

	public void go(int floor) {
		call(floor, direction);
	}

	public void process() {
		while (true) {
			if (!upQueue.isEmpty() && !downQueue.isEmpty()) {
				Request r = currentQueue.poll();
				if (r != null) {
					goToFloor(r.floor);
				} else {
					preProcessNextQueue();
				}
			}
		}
	}

	public void goToFloor(int floor) {
		state = State.MOVING;
		for (float i = location; i <= floor; i = (float) (i + 0.1)) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		location = floor;
		door = Door.OPEN;
		state = State.STOPPED;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		door = Door.CLOSED;
	}

	private void preProcessNextQueue() {
		if (getLowestTimeUpQueue() > getLowestTimeDownQueue()) {
			this.direction = Direction.UP;
			currentQueue = upQueue;
			upQueue = new PriorityQueue<>(upComparator);
		} else {
			this.direction = Direction.DOWN;
			currentQueue = downQueue;
			downQueue = new PriorityQueue<>(downComparator);
		}
	}

	private long getLowestTimeUpQueue() {
		long lowest = Long.MAX_VALUE;
		for (Request r : upQueue) {
			if (r.time < lowest)
				lowest = r.time;
		}
		return lowest;
	}

	private long getLowestTimeDownQueue() {
		long lowest = Long.MAX_VALUE;
		for (Request r : downQueue) {
			if (r.time < lowest)
				lowest = r.time;
		}
		return lowest;
	}

	public class Process implements Runnable {
		@Override
		public void run() {
			process();
		}
	}

	public class Listen implements Runnable {
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(90000);
				while (true) {
					Socket socket = serverSocket.accept();
					Thread thread = new Thread(new Worker(socket));
					thread.start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public class Worker implements Runnable {
		private Socket s;

		public Worker(Socket s) {
			this.s = s;
		}

		@Override
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line;
				while (true) {
					if ((line = reader.readLine()) != null) {
						String[] tokens = line.split(" ");
						if (tokens.length == 3 && tokens[0].equals("call")) {
							call(Integer.parseInt(tokens[1]), tokens[2].equals("up") ? Direction.UP : Direction.DOWN);
						} else if (tokens.length == 2 && tokens[0].equals("go")) {
							go(Integer.parseInt(tokens[1]));
						} else {
							s.getOutputStream().write("Wrong input".getBytes());
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		elevator.listeningThread = new Thread(elevator.new Listen());
		elevator.listeningThread.start();
		elevator.processingThread = new Thread(elevator.new Process());
		elevator.processingThread.start();
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}