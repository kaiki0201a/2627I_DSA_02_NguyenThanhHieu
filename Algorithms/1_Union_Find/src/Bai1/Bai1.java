/*
public void union(int p, int q) {
    for (int i = 0; i < leader.length; i++){
        if (leader[i] == leader[p])
            leader[i] = leader[q];
    }
}
*/

/*
- Vấn đề: không lưu lại giá trị của leader[p]
-> khi leader[p] thay đổi thành leader[q]
-> những phần tử khác thuộc tập cùng leader[p] sẽ không được union
- Test case chạy sai:
1. Khởi tạo mảng n = 3 gồm các phần tử (0,1,2)
2. Mảng ban đầu: [0, 1, 2]
3. Thực hiện union(1,0) -> Mảng sau union: [0, 0, 2]
4. Thưc hiện union(0,2) -> Mảng sau union: [2, 0, 2] -> đỉnh 1 không được cập nhật
 */