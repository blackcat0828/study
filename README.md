# H2

# schema.sql

스프링부트 구동시 테이블 자동생성

# data.sql

data insert하는 쿼리 여기에 작성

자세한건 아래 URL 참고

[https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data](https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data)

# Time_format (MySQL + Mariadb)

H2에서 TIme_format이나 Date_Format을 쓰려면 PARSEDATETIME 사용

```
PARSEDATETIME ('2016-11-17 12:00:00','yyyy-MM-dd hh:mm:ss')
```

MYSQL & MariaDB

```
STR_TO_DATE ('2016-11-17 12:00:00','%Y-%m-%d %h:%i:%s')
```

### FORMATDATETIME을 사용해야 시간만 빼올수 있음

FORMATDATETIME(PARSEDATETIME('23:59','HH:mm'),'HH:mm') > curtime())
