import sys
input = sys.stdin.readline

d = {"a":"aespa", "b":"baekjoon", "c":"cau", "d":"debug", "e":"edge",
"f":"firefox", "g":"golang", "h":"haegang", "i":"iu", "j":"java", "k":"kotlin",
"l":"lol", "m":"mips", "n":"null", "o":"os", "p":"python", "q":"query", "r":"roka",
"s":"solvedac", "t":"tod", "u":"unix", "v":"virus", "w":"whale", "x":"xcode", "y":"yahoo", "z":"zebra"}

s = input().rstrip()
res = ""

while s:
    l = len(s)
    c = s[0]
    s = s.replace(d[c], "", 1)

    if len(s) == l:
        print("ERROR!")
        break

    res += c
else:
    print("It's HG!")
    print(res)

# 시간초과 뭐가 문제지 ?