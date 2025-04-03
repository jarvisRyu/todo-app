## 일정관리 앱 만들기

사용자는 일정을 생성, 조회, 수정, 삭제할 수 있으며, 사용자 인증 기능도 포함되어 있습니다.

## API 명세서 
https://documenter.getpostman.com/view/43168025/2sB2cRD4ZA
* **SCHEDULE** 
![img.png](img.png)

* **USER**
![img_2.png](img_2.png)


### ERD


![img_10.png](img_10.png)

### 에러코드
|            코드           	|           설명           	|
|:-------------------------:	|:------------------------:	|
| 200 OK                    	| 요청 성공                	|
| 201 CREATED               	| 리소스 생성 성공         	|
| 400 BAD REQUEST           	| 잘못된 요청 파라미터     	|
| 401 UNAUTHORIZED          	| 인증 실패 또는 권한 부족 	|
| 404 NOT FOUND             	| 리소스를 찾을 수 없음    	|
| 500 INTERNAL SERVER ERROR 	| 서버 측 오류             	|
