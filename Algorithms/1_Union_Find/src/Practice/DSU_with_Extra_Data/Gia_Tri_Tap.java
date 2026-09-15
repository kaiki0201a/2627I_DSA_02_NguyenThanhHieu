// Nguồn: https://oj.vnoi.info/contest/dsu/all
// De bai phai luu them min, max, so luong dinh
package Practice.DSU_with_Extra_Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gia_Tri_Tap {
    static int[] id;
    static int[] minid;
    static int[] maxid;
    static int[] sz;

    public Gia_Tri_Tap(int N) {
        // Cấp phát mảng N + 1 để hỗ trợ 1-based indexing an toàn
        id = new int[N + 1];
        sz = new int[N + 1];
        minid = new int[N + 1];
        maxid = new int[N + 1];

        for (int i = 1; i < N+1; i++) {
            id[i] = i;
            sz[i] = 1;
            minid[i] = i;
            maxid[i] = i;
        }
    }

    public int root(int i){
        // 1. Tim root i
        if (i == id[i])
            return i;
        // 2. Neu khong phai root thi de quy len node cha
        int p = root(id[i]);
        id[i] = p;
        return p;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if (sz[i] < sz[j]){
            int temp = i;
            i = j;
            i = temp;
        }

        // Cập nhật thông tin cho gốc i mới
        sz[i] += sz[j];
        minid[i] = Math.min(minid[i], minid[j]);
        maxid[i] = Math.max(maxid[i], maxid[j]);

        id[j] = i;
    }

    static void main() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Gia_Tri_Tap gt = new Gia_Tri_Tap(n);

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            if (s.equals("union")){
                int q = Integer.parseInt(st.nextToken());
                gt.union(p, q);
            } else {
                int root = gt.root(p);
                sb.append(gt.minid[root] + " " + gt.maxid[root] + " " + gt.sz[root] + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
