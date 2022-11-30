package applyFuncsToCollectionsAndMonads;

import java.util.Comparator;
import java.util.Objects;

/*
You need to create a comparator to use it in a TreeSet that stores objects of the custom class applyFuncsToCollectionsAndMonads.LongRange. The class contains two fields called left and right to represent the borders.

The objects will be sorted according to the following rules:

If one range is longer than others, then it is the larger in the sorting order.
If several ranges have the same length, the smaller is the one with the smaller left border.
The sorting goes in the ascending order.
* */
class LongRange {
    private final long left;
    private final long right;

    public static Comparator<LongRange> getComparator() {
        // write your code here
        return Comparator.comparing(LongRange::getRange)
                .thenComparing(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    public long getRange(){
        return right-left;}

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            LongRange longRange = (LongRange) other;
            return left == longRange.left &&
                    right == longRange.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }

        @Override
        public String toString() {
            return String.format("%d %d", left, right);
        }
    }