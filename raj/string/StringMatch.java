package com.raj.string;

public class StringMatch {

	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		StringMatch obj = new StringMatch();
		obj.BruteForceMatch(pat.toCharArray(), txt.toCharArray());
	}
	
	int BruteForceMatch(char[] pattern,char []text){
		int m = pattern.length;
		int n = text.length;
		
		for(int i=0;i<=n-m;i++){
			
			int j=0;
			while(j < m && text[i+j] == pattern[j]){
				j++;
			}
			if(j == m){
				System.out.println("Pattern found at "+i);
			}
		}
		return -1;
	}
	

}
