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

# Source Code Changes

### Range 

**Original Code:**

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/media/RangeMutationTesting/SourceCodeOriginal.jpg)

**Changed Code:** 

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/media/RangeMutationTesting/SourceCodeChange.jpg)

To run PitMutation we had to ensure that our Assignment 3 Test Suite only had test cases that succeeded. A test case that failed was when we executed the method intersects with the parameter 4.99 and 5.0 on the range [5,20]. Since this method returned true if the specified lower boundary and upper boundary intersects with the specified range, it is expected that [4.99, 5.0] and [5, 20] return true, as it intersects at the value 5.0. However, instead, the test case failed. Therefore, we changed the source code to fix this error. In the original method, the line "if (b0 <= this.lower)" is true, and then it returns (b1 > this.lower), which is (5 > 5) = false. In the changed method, the line instead returns (b1 >= this.lower), which is (5 >= 5) = true and the test case returns as expected. We made changes to the second return line as well due to the same issue. 

### DataUtilities 

No changes were made to this class. 

# Analysis of 10 Mutants of the Range class 

In this section, we will analyse 5 mutants that our original test case had killed and 5 mutants that our original test case did not kill. 

### **Mutants Killed by Our Original Test Suite**

**1. Range expandToInclude(Range range, double value)**

Mutant: Negated double local variable number 1 → KILLED

Analysis: In the mutated SUT, the line “if (value < range.getLowerBound())” is changed to “if (-value < range.getLowerBound()).” Meaning that any value being passed in is negated, which can change the evaluation of the condition. For example, a test case we had was one that used the range [5, 20], and the value parameter 15. In the original SUT, when the method expandToInclude is called, it returns [5, 20]. Therefore, with our test case, when we pass in 15 as the value it checks “if (-15 < 5),” which is true and then it returns a new range of [15, 20]. As this is not what is expected ([5, 20]), the test case fails as we want it to, to kill the mutant.  

**2. double shiftWithNoZeroCrossing(double value, double delta)**

Mutant: Negated conditional → KILLED

Analysis: In the mutated SUT, the line “if ((value > 0)” is changed to “if (!(value > 0).” Since the whole condition is negated, it is clear that this will extremely change the results as a line may be skipped when it shouldn’t. For example, we had a test case that used the range [-20, -5]. In the original SUT, when the method shiftWithNoZeroCrossing is called with the parameters value = -20 and delta = 10, it returns [-10, 0], since the lower boundary and the upper boundary increases by 10, without crossing 0. Therefore, with our test case, when the lower boundary is calculated, “if (!(20 > 0)” is evaluated and returns false and skips the next statement, which then returns -10 (-20 + 10). Further, it takes Math.max(-10, 0.0), which is equal to 0, causing a returned lower boundary different from what is expected, causing the test case to fail on the mutated SUT, killing the mutant. 

**3. Range scale(Range base, double factor)**

Mutant: removed call to java/lang/IllegalArgumentException::<init> → KILLED

Analysis: In the mutated SUT, the line “throw new IllegalArgumentException("Negative 'factor' argument.")” is completely removed, which should cause an error as the factor value should never be less than 0. A test case we had that killed this mutant was when we called the method on the range [5, 20], with a factor of 0, with the original SUT, an IllegalArgumentException would be thrown and the test case would be expecting it. However, with this change, the test case fails as it expects the argument, but does not receive one. 

**4. boolean intersects(double b0, double b1)**

Mutant: removed conditional - replaced comparison check with true → KILLED 

Analysis: In the mutated SUT, the line “if (b0 <= this.lower)” is replaced with “if (true),” therefore, no matter what the values of b0 and this.lower is, this if statement will always succeed and the lines within it will be executed. For example, we have a test case that invokes the method on the range [5, 20], with parameters [20.01, 25]. This should return false, as the second range does not intersect with the original specified range. However, with the mutated SUT, instead of returning false for (20.01 <= 5) and skipping the next return line, it instead executes the return line “(b1 >= this.lower)” which evaluates to true as (25 >= 20). Therefore, with this mutant, it fails the test case, and kills the mutant. 

**5. Range combine(Range range1, Range range2)**
  
Mutant: not equal to equal → KILLED

Analysis: In the mutated SUT, the line “if (range1 == null)” is replaced with “if (range1 != null),  ” therefore, no matter what range is passed in as an argument, the results will be opposite of what is supposed to happen in the original test case, failing the test cases that we have. All test cases that we had that killed this mutant, instead of returning the second range, it returned a NullPointerException instead. A NullPointerException is not the returned value that should be expected; therefore, killing the mutant. 

### **Mutants Not Killed by Our Original Test Suite**
  
**6. boolean equals(Object obj)**

Mutant: equal to less or equal → SURVIVED

Analysis: In the mutated SUT, the line “if (!(this.lower == range.lower))” is replaced with “if (!(this.lower <= range.lower)) .”  This mutation survived because we had no test cases that checked to see if the two ranges that had different lower boundaries but the same upper boundary were equal to one another. For example, we ran a test with two ranges [-1, 1] and [-1, 3], which returned false, passing the test case. On the mutated SUT, it also returned false as “if (!(-1 <= -1))” evaluates to the same thing as “if (!(-1 == -1)),” also passed the test case and did not kill the mutant. To kill this mutant, we added in a test case with two ranges [1, 5] and [3, 5], so that when the line is evaluated it returns false “if (!(1 != 3)),” and provides a different expected output. 

**7. double constrain(double value)**

Mutant: negated double field upper → SURVIVED

Analysis: In this mutation, the line “if (value > this.upper),” is changed to “if (value > -this.upper).” The reason why this mutant survived is because we did not have any test cases where the parameter value was negative and within the range, and the range is all negative. Therefore, the value being evaluated, since it was positive, if it was greater than a positive upper boundary, then it had to also be greater than the negated upper boundary. To kill this mutant, we created a test case that was called with the parameter value -7 on the range [-15, -10]. Therefore, although -10 is the closest value to -7 that is within range, when “if (value > -this.upper)” is executed it returns false as -7 is not greater than 10, since it returns false the double value returned is -7, which is not within the range, failing the test case. 

**8. Range scale(Range base, double factor)**

Mutant: removed call to org/jfree/chart/util/ParamChecks::nullNotPermited → SURVIVED

Analysis: In this mutation, the line “ParamChecks.nullNotPermitted(base, "base")” is removed completely. This mutation survived because we had no test cases that checked if the base was null at all. Therefore, there was no coverage for this line and when the line was removed, all existing test cases were not changed. To kill this mutant, we added a simple test case to check if the base was null and then asserted that a NullPointerException was expected.  

**9. int hashCode()**

Mutant: Substituted 32 with 33 → SURVIVED

Analysis: In this mutation, the line “result = (int) (temp ^ (temp >>> 32))” is replaced with “result = (int) (temp ^ (temp >>> 33)).” This mutation survived because the only test case that we had for this method only checked if the return hash code is an integer or not, it did not check the exact values. Therefore, any changes in the calculation of the hash code did not affect the test case result. To kill this mutant, we added a test case that specifically checked to see if the exact value of the hash code is equivalent to the hash code that is returned by the function. 

**10. contains(double value)**

Mutant: Incremented (a++) double local variable number 1 → SURVIVED

Analysis: In this mutation, the line “return (value >= this.lower && value <= this.upper)” is replaced with “return (value++ >= this.lower && value <= this.upper).” However, since the increment to the double local variable number 1 is a post-increment, the value is returned before it is incrementing, which does not change the evaluation of the return statement at all. Therefore, we did not have any test cases that could kill this mutant in our original test and we could not create any additional ones either. 

# Report all the statistics and the mutation score for each test class

### Data Utilities Summary:

Original Test Suite (77% Mutation Coverage)

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/media/DataUtilitiesMutationTesting/DataUtilitiesMutationCoverageA3_OriginalCode.PNG)

To view a more detailed statistics of the original test suite against the DataUtilities class methods, please follow the instructions below. 

1. Download the repository to your local computer
2. Extract the zipped repository folder
3. Navigate to A4 -> media -> DataUtilitiesMutationTesting
4. Open originalMutationTest.html


Updated Test Suite (88% Mutation Coverage)

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/media/DataUtilitiesMutationTesting/DataUtilitiesMutationCoverageA4_UpdatedCode.PNG)
  
To view a more detailed statistics of the updated test suite against the DataUtilities class methods, please follow the instructions below. 

1. Download the repository to your local computer
2. Extract the zipped repository folder
3. Navigate to A4 -> media -> DataUtilitiesMutationTesting
4. Open updatedMutationTest.html

### Range Summary:

Original Test Suite (71% Mutation Coverage)

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/media/RangeMutationTesting/RangeMutationCoverageA3_OriginalCode.jpg)

