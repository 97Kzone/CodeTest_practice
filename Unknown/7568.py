N = int(input())

sizes = [list(map(int, input().split())) for _ in range(N)]

#등수 매기기
res = []
for i in range(N):
    rank = 1
    for j in range(N):
        if sizes[i][0] < sizes[j][0] and sizes[i][1] < sizes[j][1]:
            rank += 1
    res.append(str(rank))

print(" ".join(res))

# 브루트 포스 연습