class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0;j <n; j++) {
                if(mat[i][j]==0) {
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }
        int[] dirX = {-1,0,1,0};
        int[] dirY = {0,-1,0,1};
        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            for(int d = 0;d<4; d++) {
                int newR = p.getKey() + dirX[d];
                int newC = p.getValue() + dirY[d];
                if(newR>=0 && newR<m && newC>=0 && newC<n && !visited[newR][newC]) {
                    q.offer(new Pair(newR, newC));
                    visited[newR][newC]=true;
                    ans[newR][newC] = ans[p.getKey()][p.getValue()]+1;
                }
            }
        }
        return ans;
    }
}

time and space Complexity = O(m*n)
