# Test1
Subject Allocation

Hi, I am working on a subject allocation program which requires me to allocate the subjects to the teachers based upon thier preferences. 

There is a set of subjects with (m elements) and then
there is a set of teachers with (n elements) such that m<<n(m is very much less than n). 
Each teacher provides with preferences of its subjects.
The algorithm is to be devised in such a way that the maximum satisfaction or stable distribution of subjects takes place with each subject having atleast c (c <<n i.e c is very less than n) and no teacher and subject remains unallocated. 

Propsed Solution: 

Each subject must have a constraint on how many teachers can be allocated to a subject and number of courses that can be assigned to a teacher.

The problem can be proceeded with a  linear programming approach: 
1) starting with a flow graph with a capacity=c1 edges coming from source into each subject(in this particular case c1=2).
2)then capacity1 (c1) edges from each subject into the teachers willing to teach that subject. 
3)then capacity=c2 from each teacher to the sink and take linear programming for maximum flow on this graph and add it to any other additional constraints.
