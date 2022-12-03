words = list(input())
check = [0]*26

for i, v in enumerate(words):
    check[ord(v)-ord('a')] += i+1

res = ""
if i < 25:
    for idx, v in enumerate(check):
        if not v:
            res = "".join(words) + chr(idx+ord('a'))
            break
else:
    for i in range(25, -1, -1):
        v = ord(words[i])-ord('a')
        for j in range(v+1, 26):
            if check[v] < check[j]:
                words[i] = chr(j+ord('a'))
                res = "".join(words[:i+1]) 
                print(res)
                exit()

print(-1 if res == "" else res)