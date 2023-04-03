**SENG 438- Software Testing, Reliability, and Quality**

**Lab. Report \#5 – Software Reliability Assessment**

| Group 08:      |
| -------------- |
| Jessica Hoang  |
| Daniel Le      |
| Ayal Mashiack  |
| Ayodeji Osho   |

# Introduction

The goal of this assignment is to use reliability assessment tools to assess failure data. We will be assessing the reliability of a hypothetical system given its failure data collected during integration testing. In addition to checking whether the target failure rate or MTTF is met or not. This lab uses reliability growth testing and reliability demonstration chart (RDC). We used CASRE for reliability growth testing and the RDC excel provided in the lab to create the RDC. 

# Assessment Using Reliability Growth Testing 

## Result of the Model Comparison (selecting top two models)

For all graphs, Geometric and Jelinski-Moranda were used for modeling. This will be further discussed later.

## Result of Range Analysis (an explanation of which part of data is good for proceeding with the analysis) 

We ignored the first 5 datasets since initially the system was unstable. This allows us to get a much better representation of the datasets and any trends they have, it also provides more accurate averages when looking at any data from the graphs. Removing the first few and nothing else also allows us to keep a large enough sample for the system to be accurate when running the tests, thus giving more precise results from our data.

## Plots for Failure Rate and Reliability of the SUT for the Test Data Provided 

In the failure data given, FailureReport2 was used. The format was modified and converted to a DAT file so it can be analyzed using CASRE. 

# Time Between Failure

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/Time_Between_Failure.PNG)

# Failure Rate

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/FailureIntensity.PNG)

# Reliability 

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/Reliability.PNG)

# LaPlace Test

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/LaPlaceTest.PNG)

# Arithmetic mean test

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/Running_Mean.PNG)

## A Discussion on Decision Making Given a Target Failure Rate 

## A Discussion on the Advantages and Disadvantages of Reliability Growth Analysis 

# Assessment Using Reliability Demonstration Chart 

## 3 Plots for MTTFmin, Twice and Half of it for your Test Data

## Explain your Evaluation and Justification of how you Decided the MTTFmin

## A Discussion on the Advantages and Disadvantages of RDC

The advantage of using RDC is that it is versatile, not expensive and a quick way to analyze the reliability of a system.  

The disadvantage of using RDC is that it cannot be use used to calculate the exact quantitative value for reliability of the system under test (SUT) as it can only tell the user if the SUT is within an acceptable range or not. 

Additionally, since it is time and cost efficient, it is possible to test out different what-if scenarios by changing the confidence levels and MTTF. However, this can also be seen as a disadvantage as although it is possible, it can be a tedious process. 

# Comparison of Results

# Discussion on Similarity and Differences of the Two Techniques

# How the team work/effort was divided and managed

The team was divided into two groups, the first pair worked on Part 1, reliability growth testing, and the second pair worked on Part 2, assessment using reliability demonstration chart. Within each pair we split the report work as we found appropriate and then at the end set up a meeting with the whole team to explain what we have learned from each other and worked together to compare the results and discuss the similarities and differences of the two techniques. These two section of the report was written by everyone. 

# Difficulties encountered, challenges overcome, and lessons learned

Some difficulties encountered during Part 2 of the lab is the use of SRTAT and RDC excel. First, when trying to use SRTAT we were unable to successfully import the failure data .DAT files provided in the assignment's specifications. What we had to do was either use excel and copy and paste the data into excel to create our own .DAT file or open up the sample .DAT file given in the SRTAT tool itself and edit it with the failure data. We also had issues using the RDC excel as the file was in protected view and we could insert the failure data properly until it was unprotected. 

# Comments/feedback on the lab itself
