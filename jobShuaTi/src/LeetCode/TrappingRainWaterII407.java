package LeetCode;

import java.util.PriorityQueue;

public class TrappingRainWaterII407 {
	public int trapRainWater(int[][] heightMap) {
        //一个单元格用一个Cell来表示
        class Cell{
            int x, y,h;
            Cell(int x, int y, int height){
                this.x = x;
                this.y = y;
                h = height;
            }
        }
         if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        //优先队列，每次按照优先度输出队列，而不是按照顺序，这里是每次输出最矮的哪一个
        PriorityQueue<Cell> pq = new PriorityQueue<>((v1,v2)->v1.h - v2.h);
        boolean[][] visited = new boolean[m][n];
        //将四周初始化为访问过的，周围的一边是怎么都没法盛水的
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        for(int i = 1; i < m-1; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        //四个方向
        int[] xs = {0,  0, 1, -1};
        int[] ys = {1, -1, 0,  0};
        int sum = 0;
        //开始计算收集到的雨水，每次取出符合条件最矮的按个，然后计算差值，就是当前单元格可以容纳的了
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + xs[i];
                int ny = cell.y + ys[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum += Math.max(0, cell.h - heightMap[nx][ny]);
                    pq.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.h)));
                }
            }
        }
        return sum;
    }
}
