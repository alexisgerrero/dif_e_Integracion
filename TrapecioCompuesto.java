package dif_e_Integracion;


public class TrapecioCompuesto {
    public static double funcion(double x) {
        return Math.pow(x, 2);
    }

    public static double calcularH(double a, double b, int n) {return (b - a) / n; }

    private static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double suma = funcion(a) + funcion(b);
    

    for (int k = 1; k < n; k++) {
        double xk = a + k * h;
        suma += 2 * funcion(xk);
    }

    return (h / 2) * suma;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0;

        System.out.println("ITERACIONES (TRAPECIO COMPUESTO)");
        System.out.println("n = " + n + " | Integral = " + integralAnterior);
        
        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularTrapecio(a, b, n);

            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            System.out.println("n = " + n + " | Integral = " + integralNueva + " | Error = " + errorAbsoluto);

            integralAnterior = integralNueva;
        }
          
        return integralAnterior;

    }
}

