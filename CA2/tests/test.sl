int f(int a , int b):
    return a
end

int g(int a , int b):
    f(a , b)
end

int main():
    int x
    int y
    g(f(x,y),y)
end