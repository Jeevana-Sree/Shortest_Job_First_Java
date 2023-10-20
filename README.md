##INTRODUCTION

The Shortest Job First Scheduling algorithm is one of the fundamental algorithms in operating systems, used to manage processes efficiently. In this project, the focus is on implementing the Shortest Job First Scheduling Algorithm using a Binary Search Tree based Priority Queue tailored for Process Entities. This scheduling algorithm ensures that the process with the shortest execution time is executed first, minimizing the waiting time, and improving system throughput.

This project is very important because efficient process scheduling is essential for computer systems to run at their best. By using the Shortest Job First algorithm, we hope to make systems more efficient and responsive, which will lead to a better user experience and better use of resources. Using a Binary Search Tree based Priority Queue makes the algorithm more complex and efficient, which makes this project a challenge and a good opportunity to learn.


##OBJECTIVES AND SCOPE OF THE PROJECT

**Objectives:**

	Implement the Shortest Job First Scheduling Algorithm
	Design a robust algorithm to sort processes based on their execution time efficiently.
	Implement a Binary Search Tree-based Priority Queue specifically tailored for Process Entities.
	Ensure quick and efficient retrieval of the process with the shortest execution time.
	Minimize the waiting time of processes to ensure optimal utilization of system resources.
	Enhance system performance and user satisfaction.
	Evaluate the performance of the implemented algorithm and data structure concerning factors such as average waiting time, turnaround time, and throughput.
	Gain insights into the effectiveness of the Shortest Job First scheduling approach.

**Scope:**
	The project's scope is well-defined and covers all the essential aspects of implementing and evaluating the Shortest Job First (SJF) scheduling algorithm using a Binary Search Tree (BST) based Priority Queue.
	The project will focus on managing a set of processes characterized by their Process ID (PID), Process Name, and Execution Time. These processes represent the core entities that will be scheduled and executed.
	The project's scope includes the complete implementation of the SJF scheduling algorithm. This encompasses sorting processes based on their execution time and executing them in the order of their sorted sequence.
	The implementation of a Priority Queue using a BST is a crucial aspect of the project. This data structure ensures efficient insertion, deletion, and retrieval operations, vital for the functioning of the SJF algorithm.
	The project includes a comprehensive analysis of the implemented algorithm's performance. This evaluation will involve calculating metrics such as average waiting time, turnaround time, and system throughput, providing valuable insights into its efficiency.
	Overall, the project's scope is realistic and achievable. It is also well-aligned with the project's objectives of implementing and evaluating the SJF scheduling algorithm using a BST based Priority Queue.


##METHODOLOGY

1. Process Input: The project begins by taking input for the set of processes. Each process is characterized by its Process ID, Process Name, and Execution Time. This input is essential for creating the process entities that will be scheduled.
2. Binary Search Tree Implementation: A Binary Search Tree (BST) is implemented to serve as a Priority Queue. The processes are inserted into the BST based on their execution times. The BST operations ensure efficient sorting and retrieval of the process with the shortest execution time.
3. Shortest Job First Algorithm: The Shortest Job First Scheduling Algorithm is implemented using the BST-based Priority Queue. The algorithm selects the process with the shortest execution time from the BST and executes it. Upon completion, the process is removed from the BST.
4. Execution and Output: The processes are executed in the order determined by the Shortest Job First algorithm. During execution, the project records relevant metrics such as Average Waiting Time.

##FLOWCHART:

The flowchart of the project illustrates the step-by-step process from inputting the processes to their execution using the Shortest Job First Scheduling Algorithm.
Algorithm Implementation (Pseudocode):

