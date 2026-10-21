class MinStack {
    ArrayList<Integer> min;
    ArrayList<Integer> st;

    public MinStack() {
        min = new ArrayList<>();
        st = new ArrayList<>();
    }
    
    public void push(int value) {
        st.add(value);
        if(min.size() == 0) min.add(value);
        else min.add(Math.min(min.get(min.size()-1),value));
    }
    
    public void pop() {
        st.remove(st.size()-1);
        min.remove(min.size()-1);
    }
    
    public int top() {
        return st.get(st.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */