N = input().rstrip()
dic = {"0":"0", "1":"1", "2":"2", "3":".", "4":".", "5":"5", "6":"9", "7":".", "8":"8", "9":"6"}

def isPrime(n):
    m = int(n**0.5)
    for i in range(2, m+1):
        if n % i == 0:
            return False
    return True


if not isPrime(int(N)) or int(N) == 1:
    print("no")
else:
    num = ""
    for v in N[::-1]:
        if dic[v] == ".":
            print("no")
            exit()
        num += dic[v]

    print("yes" if isPrime(int(num)) else "no")
