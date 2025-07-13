# Concurrent Programming (Java & C++)

This repository showcases a complete collection of programming assignments focused on Concurrent and Real-Time Programming. 
The projects progressively explore fundamental topics such as multithreading, synchronization, monitors, executors, mutual exclusion, distributed systems, and performance optimization using Java, MPJ-Express, and C++. 
Each solution is well-structured and documented using Javadoc for Java or descriptive inline comments for C++, emphasizing modularity, clarity, and maintainability.

---

##  Detailed Breakdown by Assignment (1–12)

### Assignment 1 – Numerical Methods in Java
- Newton-Raphson Method for root approximation
- Monte Carlo Integration to approximate definite integrals
- **Files**: `NewtonRaphson.java`, `intDefinidaMonteCarlo.java`

### Assignment 2 – Threads, Runnables and Shared Resources
- Thread-based vs Runnable-based concurrency
- Shared variable race condition simulation
- Vector scaling (sequential and parallel)
- ATM system with concurrent access
- Lambdas for parallel computation
- **Files**: `hebra.java`, `UsaHebra.java`, `tareaRunnable.java`, `UsaTareaRunnable.java`, `escalaVector.java`, `escalaVPar.java`, `cuentaCorriente.java`, `cajero.java`, `redCajeros.java`, `concursoLambda.java`

### Assignment 3 – Parallelism with Manual Data Partitioning
- Parallel dot product of vectors
- Matrix-vector multiplication with thread slicing
- CPU and performance analysis
- **Files**: `prodEscalar.java`, `prodEscalarParalelo.java`, `matVector.java`, `matVectorConcurrente.java`

### Assignment 4 – Mutual Exclusion with Shared Variables
- Software-based mutual exclusion: Dekker’s and Peterson’s algorithms
- Experimental thread tracing
- **Files**: `tryThree.java`, `tryFour.java`, `algDekker.java`, `algPeterson.java`

### Assignment 5 – Load Balancing & Speedup Studies
- Subramanian’s formula for thread calculation
- Matrix multiplication with load balancing
- Parallel image highlighting
- Parallel perfect number finder
- Speedup chart generation
- **Files**: `prodMatricesSecuencial.java`, `prodMatricesParalelo.java`, `resImagen.java`, `resImagenPar.java`, `numPerfectos.java`, `numPerfectosParalelo.java`

### Assignment 6 – Mutual Exclusion with Executors
- Thread pool integration in server
- Synchronized array writing
- Partial object synchronization
- Deadlock simulation
- Monte Carlo with Callable and Future
- **Files**: `ServidorHiloconPool.java`, `clienteMultiple.java`, `arrSeguro.java`, `heterogenea.java`, `usaheterogenea.java`, `deadlock.java`, `integCallable.java`

### Assignment 7 – Producer-Consumer Problem with Monitor
- Monitor using wait() / notifyAll()
- Experimentation with buffer sizes and thread roles
- **Files**: `prodCon.java`, `usaprodCon.java`

### Assignment 8 – Readers-Writers with Monitor
- Readers and writers synchronized with monitor pattern
- Guarded access to shared variable
- **Files**: `recurso.java`, `lectorEscritor.java`, `usalectorEscritor.java`

### Assignment 9 – Java High-Level Concurrency APIs
- Implementing sync with:
  - ReentrantLock
  - Semaphore
  - CyclicBarrier
  - AtomicInteger
- Performance comparison of locking techniques
- **Files**: `cCRL.java`, `ccSem.java`, `barrera.java`, `lectorEscritor.java`, `recurso.java`, `usalectorEscritor.java`, `tiempos.java`

### Assignment 10 – MPJ-Express: Java Message Passing
- Message passing with Send, Bcast, Reduce
- Vector operations and distributed prime search
- **Files**: `prodInterno.java`, `escalMultiple.java`, `distributedIntegers.java`

### Assignment 11 – Java RMI: Remote Invocation
- Distributed BonoLoto game with RMI
- Remote Monte Carlo π calculation with reset capability
- **Files**: `iBonoLoto.java`, `cBonoLoto.java`, `sBonoLoto.java`, `iPiMonteCarlo.java`, `cPiMonteCarlo.java`, `PiMonteCarlo.java`

### Assignment 12 – C++ Parallel Integration
- Monte Carlo Integration
- Multithreading with `std::mutex`
- Speedup and timing curves
- **Files**: `intParalela.cpp`

---

## Compilation & Execution

### Java
```bash
javac FileName.java
java FileName
```

### MPJ-Express
```bash
javac -cp .:$MPJ_HOME/lib/mpj.jar MyMPIProgram.java
mpjrun.sh -np 4 MyMPIProgram
```

### Java RMI
```bash
javac *.java
rmiregistry &
java ServerClass
java ClientClass
```

### C++ (C++11 with threads)
```bash
g++ -std=c++11 -pthread intParalela.cpp -o intParalela
./intParalela
```
