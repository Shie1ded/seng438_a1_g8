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

[1 Introduction]([#_Toc439194677])

[2 High-level description of the exploratory testing plan]([#_Toc439194678])

[3 Comparison of exploratory and manual functional testing]([#_Toc439194679])

[4 Notes and discussion of the peer reviews of defect reports]([#_Toc439194680])

[5 Difficulties encountered, challenges overcome, and lessons
learned]([#_Toc439194682])

[6 Comments/feedback on the lab and lab document itself]([#_Toc439194683])

# Introduction

Before starting the lab, the group’s collective understanding of exploratory testing was an unstructured way of testing a system. There was no specific rule we had to follow or set of guidelines. Based on the requirement, we decide what order and what functionality we choose to test. For example, we might decide to carry out more testing on a certain feature, such as logging into a website over changing your profile picture because one feature is more important than the other. We might do testing on our system, discover a bug, and fix it in the source code without even recording it in a bug tracking tool. Exploratory testing can happen at any time in the software development process because it does not require significant planning to do this sort of testing.

However, manual testing appears to be on the opposite end of the spectrum. It is a structured and inflexible form of testing. You have a script you have to follow for your test case and you cannot deviate it from it whatsoever. Every test case is tested and recorded in a bug tracking tool. The script keeps testing consistent as you make changes to the software and anyone can carry out testing because they are just following a script.

Even with the differences, we noticed between both types of testing, there are still similarities. Typically, any test case will have a functionality you are testing but also an expected and actual output to indicate whether the test was successful or not. 

# High-level description of the exploratory testing plan

The first thing we did was to thoroughly read the system requirements. We went through it and highlighted all the key functionality that we were going to test for. This not just gave us an understanding of the ATM system, but it made sure we came up with high quality test cases. Afterwards, we began to interact with the ATM system. 

We begin by turning on and off the ATM (and when turning the ATM on, we insert the amount of $20 bills manually). We then insert the card and input random numbers as the account number and password to see what will happen. The ATM will eject the card. After a few tries we input the correct card number but the wrong password to see what happens; if the password is wrong 3 times in a row the card is ejected. Next we enter all the information correctly to see if the ATM will log us into an account, which it did. We start by pressing random buttons with unassigned actions to see if they do anything on the ATM. Then we’ll go down the list of actions possible on the ATM, starting with withdrawal, and pressing all unassigned buttons for the action before testing whether the action itself works. We’ll make sure to test the specific action for every account on the card. We also make sure that every account that is connected to the card shows up in the options. We’ll repeat this pattern for every action on the main menu. Finally we test what happens if we try to turn the ATM off when a user is logged in on the ATM. We repeat this process for both available cards. And for both versions of the ATM machine program

# Comparison of exploratory and manual functional testing

Exploratory testing allows the tester to be flexible and creative when designing test cases, as there is no strict plan required to create them, and are designed and executed simultaenously. This testing is ultimately up to the tester to create "realistic" scenarios that will cause the system under test to either pass or fail. Exploratory testing is efficient and fast at finding critical defects because it has less overhead, as the tester can start testing without writing detailed test specifications. In addition, since there is minimal need for planning and processing, testers can use exploratory testing at any step of the software development life cycle.

During our exploratory testing, the benefit we noticed was that at the end of this phase, we had a wide variety of test cases. Due to test cases being designed based on an individual's knowledge and personal experience, we could view the ATM system with different perspectives. For example, although we had several overlapping test cases, group 1 found that the ATM system still accepts a card that had been retained due to entering an incorrect PIN three times, while group 2 missed this defect in their test suite. Therefore, allowing us to find more and possibly uncommon defects in the system.  

However, a trade-off with exploratory testing is that it is more difficult to keep track of the tests performed. For example, during exploratory testing, we tested different functions in a random order, and there were times when we had to re-test them because we were unsure if we properly tested them the first time. Moreover, without in-depth domain knowledge of the system, there is a higher chance of missing critical defects as there is little documentation on what the system expects. For example, there was a misunderstanding of what the "available balance" should be after a transaction, as it was not documented clearly. 

Manual functional testing is when an individual design the test cases first, and then the same individual or different individual plays the role of a user and simulates the test case at another time. During the manual-testing, the team split the test cases amongst ourselves to efficiently execute the test cases since each individual only had to follow the path that the Appendix C script had.  

The benefits we noticed during manual functional testing was that following a script made it easier to keep track of the functions that were already tested and it's results. In addition, it made it easier to replicate tests for the regression testing to find which defects were fixed. Moreover, the documentation provided knowledge about the system as the function's expected values were clearly defined, making it easier and quicker to find functional defects. 

However, trade-offs of manual functional testing is that fewer defects may be found as it only focuses on the areas that the script provides. For example, in the Appendix C there is only three test cases related to the transaction inquiry, one of which tests to see if the system performs a legitimate inquiry transaction properly. Since the input is only to choose the checking account, we are only testing if it works with this specific account and not with the other two accounts, savings and money market, missing the defects related to inquiry about those accounts.  

Lastly, there are also similarities between exploratory testing and manual functional testing. Since they are both human-based testing, they are both prone to human error. Furthermore, they can both be an effective way of testing depending on the current stage of the software development cycle and the team's goals. For example, if the team is testing for specific test coverage, manual functional testing would be more effective, while if the team is aiming for rapid feedback, exploratory testing would be more effective. 

# Notes and discussion of the peer reviews of defect reports

Each pair was responsible for creating an informal report of all found defects during the exploratory testing, it consisted of reporting said found bugs, its expected outcome and a small statement on either the state of the system before the bug occurred or steps to reproduce.

Once the testing phase was over and new bugs were no longer being found, both groups then discussed what was found, comparing the defects to eliminate any duplicate reports and showing bugs that may have been found in one pair but not the other. Then a final list was created with the combined reports and added to our issue tracking system.


# Difficulties encountered, challenges overcome, and lessons learned

-   When reporting defects for exploratory testing, since there was no structure it was hard keeping track of the tests that we have already done. There were some         instances where wrong results were written for certain tests so we had to rerun them to be sure.
-   Exploratory testing expected value is based on the understanding of how we believe the system works. In some cases it was hard to determine whether a bug was found     or if a feature was intentional due to different interpretations of the system requirements
-   During exploratory testing the same bugs were often found and reported by both groups causing duplicate reported defects in our tracking system
-   In future assignments we could improve upon our exploratory testing by doing some more planning beforehand and creating some sort of template or structure to           follow while also having some communication between groups to avoid the previous issues we experienced

# Comments/feedback on the lab and lab document itself

I have a complaint regarding the first lab in this course. I assumed that the lab was an opportunity to work on assignment 1 and the TA would answer any questions we had. However, throughout the entire lab, the TA did not make themselves present. I would have expected the TA to at least say hello and introduce themselves. As a result, I and many other students assumed there was no TA present for the entire lab. However, after the lab a student said the TA was present and I just had to go up to them and ask questions. I have no problem with this, but since the TA never made their presence known, I lost an opportunity to ask questions. For next time, I hope this type of issue is resolved.

I found the instructions for the lab to be confusing. The description that was provided only mentioned how to format each bug we found, but did not cover where to save each case in a way that would work for the presentations. This caused us to change our formatting multiple times. 

Other than the issues above, the lab was easy to understand and implement; the format for the manual cases was done well, and it made the testing straightforward.

