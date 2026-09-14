/*
Ý tưởng:
- Ngay sau khi tìm gốc cho p, nối gốc đến ông nội của nó
 */
public class Path_Halving {
    private int[] id;
    public Path_Halving(int N){
        id = new int[N];
    }

    private int root(int i){
        while (i != id[i]){
            id[i] = id[id[i]]; // Path Halving
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}