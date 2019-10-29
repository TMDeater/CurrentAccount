# Current Account Simulator

### Introduction
This is a Bank Current Account Simulator, which simulate the following functions:
* Open Account
* Close Account
* Display Balance
* Deposit Funds
* Withdraw Funds
* Apply Agreed Overdraft (Allow Negative Balance)

### Build Guide
1. Clone the repository
1. Locate to 'src' directory
1. Complile class to 'dist' directory<br />
  `javac -classpath src/main/;src/main/model;src/main/service;src/main/util -d dist src/main/*.java`
1. Copy AccountList.txt to 'dist' directory<br />
  Linux:<br />
  `cp src/main/AccountList.txt dist/`<br />
  Windows:<br />
  `copy src\main\AccountList.txt dist\`
1. Run the app<br />
  `cd dist`<br />
  `java -classpath ./;./model;./service;./util Console`
