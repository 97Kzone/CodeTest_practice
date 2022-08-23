import sys
from collections import deque, Counter as C
input = sys.stdin.readline

N, K = map(int, input().split())
q = deque(map(int, input().split()))
robots = deque([0] * N)

res = 0
cnt = C(q)[0] # 내구도 0 개수
while cnt < K:
    res += 1

    #1 컨베이어 벨트가 한칸 전진
    q.appendleft(q.pop())
    robots.appendleft(0)
    robots.pop()

    #2. 내리는 위치에 로봇 있든 없든 내려
    robots[-1] = 0

    #3. 로봇을 한 칸씩 전진
    idx = N-2
    for idx in range(N-2, 0, -1):
        if robots[idx] == 1 and robots[idx+1] == 0: #로봇이 있다
            if q[idx+1] >= 1:
                robots[idx+1] = 1
                robots[idx] = 0
                q[idx+1] -= 1

        idx -= 1
    
    #4. 이동 후 내리는 위치 로봇은 치운다
    robots[-1] = 0

    #5. 로봇을 올리자
    if q[0] >= 1:
        robots[0] = 1
        q[0] -= 1
    
    #6. 내구도 0 개수 체크
    cnt = C(q)[0]

print(res)