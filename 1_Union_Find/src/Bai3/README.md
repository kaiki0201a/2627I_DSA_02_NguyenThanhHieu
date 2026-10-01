# Bai 3
## Trong các cặp (p,q) dưới đây, những cặp nào có thể là tham số của lệnh union(p, q) gần nhất? Giả thiết rằng p và q thuộc hai tập khác nhau trước khi lệnh union(p,q) được chạy.
### (0,4)
- Trạng thái trước khi gộp:
  - Node 0 là gốc chứa các node: {0, 1, 2, 3} -> sz = 4
  - Node 4 là gốc chứa các node: {4, 5, 6, 7}-> sz = 4
- Theo quy ước nếu sz[p] = sz[q] thì sẽ nối q vào gốc p -> union(0, 4) không thoả mãn vì làm ngược lại
### (4,0): thoả mãn như đã phân tích ở union(0,4)
###  (2,3)
- Vì (2,3) đều có root là 4 nên
- TH1: (2,3) đã được union từ trước đó
- TH2: 3 là node cuối được thêm vào -> 3 phải nối lên root(2) là 4 -> union (2,3) không thoả mãn
### (4,5):
- Trạng thái trước khi gộp:
  - Node 4 là gốc chứa các node: {0,1,2,3,4,6} -> sz = 6
  - Node 5 là gốc chứa các node: {5,7} -> sz = 2
- Theo quy ước sz[4] > sz[5] nên union(4,5) thoả mãn
### (5,0):
- Giả sử trạng thái trước khi gộp:
  - Node 0 thuộc root 4 có chứa các node: {0,1,2,3,4,6} -> sz = 6
  - Node 5 thuộc root 5 có chứa các node: {5,7} -> sz = 2
- Theo quy ước sz[0] > sz[5] nên union(5,0) thoả mãn
### (5,7): tương tự (2,3) không thoả mãn
### (6,4), (8,9)
- Dễ thấy nếu 6 và 9 là node cuối cùng thêm vào thì hoàn toàn thoả mãn.
### Tổng kết
- Cặp thoả mãn: {(4,0), (4,5), (5,0), (6,4), (8,9)}
- Cặp không thoả mãn: {(0,4), (2,3), (5,7)}