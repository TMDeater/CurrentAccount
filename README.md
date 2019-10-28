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
  `javac -classpath src/;src/model;src/service;src/util -d dist src/*.java`
1. Copy AccountList.txt to 'dist' directory<br />
  Linux:<br />
  `cp src/AccountList.txt dist/`<br />
  Windows:<br />
  `copy src\AccountList.txt dist\`
1. Run the app<br />
  `cd dist`<br />
  `java -classpath ./;./model;./service;./util Console`
