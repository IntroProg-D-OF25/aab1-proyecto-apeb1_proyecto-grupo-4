import java.util.Scanner;
import java.util.Random;

public class SistemAcademicoUTPL {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer los datos del usuario
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random(); // Para generar números aleatorios
        
        // Variables necesarias
        String[] nombres = {"Juan Pérez", "Ana Gómez", "Luis Martínez", "María Rodríguez", "Carlos López"};
        String[] materias = {"Matemáticas", "Física", "Química", "Historia", "Literatura"};
        
        String nombrestudiante, cedulaestudiante, materia;
        double calificacionacd, calificacionape, calificacionaa, sumacalificaciones, notarecuperacion, notafinal;
        boolean aprobado;
        int totalestudiantes, contadorestudiantes = 0, aprobados = 0, reprobados = 0;
        
        // Solicitar al usuario el número total de estudiantes
        System.out.print("Ingrese el número total de estudiantes: ");
        totalestudiantes = teclado.nextInt();
        
        // Limpiar el buffer
        teclado.nextLine(); 
        while (contadorestudiantes < totalestudiantes) {
            System.out.println("\nEstudiante #" + (contadorestudiantes + 1));
            
            // Solicitar datos del estudiante
            System.out.print("Ingrese el nombre del estudiante: ");
            nombrestudiante = teclado.nextLine();
            System.out.print("Ingrese la cédula del estudiante: ");
            cedulaestudiante = teclado.nextLine();
            
            // Generación aleatoria de la materia
            materia = materias[rand.nextInt(materias.length)];
            
            // Generación aleatoria de las calificaciones
            calificacionacd = 1.0 + rand.nextDouble() * 2.5; // Genera calificación entre 1.0 y 3.5
            calificacionape = 1.0 + rand.nextDouble() * 2.5; // Genera calificación entre 1.0 y 3.5
            calificacionaa = 1.0 + rand.nextDouble() * 2.0; // Genera calificación entre 1.0 y 3.5
            
            // Calcular la suma de las calificaciones
            sumacalificaciones = calificacionacd + calificacionape + calificacionaa;

            // Verificar si aprueba directamente
            if (sumacalificaciones >= 7.0) {
                aprobado = true;
                aprobados++;
            } else {
                aprobado = false;
                reprobados++;
                // Pedir la calificación de recuperación
                System.out.print("Ingrese la calificación de recuperación (máximo 3.5/10): ");
                notarecuperacion = teclado.nextDouble();

                // Limpiar el buffer
                teclado.nextLine(); 

                // Calcular la nota final después de la recuperación
                notafinal = (sumacalificaciones * 0.6) + notarecuperacion;
                if (notafinal >= 7.0) {
                    aprobado = true;
                    aprobados++;
                    reprobados--; // Ajustar el conteo de reprobados
                }
            }

            // Imprimir el reporte del estudiante
            System.out.println("\nReporte del Estudiante:");
            System.out.println("Nombre: " + nombrestudiante);
            System.out.println("Cédula: " + cedulaestudiante);
            System.out.println("Materia: " + materia);
            System.out.printf("Calificaciones: ACD = %.2f, APE = %.2f, AA = %.2f\n", calificacionacd, calificacionape, calificacionaa);
            System.out.println("Suma de calificaciones: " + sumacalificaciones);
            
            if (aprobado) {
                System.out.println("Estado: APROBADO");
            } else {
                System.out.println("Estado: REPROBADO");
            }

            // Incrementar contador
            contadorestudiantes++;
        }

        // Estadísticas finales
        System.out.println("\nEstadísticas del curso:");
        System.out.println("Total de estudiantes: " + totalestudiantes);
        System.out.println("Aprobados: " + aprobados + " (" + (aprobados * 100 / totalestudiantes) + "%)");
        System.out.println("Reprobados: " + reprobados + " (" + (reprobados * 100 / totalestudiantes) + "%)");
    }
}
