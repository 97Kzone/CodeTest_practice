import sys
input = sys.stdin.readline

N, C = map(int, input().split())
nums = list(map(int, input().split()))
check = [0] * 100000001

for num in nums:
    check[num] += 1

if not check[C]:
    for i in range(N):
        for j in range(i+1, N):
            v = nums[i] + nums[j]
            if v == C:
                print(1)
                exit()
            elif v < C:
                tmp = C - v
                if check[tmp] and tmp != nums[i] and tmp != nums[j]:
                    print(1)
                    exit()
else:
    print(1)
    exit()
print(0)
