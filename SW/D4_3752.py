from itertools import combinations as cb

answer = []
for t in range(1, int(input())+1):
    N = int(input())
    nums = list(map(int, input().split()))

    check = [0] * (sum(nums)+1)
    check[0] = 1

    l = len(check)
    for num in nums:
        for i in range(l-num, -1, -1):
            if check[i] == 1:
                check[i+num] = 1

    answer.append(sum(check))

for i in range(1, t+1):
    print("#{} {}".format(i, answer[i-1]))