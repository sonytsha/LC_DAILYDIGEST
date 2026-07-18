class FrontMiddleBackQueue {
    ArrayList<Integer> arr = new ArrayList<>();
    public FrontMiddleBackQueue() {
        
    }
    
    public void pushFront(int val) {
        arr.add(0, val);
    }
    
    public void pushMiddle(int val) {
        arr.add(arr.size()/2, val);
    }

    public void pushBack(int val) {
        arr.add(arr.size(), val);
    }
    
    public int popFront() {
        if(arr.size() == 0) return -1;
        return arr.remove(0);
    }
    
    public int popMiddle() {
        if(arr.size() == 0) return -1;
        return arr.remove((arr.size() - 1) / 2);
    }
    
    public int popBack() {
        if(arr.size() == 0) return -1;
        return arr.remove(arr.size()-1);
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */