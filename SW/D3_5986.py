def init():
    nums = [True] * 1001
    n = int(1000 ** 0.5)
    for i in range(2, n+1):
        if nums[i]:
            for j in range(i+i, 1001, i):
                nums[j] = False

    return [i for i in range(2, 1001) if nums[i] == True]

for t in range(1, int(input())+1):
    nums = init()
    N = int(input())

    res = 0
    for i in range(len(nums)):
        if nums[i] > N:
            break
        for j in range(i, len(nums)):
            if nums[i] + nums[j] > N:
                break
            for k in range(j, len(nums)):
                v = nums[i] + nums[j] + nums[k]
                if v > N:
                    break

                if v == N:
                    res += 1 
                
    print("#{} {}".format(t, res))