# 연결리스트로 Stack 구현 (C언어)

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct sNode
{
    char * data;
    struct sNode * next;
}Node;

typedef struct listStack
{
    Node * peek; // 제일 마지막애 들어온 놈을 빼낼 수 있는 !
    int size; // stack 안에 몇 개의 노드들이 들어가 있나
}listStack;

void createStack(listStack ** Stack)
{
    (*Stack) = (listStack *)malloc(sizeof(listStack));
    (*Stack)->peek = NULL;
    (*Stack)->size = 0;
}

Node * createNode(char * newChar)
{
    Node * newNode = (Node *)malloc(sizeof(Node));
    newNode->data = (char *)malloc(strlen(newChar) + 1);
    // 마지막의 NULL 값을 위해서 1을 더해준다.
    
    strcpy(newNode->data, newChar);
    newNode->next = NULL;
}

void deleteNode(Node * removeNode)
{
    free(removeNode->data);
    free(removeNode);
}

// 이 스택에 이 노드 넣어줘
void Push(listStack * Stack, Node * newNode)
{
    // when stack is empty
    if(Stack->size == 0)
    {
        Stack->peek = newNode;
    }
    // when stack is not empty
    else
    {
        newNode->next = Stack->peek;
        Stack->peek = newNode;
    }
    Stack->size++;    	
}

Node * Pop(listStack * Stack)
{
    Node * tempNode;
    
    // when stack is empty
    if(Stack->size == 0)
    {
        printf("Stack is Empty");
        tempNode = NULL;
    }
    // when stack is not empty
    else
    {
        tempNode = Stack->peek;
        Stack->peek = (Stack->peek)->next;
        Stack->size--;
    }
    
    return tempNode;
}

void deleteStack(listStack * Stack)
{
    int count = Stack->size;
    Node * tempNode;
    
    for(int i = 0; i < count; i++)
    {
        tempNode = Pop(Stack);
        deleteNode(tempNode);
    }
    free(Stack);
}

int main()
{
    listStack * Stack;
    
    createStack(&Stack);
    
    Push(Stack, createNode("a"));
    Push(Stack, createNode("b"));
    Push(Stack, createNode("c"));
    PUsh(Stack, createNode("d"));
    
    printf("abcd pushed\n");
    
    printf("\n--Current Stack--[size:%d]\n\n", Stack->size);
    
    Node * horse = Stack->peek;
    
    for(int i = 0; i < Stack->size; i++)
    {
        printf("%s\n", horse->data);
        horse = horse->next;
    }
    
    horse = Pop(Stack);
    horse = Pop(Stack);
    
    printf("\n--Current Stack--[size:%d]\n\n", Stack->size);
    
    horse = Stack->peek;
    
    for(int i = 0; i < Stack->size; i++)
    {
    	printf("%s\n", horse->data);
        horse = horse->next;
    }
    
    deleteStack(Stack);
    printf("\nStack has been completely freed\n");
}
```



#### Last In First Out 원칙



(1) **구조체 Node** 안에는

1. 다음 노드를 가르켜주는 pointer
2. 데이터가 들어갈 문자열



(2) **구조체 listStack** 안에는

1. 제일 마지막에 들어온 놈을 빼낼 수 있는 peek Node pointer
2. Stack 안에 몇 개의 노드들이 들어갔는지 알려주는 size

메모리를 할당해주는 함수 createStack



(3) **void 형 함수 createStack** 안에는

1. Stack의 껍데기를 받고
2. peek과 size를 초기화하여
3. 메모리를 할당해준다.



(4) **Node * 형 함수 createNode** 안에는

1. 문자열을 받고
2. Stack Node 에 대해 메모리를 할당해주고
3. 문자열에 한해서 메모리를 할당해준다.



(5) **Pop 함수**와 **Push 함수**

   **When stack is empty** 확인 방법

1. stack의 size가 0인 경우
2. stack의 peek이 Null Pointer인 경우



[ 출처 ] www.algotogether.com