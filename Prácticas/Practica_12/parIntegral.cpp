//hebras en C++ que procesan funciones con carga parametrica...
//17/01/2017
//A.T.

// g++ -std=c++17 -pthread hebrasCargaParametrica.cpp


#include<iostream>
#include <thread>
#include <random>
#include <mutex>
using namespace std;

mutex m;

double totalbits = 0;

double f(double x){
    return pow(x,3)/(pow(x,4)+2);
}

void monteCarloIntegration(int numPoints) //codigo a ejecutar por la hebras con parametros
{
    random_device rd;
    mt19937 gen(rd());
    uniform_real_distribution<> dis(0, 1);
    int contPuntos = 0;
    for(int i = 0; i<numPoints; i++){
        double x = dis(gen);
        double y = dis(gen);
        if(y<=f(x)){
            m.lock();
            contPuntos++;
            m.unlock();
        }
            
    }
    totalbits = (double)contPuntos/(double)numPoints;
}

int main()
{ 
    int nHilos;
    int hits;
    cout<<"Ingrese el numero de puntos a lanzar: "; cin>>hits;
    cout<<endl<<"Ingrese el numerode tareas paralelas: "; cin>>nHilos;
    thread hilos[nHilos];
    for(int i=0; i<nHilos; i++)hilos[i] = thread(monteCarloIntegration, hits); //las hebras se crean -y ejecutan de esta forma
    for(int i=0; i<nHilos; i++)hilos[i].join();
    cout << endl << "Aproximacion: "<<totalbits<<endl;
    return(0);
}