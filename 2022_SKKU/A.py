N, X = map(int, input().split())
nums = list(map(int, input().split()))

i = 0
while True:
    if nums[i%N] < X:
        print((i%N) + 1)
        break
    X += 1
    i += 1

