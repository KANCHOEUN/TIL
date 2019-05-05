#include <iostream>
using namespace std;

void Merge(int *(&a), int left, int mid, int right)
{
  int len = (sizeof(a) / sizeof(int)) * 2 + 1;
  int b[(sizeof(a)/sizeof(int))*2 + 1];
  int i = left;
  int j = mid + 1;
  int k = 0;

  while(i <= mid && j <= right)
  {
    if(a[i] <= a[j])
    {
      b[k++] = a[i++];
    }
    else
    {
      b[k++] = a[j++];
    }
  }
  while(i <= mid)
  {
    b[k++] = a[i++];
  }
  while(j <= right)
  {
    b[k++] = a[j++];
  }
  k--;
  while(k >= 0)
  {
    a[left + (k--)] = b[(k--)];
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
  cin >> N;

  int * arr = new int[N];

  for(int i = 0; i < N; i++)
  {
    cin >> arr[i];
  }

  MergeSort(arr, 0, N-1);

  for(int i = 0; i < N; i++)
  {
    cout << arr[i] << endl;
  }

  return 0;
}
