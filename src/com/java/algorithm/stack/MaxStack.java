package com.java.algorithm.stack;


import java.util.Deque;
import java.util.LinkedList;

public class MaxStack {

    private Deque<Integer> element = new LinkedList<Integer>();
    private Deque<MaxWithCount> cachedMaxWithCount = new LinkedList<>();

    private class MaxWithCount {
        Integer max;
        Integer count;

        MaxWithCount(Integer max, Integer count) {
            this.max = max;
            this.count = count;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    public boolean isEmpty() {
        return element.isEmpty();
    }

    public Integer max() {
       if(isEmpty()) {
           throw new IllegalStateException("max(): empty stack");
       }

       return cachedMaxWithCount.peekFirst().max;
    }

    public Integer pop() {
        if(isEmpty()) {
            throw new IllegalStateException("pop(): stack empty");
        }

        Integer data = element.removeFirst();
        Integer currMax = cachedMaxWithCount.peekFirst().max;
        if(data.compareTo(currMax) == 0) { // if it match decrement the count and if count is 0 then remove from max
            cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count - 1;
            if(cachedMaxWithCount.peekFirst().count.equals(0)) {
                cachedMaxWithCount.removeFirst();
            }
        }

        return data;
    }

    public void push(Integer x) {
      element.push(x);

      if(!cachedMaxWithCount.isEmpty()) {
            int compare = Integer.compare(x,cachedMaxWithCount.peekFirst().max);
            if(compare == 0) {
                cachedMaxWithCount.peekFirst().count = cachedMaxWithCount.peekFirst().count + 1;
            } else if(compare > 0) {
                cachedMaxWithCount.push(new MaxWithCount(x,1));
            }
      } else {
          cachedMaxWithCount.push(new MaxWithCount(x,1));
      }
    }
}
