//hebras en C++ que procesan funciones con carga parametrica...
//17/01/2017
//A.T.

// g++ -std=c++17 -pthread hebrasCargaParametrica.cpp


#include<iostream>
#include <thread>
using namespace std;

int totalbits = 0;
    
void hola(int hola) //codigo a ejecutar por la hebras con parametros
{
for (int a = 0; a < hola; a++){
    totalbits++;
}
}
int main()
{ 
int nHilos = 4;
thread hilos[nHilos];
for(int i=0; i<nHilos; i++)hilos[i]=thread (hola, i); //las hebras se crean -y ejecutan de esta forma
for(int i=0; i<nHilos; i++)hilos[i].join();
cout << "Valor de totalbits: "<<totalbits;
return(0);
}