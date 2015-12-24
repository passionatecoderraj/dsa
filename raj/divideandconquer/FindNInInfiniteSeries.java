package com.raj.divideandconquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindNInInfiniteSeries {

	public static void main(String[] args) {
		FindNInInfiniteSeries obj = new FindNInInfiniteSeries();
		
		Random rand = new Random();
		int min=1,max=10;
		
	    List<Integer> series = new ArrayList<Integer>();
		for(int i=0;i<2000;i++){
			if(i<800){
				int randomNum = rand.nextInt(max);
			    series.add(randomNum);
			}
			else{
				series.add(-1);
			}
		}
		System.out.println(series);
		obj.findNInInfiniteSeries(series);
	}

	public void findNInInfiniteSeries(List<Integer> series) {
		int l=1,r=1;
		while(series.get(r-1) != -1){
			l=r;
			r=r*2;
		}
		
		int mid;
		
		while(r-l>1){
			mid = (r-l)/2+l;
			if(series.get(mid) == -1){
				r = mid;
			}
			else{
				l = mid;
			}
		}
		
		System.out.println(r-1);
	}

}
