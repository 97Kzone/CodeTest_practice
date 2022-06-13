N = int(input())

for i in range(N):
    x, y = map(int, input().split())

    val = y - x
    cnt = 0

    while True:
        if val <= cnt*(cnt+1):
            break
        cnt += 1

    if val <= cnt ** 2:
        print(cnt*2-1)
    else:
        print(cnt*2)

# 수학적으로 케이스를 분류해야 하는 문제, 분류 후 규칙성을 찾는게 제일 애먹었다.
# 골드 5, 정답률 30프로, solved 2022-01-21