import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception { // this is the main method in java, where execution starts
        Scanner scanner = new Scanner(System.in); // takes the users input
        System.out.print("Enter a number: "); //prompts the user
        MultiThreading.loops = scanner.nextInt(); // stores value in static loops varible 
        scanner.close(); // close the scanner input

        Thread t1 = new  MultiThreading.Worker(); //turns the object worker into a thread to be run outside of the main thread
        Thread t2 = new  MultiThreading.Worker(); //turns the object worker into a thread to be run outside of the main thread

        System.out.println("Initial value: " +  MultiThreading.counter); // the value of the counter before the threads get to them

        t1.start(); // starts the run method in the work class
        t2.start(); //starts the run method in the work class

        try {
            t1.join(); //The current thread pauses and waits for the target thread to finish running.
            t2.join(); // The current thread pauses and waits for the target thread to finish running.
            // join makes shure that that thread finishes before procedding with the next one,
            // in this case we are telling the main thread to wait till thread one and two finish
            //join() only pauses the thread that calls it — not the thread it's waiting on.
            // the main thread called join so join pauses main.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value: " +  MultiThreading.counter); // prints the final value of the counter after the threads are done
    }
}

// input : 1000000000

/*
 * You expected the final value to be 2,000,000,000 (because two threads each incremented the counter 1 billion times).
But the actual final value was less (1,999,790,510), meaning some increments got lost.
This loss happens because the two threads were overlapping in their reads/writes to the shared counter without coordination.
this means that instead of incremnting on order sometimes the two threads were looking at the same number, race condition
 */