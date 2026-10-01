# Bài 1.4.6. Cho biết bậc tăng của thời gian chạy (theo hàm của N) của mỗi đoạn code sau:
## a.
```
int sum = 0; 
for (int n = N; n > 0; n /= 2) 
    for(int i = 0; i < n; i++) sum++; 
```
Vòng lặp ngoài: O(logn)
Vòng lặp trong chạy theo n phụ thuộc vòng ngoài:
Tổng số phép tính: n + n/2 + ... + 1 ~ 2n
Kq: O(n)
## b.
```aiignore
int sum = 0; 
for (int i = 1; i < N; i *= 2) 
    for (int j = 0; j < i; j++) sum++; 

```
Vòng lặp ngoài: O(logn)
Vòng lặp trong chạy theo vòng lặp ngoài tương tự a:
KQ: O(n)
## c.
```aiignore
int sum = 0; 
for (int i = 1; i < N; i *= 2) 
    for (int j = 0; j < N; j++) sum++;

```
Vòng lặp ngoài: O(logn)
Vòng lặp trong chạy đến N :
KQ: O(Nlogn)