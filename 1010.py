import itertools
import sys
from itertools import product as pro

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())

    nums1 = [i for i in range(1, N+1)]   
    nums2 = [i for i in range(1, M+1)]

    temp = list(pro(nums1, nums2))
    print(temp)
