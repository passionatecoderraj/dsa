package com.raj.nodes;

import java.util.List;

public class NestedInteger {

	private Integer mSingleInteger;
	private List<NestedInteger> mNestedList;

	public NestedInteger(List<NestedInteger> nestedList) {
		mNestedList = nestedList;
	}

	public NestedInteger(Integer singleInteger) {
		mSingleInteger = singleInteger;
	}

	public NestedInteger() {

	}

	public boolean isInteger() {
		return mSingleInteger != null;
	}

	public Integer getInteger() {
		return mSingleInteger;
	}

	public void setInteger(Integer value) {
		this.mSingleInteger = value;
	}

	public void add(NestedInteger ni) {
		mNestedList.add(ni);
	}

	public List<NestedInteger> getList() {
		return mNestedList;
	}

}