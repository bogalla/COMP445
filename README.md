# COMP445
networks class

### SET UP
1. cd into root
2. `mkdir bin`
3. cd into src
4. `javac -d ../bin Httpc.java`

### TESTING
1. in src folder
2. `java -cp ../bin Httpc help`
3. `java -cp ../bin Httpc get -h a:b -h c:d 'http://httpbin.org/get'`
4. `java -cp ../bin Httpc get -v 'http://httpbin.org/get?course=networking&assignment=1%27'`
5. `java -cp ../bin Httpc post -h Content-Type:application/json -d '{"Assignment": 1}' http://httpbin.org/post`