To view a more detailed statistics of the original test suite against the Range class methods, please follow the instructions below. 

1. Download the repository to your local computer
2. Extract the zipped repository folder
3. Navigate to A4 -> media -> RangeMutationTesting
4. Open originalMutationTest.html

Updated Test Suite (82% Mutation Coverage)

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A4/media/RangeMutationTesting/RangeMutationCoverageA4_UpdatedCode.jpg)

To view a more detailed statistics of the updated test suite against the Range class methods, please follow the instructions below. 

1. Download the repository to your local computer
2. Extract the zipped repository folder
3. Navigate to A4 -> media -> RangeMutationTesting
4. Open updatedMutationTest.html

# Analysis drawn on the effectiveness of each of the test classes

As shown in the pictures above, we originally had a Mutation Coverage of 71% for the Range class and after adding addition test cases, we were able to increase the Mutation Coverage by 11%, ending with a Mutation Coverage of 82%. As for DataUtilities, we originally had a Mutation Coverage of 77% and were able to increase the Mutation Coverage also by 11%, ending with a Mutation Coverage of 88%.

From these additional test cases and increases in Mutation Coverage, we can say that the effectiveness of each test class has increased as since it illustrates that we have improved he adequacy of our tests to be able to identify more defects in the code than we originally did with our Assignment 3 Test Suite. Essentially, if our test suite can actually catch problems, then we can ensure that the test class is properly working based on specifications needed.

# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants significantly affected our mutation score accuracy. They made up a majority of mutants that survived. The reason is because the source code for Range and DataUtilities has a lot of condition statements that involve >, ==, !=, < , <=, >=. For example, in most cases, changing < to <= still causes the mutants to survive because the behavior is still the same.
  
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

We spent a very long time trying to run Pit Mutation for the first time as once we ran it, the console log was flooded with red output, which made us think that we set it up wrong. An explanation of what we expect to see when we run Pit Mutation would have helped us same some time as we were debugging an issue that did not exist. Additionally, some extra explaination on Selenium would have been very helpful as it took us some time to understand the verifications and assertions used in the GUI testing tool.  
