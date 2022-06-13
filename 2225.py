import math
N, K = map(int, input().split())

val = math.factorial(N+K-1) // (math.factorial(N) * math.factorial(K-1))

print(val % 1000000000)
