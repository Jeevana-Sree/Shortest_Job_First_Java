package dsproject;

// Class to represent a Process
public class Process {
    int processID; // A unique identifier for the process
    String processName; // A name for the process
    int executionTime; // The time required to execute the process
    // Constructor to initialize the process fields
    public Process(int processID, String processName, int executionTime) {
        this.processID = processID;
        this.processName = processName;
        this.executionTime = executionTime;
    }
}


