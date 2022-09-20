import sys
from collections import deque
input = sys.stdin.readline

N, W, L = map(int, input().split())
trucks = deque(list(map(int, input().split())))

res = 1
q = deque([0] * (W-1)) #첫 차를 다리에 올린 상태로 시작
q.append(trucks.popleft())
s = sum(q) #현재 다리에 올라간 무게

while s != 0:
    #다리 위 트럭 한 칸 씩 전진
    q.popleft()
    q.append(0)
    s = sum(q)

    # 트럭이 남아있다면
    if trucks:
        if s + trucks[0] <= L:
            q[-1] = trucks.popleft()
    else:
        res += W
        break

    res += 1
    s = sum(q)

print(res)