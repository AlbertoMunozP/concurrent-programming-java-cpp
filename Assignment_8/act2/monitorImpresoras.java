public class monitorImpresoras{
    private boolean[] impresoras;
    private int ocupadas;
    private int N;
    public monitorImpresoras(int i){
        impresoras = new boolean[3];
        for (int a = 0; a < impresoras.length; a++){
            impresoras[a] = true;
        }
        ocupadas = 0;
        N = impresoras.length;
    }
    public synchronized int pedirImpresora() {
        while (ocupadas == 3){
            try{
                wait();
            }catch(InterruptedException e){
                System.err.println("Error");
            }
        }
        ocupadas++;
        int i = 0;
        while(i<N && !impresoras[i])    //primera condicion omitible
            i++;
        impresoras[i] = false;
        return i;
    }
    public synchronized void liberarImpresora(int n){
        ocupadas--;
        impresoras[n] = true;
        notifyAll();
    }
}