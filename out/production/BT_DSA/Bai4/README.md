# Bài 4
## Xem xét parent[8] có thể nhận những giá trị nào từ 0 -> 9
- Parent: [0, 0, 0, 0, 4, 4, 4, 5, ?, 9]
- Ta sẽ loại bỏ được ngay những thành phần liên thông hiện tại sz < 2 và node con của 8: là {7,9}
- Những root của tập lớn hơn hoàn thành có thể là parent[8]
- Kết quả: parent[8] có thể nhận các giá trị {0, 4, 8}