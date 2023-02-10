**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group 08:      |
| -------------- |
| Jessica Hoang  |
| Daniel Le      |
| Ayal Mashiack  |
| Ayodeji Osho   |

**Table of Contents**

1. Introduction

2. Detailed description of unit test strategy

3. Test cases developed

4. How the team work/effort was divided and managed

5. Difficulties encountered, challenges overcome, and lessons
learned

6. Comments/feedback on the lab and lab document itself


# 1 Introduction

The goal of this assignment is to use JUnit to create an automated unit testing suite that focuses on black-box testing, where we develop test cases based on each unit/method's requirements. Furthermore, we developed test cases based on equivalence classes and boundary value analysis to ensure that all necessary input values are tested.  


Our testing suite includes unit testing for the classes, org.jfree.data.Range and _org.jfree.data.DataUtilities_. In _org.jfree.data.DataUtilities_, we created test cases for the methods _calculateColumnTotal_, _calculateRowTotal_, _createNumberArray_, _createNumberArray2D_, _getCumulativePresentages_. As for org.jfree.data.Range, we developed test cases for the methods _constrain_, _intersect_, _combine_, _equals_, and _contains_. In addition, we used JMock to mock objects, such as _Value2D_ and _KeyedValues_, when developing test cases for _org.jfree.data.DataUtilities_ to simulate the behaviour of a real object that would interact with the methods in this class. 

# 2 Detailed description of unit test strategy

In our test-case design and plan, we applied black-box testing techniques, such as equivalence classes and boundary value analysis. 

**Black Box Testing:** a testing technique where we do not have any knowledge of the internal code structure, implementation details and internal paths. For each test case developed, we based it on the software requirements and focused on the inputs and outputs of the methods. 

**Equivalence Classes:** For each method tested, we divided the input set into partitions where the input data has the same effect on the SUT. We first divided it into legal and illegal inputs, then, within each of these subsets, we further divided it based on how the method behaves. 

**Boundary Value Analysis:** In addition to the equivalence classes, we added boundary value testing. For each method, we checked to see if the input value could be either above or below the boundary or equal to the boundary/input. 

For the methods that we are testing in the class _org.jfree.data.Range_, the domain is any input with a positive or negative decimal value. As for the equivalence classes, we create a partition class for positive inputs within the range, positive inputs not within the range, negative inputs within the range, negative input not within the range, inputs that are way above the range, inputs that are way below the range, inputs that fully intersects with the range and inputs that semi-intersects with the range on both the upper and lower boundary separately. Subsequently, we created boundary value tests with inputs that are 0.01 more than the boundary or 0.01 less than the boundary or equal to the boundary. 

For the methods that we are testing in the class _org.jfree.data.DataUtilities_, **TO DO, THIS IS NOT COMPLETE** For calculateColumnTotal and calculateRowTotal, the equivalence classes were row and column of the data table but also the columnIndex and rowIndex. For a valid data table, row>= 0 , column >= 0, columnIndex >= 0 and rowIndex >= 0. For the boundary, the data table could be null, the columnIndex is negative, columnIndex > number of columns and rowIndex > number of rows.

**Mocking:**
When testing the class _org.jfree.data.DataUtilities_, we used Mock Objects for Value2D and KeyedValues. More specifically, we implemented stub to return values for method calls. The benefit of this technique is that it is typically easy to implement and allows us to completely isolate the class we were testing for, which makes testing the class simpler. Mocking reduces the complexity since dependency classes could have their complexity that makes it infeasible to use a real object in a unit test, or the real object may not have been tested thoroughly yet and could break the test cases. Furthermore, the drawbacks of mocking are that it is not equivalent to the real object it replaces. The test may work with the mock object; however, we will still need additional tests to ensure it works with the real object. Mocking can create a lack of confidence as we do not know if the actual class will work with the dependent class, for example, if _org.jfree.data.DataUtilities_ will work with _Value2D_ and _KeyedValues_. Lastly, there may be difficulties in replacing certain method behaviours with a mock object, making it harder to develop the test cases. 

# 3 Test cases developed

**TO ADD, THIS IS WHERE WE WILL PUT OUR EXCEL FILE IN**

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Since there are two classes that we are testing in this assignment, we split the group into pairs of two. One group created test cases on org.jfree.data.DataUtilities, and the other group developed test cases for org.jfree.data.Range. Within each group, one person would focus on two methods, and the other member would focus on another three. To divide which methods each person would develop test cases for, we went through all the methods in the class to choose ones we were interested in and to ensure we chose different methods. After this step, each member would create a set of their own equivalence classes and boundary value analysis. Once that was complete, they would inform the rest of the group, and we would review the existing test cases and make any changes necessary. This way, we could provide our opinions and perspective to each method being tested. When we finalized the test plan, we each developed the test cases that we made in JUnit, and then the team came together to review and learn from each other's testing experience. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

Getting GitHub set up with the java project given in assignment two was difficult for the team. We realized that if we created a repository for the java project and shared it with each other, the JUnit file did not work since it was missing the reference libraries that were added to the original java project. To fix this, we decided that it would be best to have our java project and JUnit file and combine them just before the due date as we are performing unit testing, and each method and test case will not interact with each other. 

# 6 Comments/feedback on the lab itself

The assignment details were unclear as it did not state what files we needed to submit. We assumed that we needed to submit the whole project that we had cloned at the beginning of the lab; however, after asking the TA, only then did we find that we only needed to submit the test suite files that we coded.
