package com.interview.design.jukebox;

import java.util.Queue;

public class Playlist {
	private Song song;
	private Queue<Song> queue;
	private PlayOrder order;
	private boolean repeatAllSongs;

	public Playlist(Song song, Queue<Song> queue) {
		super();
		this.song = song;
		this.queue = queue;
	}

	public Song getNextSongToPlay() {
		return queue.peek();
	}

	public void queueUpSong(Song s) {
		queue.add(s);
	}
}

enum PlayOrder {
	PlayAlphatically, Shuffle, RecentlyPlayed, MostFrequentlyPlayed
}
