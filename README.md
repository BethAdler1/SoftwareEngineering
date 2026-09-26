# Software Engineering Project 
## System Architecture & API Boundaries

![System Design Diagram](images/system-design.png)

Computation: Monte Carlo Method to estimate the value of pi.

Given a positive integer N the computation will perform N random trials. During each trial, the system will generate a random point (x, y) within a 1 × 1 square. It will then determine whether the point lies inside a quarter-circle of radius 1 by checking whether x^2 + y^2 <= 1.

After all trials have been completed, the system will estimate pi using the ratio of points that fell inside the quarter-circle to the total number of points:

pi  ≈ 4 × (points inside the circle / total points)

For example, if the input is 1,000,000 and approximately 785,000 of the generated points fall inside the quarter-circle, the estimated value of pi will be approximately 3.14.

The computation is CPU intensive because it performs the point generation and distance calculation repeatedly for every trial. Increasing the input number increases the amount of computation required