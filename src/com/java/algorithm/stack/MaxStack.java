package com.java.algorithm.stack;



public class MaxStack {

    ResizingArrayStack<Integer> element = new ResizingArrayStack<>(10);
    ResizingArrayStack<MaxWithCount> cachedMaxWithCount = new ResizingArrayStack<>(10);

    private class MaxWithCount {
        Integer max;
        Integer count;

        public MaxWithCount(Integer max, Integer count) {
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

       return cachedMaxWithCount.peek().max;
    }

    public Integer pop() {
        if(isEmpty()) {
            throw new IllegalStateException("pop(): stack empty");
        }

        Integer data = element.pop();
        Integer currMax = cachedMaxWithCount.peek().max;
        if(data.compareTo(currMax) == 0) { // if it match decrement the count and if count is 0 then remove from max
            cachedMaxWithCount.peek().count = cachedMaxWithCount.peek().count - 1;
            if(cachedMaxWithCount.peek().count.equals(0)) {
                cachedMaxWithCount.pop();
            }
        }

        return data;
    }

    public void push(Integer x) {
        element.push(x);

        if(!cachedMaxWithCount.isEmpty()) {
            Integer currMax = cachedMaxWithCount.peek().max;
            if(x.compareTo(currMax) == 0) { // if equal update the count
                cachedMaxWithCount.peek().count = cachedMaxWithCount.peek().count + 1;
            } else if(x.compareTo(currMax) > 0) { // if greater than currMax then push it
                cachedMaxWithCount.push(new MaxWithCount(x,1));
            }
        } else {
            cachedMaxWithCount.push(new MaxWithCount(x,1));
        }
    }
}
