import sys

nums0 = [0] * 1000001
nums1 = [1] * 1000001

def make_data():
    for i in range(2, 1000001):
        for j in range(i, 1000001, i):
            nums1[j] += i
    
    for i in range(1, 1000001):
        nums0[i] = nums0[i-1] + nums1[i]

make_data()

T = int(input())
for _ in range(T):
    print(nums0[int(sys.stdin.readline())])

# 시간초과가 발생하는 문제, pypy 로 풀어야 풀린다.
# 골드5, 정답률 27프로, solved 22-02-05