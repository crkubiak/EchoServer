# Java EchoServer

This repository is for a basic Java EchoServer and associated classes required to test the EchoServer. 

## Installation

Clone the repo to the directory of your choice on your local computer.

### EchoServer
The classes for the EchoServer are located at `src\main\java\`.  You will need to compile all the classes in this directory.

```
\src\main\java\ $ javac *.java
```
### EchoClient

The class for the EchoClient is located in a separate module at `EchoClient\src\main\java`.  The EchoClient is a single class and compiling is optional.


## Usage
You will need two separate terminals as the EchoServer and EchoClient will be running concurrently.

### Terminal 1 - EchoServer
```
$ java EchoServer 8080 # you can choose any valid port
```
### Terminal 2 - EchoClient
```
$ java EchoClient 8080 # you can use any valid port as long as it matches the EchoServer
$ hello # you can type any message and the EchoServer should relay it

$ bye # when "bye" is entered into the terminal the EchoServer will terminate it's connnection and exit it's program
```
If you receive `[-]Can't connect to the server.` there is an issue with your setup.  Double-check to make sure that your `EchoServer` is up and running and that your `EchoServer` and `EchoClient` are on the same port.  

### Terminal 2 - No EchoClient
If you chose not to use the EchoClient class you can use the `nc` command from the command line.
```
$ nc localhost 8080 # use whatever port the EchoServer is operating on
```

## Testing
Tests are located at `src\test\java\`.  They are written for JUnit 4.XX and can be accessed using your IDE's test runner package.  If you chose to run the tests from the command line you will need to specify your local path's correctly.  [You can use this link on running JUnit from the CLI for guidance.](https://stackoverflow.com/questions/2235276/how-to-run-junit-test-cases-from-the-command-line)  