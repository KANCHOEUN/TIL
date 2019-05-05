#include <stido.h>

int LSearch(int ar[], int len, int target)
{
  int i;
  for(i = 0; i < len; i++)
  {
    if(ar[i] == target)
    {
      return i;
    }
  }
  return -1; // 찾지 못했음을 의미하는 값 반환
}

int main()
{
  int arr[] = {3, 5, 2, 4, 9};
  int index;

  index = LSearch(arr, sizeof(arr) / sizeof(int), 4);

  if(index == -1)
  {
    printf("탐색 실패\n");
  }
  else
  {
    printf("타겟 저장 인덱스 : %d\n", index);
  }

  index = LSearch(arr, sizeof(arr) / sizeof(int), 7);

  if(index == -1)
  {
    printf("탐색 실패\n");
  }
  else
  {
    printf("타겟 저장 인덱스 : %d\n", index);
  }

  return 0;
}
