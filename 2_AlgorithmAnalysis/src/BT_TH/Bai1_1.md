# Bài 1.4.1 Chứng minh rằng số các bộ ba phần tử có thể chọn được từ N phần tử được tính bằng công thức N(N-1)(N-2)/6. 
Với n=3: số cách chọn: 3*2*1/6 = 1 đúng
Giả sử n=k đúng, cần chứng minh n đúng với n = k + 1
Ta có:
Với n = k + 1:
TH1: Chọn 3 phần tử trong k phần tử đầu: k*(k-1)*(k-2)/6
TH2: Chọn 2 phần tử trong k phần tử đầu và phần tử mới: k*(k-1)/2
-> k*(k-1)*(k-2)/6 + k*(k-1)/2 = (k+1)*k*(k-1)/6 (đccm)
