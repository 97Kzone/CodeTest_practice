import sys
input = sys.stdin.readline

#i번째 최소값이 J 라면 J-1번쨰까지 최소값은 전부 J다.
N = int(input())
nums = list(map(int, input().split()))
res = []

i, j = 0, 1
while i <= j:
    if i == N-1:
        break

    if nums[i] != nums[j]:
        res += [j+1] * (j-i)
        i = j
        j += 1
    elif j == N-1 and nums[i] == nums[j]:
        res += [-1] * (j-i)
        break
    elif nums[i] == nums[j]:
        j += 1

res += [-1]
print(*res)