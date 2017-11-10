javac -d Banking/bin $(find Banking/src -name *.java)
java -classpath Banking/bin banking.MAIN
