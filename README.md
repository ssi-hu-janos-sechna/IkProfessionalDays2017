# IkProfessionalDays2017 - Microservice architecture

Az elindításhoz szükséges hogy telepítve egyen a gépen gradle és docker.
Az alábbi oldalakrol tudjátok telepíteni ezeket.

https://gradle.org/

https://www.docker.com/

Ezek után a root konyvtárban csak az alábbi parancsokat kell futtatni és elindul a project.

`gradle clean build`

`docker-compose up`

| Port          | Alkalmazas            |
| ------------- |:---------------------:|
| 8080          | Zuul gateway          |
| 8081          | SpringBootAdmin       |
| 8082          | Zipkin server         |
| 8083          | Microservice dashboard|
