# 스프링 학습용도로 사용됩니다.

## Java WIKI Engine

- SpringBoot 2.2.0
- Spring Data JPA
- MySQL
- thymeleaf
- Docker
- Jenkins or Travis CI
- nginx

## 기능 구현 목록 / 고려해야 할 사항

- 유저 권한 상관 없이 게시글 수정 가능
- 게시글 저장 방식
    - 동시성 제어(초기 배포까지는 동시수정 불가)
- 게시글 히스토리 저장 방식 (depth 는 어디까지?)
    - 히스토리 복원 가능할 경우
        - A,B,C 순에서 현재 C인데, B로 복원할 경우 C에 대한 기록은 어떻게 할지?
        - 위 문제에서 B 상태에 새로운 D로 수정하게 되면 C에 대한 기록은 어떻게?
        - 히스토리 순서는 어떻게 하는지?
    - 히스토리 복원 자체를 막음
        - 히스토리 조회는 가능하지만 복원은 불가능하다.
- 게시글 버저닝 방식
    - 게시글, 게시글 내용 간 관계 설계
    - 게시글, 유저 간 관계 설계
- Github OAuth
    - 유저 정보 받아오고 DB와 연결
    - 계정관리를 어떻게 할 것인지
- 검색 기능
    - 초기에는 Like 로 제목만 검색
    - Elastic Search 적용
- 배포 자동화
    - Jenkins 또는 Travis CI로 구축
    - Docker 활용하여 WAS 이중화
    - nginx 로 로드밸런싱
- HTTPS 적용