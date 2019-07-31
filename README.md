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
```
If you receive `[-]Can't connect to the server.` there is an issue with your setup.  Double-check to make sure that your `EchoServer` is up and running and that your `EchoServer` and `EchoClient` are on the same port.

## Testing
Tests are located at `src\test\java\`. 