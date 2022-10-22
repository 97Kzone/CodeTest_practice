#재귀호출 사용
def check(a, b, c):
    if b == c:
        return a
    
    return a * check(a, b, c+1)

for _ in range(10):
    t = int(input())
    n, m = map(int, input().split())
    res = check(n, m, 1)
    print("#{} {}".format(t, res))