import java.awt.*;

class Solution {
        static int [] dx = {-1, 0, 1, 0};
        static int [] dy = {0, 1, 0, -1};
        static boolean visitP[][];
        static boolean visitA[][];
        static int m = 0, n = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList();
        m = heights.length;//세로
        n = heights[0].length;//가로
        visitP = new boolean[m][n];
        visitA = new boolean[m][n];
        //initial setting
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0)
                    visitP[i][j] = true;
                if(i == m-1 || j == n-1)
                    visitA[i][j] = true;
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0)
                    BFSP(i, j, heights);
                if(i == m-1 || j == n-1)
                    BFSA(i, j, heights);
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visitP[i][j] && visitA[i][j]){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    answer.add(temp);
                }
                    
            }
        }
        
        return answer;
    }//pacificAtlantic
    
    //        System.out.println();

    public static void BFSP(int x, int y, int [][] heights){
        Queue<Point> q = new LinkedList();
        q.add(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];

                if(tx < 0 || ty < 0 || tx >= m || ty >= n)
                    continue;
                
                if(!visitP[tx][ty] && heights[tx][ty] >= heights[p.x][p.y]){
                    visitP[tx][ty] = true;
                    q.add(new Point(tx, ty));
                }
            }
        }//while 
    }//BFSP
    
    public static void BFSA(int x, int y, int [][] heights){
        Queue<Point> q = new LinkedList();
        q.add(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                
                if(tx < 0 || ty < 0 || tx >= m || ty >= n)
                    continue;
                
                if(!visitA[tx][ty] && heights[tx][ty] >= heights[p.x][p.y]){
                    visitA[tx][ty] = true;
                    q.add(new Point(tx, ty));
                }
            }
        }//while 
    }//BFSA
}