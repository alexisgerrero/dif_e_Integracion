# Unidad 4: Integración numérica

Implementación en Java de los métodos de **Trapecio Compuesto** y **Simpson 1/3 Compuesto**, con refinamiento del número de subintervalos hasta que la diferencia entre dos aproximaciones consecutivas sea menor o igual que la tolerancia indicada.

## Requisitos

- Tener instalado el **JDK de Java**.
- Contar con una terminal o un IDE, por ejemplo Visual Studio Code con las extensiones de Java.

## Estructura del proyecto

La carpeta del proyecto debe tener esta estructura:

```text
C1U4/
├── README.md
└── dif_e_Integracion/
    ├── MainTrap.java
    ├── TrapecioCompuesto.java
    └── SimpsonCompuesto.java
```

Los tres archivos `.java` deben declarar el mismo paquete al inicio:

```java
package dif_e_Integracion;
```

## Parámetros del ejemplo

El programa utiliza la función `f(x) = x^2` en el intervalo `[0, 2]`, con tolerancia `0.0001`. El valor exacto de la integral es:

`∫₀² x² dx = 8/3 ≈ 2.6666666667`

El criterio de paro compara el valor calculado en una iteración con el de la iteración anterior. Por ello, el error impreso es la **diferencia absoluta entre aproximaciones consecutivas**, no necesariamente el error absoluto respecto al valor exacto.

## Compilar y ejecutar desde la terminal

Abre una terminal en la carpeta raíz `C1U4`, donde se encuentra el archivo `README.md`.

### Windows

1. Comprueba que Java está instalado:

   ```bash
   java -version
   javac -version
   ```

2. Compila los archivos:

   ```bash
   javac -d . dif_e_Integracion/*.java
   ```

3. Ejecuta el programa principal:

   ```bash
   java dif_e_Integracion.MainTrap
   ```

Si usas PowerShell y el comodín no encuentra los archivos, puedes compilar indicando los nombres explícitamente:

```powershell
javac -d . dif_e_Integracion/MainTrap.java dif_e_Integracion/TrapecioCompuesto.java dif_e_Integracion/SimpsonCompuesto.java
java dif_e_Integracion.MainTrap
```

## Ejecutar desde Visual Studio Code

1. Abre en VS Code la carpeta raíz `C1U4`, no únicamente uno de los archivos `.java`.
2. Verifica que los tres archivos estén dentro de `dif_e_Integracion`.
3. Comprueba que los tres tengan `package dif_e_Integracion;` al inicio.
4. Abre `MainTrap.java`.
5. Pulsa **Run** sobre el método `main`, o utiliza **Run Java** si aparece en el editor.

Si VS Code muestra un error indicando que el paquete declarado no coincide con el paquete esperado, revisa que la estructura de carpetas coincida con el nombre del paquete y que los tres archivos estén ubicados en la carpeta `dif_e_Integracion`.

## Ejemplo de salida en consola

Con el código descrito en esta práctica, la salida tendrá un formato similar al siguiente. Los valores se muestran redondeados y pueden variar en los últimos decimales según el formato de impresión utilizado:

```text
FUNCION: f(x) = x^2
Intervalo: [0.0, 2.0]
Tolerancia: 1.0E-4

ITERACIONES (TRAPECIO COMPUESTO)
n = 2 | Integral = 3.0
n = 4 | Integral = 2.75 | Error = 0.25
n = 8 | Integral = 2.6875 | Error = 0.0625
n = 16 | Integral = 2.671875 | Error = 0.015625
n = 32 | Integral = 2.66796875 | Error = 0.00390625
n = 64 | Integral = 2.6669921875 | Error = 9.765625E-4
n = 128 | Integral = 2.6667480469 | Error = 2.44140625E-4
n = 256 | Integral = 2.6666870117 | Error = 6.103515625E-5
Resultado final Trapecio: 2.6666870117

ITERACIONES (SIMPSON COMPUESTO)
n = 2 | Integral = 2.6666666667
n = 4 | Integral = 2.6666666667 | Error = 0.0000000000
Iteraciones realizadas: 1
Subintervalos finales: 4
Resultado final Simpson: 2.6666666667

Valor exacto: 2.6666666667
```

**Nota:** el bloque es una referencia del formato esperado, basado en `f(x)=x^2`, el intervalo `[0,2]` y la tolerancia `0.0001`. Para entregar la práctica, conviene ejecutar el programa y sustituirlo por la salida real de tu versión, especialmente si modificaste los mensajes de impresión.

## Comparación de los métodos

| Aspecto | Trapecio compuesto | Simpson 1/3 compuesto |
|---|---|---|
| Fórmula de ponderación | Extremos con coeficiente 1 e interiores con coeficiente 2 | Coeficientes alternados 1, 4, 2, 4, ..., 1 |
| Restricción sobre `n` | Puede utilizarse cualquier número entero positivo de subintervalos | `n` debe ser par |
| Interpretación geométrica | Aproxima el área mediante trapecios | Aproxima la función por parábolas sobre pares de subintervalos |
| Para `f(x)=x^2` en `[0,2]` | Aproximación progresivamente más precisa al aumentar `n` | Exacto en aritmética exacta para esta función cuadrática |

## ¿Por qué Simpson requiere un número par de subintervalos?

La regla 1/3 de Simpson ajusta una parábola a tres puntos consecutivos, lo que cubre dos subintervalos. Para cubrir todo el intervalo sin dejar un subintervalo sin pareja, el número total de subintervalos debe ser par.

## ¿Por qué cambian los coeficientes?

En Simpson, los extremos se cuentan una vez, los puntos interiores con índice impar reciben coeficiente 4 y los puntos interiores con índice par reciben coeficiente 2. Esto resulta de combinar las fórmulas parabólicas aplicadas a pares de subintervalos contiguos.

En el método del trapecio, los extremos se cuentan una vez y cada punto interior se comparte entre dos trapecios, por lo que recibe coeficiente 2.

## Observaciones

- Ambos métodos usan la misma función, intervalo y tolerancia para que la comparación sea consistente.
- La implementación aumenta `n` duplicándolo en cada iteración.
- La tolerancia se aplica a la diferencia entre aproximaciones consecutivas.
- Simpson 1/3 compuesto requiere un número par de subintervalos en cada evaluación.
