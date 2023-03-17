**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**


| Group 08:      |
| -------------- |
| Jessica Hoang  |
| Daniel Le      |
| Ayal Mashiack  |
| Ayodeji Osho   |

# Introduction

The goal of this assignment is to use PitMutation for Mutation Testing and Selenium for GUI Testing. In Mutation testing, we were able to run PitMutation, understand which mutants our original test cases have not covered, and then create these fault versions in our SUT and created test cases to distinguish (kill) those mutants. In the report below, we will interpret our mutation scores. In GUI Testing, we focused on the Amazon website and tested key functionalities, such as add to cart, delete from cart, update item in cart quantity, save for later, navigation bar, and more. 

# Analysis of 10 Mutants of the Range class 


# Report all the statistics and the mutation score for each test class

Data Utilities Summary:

Original Test Suite (77% Mutation Coverage)

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/DataUtilitiesMutationTesting/DataUtilitiesMutationCoverageA3_OriginalCode.PNG)


Updated Test Suite (88% Mutation Coverage)

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/DataUtilitiesMutationTesting/DataUtilitiesMutationCoverageA4_UpdatedCode.PNG)

# Analysis drawn on the effectiveness of each of the test classes


# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants significantly affected our mutation score accuracy. They made up a majority of mutants that survived. The reason is because the source code for Range and DataUtilities has a lot of condition statements that involve >, ==, !=, < , <=, >=. For example, changing < to <= still causes the mutants to survive because the behavior is still the same.

Another huge source of mutants was increment and decrement variables with the syntax a- - and a++. The problem is the variable value is returned within the condition and evaluated before it is incremented or decremented.

This results in having a lower percentage than expected. In DataUtilities the original score was 77%, and if we were able to correctly detect equivalent mutants then that score would be more likely to be around 90% since after analysis of our mutation test result we realized they formed the majority of surviving mutants. The same principle applies to the Range Class. This indicated to us that our test suite is still of high quality.

Detecting equivalent mutants can involve a systematic process. Mutants can be created by changing a condition statement, incrementing and decrementing a value. For changing a condition, you can look to see if the syntax is similar. For example < and <= will most likely result in equivalent mutants. For incrementing and decrementing a variable value, you can look at the logic of the program and see if you would have the same result. Estimating how many equivalent mutants present can help determine how much to boost the mutation test score.

# A discussion of what could have been done to improve the mutation score of the test suites

To improve the mutation score of the test suites we first took a look at the initial report given by Pitest when running our mutation tests. This report provides details regarding what mutations were conducted on our SUT and shows which survived or which would have been killed by our already present tests that were developed in the previous assignment. Analyzing these results help identify areas of our test suite that lack coverage. We checked to see which mutant survived and then we made changes to our SUT to do exactly as what the surviving mutant did. For example, if it said “Negated Double Field Upper -> SURVIVED,” then we went to that specific line and negated the double field value, and built test cases that would make that test case return differently than if we did not negate the value. As also explained in more detail in the section Analysis of 10 Mutants of Range above. 

With the information from the report we now are able to increase the number of tests or modify existing test cases to increase test coverage. This cycle was repeated until we could no longer develop any more test cases that successfully killed any surviving mutations.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

The reason we need to use mutation testing is because it allows us to test failed operations to make sure the program does not crash/freeze, and to ensure all data gets killed and does not continue running in the background.

The biggest advantage of mutation testing is that it allows the programmer to test the entire source code coverage, which allows the programmer to test if the program is properly killed, along with allowing the user to test failed cases. These cases allow the programmer other ways of testing their code, since they can ensure their code is working by testing situations where the code should fail. For example, when testing null cases we cannot always send a null value to the program, so by sending other values that should fail it allows us to make sure that null values work (if nothing works then it is null).

The biggest disadvantage of mutation testing is how costly it is. Because of it mutation testing takes a very long time to complete, meaning that as the size of the program increases the waiting time for the mutation testing to complete also increases, (our program took about 20 mins to finish one test). Another disadvantage of mutation testing is it usually demands testing it against the original test suite, making it more time consuming as well as inefficient.

# Explain your SELENUIM test case design process

Initially, we went on the amazon website and explored the website to figure out the different functionality. Each member picks two commonly used functionalities by amazon users to test on and comes up with test cases for the type of input used by the customer for both valid and invalid states. After deciding on a functionality such as clicking a button, we go on amazon and explore what type of features that comes with using that functionality. We make notes of the sequence of events that our test cases will do in order to carry out an effective test. 

# Explain the use of assertions and checkpoints

Assertions and checkpoints are a critical element in GUI testing. The purpose of assertions and checkpoints in GUI testing is to have stages during test cases to verify whether certain aspects of the application are behaving as intended or not. With assertions we are able to verify specific conditions of GUI elements by seeing if they are present or not. Checkpoints are used to check the state of the application at particular points in time and compare what's expected to what's being shown.

# How did you test each functionaity with different test data

We tested each functionality by first running the mutation testing on our original code and seeing the results. Then we checked the results to see which case needs more specific testing. This allowed us to create different cases for each functionality, for example for createNumberArray we were able to create multiple test cases that checked for a pass case along with values missing/being incorrect and runtime errors. And finally we went to the base code and changed some values and matched them with test cases to make sure that the code fails if the values are incorrect. We then reran the mutation test and compared the results from the original test and the new test to ensure we solved the errors appropriately

# Discuss advantages and disadvantages of Selenium vs. Sikulix

Selenium and Sikulix are both testing tools that are used for GUI testing. Each tool has their own advantages and disadvantages, and although our tests are done on Selenium WebDriver, the choice of which to use will depend on the specific needs of what is to be tested.

Some of the biggest advantages of Selenium WebDriver is that this tool is extremely simple to set up and use. Selenium can be installed as a plugin or extension on all major browsers and is used through a simple compact interface. The biggest disadvantage of Selenium would be that the webdriver version which was used in our case specifically will not work on non-web applications. Which means it is ideally used for web-applications.

Sikulix is another tool that is commonly used for GUI testing, it is a separate IDE that runs alone and can be used to automate testing and inputs through manually recording or a visual image recognition system. The advantage with Sikulix is that this tool can be used for GUI testing on non-web applications, it is also a standalone IDE rather than a web extension allowing more sophisticated technology like image recognition to be used. The disadvantages when compared to Selenium WebDriver is that it is not as accessible as a simple web plugin, and thus means it has a smaller community backing. It also does not allow the host machine to be used in parallel as scripts and programs run.

# How the team work/effort was divided and managed

Like previous labs, our group was divided into two groups that would work on the org.jfree.data.DataUtilities method and org.jfree.data.Range method for the mutation testing portion of the lab. Those who originally worked on those methods in previous labs would remain on them during this one. For part 2 of the lab, the GUI testing, each member designed a minimum of two test cases and recorded their automated tests in Selenium.

We used Discord and Google Doc to organize our test plans, keep each other updated with our personal progress, and to help each other out when trying new coverage tools and the Selenium interface.

# Difficulties encountered, challenges overcome, and lessons learned

One difficulty encountered in this lab was that running the Pit tests in eclipse would often take very long, up to 30 minutes for a single run on the program. We learned to avoid running multiple tests by looking into what kinds of mutation tests were being done from the first run and edited the source code to imitate the mutations and tested as a standard JUnit test case.

Another difficulty found was during the GUI testing, Selenium would open its own web browser and allow for recording, but some group members found that this separate browser would operate very slow, leading to delay in recording and in some cases crash altogether. We found that system specs were the main causes of a slow browser and had to use different machines to solve this issue.


# Comments/feedback on the lab itself
