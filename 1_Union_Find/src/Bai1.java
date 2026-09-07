public void union(int p, int q) {
    for (int i = 0; i < leader.length; i++){
        if (leader[i] == leader[p])
            leader[i] = leader[q]
    }
}

/*
- Vấn đề: không lưu lại giá trị của leader[p]
-> khi leader[p] thay đổi thành leader[q]
-> những phần tử khác thuộc tập cùng leader[p] sẽ không được union

 */