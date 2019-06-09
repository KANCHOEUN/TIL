# 파이프라이닝 ( Pipelining )

###### 지금까지의 프로세스 설계

![pipelining(1)](../Images/pipelining(1).JPG) 

: 명령어를 fetch, decode, execute 까지 완전히 다 끝나야

  다음 명령어를 fetch, decode, execute 할 수 있는 것



##### 파이프라이닝 ( Pipelining )

![pipelining(2)](../Images/pipelining(2).JPG) 

: 하나가 완전히 끝나기 전에 다른 명령어가 실행되어 동시에 여러 개의 명령어가 실행 상태

: **여러 개의 명령어가 중첩돼서 실행**되는 구현 기술

: 프로세서에는 여러 개의 명령어가 한꺼번에 들어와 있음 → 시간 단축 → 성능 개선

: individual execution time ( 각각의 명령어 실행 시간 ) 을 개선하는 것이 아니라

  **<span style="color:RoyalBlue">1초 동안 실행할 수 있는 명령어의 개수 ( improves instruction throughput ) 가 늘어남</span>**



### 5 Stages of Instruction Execution

1. **Fetch** Instruction ( IF )

   : 명령어를 instruction memory 에서 읽어오고 PC 증가

2. **Read registers** while decoding the instruction ( ID )

3. **Execute the operation or calculate an address** ( EX )

   : ALU 에서 명령어 실행 및 주소 계산

4. **Access** an operand in **data memory** ( MEM )

   : 읽고 (lw) / 쓰고 (sw)

   : R-type 명령어는 4번째 단계 없음

5. **Write** the result into a **register** ( WB )

   : 결과를 register에 쓴다.



#### A Pipelined MIPS Processor

- **Improves Throughput** ( 처리량 )

- Instruction Latency is not reduced

  : 명령어 하나 실행하는데 걸리는 시간은 오히려 늘어남

- **Clock Cycle ( = Pipeline Stage Time )** is limited by the **Slowest** stage

  : CCT 는 **가장 느린 스테이지**에 의해 결정되어야 함

- For some instructions, some stages are **wasted** cycles

  : 시간이 짧게 걸리는 스테이지는 **시간이 낭비**됨
  
  - sw 는 register 에 저장 X
  - R - type 명령어는 Mem 단계 X



> ##### Example
>
> ![pipelining(3)](../Images/pipelining(3).JPG) 
>
> ![pipelining(4)](../Images/pipelining(4).JPG)  
>
> ###### single - cycle time
>
> : 한 명령어 당 800 ps
>
> ###### pipelined clock cyle time
>
> : 200 ps 이지만 명령어 하나 실행하는데 걸리는 시간은 오히려 늘어나서 1000 ps
>
> ![pipelining(5)](C:\Users\kanch\Desktop\TIL\Images\pipelining(5).JPG) 
>
>  



