public class MultiThreading { // this is class that holds the static variable's that both threads will share
    static int counter = 0;  // the variable that both threads will try to increment
    static int loops; //how many times each thread will try to increment the counter variable 

    static class Worker extends Thread { // this sublcass is the class that host the run method
        public void run() { // this method overides the run method from the thread class, it needs to be called run 
            // so that the threads know what method to run, threads only run methods named run
            for (int i = 0; i < loops; i++) {
                counter++;  // since both threads share this variable it means that if two threads are
                //running concruently and both threads try to grab the data at the same time
                // 0 should be incremented to tow since both threads try to increment, but since they both holds zero
                //count just gets incremented to one instead of two, this is a race condition
            }
        }
    }
}

//this is a diffrent and in my opinion the most simple way to create a thread, lambdas. instead of making a whole class 
//just to use them

/*Thread t1 = new Thread(() -> {
    System.out.println("Thread 1: downloading file");
});

Thread t2 = new Thread(() -> {
    System.out.println("Thread 2: resizing image");
});

t1.start();
t2.start();
 */
