def solve():
    n, b, c = map(int, input().split())
    if b == 0:
        if n > c + 2:
            print(-1)
        elif c>=n:
            print(n)
        else:
            print(n - 1)
        return
    low = 0
    high = n

    while low < high:
        mid = low + (high - low) // 2
        rem = n - mid
        req = c + (rem - 1) * (b - 1)
        if mid >= req:
            # if (mid - req) < b:
            #     print(mid)
            #     return
            high = mid
        else:
            low = mid + 1
    print(high)

t = int(input())
for _ in range(t):
    solve()
