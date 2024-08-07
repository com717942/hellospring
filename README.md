스프링 입문 - 코드로 배우는 스프링 부트

김영한

https://www.youtube.com/watch?v=wCCMoUatat8&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd&index=18

ex)
http://localhost:8080/helloapi?name=spring


myproject
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── hello
│       │               ├── controller
│       │               │   ├── HomeController.java
│       │               │   ├── MemberController.java
│       │               │   └── MemberForm.java
│       │               ├── domain
│       │               │   └── Member.java
│       │               ├── repository
│       │               │   ├── MemberRepository.java
│       │               │   └── MemoryMemberRepository.java
│       │               └── service
│       │                   └── MemberService.java
│       └── resources
│           ├── static
│           │   └── index.html
│           └── templates
│               ├── home.html
│               └── members
│                   ├── createMemberForm.html
│                   └── memberList.html
└── build.gradle
