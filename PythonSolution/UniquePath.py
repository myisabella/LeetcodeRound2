def getUniquePaths(m, n):
    return dfs(0, 0, m, n)

def dfs(i, j, m, n):
    if i == m - 1 and j == n - 1:
        return 1
    if i < m - 1 and j < n - 1:
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n)
    if i < m - 1:
        return dfs(i + 1, j, m, n)
    if j < n - 1:
        return dfs(i, j + 1, m, n)
    return 0

def getUniquePathsDP(m, n):
    if m == 0 or n == 0:
        return 0
    if m == 1 or n == 1:
        return 1

    matrix = [[0 for x in xrange(m)] for y in xrange(n)]

    for i in xrange(m):
        matrix[i][0] = 1

    for j in xrange(n):
        matrix[0][j] = 1

    for i in xrange(1, m):
        for j in xrange(1, n):
            matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1]

    return matrix[m - 1][n - 1]

print getUniquePaths(10, 10)
print getUniquePathsDP(20, 20)
