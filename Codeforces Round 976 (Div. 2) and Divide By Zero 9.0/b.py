import math

def count_non_perfect_squares(n):
    sqrt_n = math.isqrt(n)
    return n - sqrt_n 

def solve(k):
    low, high = 1, 2 * 10**18
    while low < high:
        mid = (low + high) // 2
        if count_non_perfect_squares(mid) < k:
            low = mid + 1 
        else:
            high = mid
    return low 

t = int(input())
for _ in range(t):
    k = int(input()) 
    result = solve(k)
    print(result)
