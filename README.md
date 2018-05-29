# atmtransaction
Software’s: -
1)Sts(Spring tool suite)
2)postman

Import project into STS:

1)copy below github link
	https://github.com/naga6502/atmtransaction
2)select clone or download option and select download zip option so that it will download as zip file.
3)open sts and right click then select import ->maven -> existing maven projects -> select location of the project(after extract)->finish.
Run Application: -
	1)Right click on project ->Run As -> Spring Boot APP
	2)open postman use below URL’s for test

Base url : localhost:8081
Ex: add cash
 localhost:8081/addcash?fifty=50&twent=20

Method Name	URI	MethodType
Add Cash	/addcash?fifty=50&twent=20	POST
Get Cash Details	/getcashdetails	GET
Withdraw Money	/withdrawamount?amount=1000	GET
