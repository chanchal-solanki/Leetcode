// class Solution {
//     public int shortestPath(int n, int[][] edges, String labels, int k) {
//         ArrayList<ArrayList<int []>> adjList = new ArrayList<>();

//         for(int i=0; i<n; i++) adjList.add(new ArrayList<>());

//         for(int[] edg : edges){
//             int u = edg[0];
//             int v = edg[1];
//             int w = edg[2];

//             adjList.get(u).add(new int[]{v,w});
//         }

//         int[][] dist = new int[n][k+1];

//         for(int[] d : dist) Arrays.fill(d,Integer.MAX_VALUE);

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
//         pq.offer(new int[]{0,0,1}); // d,node,cnt
//         dist[0][1] = 0;// dist[node][cnt] = d;

//         while(!pq.isEmpty()){
//             int[] curr = pq.poll();
//             int d = curr[0], node = curr[1] , cnt = curr[2];

//             if (d > dist[node][cnt]) continue;
//             if(node == n-1) return d;
//             for(int[] adj : adjList.get(node)){
//                 int v = adj[0];
//                 int w = adj[1];
                
//                 int c = labels.charAt(node) == labels.charAt(v) ? cnt+1 : 1;
//                  if(c> k) continue;
//                 if(d+w > dist[v][c]) continue;

//                 dist[v][c] = d+w;
//                 pq.offer(new int[]{d+w,v,c});

//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
        }
        int INF = 1000000000;
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1], cnt = cur[2];
            if (d > dist[u][cnt]) continue;
            if (u == n - 1) return d;
            for (int[] edge : g[u]) {
                int v = edge[0], w = edge[1];
                int ncnt = labels.charAt(u) == labels.charAt(v) ? cnt + 1 : 1;
                if (ncnt > k) continue;
                if (d + w < dist[v][ncnt]) {
                    dist[v][ncnt] = d + w;
                    pq.offer(new int[]{dist[v][ncnt], v, ncnt});
                }
            }
        }
        return -1;
    }
}