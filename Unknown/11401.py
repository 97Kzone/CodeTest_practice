import math

N, K = map(int, input().split())

if K < 0 or K > N:
    print(0)
else:
    res = (math.factorial(N) % 1000000007) // ((math.factorial(K)) % 1000000007 * (math.factorial(N-K) % 1000000007))
    print(res)