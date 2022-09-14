package leetcode.struct;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl<T> implements NestedInteger{

    List<T> list = new ArrayList<>();

    public NestedIntegerImpl() {

    }

    public NestedIntegerImpl(Integer num) {
        this.list.add((T) num);
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {
        list.add((T) ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
