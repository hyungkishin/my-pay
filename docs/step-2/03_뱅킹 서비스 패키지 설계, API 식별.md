# 뱅킹 서비스 패키지 설계, API 실별

### Banking Service (뱅킹 서비스)
- 외부 은행과의 직접적인 통신을 담당하고, 펌뱅킹 계약이나 수수료 관리 등 외부 은행 사용과 관련된 모든 기능을 제공하는 서비스

### Banking Service MVP Version (뱅킹서비스, Minimal Viable Product)
- 외부 은행과 입/출금 요청(펌뱅킹 통신을 담당하고, 내부 고객의 계좌 정보를 등록하는 서비스)

### 도메인 모델 기반, 모델 객체 식별해보기

- 계좌 연동
  - RegisteredBankAccount ( 고객 계좌 등록 )
  - RegisteredBankAccountHistory ( 고객 계좌 기록 )
- 펌뱅킹 관련 
  - RequestFirmBanking ( 받는사람 보내는 사람 (은행 정보 ) , 금액 , 시간 )
  - RequestFirmBankingHistory (기록 )
  - BankAccount (외부 은행 수많은 정보 개설, 폐쇄, 세금)

### API 설계
- Query 
  - 입금/출금 요청 내역 조회
    - find - FirmBankingInfo ( -by - membershipId )
      - Request: membershipId
      - Response: Firmbanking Object
  - 고객의 연동된 계좌 조회
    - find - RegisteredBankAccount
      - Request: membershipId
      - Response: RegisteredBankAccount Object

- Command
  - 고객 정보에 대한 요청된 Account 정보를 매핑, 연동
    - register - BankAccount ( -with - membershipId )
      - Request: membershipId, BankAccount
      - Response: RegisteredBankAccount Object
  - 실제 실물 계좌에서의 입/출금을 요청하는 펌뱅킹을 요청, 수행
    - request - Firmbanking - ( - to Remittance ) - ( - with BankAccount )
      - Request: form Bank Account to Bank Account, Money
      - Response: RequestFirmbankingUUID