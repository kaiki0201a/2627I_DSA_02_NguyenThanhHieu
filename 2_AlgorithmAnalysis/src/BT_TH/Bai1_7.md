# Bài 7: Phân tích thuật toán duyệt toàn bộ ThreeSum theo mô hình chi phí dựa trên các phép toán số học và so sánh.
Đoạn lõi cần phân tích:
```aiignore
int count = 0;
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
            if (a[i] + a[j] + a[k] == 0) {
                count++;
            }
        }
    }
}
```
Vòng lặp thực hiện đúng theo 0< i< j < k < n
Tổng bộ ba số này ~ n^3/ 6
KQ: O(n^3)