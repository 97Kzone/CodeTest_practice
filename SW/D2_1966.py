for t in range(1, int(input())+1):
    N = int(input())
    nums = list(map(int, input().split()))
    nums.sort()
    print("#{} {}".format(t, " ".join(str(n for n in nums))))