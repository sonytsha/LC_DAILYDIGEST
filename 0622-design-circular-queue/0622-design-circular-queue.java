class MyCircularQueue {
    Deque<Integer> dequeue = new LinkedList<>();
    int capacity;
    public MyCircularQueue(int k) {
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        dequeue.addLast(value);
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
        return false;
        }
        dequeue.pollFirst();
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return dequeue.peekFirst();
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return dequeue.peekLast();
    }
    
    public boolean isEmpty() {
        if(dequeue.size() == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        return dequeue.size() == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */