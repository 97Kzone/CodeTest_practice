data = [0 for _ in range(11)]
data[0], data[1], data[2], data[3] = 1, 2, 4, 7

for i in range(4, 11):
    data[i] = sum(data[i-3:])


for _ in range(int(input())):
    print(data[int(input())-1])


# 수학적 접근이면 OK, 쉬운 문제
# 실버 3 정답률 62프로, solved 22-02-06