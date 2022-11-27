sum:
	javac src/Sum.java -d output
main:
	javac src/Main.java -d output
classpath:
	@echo $$CLASSPATH
exec:
	java -cp ${CLASSPATH} mypackage.Main
hello:
	javac src/Hello.java -d output
