# 2023_SIG_Cloudnative_Spring

### 매주 진행한 코드를 올리는 저장소 입니다

### 프로젝트 구조
```
📦 
├─ .gitignore
├─ README.md
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
└─ src
   ├─ Description.md
   ├─ main
   │  ├─ java
   │  │  └─ SiG
   │  │     └─ demo
   │  │        ├─ Config
   │  │        │  ├─ AppConfig.java
   │  │        │  └─ PureJavaConfig.java
   │  │        ├─ DemoApplication.java
   │  │        ├─ EncodeUtil
   │  │        │  ├─ EnforcedEncoder.java
   │  │        │  ├─ PasswordEncoder.java
   │  │        │  ├─ SimpleEncoder.java
   │  │        │  └─ SimplePasswordEncoder.java
   │  │        ├─ Entity
   │  │        │  └─ User.java
   │  │        ├─ Repository
   │  │        │  ├─ Memory2UserRepository.java
   │  │        │  ├─ MemoryUserRepository.java
   │  │        │  └─ UserRepository.java
   │  │        ├─ SingletonApplication.java
   │  │        └─ UserService
   │  │           ├─ SingletonService.java
   │  │           ├─ UserModifyService.java
   │  │           ├─ UserModifyServiceImpl.java
   │  │           ├─ UserService.java
   │  │           └─ UserServiceImpl.java
   │  └─ resources
   │     └─ application.yml
   └─ test
      └─ java
         └─ SiG
            └─ demo
               ├─ BeanTest.java
               └─ SingletonTest.java
```

### 실행 방법
#### Eclipse
Eclipse의 경우 IDE 차이로 현재 불가능. 추후 Update 하겠습니다.

#### IntelliJ
```
git bash 혹은 Terminal, IntelliJ Terminal 에서 진행하시면 됩니다.

- mkdir (원하는 폴더 이름)
- cd (원하는 폴더 이름)
- git init
- git remote add (현재 github 주소) (원하는 remote 이름)
- git pull (원하는 remote 이름) main
- Settings -> Build,Excecution,Deployment -> Build tools -> Gradle 로 이동 후, 
  Build and run using과 Run tests using을 IntelliJ IDEA로 변경 하시면 됩니다.
```

git pull 혹은 remote 저장소 등록 시 아래의 사진처럼 Code 클릭 후 주소를 복사하면 됩니다. 
<img src="img/Git pull.png">

### Spring 1주차
- Spring Framework란?
  - https://dhtechblog.notion.site/Spring-Framework-2adee5e5c4834e098ce321119d6c4c4b
- Ioc와 DI
  - https://dhtechblog.notion.site/IOC-DI-d8cf6b9a59d94e549ec72a3560e980d6
- Spring Container & Bean
  - https://dhtechblog.notion.site/Spring-Container-Bean-54a099df12bb4798967184e5b9f8029a
- Spring의 빈 조회
  - https://dhtechblog.notion.site/Spring-f48ffb58546c436292a61dbef20e8032
- Singleton Pattern
  - https://dhtechblog.notion.site/SingleTon-Pattern-de305551616e46b288f315bcf1f1317d

### Spring 2주차
- Singleton Container
- Singleton 방식의 주의점
- @Configuration과 Singleton
- Component Scan과 자동 주입
- Component Scan의 스캔 방식
- 중복 등록, 충돌
