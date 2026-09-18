// class Solution {
//     public List<String> maxNumOfSubstrings(String s) {
//         int n = s.length();

//         int[] first = new int[26];
//         int[] last = new int[26];
//         Arrays.fill(first,-1);

//         for(int i=0; i<n; i++){
//             int ind = s.charAt(i)-'a';
//             if(first[ind] == -1 ) first[ind] = i;
//             last[ind] = i;
//         }

//         for(int i=0; i<26; i++){
//             if(first[i] == -1) continue;

//             int start = first[i];
//             int end = last[i];

//             for(int j = start; j<=end; j++){
//                 int idx = s.charAt(j)-'a';
//                 if(first[idx] < start){
//                     end = -1;
//                     break;
//                 }
//                 end = Math.max(end, last[idx]);
//             }
//             last[i] = end;
//         }

//         int end = n;
//         List<String> ans =  new ArrayList<>();

//         for(int i=n-1; i>=0; i--){
//             int c = s.charAt(i) - 'a';

//             if(last[c] != -1 && first[c] == i && last[c] < end){
//                 ans.add(s.substring(i,last[c]+1));
//                 end = i;
//             }
    
//         }

                
//         return ans;
//     }
// }
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Build valid intervals
        for (int c = 0; c < 26; c++) {
            if (last[c] == -1) continue;

            int l = first[c];
            int r = last[c];
            boolean valid = true;

            for (int i = l; i <= r; i++) {
                int x = s.charAt(i) - 'a';

                // x has an occurrence before l
                if (first[x] < l) {
                    valid = false;
                    break;
                }

                // Must include all occurrences of x
                r = Math.max(r, last[x]);
            }

            if (valid)
                intervals.add(new int[]{r, l});
        }

        // Earliest ending interval first
        intervals.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        for (int[] iv : intervals) {
            int r = iv[0], l = iv[1];
            if (l > prevEnd) {
                ans.add(s.substring(l, r + 1));
                prevEnd = r;
            }
        }

        return ans;
    }
}
