class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String c : tokens){
            if(c.equals("+") || c .equals("-") || c.equals("*") || c .equals("/")) {
                int a = st.pop();
                int b = st.pop();
                
                if(c.equals("+")) st.push(a + b );
                else if( c .equals("-")) st.push(b-a);
                else if(c.equals("*")) st.push(a * b);
                else st.push(b/a);
                System.out.println(st.peek());
            }
            else st.push(Integer.parseInt(c));
        }
        return st.peek();
    }
}