package com.raj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

	public static void main(String[] args) {
		ActivityJob job1 = new ActivityJob(0, 1, 2);
		ActivityJob job2 = new ActivityJob(1, 3, 4);
		ActivityJob job3 = new ActivityJob(2, 0, 6);
		ActivityJob job4 = new ActivityJob(3, 5, 7);
		ActivityJob job5 = new ActivityJob(4, 8, 9);

		ActivityJob job6 = new ActivityJob(5, 5, 9);
		List<ActivityJob> jobs = new ArrayList<ActivityJob>();
		jobs.add(job4);
		jobs.add(job5);
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job6);

		ActivitySelection obj = new ActivitySelection();

		obj.printMaxAcitiviesBySinglePerson(jobs);
	}

	public static Comparator<ActivityJob> customSorter = new Comparator<ActivityJob>() {
		@Override
		public int compare(ActivityJob e1, ActivityJob e2) {
			return (e1.finish - e2.finish);
		}
	};

	public void printMaxAcitiviesBySinglePerson(List<ActivityJob> jobs) {
		Collections.sort(jobs, customSorter);

		ActivityJob prev = null;
		for (int i = 0; i < jobs.size(); i++) {
			if (0 == i) {
				System.out.println(jobs.get(i));
				prev = jobs.get(i);
			} else {
				if (jobs.get(i).start >= prev.finish) {
					System.out.println(jobs.get(i));
					prev = jobs.get(i);
				}
			}
		}
	}
}

class ActivityJob {
	int id;
	int start;
	int finish;

	public ActivityJob(int id, int start, int finish) {
		super();
		this.id = id;
		this.start = start;
		this.finish = finish;
	}

	@Override
	public String toString() {
		return "ActivityJob [id=" + id + ", start=" + start + ", finish=" + finish + "]";
	}

}
