package com.raj.nodes;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger{

    private Integer mSingleInteger;
    private List<NestedInteger> mNestedList;

    public NestedIntegerImpl(List<NestedInteger> nestedList){
        mNestedList = nestedList;
    }

    public NestedIntegerImpl(Integer singleInteger){
        mSingleInteger = singleInteger;
    }

    @Override
    public boolean isInteger(){
        return mSingleInteger != null;
    }

    @Override
    public Integer getInteger(){
        return mSingleInteger;
    }

    @Override
    public List<NestedInteger> getList(){
        return mNestedList;
    }
}