cnt = int(input())
meas = list(map(int, input().split()))

meas.sort()
print(meas[0] * meas[-1])

# 그냥 연습
# 실버 5, solved 22-02-05