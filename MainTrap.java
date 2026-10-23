package dif_e_Integracion;

public class MainTrap {

    public static void main(String[] args) {

        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;

        System.out.println("FUNCION: f(x) = x^2");
        System.out.println("Intervalo: [" + a + ", " + b + "]");
        System.out.println("Tolerancia: " + tolerancia);

        double resultadoTrapecio =
                TrapecioCompuesto.integrarConTolerancia(
                        a, b, tolerancia);

        System.out.printf(
                "%nResultado final Trapecio: %.10f%n",
                resultadoTrapecio);

        double resultadoSimpson =
                SimpsonCompuesto.integrarConTolerancia(
                        a, b, tolerancia);

        System.out.printf(
                "%nResultado final Simpson: %.10f%n",
                resultadoSimpson);

        System.out.printf(
                "%nValor exacto: %.10f%n", 8.0 / 3.0);
    }
}
