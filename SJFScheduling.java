package dsproject;

// Importing the required libraries
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SJFScheduling {

    public static void main(String[] args) {
        // Creating a scanner object to take input from the user
        Scanner sc = new Scanner(System.in);
        // Creating a list of processes
        List<Process> processes = new ArrayList<>();
        // Taking the number of processes as input from the user
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        // Looping n times to take the process details as input from the user and add them to the list
        for (int i = 0; i < n; i++) {
            // Taking the process ID, name and execution time as input from the user
            System.out.println("Enter the process ID, name and execution time for process " + (i + 1) + ": ");
            int pid = sc.nextInt();
            String pname = sc.next();
            int etime = sc.nextInt();
            // Creating a process object with the input values
            Process p = new Process(pid, pname, etime);
            // Adding the process object to the list
            processes.add(p);
        }
        // Closing the scanner object
        sc.close();

        // Sort processes based on execution time (SJF)
        processes.sort((p1, p2) -> p1.executionTime - p2.executionTime);

        // Create a Priority Queue
        PriorityQueue priorityQueue = new PriorityQueue();

        // Insert processes into the Priority Queue
        for (Process process : processes) {
            priorityQueue.insert(process);
        }

        int currentTime = 0;
        int totalWaitingTime = 0;
        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("\nThe following list shows the order of processes executed by the Shortest Job First Algorithm.\n");
        // Execute processes in SJF order
        while (priorityQueue.root != null) {
            Process currentProcess = priorityQueue.getShortestJob();
            currentTime += currentProcess.executionTime;
            totalWaitingTime += currentTime - currentProcess.executionTime;
            System.out.println("Executing " + currentProcess.processName + " (Execution Time: " + currentProcess.executionTime + ")");
            priorityQueue.delete(currentProcess);
        }

        double averageWaitingTime = (double) totalWaitingTime / processes.size();
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
    }
}
