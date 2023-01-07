for t in range(1, int(input())+1):
    words = input()
    print("#{} {}".format(t, "1" if words == words[::-1] else "0"))