#include <cstdio>
#include <cstring>
#define MAX 7

int main()
{
  char arr[MAX];
  int ten = 0;

  scanf("%s", arr);

  int len = strlen(arr);
  int m = 1;

  for(int i = len - 1; i >= 0; i--)
  {
    if('0' <= arr[i] && arr[i] <= '9')
    {
      ten += (arr[i] - '0') * m;
    }
    else
    {
      ten += (arr[i] - 'A' + 10) * m;
    }
    m = m * 16;
  }

  printf("%d", ten);

  return 0;
}
