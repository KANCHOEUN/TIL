#include <iostream>
#define MAX 1000001
int tmp[MAX];

void Merge(int *(&a), int left, int mid, int right)
{
  int i = left;
  int j = mid + 1;
  int k = 0;

  while(i <= mid && j <= right)
  {
    if(a[i] <= a[j])
    {
      tmp[k++] = a[i++];
    }
    else
    {
      tmp[k++] = a[j++];
    }
  }
  while(i <= mid)
  {
    tmp[k++] = a[i++];
  }
  while(j <= right)
  {
    tmp[k++] = a[j++];
  }
  k--;
  while(k >= 0)
  {
    a[left + k] = tmp[k];
    k--;
  }
}

void MergeSort(int *(&arr), int left, int right)
{
  if( left < right )
  {
    int mid = ( left + right ) / 2;
    MergeSort(arr, left, mid);
    MergeSort(arr, mid + 1, right);

    Merge(arr, left, mid, right);
  }
  else
  {
    return;
  }
}

int main()
{
  int N;
  scanf("%d", &N);

  int * arr = new int[N];

  for(int i = 0; i < N; i++)
  {
    scanf("%d", &arr[i]);
  }

  MergeSort(arr, 0, N-1);

  for(int i = 0; i < N; i++)
  {
    printf("%d\n", arr[i]);
  }

  return 0;
}
