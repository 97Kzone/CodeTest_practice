import sys

n,t = map(int, sys.stdin.readline().strip().split())
people = []
llis = 0 ; rlis = 0
maxl = -1 
maxr = -1
res = 10**10 

for _ in range(n) :
    l,r = map(int, sys.stdin.readline().strip().split())
    people.append((l,r, r-l)) 

    llis+=l 
    rlis+=r 

    if maxl < l : maxl = l
    if maxr < r : maxr = r

if llis > t or rlis < t :
        print(-1)
        exit(0)

l,r = maxl, maxr 

while l<=r : 
    mid = (l+r)//2 
    chk = t 
    cover = 0 

    for p in people : 
        pl,pr, pcover = p[0], p[1], p[2] 

        chk-=pl 

        cover+= min(mid-p[0], p[2]) 

    if cover >= chk :

        if res > mid : 
            res = mid
        r=mid-1

    else : 
        l=mid+1

else : print(res)