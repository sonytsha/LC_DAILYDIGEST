class Solution {
    public int secondHighest(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                arr.add(ch-'0');
            }
        }
        Collections.sort(arr);
        if(arr.size() < 2) return -1;
        
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            if(largest < arr.get(i)){
                secondLargest = largest; 
                largest = arr.get(i);
            }
            else if(arr.get(i) > secondLargest && arr.get(i) != largest){
                secondLargest = arr.get(i);
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}