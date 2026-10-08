# Phân tích có nên lưu dữ liệu  vào trong linkedlist với 2 thuật toán Insertion Sort và Selection Sort

## Với Insertion Sort
Ý tưởng chính của Insertion Sort là xem mảng trước là đã sắp xếp sau đó di chuyển con trỏ để chọn vị trí đúng

LinkedList có thể làm việc này vì thao tác tìm là O(n) và chèn vào chỗ đúng là O(1) tương đối tương đương khi làm với Mảng
-> Có thể dùng LinkedList với Insertion Sort

## Với Selection Sort
Ý tưởng: tìm ra cái bé nhất và xếp vào từ bé -> lớn

Có thể liên tục duyệt qua sau đó nối vào đuôi để tạo ra mảng đã sắp xếp nhưng nhược điểm là tốn thời gian xử lý các con trỏ 
-> Không nên dùng với LinkedList mà nên dùng với mảng
