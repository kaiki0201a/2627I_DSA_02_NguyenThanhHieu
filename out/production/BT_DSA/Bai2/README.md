# Bài 2: COS226, Midterm f22
## Đề bài:Giả sử ta khởi tạo một cấu trúc dữ liệu union-find với n phần tử. Sau đó, ta thực hiện chuỗi các thao tác union() sau:  union(0, 1), union(0, 2), union(0, 3), ..., union(0, n-1). Trả lời các câu hỏi sau:

### A. Cấu trúc dữ liệu thu được chứa tổng cộng bao nhiêu thành phần liên thông (tức là các tập hợp rời nhau)?
- Cấu trúc dữ liệu chứa một thành phần liên thông duy nhất vì tất cả các đỉnh đều union với đỉng 0
### B. Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp quick-find. Có bao nhiêu lần cập nhật mảng được thực hiện bởi các thao tác union() này (biểu diễn dưới dạng hàm của n theo ký hiệu xấp xỉ ~)? (Lưu ý: cài đặt quick-find cho union(p,q) của chúng ta không bao giờ thay đổi giá trị leader[q].)
- Đọc lần 1 ở pid = id[p] và lần 2 ở qid = id[q]
- Trong vòng for -> n lần đọc ở lệnh if và k lần đọc trong lệnh if, với k là số trường hợp mà id[i] = pid
- Với trường hợp tổng quát union(0, p) -> k ở đây đúng bằng p - 1 -> số lần truy cập: 2 + n + p - 1
- Total: $$\text{Tổng truy cập} = \sum_{k=1}^{n-1} (n + 2 + k) = (n - 1)(n + 2) + \sum_{k=1}^{n-1} k$$
- $$\text{Tổng truy cập} = (n^2 + n - 2) + \frac{(n-1)n}{2} = 1.5n^2 + 0.5n - 2$$
- ~ $1.5n^2$
### C. Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp quick-union, và ta gọi find(0) sau chuỗi thao tác nêu trên. Thao tác find(0) sẽ thực hiện bao nhiêu lần truy cập mảng (biểu diễn dưới dạng hàm của n theo ký hiệu Θ)? (Lưu ý: cài đặt quick-union cho union(p,q) của chúng ta không bao giờ thay đổi parent[q].)
- Vì quick-union theo kiểu như thế nên kết quả thu được sẽ là :
- 0 -> 1 -> 2 -> 3 -> ... -> n-1
  - Khi gọi find(0) sẽ duyệt từ id[0] -> id[1] -> id[2] -> ... -> id[n-1]; Hay sẽ tốn n lần truy cập mảng -> Θ(n)
### D. Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp weighted quick-union, và ta gọi find(0) sau chuỗi thao tác nêu trên. Thao tác find(0) sẽ thực hiện bao nhiêu lần truy cập mảng (biểu diễn dưới dạng hàm của n theo ký hiệu Θ)? 
- Sau khi union xong vì theo yêu cầu của đề bài nên cây thu được sẽ có dạng gốc là 0 và lá là tất cả các node còn lại.
- Find(0) sẽ chỉ cần truy cập 1 lần -> Θ(1)