### docker-compose 란

- 서비스 들의 집합을 의미한다
- 서비스 들을 어떻게 여러개의 이미지로써 도커 compose 화 시킬꺼야 라는것

> mysql 아래 에러 나타날 시
> - 2023-10-02 14:26:50 2023-10-02 05:26:50+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.0.34-1.el8
    started.
    2023-10-02 14:26:50 2023-10-02 05:26:50+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
    2023-10-02 14:26:50 2023-10-02 05:26:50+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.0.34-1.el8
    started.
    2023-10-02 14:26:50 2023-10-02 05:26:50+00:00 [ERROR] [Entrypoint]: Database is uninitialized and password option is
    not specified
    2023-10-02 14:26:50 You need to specify one of the following as an environment variable:
    2023-10-02 14:26:50 - MYSQL_ROOT_PASSWORD
    2023-10-02 14:26:50 - MYSQL_ALLOW_EMPTY_PASSWORD
    2023-10-02 14:26:50 - MYSQL_RANDOM_ROOT_PASSWORD
> - 솔루션
> - mysql 컨테이너는 root 유저의 password를 어떻게 할 것인지에 대해 옵션을 명시해야 한다.
> - 아래 3개의 항목 중 하나를 선택해 컨테이너 안에 환경변수로 넘겨 준다.
> - docker run mysql -e MYSQL_ROOT_PASSWORD=1234
> - docker run mysql -e MYSQL_ROOT_PASSWORD=rootpassword