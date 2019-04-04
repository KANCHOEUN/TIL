# Merge Sort ( 합병 정렬 )



```c
#include <stdio.h>
#define max 6

// conquer : 서열 정리
void Merge(int a[], int low, int mid, int high)
{
    int b[1000]; // 임시 array
    int i = low; // left의 시작
    int j = mid + 1; // right의 시작
    int k = 0;
    
    // 한쪽이 전멸할 때까지
    while(i <= mid && j <= high)
    {
        if(a[i] <= a[j])
        {
            b[k] = a[i];
            k++;
            i++;
        }
        else
        {
            b[k] = a[j];
            k++;
            j++;
        }
    }
    
    // left가 살아있다면
    while(i <= mid)
    {
        b[k] = a[i];
        i++;
        k++;
    }
        
    // right가 살아있다면
    while(j <= right)
    {
        b[k] = a[j];
        j++;
        k++;
    }
    
    k--;
    
    // 문서 작성
    while(k >= 0)
    {
        a[low + k] = b[k];
        k--;
    }
}

// divide : 대진표 작성
// recursive function (재귀 함수)
void MergeSort(int a[], int low, int high)
{
    // exit condition
    if(low < high)
    {
        int mid = (low + high) / 2;
        
        // left
        MergeSort(a, low, mid);
        // right
        MergeSort(a, mid+1, high);
        // fight
        Merge(a, low, mid, high);
    }
    else
    {
        return;
    }
}

int main()
{
    int a[max] = {20, 10, 70, 80, 40, 90};
    int i = 0;
    
    cout << "Before Merge" << endl;
    for(int i = 0; i < max; i++)
    {
        cout << a[i] << " ";
    }
    
    MergeSort(a, 0, max-1);
    
    cout << "After Merge" << endl;
    for(int i = 0; i < max; i++)
    {
        cout << a[i] << " ";
    }
}
```



##### recursive function( 재귀 함수 )는

1. exit condition일 때 함수에서 나가는 부분과

2. exit condition이 아닐 때 함수를 진행하는 부분으로 나누어진다.



```
if(!exit condition)
{
    // 재귀 함수를 계속 진행하는 부분
}
else
{
    return; // 재귀 함수를 빠져나가는 부분
}
```



[ 출처 ] : 알고리즘 투게터 with 거니 강의 + a