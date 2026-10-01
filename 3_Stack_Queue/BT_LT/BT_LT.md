# Bài tập LT
## Bài 1.
## a. Bắt đầu từ một queue rỗng, chuỗi sau sẽ in ra nội dung gì??
enqueue(0) Q: [0]
enqueue(1) Q: [0, 1]
dequeue()  Q: [0] -> in ra 0
enqueue(2)  Q: [0, 2]
enqueue(3)  Q: [0, 2, 3]
dequeue()   Q: [0, 2] -> in ra 0 2
enqueue(4)  Q: [0, 2, 4]
enqueue(5)  Q: [0, 2,4 ,5]
dequeue()   Q: [0, 2, 4] -> in ra 0 2 4
enqueue(6)  Q: [0, 2, 4, 6]
enqueue(7)  Q: [0, 2, 4, 6, 7]
dequeue()   Q: [0, 2, 4 , 6] -> in ra 0 2 4 6
KQ: 0 0 2 0 2 4 0 2 4 6
### b. Thao tác enqueue của self-printing queue chứa n phần tử có thời gian chạy trong trường hợp tồi nhất là loại nào?
Nếu thao tác enqueue rơi vào đúng lần số 3 in ra thì sẽ là: O(n)
và best case là O(1)

### c. Thời gian chạy trung bình (amortized) trên mỗi thao tác đối với n thao tác `enqueue()` và `dequeue()` trên một hàng đợi loại self-printing queue ban đầu rỗng là bao nhiêu? Biết rằng đại lượng này được định nghĩa là tổng thời gian chạy trong trường hợp xấu nhất của bất kỳ chuỗi hỗn hợp nào gồm n thao tác `enqueue()` và `dequeue()` bắt đầu từ một hàng đợi tự in rỗng, chia cho n.
Vì enqueue và dequeue đều O(1) nên trường hợp xấu nhất là khi cứ enqueue liên tục và in ra
Với n thao tác thì số lần in tối đa là n/3
3+6+...+ n ~ 3. (n/3)^2/2 ~ O(n^2)
Hay trên mỗi thao tác thì là O(n)
