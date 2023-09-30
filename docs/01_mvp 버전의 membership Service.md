### MVP 버전의 Membership Service 정의하기

- 멤버십 서비스
- - pay 라는 비즈니스에서 제공하는 멤버십 서비스로서, 페이에 가입하는 개인/법인 고객의 정보를 소유하고,
- 관련 정보의 변경에 대한 의무를 가진 서비스

- MVP Version
  - pay 라는 비스니스에서 제공하는 멤버십 서비스로서, 페이에 가입하는 개인/법인 고객의 정보를 소유하고 새로운 멤버십 의 추가가 가능하며, 이에 대한 정보를 조회할 수 있는 기능을 제공하는 서비스

> MVP : Minimum Viable Product
> 구현하고자 하는 제품의 핵심적인 가치를 골라 최소한의 기능만을 담아낸 제품

### API 설계
- Query
  - 고객 정보 를 통한 고객 정보의 조회
    - find - membership 
  - Request Params: memberhsipId
  - Response: Membership


- command
  - 필요한 고객 정보를 통한 신규 고객 멤버십의 생성
    - register - membership
      - request Params: membership 
      - response: registered membership with response code 