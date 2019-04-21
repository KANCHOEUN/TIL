#include <cstdio>
#define MAX 101

int main()
{
  int i = 0;
  char str[MAX];

  scanf("%s", str);

  while(str[i] != '\0')
  {
    printf("%c", str[i]);
    if( (i + 1) % 10 == 0 )
    {
      printf("\n");
    }
    i++;
  }

  return 0;
}
