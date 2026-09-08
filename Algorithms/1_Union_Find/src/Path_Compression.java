/*
Ý tưởng:
- Ngay sau khi tìm gốc cho p, lấy tất cả các nút trên đường đi trỏ trực tiếp đến root
 */
public class Path_Compression{
    private int[] id;
    public Path_Compression(int N){
        id = new int[N];
    }

    private int root(int i){
        while (i != id[i]){
            id[i] = id[id[i]]; // Path compression
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