function shortestJobFirst(processes):
    initialize BST-based Priority Queue    
    for each process in processes:
        insert process into BST-based Priority Queue based on execution time 
    waitingTime = 0
    currentTime = 0
    
    while BST-based Priority Queue is not empty:
        process = getProcessWithShortestExecutionTime() from BST-based Priority Queue
        processStartTime = max(currentTime, process.arrivalTime)
        waitingTime += currentTime - process.arrivalTime
        currentTime += process.executionTime
        process.completionTime = currentTime
        remove process from BST-based Priority Queue
    
    averageWaitingTime = waitingTime / totalProcesses
    
    return averageWaitingTime
    
##SUMMARY

The above code is an implementation of the Shortest Job First Scheduling Algorithm using Binary Search Tree based Priority Queue for a Process Entity. The code uses the following classes:

1) Process: This class represents a process that has a process ID, a process name and an execution time. The execution time is the time required to complete the process. The constructor of this class takes these three parameters and initializes the fields of the process object.
2) Node: This class represents a node of a binary search tree that stores a process object and has a left and a right child. The constructor of this class takes a process object and initializes the node fields.
3) PriorityQueue: This class represents a priority queue that is implemented using a binary search tree. The root of the priority queue is the root of the binary search tree. The priority queue has the following methods:
    A) insert: This method inserts a process into the priority queue based on its execution time. The process with the smallest execution time is inserted at the leftmost position of the binary search tree, while the process with the largest execution time is inserted at the rightmost position of the binary search tree. The method uses a recursive helper method to insert the process at the appropriate position in the binary search tree.
    B) getShortestJob: This method returns the process with the shortest execution time from the priority queue. The process with the shortest execution time is the leftmost node of the binary search tree. The method traverses to the leftmost node and returns its process object.
    C) delete: This method deletes a process from the priority queue. The method uses a recursive helper method to delete the process from the binary search tree. The helper method follows these steps:
	If the tree is empty, return null.
	If the process's execution time is smaller than the root's execution time, it lies in the left subtree. Recursively delete it from the left subtree and return the updated root.
	If the process's execution time is larger than the root's execution time, it lies in the right subtree. Recursively delete it from the right subtree and return the updated root.
	If the process's execution time is equal to the root's execution time, then this is the node to be deleted. There are three cases:
	If the node has only right child or no child, replace it with its right child and return it.
	If the node has only left child or no child, replace it with its left child and return it.
	If the node has two children, find its inorder successor (the smallest node in its right subtree) and copy its data to this node. Then recursively delete the inorder successor from the right subtree and return this node.
    D) minValue: This is a helper method that finds and returns the node with the smallest value (execution time) in a binary search tree. The method starts from a given node and traverses to its leftmost child until it reaches null. It returns the last visited node's data (process object).
4) SJFScheduling: This is the main class that contains the main method. The main method does the following tasks:
    a) Creates a scanner object to take input from the user.
    b) Creates a list of processes to store them.
    c) Takes the number of processes as input from the user and loops n times to take their details           as input from the user. For each process, it takes its ID, name and execution time as input from user and creates a process object with these values. It then adds this object to list of processes.
    d) Closes scanner object.
    e) Sorts list of processes based on their execution time in ascending order using lambda expression as comparator.
    f) Creates priority queue object.
    g) Inserts all processes from list into priority queue using insert method.
    h) Initializes current time and total waiting time variables to zero.
    i) Prints header for output list of processes executed by SJF algorithm.
    j) Executes processes in SJF order by doing following steps until priority queue is empty:
I.	Gets shortest job from priority queue using getShortestJob method and stores it in currentProcess variable.
II.	Increments current time by currentProcess's execution time.
III.	Increments total waiting time by current time minus currentProcess's execution time.
IV.	Prints currentProcess's name and execution time as output.
V.	Deletes currentProcess from priority queue using delete method.
    k) Calculates average waiting time by dividing total waiting time by number of processes and prints it as output.
In summary, the project follows a systematic approach, beginning with input collection, implementing a Binary Search Tree based Priority Queue, and executing processes using the Shortest Job First Scheduling Algorithm. The flowchart visually represents this process, while the pseudocode provides a clear algorithmic representation of the project's implementation.
