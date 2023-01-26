>   **SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#1 – Introduction to Testing and Defect Tracking**

| Group: Group 8      |
|-----------------|
| Jessica Hoang       |   
| Daniel Le           |   
| Ayal Mashiack       |   
| Ayodeji Osho        |   


**Table of Contents**

(When you finish writing, update the following list using right click, then
“Update Field”)

[1 Introduction	1](#_Toc439194677)

[2 High-level description of the exploratory testing plan	1](#_Toc439194678)

[3 Comparison of exploratory and manual functional testing	1](#_Toc439194679)

[4 Notes and discussion of the peer reviews of defect reports	1](#_Toc439194680)

[5 How the pair testing was managed and team work/effort was
divided	1](#_Toc439194681)

[6 Difficulties encountered, challenges overcome, and lessons
learned	1](#_Toc439194682)

[7 Comments/feedback on the lab and lab document itself	1](#_Toc439194683)

# Introduction

An introduction of your lab work, and what you knew about exploratory and manual
functional testing before this lab

# High-level description of the exploratory testing plan

Text…

# Comparison of exploratory and manual functional testing

Exploratory testing allows the tester to be flexible and creative when designing test cases, as there is no strict plan required to create them, and are designed and executed simultaenously. This testing is ultimately up to the tester to create "realistic" scenarios that will cause the system under test to either pass or fail. Exploratory testing is efficient and fast at finding critical defects because it has less overhead, as the tester can start testing without writing detailed test specifications. In addition, since there is minimal need for planning and processing, testers can use exploratory testing at any step of the software development life cycle.

During our exploratory testing, the benefit we noticed was that at the end of this phase, we had a wide variety of test cases. Due to test cases being designed based on an individual's knowledge and personal experience, we could view the ATM system with different perspectives. For example, although we had several overlapping test cases, group 1 found that the ATM system still accepts a card that had been retained due to entering an incorrect PIN three times, while group 2 missed this defect in their test suite. Therefore, allowing us to find more and possibly uncommon defects in the system.  

However, a trade-off with exploratory testing is that it is more difficult to keep track of the tests performed. For example, during exploratory testing, we tested different functions in a random order, and there were times when we had to re-test them because we were unsure if we properly tested them the first time. Moreover, without in-depth domain knowledge of the system, there is a higher chance of missing critical defects as there is little documentation on what the system expects. For example, there was a misunderstanding of what the "available balance" should be after a transaction, as it was not documented clearly. 

Manual functional testing is when an individual design the test cases first, and then the same individual or different individual plays the role of a user and simulates the test case at another time. During the manual-testing, the team split the test cases amongst ourselves to efficiently execute the test cases since each individual only had to follow the path that the Appendix C script had.  

The benefits we noticed during manual functional testing was that following a script made it easier to keep track of the functions that were already tested and it's results. In addition, it made it easier to replicate tests for the regression testing to find which defects were fixed. Moreover, the documentation provided knowledge about the system as the function's expected values were clearly defined, making it easier and quicker to find functional defects. 

However, trade-offs of manual functional testing is that fewer defects may be found as it only focuses on the areas that the script provides. For example, in the Appendix C there is only three test cases related to the transaction inquiry, one of which tests to see if the system performs a legitimate inquiry transaction properly. Since the input is only to choose the checking account, we are only testing if it works with this specific account and not with the other two accounts, savings and money market, missing the defects related to inquiry about those accounts.  

Lastly, there are also similarities between exploratory testing and manual functional testing. Since they are both human-based testing, they are both prone to human error. Furthermore, they can both be an effective way of testing depending on the current stage of the software development cycle and the team's goals. For example, if the team is testing for specific test coverage, manual functional testing would be more effective, while if the team is aiming for rapid feedback, exploratory testing would be more effective. 

-   Note that you need to submit a report generated by your defect tracking
    system, containing all defects recorded in the system.

# Notes and discussion of the peer reviews of defect reports

Text…

# How the pair testing was managed and team work/effort was divided 

Text…

# Difficulties encountered, challenges overcome, and lessons learned

Text…

# Comments/feedback on the lab and lab document itself

Text…
