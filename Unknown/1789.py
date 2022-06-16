S = int(input())

cnt = 1

while cnt <= S:
    S -= cnt
    cnt += 1

print(cnt-1)

#정답률 43프로, EASY
#solved 2022-01-03