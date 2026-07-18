class MyCircularQueue {
    ArrayList<Integer> arr = new ArrayList<>();
    int capacity;
    public MyCircularQueue(int k) {
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(capacity == arr.size()) return false;
        arr.add(value);
        return true;
    }
    
    public boolean deQueue() {
        if(arr.size() == 0) return false;
        arr.remove(0);
        return true;
    }
    
    public int Front() {
        if(arr.size() ==0) return -1;
        return arr.get(0);
    }
    
    public int Rear() {
        if(arr.size() ==0) return -1;
        return arr.get(arr.size()-1);
    }
    
    public boolean isEmpty() {
        if(arr.size() ==0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(arr.size() == capacity) return true;
        return false;
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