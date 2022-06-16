from itertools import combinations as cb

heights = [int(input()) for _ in range(9)]

datas = list(cb(heights, 7))
res = []

for data in datas:
    if sum(data) == 100:
        res = list(data)
        break

res.sort()
for val in res:
    print(val)

# 연습, 별거없음
# 브론즈2, 정답률 47프로 solved 22-02-06