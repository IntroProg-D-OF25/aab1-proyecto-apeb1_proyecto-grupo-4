/***
 * Mientras se ejercita, puede usar un monitor de frecuencia cardiaca para ver
 * que su corazón permanezca dentro de un rango seguro sugerido por sus
 * entrenadores y doctores. De acuerdo con la Asociación Estadounidense del
 * Corazón (AHA) (vwwv.americanheart.org), la fórmula para calcular su
 * frecuencia cardiaca máxima en pulsos por minuto es de 220 menos su edad en
 * años. Su frecuencia cardiaca esperada es un rango que está entre el 50 y el
 * 85% de su frecuencia cardiaca máxima.

 * Cree una solución de FrecuenciasCardiacas. Los datos de esta solución
 * deben incluir el primer nombre de la persona y fecha de nacimiento (la cual
 * debe consistir en datos separados para el mes, día y año de nacimiento). La
 * solución también debe incluir un método que calcule y devuelva la edad de la
 * persona (en años), uno que calcule y devuelva la frecuencia cardiaca máxima
 * de esa persona, y otro que calcule y devuelva la frecuencia cardiaca esperada
 * de la persona. Escriba una aplicación de Java que auto genere la información
 * de la persona, e imprima y que después calcule e imprima la edad de la
 * persona en (años), frecuencia cardiaca máxima y rango de frecuencia cardiaca
 * esperada. Finalmente, su aplicación debe tener la posibilidad de presentar un
 * historial de seguimiento de estos signos vitales según periodos de ejercicio
 * realizado (tiempo) y un indicador adicional que el estudiante elija como
 * relevante en el monitoreo; todo esto se debe presentar en una tabla
 * estadística. 
 */
import java.util.Random;
import java.util.Scanner;

public class FrecuenciasCardiacas {

    // Clase interna para almacenar información de una persona
    static class Persona {
        String nombre;
        int mesNacimiento, diaNacimiento, añoNacimiento;

        // Constructor para crear una persona con información aleatoria
        public Persona(String nombre, int mesNacimiento, int diaNacimiento, int añoNacimiento) {
            this.nombre = nombre;
            this.mesNacimiento = mesNacimiento;
            this.diaNacimiento = diaNacimiento;
            this.añoNacimiento = añoNacimiento;
        }

        // Método para calcular la edad de la persona
        public int calcularEdad() {
            int añoActual = 2024;
            int mesActual = 11;  // Noviembre
            int diaActual = 23;  // Día actual
            int edad = añoActual - this.añoNacimiento;

            if (mesActual < this.mesNacimiento || (mesActual == this.mesNacimiento && diaActual < this.diaNacimiento)) {
                edad--; // Ajuste si la persona aún no cumplió años este año
            }

            return edad;
        }

        // Método para calcular la frecuencia cardiaca máxima (FCM)
        public int calcularFCM() {
            return 220 - this.calcularEdad();
        }

        // Método para calcular el rango esperado de la frecuencia cardiaca (50% - 85% de la FCM)
        public String calcularRangoEsperado() {
            int fcm = this.calcularFCM();
            int limiteInferior = (int) (fcm * 0.50);
            int limiteSuperior = (int) (fcm * 0.85);
            return limiteInferior + " - " + limiteSuperior + " pulsos por minuto";
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        // Generación de datos aleatorios para una persona
        String[] nombres = {"Juan", "Pedro", "Maria", "Ana", "Carlos", "Lucia", "Marta", "Jose", "Sofia", "Pedro"};
        String nombreAleatorio = nombres[random.nextInt(nombres.length)];
        int mesNacimiento = random.nextInt(12) + 1;
        int diaNacimiento = random.nextInt(28) + 1; // Para evitar fechas incorrectas
        int añoNacimiento = random.nextInt(63) + 1960;  // Edad entre 18 y 80 años

        // Creación de la persona con datos aleatorios
        Persona persona = new Persona(nombreAleatorio, mesNacimiento, diaNacimiento, añoNacimiento);

        // Mostrar la información de la persona
        System.out.println("Información generada para la persona:");
        System.out.println("Nombre: " + persona.nombre);
        System.out.println("Fecha de nacimiento: " + persona.diaNacimiento + "/" + persona.mesNacimiento + "/" + persona.añoNacimiento);
        System.out.println("Edad: " + persona.calcularEdad() + " años");
        System.out.println("Frecuencia cardiaca máxima (FCM): " + persona.calcularFCM() + " pulsos por minuto");
        System.out.println("Rango esperado de frecuencia cardiaca: " + persona.calcularRangoEsperado());

        // Historial de ejercicio
        System.out.println("\nIngrese el número de periodos de ejercicio registrados:");
        int nPeriodos = teclado.nextInt();

        // Mostrar el encabezado de la tabla
        System.out.println("\nHistorial de ejercicio:");
        System.out.println("Periodo\tTiempo (minutos)\tFrecuencia Cardiaca (pulsos por minuto)");

        // Registrar el historial de ejercicio
        for (int i = 1; i <= nPeriodos; i++) {
            System.out.println("\nPeriodo " + i + ":");
            System.out.print("Tiempo de ejercicio (minutos): ");
            int tiempo = teclado.nextInt();
            System.out.print("Frecuencia cardiaca durante el ejercicio: ");
            int frecuenciaCardiaca = teclado.nextInt();

            // Mostrar los datos del periodo de ejercicio
            System.out.println(i + "\t" + tiempo + "\t\t" + frecuenciaCardiaca);
        }
    }
}
