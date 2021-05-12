#include<algorithm>
#include<iostream>
#include<cmath>
using namespace std;
bool cmp(int i, int j) {

    return abs(i) < abs(j);
}
int main() {
    int a[10] = {1, -2, 5, -6, -10, 8, 7, -16, 17, -18};
    for(int i = 0; i < 10; i++)
        sort(a, a + 10, cmp);
    for(int i = 0; i < 10; i++)
        cout << a[i] << ' ';
    return 0;
}
