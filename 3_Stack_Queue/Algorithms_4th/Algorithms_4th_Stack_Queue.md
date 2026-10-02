# Ngăn xếp và hàng đợi
## Bài 1.3.1. Thêm hàm isFull() vào FixStrings
```aiignore
public boolean isFull(){
    return n == a.length;
}
```
## Bài 1.3.3. 
Quy tắc: Các số lớn luôn đứng trước số bé hơn nếu số đó chưa bị pop ra
### a. 4 3 2 1 0 9 8 7 6 5
Hợp lệ
### b. 4 6 8 7 5 3 2 9 0 1
Xét 9 0 1 không thoả mãn quy tắc -> không hợp lệ
### c. 2 5 6 7 4 8 9 3 1 0
Hợp lệ
### d. 4 3 2 1 0 5 6 7 8 9
Hợp lệ
### e. 1 2 3 4 5 6 9 8 7 0
Hợp lệ
### f. 0 4 6 5 3 8 1 7 2 9
Xét 3 1 2 -> không hợp lệ
### g. 1 4 7 9 8 6 5 3 0 2
Xét 3 0 2  -> không hợp lệ
### h. 2 1 4 3 6 5 8 7 9 0
Hợp lệ

## Bài 1.3.5. Hỏi đoạn code sau in ra kết quả gì khi N bằng 50? Hãy mô tả tổng quan công việc của nó khi N là một giá trị nguyên dương (1 câu)
```aiignore
Stack<Integer> stack = new Stack<Integer>();
while (N > 0) {
  stack.push(N % 2);
  N = N / 2;
}
for (int d : stack) StdOut.print(d);
StdOut.println();
```
Đáp án: in biểu diễn nhị phân của N(110010)

## Bài 1.3.6. Đoạn code sau làm gì đối với queue q?
```aiignore
Stack<String> stack = new Stack<String>();
while (!q.isEmpty())  stack.push(q.dequeue());
while (!stack.isEmpty())  q.enqueue(stack.pop());

```
Vòng while đầu tiên: bỏ hết phần tử trong q sang stack
Vòng while 2: đem các các trí đó xếp ngược lại kèm thêm phần từ của stack

## Bài 1.3.7. Thêm hàm peek() vào Stack mà không pop() nó ra
```aiignore
public Item peek() {
    if (isEmpty()) {
        throw new NoSuchElementException("Stack underflow");
    }
    return first.item;
}
```