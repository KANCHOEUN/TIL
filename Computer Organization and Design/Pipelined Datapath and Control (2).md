# Pipelined Datapath and Control (2)

: 어떤 명령어든 1번째 스테이지와 2번째 스테이지는 똑같다 !



### Store Word Instruction Stage

: IF 와 ID 는 동일

: EX 스테이지에서 하는 일은 lw 와 똑같음



#### (4) MEM STAGE

![PipelinedDatapathAndControl-(7)](../Images/PipelinedDatapathAndControl-(7).JPG) 

: 3번째 스테이지에서 안쓰이는 것이 4번째 스테이지에서는 쓰임

: data memory 에 write data 신호를 보내면

  lw 는 출력부가 활성화되는 반면 **sw 는 memory write 입력부가 활성화**된다 !





#### (5) WB STAGE

![PipelinedDatapathAndControl-(8)](../Images/PipelinedDatapathAndControl-(8).JPG) 

: register write 를 하지 않으니까 **register 가 활성화되지 않는다.**

: 한 clock 낭비하는 것





### Pipelined Control

- 총 8개의 제어 신호

- ALUOp 가 2 bits로 총 9 bits

- Single Cycle 에서는 한 clock 안에 모든 제어 신호가 사용됐는데

  pipeline이 되면서 제어 신호가 시차를 두고 사용됨

- 1번째, 2번째 스테이지까지는 제어 신호 없음

  

![PipelinedDatapathAndControl-(9)](../Images/PipelinedDatapathAndControl-(9).JPG) 

##### (1) EX STAGE

1. **ALUSrc** : ALU 에 들어갈 2번째 입력이 rt 냐 부호확장한 offset 이냐

2. **ALUOp** : function code 를 보고 ALU 가 무슨 일을 하는 것인지 결정

3. **RegDst** : write 할 목적지 레지스터가 rt 냐 rd 냐

   ​			   다음 clock 에서 결정할 수 있음

   ( rt 와 rd 중 무엇을 쓸지 2번째 스테이지는 모르므로 둘 다 뒷 스테이지로 넘겨주면

     3번째 스테이지에서 opcode decoding 이 끝난 상태로 무슨 명령어인지 아는 상태이므로

     둘 중에 하나를 선택해서 가져감 )

   

##### (2) MEM STAGE

1. Branch : branch 할 것인지 아닌지

2. MemWrite

3. MemRead

   

##### (3) WB STAGE

1. **MemtoReg** : **register 에 write 할 데이터를 결정**하는 것

   ​					  write 할 데이터가 data memory 에 읽은 값이냐 ALU 에서 계산한 값이냐

2. **RegWrite** : 물리적으로는 2번째 스테이지에 있지만 실제로는 5번째 스테이지에 쓰는 제어신호

