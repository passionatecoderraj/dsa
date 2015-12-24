package com.raj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {

	public static Comparator<Job> SalaryComparator = new Comparator<Job>() {
	    @Override
        public int compare(Job e1, Job e2) {
            return (int) (e2.profit - e1.profit);
        }
    };

    public Job jobWithMaxDeadLine(List<Job> jobs){
    	Job max = null;
    	if(jobs.size() ==0){
    		max = null;
    		return max;
    	}
    	else{
    		max = jobs.get(0);
    	}
    	
    	for(int i=1;i<jobs.size();i++){
    		if(jobs.get(i).deadline > max.deadline){
    			max = jobs.get(i);
    		}
    	}
    	return max;
    }
    
	public void printJobSequencing(List<Job> jobs) {
		if(jobs.size()==0) return;

		Collections.sort(jobs, SalaryComparator);
		
		
		Job max = jobWithMaxDeadLine(jobs);
		
		
		boolean slots[] = new boolean[max.deadline];
		Job result[] = new Job[max.deadline];
		
		for(int i=0;i<slots.length;i++)
			slots[i] = false;
		
		for(int i=0;i<jobs.size();i++){
			Job cur = jobs.get(i);
			boolean isCurPlaced = false;
			for(int j=cur.deadline-1;j>=0;j--){
				if(!slots[j] && !isCurPlaced){
					slots[j] = true;
					result[j] = cur;
					isCurPlaced = true;
				}
			}
		}
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
			
		}
	}

	public static void main(String[] args) {
		Job job1 = new Job('a', 2, 100);
		Job job2 = new Job('b', 1, 19);
		Job job3 = new Job('c', 2, 27);
		Job job4 = new Job('d', 1, 25);
		Job job5 = new Job('e', 3, 15);

		List<Job> jobs = new ArrayList<Job>(5);
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		jobs.add(job5);
		JobSequencing obj = new JobSequencing();
		obj.printJobSequencing(jobs);
	}

}

class Job {
	char id;
	int deadline;
	int profit;

	public Job(char id, int deadline, int profit) {
		super();
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]";
	}

	
}
