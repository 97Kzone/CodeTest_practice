S = input()
word = input()

L = len(word)
cnt, idx = 0, 0
while True:
    if (idx + L) > len(S):
        break

    if S[idx:idx+L] == word:
        cnt += 1
        idx = (idx + L)
    else:
        idx += 1

print(cnt)
