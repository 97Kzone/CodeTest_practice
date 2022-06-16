N = int(input())
time = [list(map(int, input().split())) for _ in range(N)]

temp = sorted(time, key = lambda x : x[0])
std = 0
for val in temp:
    if val[0] > std:
        std = sum(val)
    else:
        std += val[1]

print(std) 

# 초반 아이디어가 생각나지 않아 헤맨 문제, 간단한 접근이 오히려 정답..
# 정답률 66%, solved 2022-01-06