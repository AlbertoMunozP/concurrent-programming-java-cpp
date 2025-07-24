#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

class simBarrier {
private:
    int count;
    int totalThreads;
    std::mutex mtx;
    std::condition_variable cv;

public:
    simBarrier(int numThreads) : totalThreads(numThreads), count(0) {}

    void toWaitOnBarrier() {
        std::unique_lock<std::mutex> lock(mtx);
        count++;

        if (count < totalThreads) {
            cv.wait(lock);
        } else {
            count = 0;
            cv.notify_all();
        }
    }

    void resetBarrier() {
        std::lock_guard<std::mutex> lock(mtx);
        count = 0;
        cv.notify_all();
    }
};

simBarrier bar(3);  // Inicializa la barrera con capacidad para 3 hebras

void workerThread() {
    std::cout << std::this_thread::get_id() << " llegando a barrera..." << std::endl;
    bar.toWaitOnBarrier();
    std::cout << std::this_thread::get_id() << " saliendo de barrera..." << std::endl;
}

int main() {
    std::thread group1[3];
    std::thread group2[3];

    std::cout << "main creando barrera para tres hebras..." << std::endl;

    // Lanzar el primer grupo de tres hebras
    for (int i = 0; i < 3; i++) {
        group1[i] = std::thread(workerThread);
    }

    // Esperar a que todas las hebras del primer grupo terminen
    for (int i = 0; i < 3; i++) {
        group1[i].join();
    }

    std::cout << "main reseteando barrera para tres nuevas hebras..." << std::endl;

    // Resetear la barrera para el segundo grupo de tres hebras
    bar.resetBarrier();

    // Lanzar el segundo grupo de tres hebras
    for (int i = 0; i < 3; i++) {
        group2[i] = std::thread(workerThread);
    }

    // Esperar a que todas las hebras del segundo grupo terminen
    for (int i = 0; i < 3; i++) {
        group2[i].join();
    }

    return 0;
}
