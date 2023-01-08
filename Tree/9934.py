def make(arr, d):
    m = (len(arr)//2)
    res[d].append(arr[m])

    if len(arr) == 1:
        return
    
    make(arr[:m], d+1)
    make(arr[m+1:], d+1)

K = int(input())
nums = list(map(int, input().split()))
res = [[] for _ in range(K)]

make(nums, 0)
for i in range(K):
    print(*res[i])
