package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

 public class DelegationSortedIntList implements IntegerList {
    private final SortedIntList sortedList; 
    private int totalAdded = 0;

    public DelegationSortedIntList() {
        this.sortedList = new SortedIntList();
    }

    @Override
    public boolean add(int num) {
        totalAdded++;
        return sortedList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        int countBefore = totalAdded;
        
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }

        return totalAdded > countBefore;
    }

    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    @Override
    public int size() {
        return sortedList.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}