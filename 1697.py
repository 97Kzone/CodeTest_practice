from collections import deque
q = deque()

def bfs():
    q.append(N)
    while q:
        val = q.popleft()
        if val == K:
            print(cnt[val])
            break

        for i in (val-1, val+1, val*2):
            if 0 <= i <= 100000 and not cnt[i]:
                cnt[i] = cnt[val] + 1
                q.append(i)


N, K = map(int, input().split())
cnt = [0] * 100001

bfs()