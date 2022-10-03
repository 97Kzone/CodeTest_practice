for _ in range(int(input())):
    words = list(input().rstrip())
    l = len(words)

    i = l-2
    while i >= 0 and words[i] >= words[i+1]:
        i -= 1

    if i == -1:
        print("".join(words))
        continue

    j = l-1
    while words[i] >= words[j]:
        j -= 1
    
    words[j], words[i] = words[i], words[j]
    words = words[:i+1] + list(reversed(words[i+1:]))
    print("".join(words))