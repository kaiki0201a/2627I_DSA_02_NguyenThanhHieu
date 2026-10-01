# BT Lý thuyết
## Bài 1: Hãy xác định số lần hàm op() được gọi theo đánh giá tiệm cận (asymptotic), dưới dạng một hàm số của n, sử dụng cả ký hiệu xấp xỉ (∼ tilde) và ký hiệu Big Theta (Θ, tức là bậc tăng trưởng - order of growth).
### 1.1
```
for (int i = 10; i < n + 5; i += 2)
    op();
```
Vòng lặp chạy từ 10 -> n - 5; step = 2 ~ Θ(n) 

### 1.2
```
for (int i = 1; i < n * n; i *= 2)
    op();
```
Vòng lặp chạy từ 1 -> n**2; step luỹ thừa của 2; ~ 2logn ~ Θ(logn) 
### 1.3
```
for (int i = 0; i < n; i++)
    for (int j = 0; j < 100; j++)
        op();
```
Vòng lặp ngoài: ~O(n)
Vòng lặp trong: ~O(100)
~ 100n hay Θ(n)
### 1.4
```
for (int i = 0; i * i < n; i++)
    for (int j = 1; j < n; j *= 3)
        op();
```
Vòng lặp ngoài: i**2 < n -> $\sqrt{n}$ lần
Vòng lặp trong: ~$\log_3(n)$ lần
~ O ($\sqrt{n}$ $\log_3(n)$) -> Θ($\sqrt{n}$ $\log(n)$)

### 1.5
```
for (int i = 0; i < n; i++)
    for (int j = 1; j < n; j *= 2)
        op();
```
Vòng lặp ngoài: O(n)
Vòng lặp trong: O(logn)
-> Θ(nlogn)

### 1.6 
```
for (int i = 0; i < n; i++)
    for (int j = 0; j < 100; j++)
        for (int k = 0; k < n; k++)
            for (int l = k; l < n; l++)
                op();
```
Vòng lặp 1-2-> O(n): đã làm ở bài trên
Vòng lặp 3-4-> O(n^2): vì số lần lặp op(): n + (n-1) + ... + 1 ~ O(n^2)
-> Θ(n^3)


## Bài 2:Hàm op() được gọi bao nhiêu lần (tính theo n)?
```
for (int i = 0; i < n*n; i ++)
    for (int j = i + 1; j < n*n; j++)
        for (int k = 1; k <= n**; k *= 2)
            op()
```
Vòng lặp đầu tiên: O(n^2)
Vòng lặp thứ 2: Số lần: n*2 + n*2 -1 + ... + 1 ~ 1/2 O(n^2)
Vòng lặp thứ 3: 2log(n)
-> KQ: n^4 logn

## Bài 3: Biểu thức nào mô tả đúng về hàm f (n) = 2n2 + 2n + 6 log2 n ?
Vì khi n -> oo: logn << n << n^2
-> O(n^2); O(n3)  và Ω(n2); Ω(log n); Ω(n) 

## Bài 4: 
### **1. Chi phí bộ nhớ cho một nút (`Node`)**

Lớp `Node` được định nghĩa là một *non-static inner class* bên trong lớp `BST`:

* **Object overhead:** $16$ bytes.
* **Tham chiếu trỏ đến lớp ngoài (`BST` enclosing instance reference):** $8$ bytes (do `Node` không phải là `static`).
* **5 tham chiếu đối tượng (mỗi tham chiếu $8$ bytes):**
    * `private Key key;` $\rightarrow 8$ bytes
    * `private Value value;` $\rightarrow 8$ bytes
    * `private Node parent;` $\rightarrow 8$ bytes
    * `private Node left;` $\rightarrow 8$ bytes
    * `private Node right;` $\rightarrow 8$ bytes
      $$\implies 5 \times 8 = 40\text{ bytes}$$
* **Biến nguyên thủy:**
    * `private int count;` $\rightarrow 4$ bytes
* **Padding:**
    * Tổng tạm tính: $16 + 8 + 40 + 4 = 68$ bytes.
    * Cần đệm thêm $4$ bytes để tổng dung lượng chia hết cho $8$ (bội của 8 theo mô hình 64-bit).
      $$\implies 68 + 4 = 72\text{ bytes}$$

Ngoài ra, mỗi nút trong cây luôn đi kèm **$1$ tham chiếu trỏ đến chính nó** (từ `root` hoặc từ con trỏ `left`/`right` của nút cha):
$$\text{Chi phí mỗi nút} = 72 + 8 = 80\text{ bytes}$$

---

### **2. Chi phí bộ nhớ cho vỏ bọc (`BST`)**

* **Object overhead:** $16$ bytes
* **Tham chiếu `root` (`private Node root`):** $8$ bytes
* **Biến nguyên thủy `n` (`private int n`):** $4$ bytes
* **Padding:** $4$ bytes (đảm bảo chia hết cho 8 $\rightarrow 32$ bytes)
* **Tham chiếu đến đối tượng `BST`:** $8$ bytes
  $$\implies \text{Tổng chi phí cho BST} = 40\text{ bytes}$$

---
Tổng dung lượng bộ nhớ cấp phát cho cây có $n$ nút:
$$\text{Memory} = 80n + 40 \sim 80n\text{ bytes}$$

## Bài 5: 
2 Vòng lặp đầu: số lần: n + (n-1) + ... + 1 ~ 1/2 O(n^2)
Vòng lặp trong cùng k chạy từ 1->n step n/100
Giá trị mà k sẽ nhận: 
1 ; 1 + n/100 ;... 1+ m * n/100
Vòng lặp dừng khi 1 + m*n/100 > n -> m > 100((n-1)/n) = 100 - 100/n
Giả thiết n chia hết cho 100 -> m <= 99 hay lặp đúng 100 lần
-> ~ 100*1/2 n^2 hay 50n^2

## Bài 6: Chọn biểu thức mô tả đúng về hàm  nlog2n+3nn-5n 
Vì: n << nlogn**2 << n$\sqrt{n}$ 
nên KQ: O(n$\sqrt{n}$); O(n**3);Ω(log n)