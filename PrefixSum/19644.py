import sys
input = sys.stdin.readline

L = int(input()) # 거리
M, K = map(int, input().split()) #사거리, 데미지
C = int(input()) # 지뢰 수
zombies = [int(input()) for _ in range(L)]

#각 좀비들을 떄릴 수 있는 기회
hit = [(i+1) if i < M else M for i in range(max(M, L))]
cnt = 0
for i in range(L):
    # 만약 좀비가 없으면? = 기회를 한 턴 얻었다
    if zombies[i] == 0:
        cnt = max(cnt-1, 0)
        continue

    # 크레모아를 터트린다고 총 쏠 기회가 0 이 될 수 없다
    if hit[i] == 1:
        v = zombies[i] - hit[i]*K
    else:
        v = zombies[i] - (K * (hit[i] - cnt))

    # 위 경우를 다 뚫고 좀비 생존여부 확인
    if v <= 0:
        continue
    else:
        if C > 0:
            C -= 1
            cnt += 1
        else:
            print("NO")
            exit()

print("YES")