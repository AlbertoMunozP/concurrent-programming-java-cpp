import mpi.*;

public class ProdInterno {
    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        if (size != 2) {
            System.out.println("Este programa requiere exactamente 2 procesos.");
            MPI.Finalize();
            System.exit(1);
        }

        if (rank == 0) {
            // Proceso maestro
            int[] vectorA = {1, 2, 3, 4};
            int[] vectorB = {5, 6, 7, 8};

            // Enviar vectores al proceso esclavo
            MPI.COMM_WORLD.Send(vectorA, 0, 4, MPI.INT, 1, 0);
            MPI.COMM_WORLD.Send(vectorB, 0, 4, MPI.INT, 1, 0);

            // Recibir el resultado del esclavo
            int resultado = 0;
            MPI.COMM_WORLD.Recv(resultado, 0, 1, MPI.INT, 1, 0);

            // Imprimir resultado
            System.out.println("El producto interno es: " + resultado);
        } else if (rank == 1) {
            // Proceso esclavo
            int[] vectorA = new int[4];
            int[] vectorB = new int[4];

            // Recibir vectores del maestro
            MPI.COMM_WORLD.Recv(vectorA, 0, 4, MPI.INT, 0, 0);
            MPI.COMM_WORLD.Recv(vectorB, 0, 4, MPI.INT, 0, 0);

            // Calcular el producto interno
            int resultado = 0;
            for (int i = 0; i < 4; i++) {
                resultado += vectorA[i] * vectorB[i];
            }

            // Enviar resultado al maestro
            MPI.COMM_WORLD.Send(new int[] {resultado}, 0, 1, MPI.INT, 0, 0);
        }

        MPI.Finalize();
    }
}
