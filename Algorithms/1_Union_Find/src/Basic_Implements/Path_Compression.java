/*
Ý tưởng: Khi tìm root của p, ta sẽ nối tất cả các node trên đường đi tới root sau đệ quy
 */
public class Path_Compression {
    private int[] id;
    public Path_Compression(int N){
        id = new int[N];
    }

    private int root(int i){
        if (i == id[i])
            return i;   // Tìm root của i
        int p = root(id[i]);    // Nếu không phải gốc thì đệ quy lên node cha
        id[i] = p;  // Nén đoạn từ i lên root
        return p;
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
