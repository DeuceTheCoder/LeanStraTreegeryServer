[![Build Status](https://travis-ci.org/DeuceTheCoder/LeanStraTreegeryServer.svg?branch=master)](https://travis-ci.org/DeuceTheCoder/LeanStraTreegeryServer)

A server to support [LeanStraTreegery](https://github.com/rosatolen/LeanStraTreegery).

Written in Java using DropWizard

# Run Tests
```
./gradlew test
```

# Run The Server
Create a file in the project root called main.yml with the following contents:
```
postgresConnection: <Your postgres connection string>
```

To start the server:

`./gradlew run`