# MIPS Processor, Datapath Design



## A Simplified Version



> ##### 대표적인 명령어 9가지

#### 1. Memory-reference Instructions : lw, sw

#### 2. Arithmetic-logical Instructions : add, sub, and, or, slt

#### 3. Branch Instructions : beq, j



> ### 명령어의 실행 과정

#### The First Step

- Instruction Fetch : Send **(1) PC** to **(2) memory**
- PC = PC **(3) +** 4

![MIPSProcessor-(1)](../Images/MIPSProcessor-(1).JPG) 

(1) Instruction Memory : 프로그램의 명령어를 저장

(2) Program Counter ( PC ) : 명령어의 주소를 저장

(3) Adder : PC + 4 를 계산



#### The Second Step

- Opcode **decoding** → Control Unit 에 해당
- **(4) Register** **pre**fetch



: MIPS 명령어 format을 잘 설계해놓아서 무슨 명령어인지 모르는 상태에서 register를 읽어낼 수 있다.

  명령어 종류에 관계없이 읽어야 할  register 번호는 항상 똑같은 위치에 있다.

: Opcode decoding 결과 제어 신호를 발생시킨다. ( generate control signals )



(4) Register



#### The Third Step & The Final Step

##### (1) Arithmetic-logical Instructions ( R-format Instructions )

![MIPSProcessor-(2)](../Images/MIPSProcessor-(2).JPG) 

읽는 것은 제어 신호가 필요 없지만 쓰는 것은 제어 신호가 필요하다 !



##### (2) Memory-reference Instructions

- Compute a Memory Address by Adding the Base Register to the Sign-extended 16-bit Offset
- Major Components
  - Sign extension unit
  - Data Memory



###     Datapath for STORE Instructions

![MIPSProcessor-(3)](../Images/MIPSProcessor-(3).JPG) 

1. rs, rt ( register prefetch )
2. 주소 계산을 할 때 base register가 들어가고
3. 명령어 16 bit가 부호 확장 돼서 ALU로 들어가고 ALU에서 계산되어 나온 값이 effective address
4. ALU 결과 값을 Address로 주고 Data2는 Write Data로. 그리고 MemWrite 신호 !



###    Datapath for LOAD Instructions

![MIPSProcessor-(4)](../Images/MIPSProcessor-(4).JPG) 

   Store의 과정과 1, 2, 3이 같다.

4. Memory Read 하려면 주소를 줘야 하고 Memory Read 신호만 1로 준다.
5. 데이터를 write data로 보내고 RegWrite 신호를 1로 준다.



##### (3) Branch Instructions



![MIPSProcessor-(5)](../Images/MIPSProcessor-(5).JPG) 

- Use ALU for comparison
  - 빼기를 한 결과가 0일 경우 PC + 4
  - 빼기를 한 결과가 1일 경우 Branch Target Address
- (PC + 4) + sign-extended offset * 4
  - 4를 곱하기를 표현하기 위해 shift left 연산
  - (PC + 4) 와 sign-extended offset * 4 의 더하기 연산



- Change PC based on comparison



- Main Component
  - Shift-left-2 unit
  - Separate Adder



## The Simplest Datapath

충돌이 일어나는 부분에는 Multiplexer 를 추가한다.



![MIPSProcessor-(6)](../Images/MIPSProcessor-(6).JPG) 



[ 출처 ] 컴퓨터 구조 및 설계 5th Edition, David A.Patterson / John L. Hennssy 지음

개인적으로 공부하며 정리한 것