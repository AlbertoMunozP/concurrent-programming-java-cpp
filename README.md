# ⏱️ Concurrent Programming (Java & C++)

This repository showcases a complete collection of programming assignments focused on **Concurrent and Real-Time Programming**.  
The projects progressively explore fundamental topics such as multithreading, synchronization, monitors, executors, mutual exclusion, distributed systems, and performance optimization using **Java, MPJ-Express**, and **C++**.  
Each solution is well-structured and documented using **Javadoc** for Java or descriptive inline comments for C++, emphasizing modularity, clarity, and maintainability.

---

## 📘 Detailed Breakdown by Assignment (1–12)

### 🧮 Assignment 1 – Numerical Methods in Java
- Newton-Raphson Method for root approximation  
- Monte Carlo Integration to approximate definite integrals  
- **Files**: `NewtonRaphson.java`, `intDefinidaMonteCarlo.java`

### 🔄 Assignment 2 – Threads, Runnables and Shared Resources
- Thread-based vs Runnable-based concurrency  
- Shared variable race condition simulation  
- Vector scaling (sequential and parallel)  
- ATM system with concurrent access  
- Lambdas for parallel computation  
- **Files**: *(see original list)*

### 🧵 Assignment 3 – Parallelism with Manual Data Partitioning
- Parallel dot product of vectors  
- Matrix-vector multiplication with thread slicing  
- CPU and performance analysis  
- **Files**: *(see original list)*

### 🔐 Assignment 4 – Mutual Exclusion with Shared Variables
- Dekker’s and Peterson’s algorithms  
- Thread trace experimentation  
- **Files**: *(see original list)*

### ⚖️ Assignment 5 – Load Balancing & Speedup Studies
- Subramanian’s formula  
- Matrix multiplication with load balancing  
- Parallel image highlighting  
- Parallel perfect number finder  
- Speedup chart generation  
- **Files**: *(see original list)*

### 🧰 Assignment 6 – Mutual Exclusion with Executors
- Thread pool integration  
- Synchronized writing and partial synchronization  
- Deadlock simulation  
- Callable/Future Monte Carlo integration  
- **Files**: *(see original list)*

### 🍞 Assignment 7 – Producer-Consumer Problem with Monitor
- Wait/NotifyAll monitor implementation  
- Buffer size experimentation  
- **Files**: *(see original list)*

### 📚 Assignment 8 – Readers-Writers with Monitor
- Classic reader-writer problem using monitors  
- Guarded variable access  
- **Files**: *(see original list)*

### 🧱 Assignment 9 – Java High-Level Concurrency APIs
- ReentrantLock, Semaphore, CyclicBarrier, AtomicInteger  
- Locking performance comparison  
- **Files**: *(see original list)*

### 📡 Assignment 10 – MPJ-Express: Java Message Passing
- Send, Bcast, Reduce primitives  
- Vector ops and distributed prime search  
- **Files**: *(see original list)*

### 🛰️ Assignment 11 – Java RMI: Remote Invocation
- Distributed BonoLoto game  
- Monte Carlo π via remote object  
- **Files**: *(see original list)*

### ⚙️ Assignment 12 – C++ Parallel Integration
- Monte Carlo Integration  
- Multithreading with `std::mutex`  
- Speedup curves  
- **Files**: `intParalela.cpp`

---

## 🛠️ Compilation & Execution

### ☕ Java
```bash
javac FileName.java
java FileName

javac -cp .:$MPJ_HOME/lib/mpj.jar MyMPIProgram.java
mpjrun.sh -np 4 MyMPIProgram

javac *.java
rmiregistry &
java ServerClass
java ClientClass

g++ -std=c++11 -pthread intParalela.cpp -o intParalela
./intParalela