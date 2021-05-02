CREATE USER underbar IDENTIFIED BY ORACLE; --유저 생성

ALTER USER underbar IDENTIFIED BY underbar;--유저 비밀번호 변경

GRANT CONNECT, RESOURCE TO underbar;--underbar에 접속권한, 테이블 사용권한 부여 롤이용