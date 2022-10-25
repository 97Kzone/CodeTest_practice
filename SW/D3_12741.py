from itertools import accumulate
res = []
for t in range(1, int(input())+1):
    num = [0] * 102

    a1, a2, b1, b2 = map(int, input().split())
    num[a1] += 1
    num[a2+1] -= 1
    num[b1] += 1
    num[b2+1] -= 1

    nums = list(accumulate(num))
    cnt = nums.count(2)
    res.append(cnt-1 if cnt != 0 else 0)

for i in range(1, len(res)+1):
    print("#{} {}".format(i, res[i-1]))