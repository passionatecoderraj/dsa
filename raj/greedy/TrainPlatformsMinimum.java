package com.raj.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainPlatformsMinimum {
	
	public static void main(String[] args) {
		Train a = new Train('A',900,950);
		Train b = new Train('B',925,1300);
		Train c = new Train('C',1050,1100);
		Train d = new Train('D',1075,1175);
		List<Train> trains = new ArrayList<Train>(4);
		trains.add(a);trains.add(b);
		trains.add(c);trains.add(d);
		
		int p = -1;
		
		TrainPlatformsMinimum obj = new TrainPlatformsMinimum();
		// method1 According to Narasimha
	//	p = obj.minPlatFormsForTrains(trains);
		System.out.println(p);
		// method1 According to Raj
		p = obj.minPlatFormsForTrainsUsingActivingSelection(trains);
		System.out.println(p);
		
	}

	public static Comparator<Types> customSorterForTypes = new Comparator<Types>() {
		@Override
		public int compare(Types e1, Types e2) {
			return (int) (e1.value - e2.value);
		}
	};	
	
	public int minPlatFormsForTrains(List<Train> trains) {
		Types[] types = new Types[trains.size()*2];
		int j=0;
		for(int i=0;i<trains.size();i++){
			types[j++]= new Types("Arrival",trains.get(i).arrival);
			types[j++] = new Types("Departure",trains.get(i).departure);
		}
		int[] arr = new int[trains.size()*2];
		
		Arrays.sort(types, customSorterForTypes);
		for(int i=0;i<types.length;i++){
			if(types[i].type.equals("Arrival")){
				arr[i] = 1;
			}
			else if(types[i].type.equals("Departure")){
				arr[i] = -1;
			}
		}
		return cumulativeArray(arr);
	}

	public int cumulativeArray(int[] a) {
		for(int i=1;i<a.length;i++){
			a[i] = a[i-1] + a[i];
		}
		return findMaxInArray(a);
	}
	
	public int findMaxInArray(int[] a){
		int max =-1;
		for(int i=0;i<a.length;i++){
			if(a[i] > max)
				max = a[i];
		}
		return max;
	}


	public static Comparator<Train> customSorter = new Comparator<Train>() {
		@Override
		public int compare(Train e1, Train e2) {
			return (int) (e1.departure - e2.departure);
		}
	};
	
	public int minPlatFormsForTrainsUsingActivingSelection(List<Train> trains) {
		Collections.sort(trains, customSorter);
		int p =0;
		Map<Integer,List<Train>> map = new HashMap<Integer,List<Train>>();
		
		for(int i=0;i<trains.size();i++){
			if(0 == i){
				List<Train> ts = new ArrayList<Train>();
				ts.add(trains.get(i));
				map.put(++p,ts);
			}
			else{
				boolean isFound = false;
				for(Integer id:map.keySet()){
					if(isFound) continue;
					List<Train> t = map.get(id);
					if(t.size()>0){
						if(trains.get(i).arrival >= t.get(t.size()-1).departure){
							map.get(id).add(trains.get(i));
							isFound = true;
						}
					}
				}
				if(!isFound){
					List<Train> ts = new ArrayList<Train>();
					ts.add(trains.get(i));
					map.put(++p,ts);
				}
			}
		}
		
		System.out.println(map);
		
		return map.keySet().size();
	}
	
	
}

class Types{
	String type;
	int value;
	public Types(String type, int value) {
		super();
		this.type = type;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Types [type=" + type + ", value=" + value + "]";
	}
}


class Train{
	char id;
	int arrival;
	int departure;
	
	public Train(char id, int arrival, int departure) {
		super();
		this.id = id;
		this.arrival = arrival;
		this.departure = departure;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", arrival=" + arrival + ", departure=" + departure + "]";
	}
	
	
	
}
