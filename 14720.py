import sys
N = int(input())
nums = list(map(int, input().split()))

keys = [0, 1, 2]
key, res = 0, 0

for num in nums:
    if keys[key] == num:
        res += 1
        key = (key+1) % 3

print(res)

#1분짜리 알고리즘, 변수를 줄이는 생각을 하자
#solved 2021-12-28