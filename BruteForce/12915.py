nums = list(map(int, input().split()))
e, em, m, mh, h = nums

res = 0
while True:
    if e > 0:
        e -= 1
    elif em > 0:
        em -= 1
    else:
        break

    if h > 0:
        h -= 1
    elif mh > 0:
        mh -= 1
    else:
        break

    if m > 0:
        m -= 1
    else:
        if em > mh and em > 0:
            em -= 1
        elif em < mh and mh > 0:
            mh -= 1
        elif em == mh and em > 0:
            em -= 1
        else:
            break
    
    res += 1

print(res)

