## Memory Hierarchy

###### 목표 : Large and Fast

![MemoryHierarchy-(1)](../Images/MemoryHierarchy-(1).JPG) 

###### 메모리 장벽 문제

: CPU 는 빠른 속도로 발전해왔는데 memory 속도는 발전이 더딤

: 메모리는 CPU 보다 훨씬 느리기 때문에 효율적으로 해결하기 위해 memory hierarchy



- Minimum Cost 에 Maximum Performance

- Faster memory 는 processor 에 가까움
- Fast memory 는 작고 비쌈



> ##### Principle of Locality
>
> : Memory Access에 대해 어느 부분만 집중적으로 사용
>
> 
>
> ###### " 각 시점에서 사용된 Memory 주소 "
>
> ![MemoryHierarchy-(2)](../Images/MemoryHierarchy-(2).JPG) 
>
> 1. ##### Temporal Locality ( → )
>
>    : Locality in **Time**
>
>    : Items **accessed recently** are likely to be accessed again soon ( 하나의 데이터 다시 참조 )
>
>    
>
> 2. ##### Spatial Locality ( ↑ )
>
>    : Locality in **Space**
>
>    : Items **near those accessed recently** are likely to be accessed soon ( 주위의 데이터 )
>
>    



### 용어 정리

##### (1) Block ( = Line )

​	: 두 계층 간 정보의 최소 단위

##### (2) Hit

​	: 프로세서가 요구한 데이터가 상위 계층의 어떤 블록에 있는 경우

##### (3) Miss

​	: 상위 계층에서 찾을 수 없을 때 실패

​	: 이 때 필요한 데이터를 포함하는 블록을 찾기 위해 하위 계층 메모리에 접근하게 됨

###### (4) Hit rate ( = hit ratio )

​	: hit / ( hit + miss )

###### (5) Miss rate

​	: 1 - hit rate

​	: miss / ( hit + miss )



### Performance of the Memory Hierarchy

: 메모리 계층 구조를 만든 가장 큰 이유는 **성능 향상**이기 때문에 **적중과 실패의 처리 속도**가 매우 중요



##### (1) Hit time

​	: 메모리 계층 구조의 한 계층에 접근하는 데 필요한 시간

​	: 접근이 적중인지 실패인지 결정하는 데 필요한 시간 또한 포함



##### (2) Miss penalty

​	: Miss 가 발생하면 추가적으로 걸리는 시간

​	: 하위 계층에서 상위 계층으로 블록을 인출하는 데 걸리는 시간

​	: 블록에 접근하고 한 계층엣 다른 계층으로 전달하여 실패가 발생한 계층에 넣은 뒤 블록을 넘겨주는 시간 포함



#### Average Memory Access Time = ( Hit time ) + ( Miss rate ) x ( Miss penalty )

: 메모리의 performance 를 좌우함