#include <stdlib.h>
#include <stdio.h>
#include <limits.h>
#include <math.h>

int midpt1(int x, int y) { // Definition 2
    return x + div(y-x, 2).quot;
}

int midpt(int x, int y) {
    return x <= y ? (y-x)/2 + x : (x-y)/2 + y;
}

int midpt2(int x, int y) { // Definition 1
    return div(x+y, 2).quot;
}

float hyp(float x, float y) {
    float a = fabsf(x), b = fabsf(y);
    if (a > b) {
        b = b/a;
        return sqrtf(1.0f + b*b)*a;
    } else
        if (a < b) {
            a = a/b;
            return sqrtf(1.0f + a*a)*b;
        } else { // This works even when a == b == 0.0f
            return a*sqrtf(2.0f);
        }
}

float heron_area(float a, float c) {
    float s = (a+a+c)/2.0f;
    return (s-a)*sqrtf(s*(s-c));
}

float baseht_area(float a, float c) {
    float d = c/(2.0f*a);
    return sqrtf(1.0f - d*d)*a*c*0.5f;
}

int main(void) {
    float c = 1.0f, a = 1.0f;
    for (int i = 0; i < 20; i++) {
        printf("%2d %g\n", i, heron_area(a, c));
        printf("%2d %g\n", i, baseht_area(a, c));
        a *= 10.0f;
    }
    return 0;
}
