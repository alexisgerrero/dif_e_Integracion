package dif_e_Integracion;

public class SimpsonCompuesto {

    private static double calcularSimpson(
            double a, double b, int n) {

        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        double sumaTotal =
                TrapecioCompuesto.funcion(a)
                + 4 * sumaImpares
                + 2 * sumaPares
                + TrapecioCompuesto.funcion(b);

        return (h / 3) * sumaTotal;
    }

    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        int n = 2;
        int iteraciones = 0;

        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;

        System.out.println("\nITERACIONES (SIMPSON COMPUESTO)");
        System.out.printf("n = %d | Integral = %.10f%n",
                n, integralAnterior);

        while (errorAbsoluto > tolerancia) {
            n *= 2;

            double integralNueva = calcularSimpson(a, b, n);

            errorAbsoluto =
                    Math.abs(integralNueva - integralAnterior);

            iteraciones++;

            System.out.printf(
                    "n = %d | Integral = %.10f | Error = %.10f%n",
                    n, integralNueva, errorAbsoluto);

            integralAnterior = integralNueva;
        }

        System.out.println("Iteraciones realizadas: " + iteraciones);
        System.out.println("Subintervalos finales: " + n);

        return integralAnterior;
    }
}
