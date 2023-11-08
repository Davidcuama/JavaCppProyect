#include <iostream>

extern "C" {
    int findMaximum(const int* arr, int numElements) {
        int max = arr[0];
        for (int i = 1; i < numElements; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}