mod = int(1e9 + 7)

def power(a, b):
    if a == 0:
        return 0
    ans = 1
    while b > 0:
        if b & 1:
            ans = (ans * a) % mod
        a = (a * a) % mod
        b >>= 1
    return ans

def inv(a):
    return power(a, mod - 2)

def solve():
    t = int(input())  # Number of test cases
    for _ in range(t):
        n = int(input())
        a = list(map(int, input().split()))

        # Check if n matches the length of a
        if len(a) != n:
            print("Error: The length of the array does not match n.")
            continue
        
        sum_val = a[0] % mod
        ans = 0
        cnt = (n * (n - 1)) // 2
        val = inv(cnt) % mod

        for i in range(1, n):
            ans = (ans + ((sum_val * a[i]) % mod) * (val % mod)) % mod
            sum_val = (sum_val + a[i]) % mod
        
        print(ans % mod)

solve()
