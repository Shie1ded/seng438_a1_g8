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

### Time Between Failure

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/Time_Between_Failure.PNG)

In the Time between Failure graph we see that as the number of failures increase so does the time between each failure, we can also see as part of the raw data that failures come in groups, most likely due to the fact that one failure tends to lead to a few others. Once a failure (and its corresponding failures) are solved, the time to the next failure increases greatly.

When looking at the geometric data we can see that as we find more failures the deviation from the ideal behavior of the program increases hence the time between failures also increases.

Looking at the Jelinski-Moranda data, we can see that it is very similar to the geometric for most of the failures found, but as we reach the last failures we found, the estimation of time between each failure increases drastically compared to geometric. This supports the idea that the Jelinski-Moranda provides over-optimistic results as more failures are found. This is caused due to a belief that, although the number of errors is unknown, it is fixed and constant.

### Failure Rate

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/FailureIntensity.png)

The Failure Rate graph shows the average of failures per second, and the cumulative time between each failure. By looking at the Raw data we can see once again that as the time between failures increases the number of failures per second decreases, meaning that with a few outliers the longer it takes for another failure to occur, the less failures occur.

When looking at the geometric data we can see that even though the sets remain relatively the same when it comes to failures per second, there are more failures per second at the beginning. This could be due to the fact that there is less time between each failure, causing more deviations from the ideal behavior expected from the program.

Looking at the Jelinski-Moranda data, we can see that it is very similar to the geometric for most of the failures found, although the data-sets start at a lower failure per second value. This is most likely due to its over-optimistic nature detecting less errors which correspond to the initial failure.

### Reliability 

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/Reliability.PNG)

The Reliability graph shows the average reliability of the code between each failure. We can see from the raw data that as the time between failures increases so does the reliability of the code. Meaning that every failure that gets fixed improves the overall code.

Looking at the geometric data-sets that as the program becomes more reliable, deviations from the program's intended behavior become less frequent, meaning the program is more reliable.

Though the Jelinski-Moranda data-sets follow a somewhat similar trajectory, they have much greater fluctuations. When looking at the initial data we can see the over optimistic sets once again, but as we continue and more faults are found the model underdelivers due to its initial estimations. Then as we reach the end sets we can see that the over-optimism of this model comes into play as it believes that most of the initial constant errors are gone. Though this method is not always accurate, using it compared to the geometric model will actually create a more balanced average from the sets on the graph

### LaPlace Test

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/LaPlaceTest.PNG)

This graph is a representation of the Laplace test values compared to the number of failures which occur. When looking at the graph and its data we can see that the system begins with no change in its reliability. This “no trend” in the reliability of the system continues until we get to failure 40, at which set the program begins to grow in reliability, a trend which continues until the last found failure


### Arithmetic mean test

![ ALT](https://github.com/Shie1ded/seng438_g8/blob/main/A5/PlottedGraphs/Running_Mean.PNG)

The Arithmetic mean graph shows us its average mean per failure number. We can see an overall trend with the raw data that tells us the mean increases as more failures are found. Since we know that the higher the mean, the more reliable the program. We can conclude from the data that as more failures are found and fixed, the more reliable the program becomes. When looking at the last 10 failures however we can see that there is no increase in mean (i.e. no increase in reliability) this happens because in reality it is next to impossible to reach 100% reliability with any code created. This also tells us that continuing to test the system will likely not improve its reliability in any significant way.

## A Discussion on Decision Making Given a Target Failure Rate 

We believe that a 0.0015 failure per second average rate is very good. This means that our goal is not to hit a 0.0015 failure per second rate once, but to improve our program enough that our overall average is 0.0015. This also means that we ignore the first 5 datasets we test, these tests will most likely yield a large failure rate, and since we simply are trying to configure the system and achieve a more stable state for the system to begin testing on, these first few datasets will only throw the values out of balance. We also decided on a limit of 100 failures before we accept the failure average we get and proceed with improving the code more, then retesting the system.

## A Discussion on the Advantages and Disadvantages of Reliability Growth Analysis 

Advantage: reducing frequency of failures improves reliability, reduces costs later on by lowering the possibility of the program malfunctioning or failing all together, improves customer satisfaction, and provides great feedback.

Disadvantage: some disadvantages of reliability growth analysis are that it needs a large amount of data to be viable. It can be time consuming to run this, especially if we are doing it on multiple iterations of the code. It also has a large initial cost to implementation, meaning it is looked at as an investment, and the company needs to have the initial cost in order to implement it. And finally, this type of coding could be very difficult to interpret, especially for newer workers.

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
