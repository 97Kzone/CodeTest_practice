N = int(input())
std = [[1, 0], [0, 1]]

for i in range(2, 41):
    std.append([std[i-2][0] + std[i-1][0], std[i-2][1] + std[i-1][1]])

nums = [int(input()) for _ in range(N)]

temp = []
for num in nums:
    temp.append(map(str, std[num]))

for res in temp:
    print(" ".join(res))

# 해보면 풀리는 문제
# 실버 3, 정답률 30프로 solved 2022-01-21