int sum(int a, int b):
    return a + b
end

int doubleSum(int x):
    return sum(x, x)
end

int main():
    int x
    doubleSum(sum(x, y))
end