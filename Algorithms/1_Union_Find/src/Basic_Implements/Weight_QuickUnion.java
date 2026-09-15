// Weight: co them thuoc tinh sz; khi gop se danh gia sz; noi cay be vao cay lon
// Lưu ý: cài đặt weighted quick-union cho union(p,q) của chúng ta sẽ thay đổi parent[q] nếu hai cây có cùng kích thước.)

public class Weight_QuickUnion{
    private int[] id;
    private int[] sz;

    public Weight_QuickUnion(int N){
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        if (i == j) return;
        if (sz[i] >= sz[j]){
            id[j] = i;
            sz[i] += sz[j];
        } else {
            id[i] = j;
            sz[j] += sz[i];
        }
    }
}