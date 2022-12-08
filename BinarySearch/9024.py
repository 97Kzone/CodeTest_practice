import sys
from collections import defaultdict
input = sys.stdin.readline

for _ in range(int(input())):
    N, K = map(int, input().split())

    dic = defaultdict(int)
    nums = list(map(int, input().split()))
    nums.sort()

    i, j = 0, N-1
    while i < j:
        v = nums[i] + nums[j]
        dic[abs(K-v)] += 1

        if v >= K:
            j -= 1
        else:
            i += 1

    res = dic.keys()
    print(dic[sorted(res)[0]])
