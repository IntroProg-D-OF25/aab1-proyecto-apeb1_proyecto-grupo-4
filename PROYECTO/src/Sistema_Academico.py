"""
Se debe verificar la aprobación de una materia dadas tres calificaciones: 
ACD (3.5/10), APE (3.5/10) y AA (3/10). Se aprueba si la sumatoria es de al menos 70%, 
si cumple con este requisito, se considera que ha aprobado, caso contrario informar al 
estudiante que deberá rendir un examen de recuperación sobre 3.5/10 pts. agregado al 60% 
acumulado de los componentes ACD, APE y AA.
"""
import random                                                                                           
class Estudiante:
    def __init__(self, nombre, cedula, materia):
        self.nombre = nombre
        self.cedula = cedula
        self.materia = materia
        #Calificaciones generadas aleatoriamente dentro de rangos específicos
        self.acd = random.uniform(0, 3.5)  
        self.ape = random.uniform(0, 3.5)
        self.aa = random.uniform(0, 3) 
        #Suma las calificaciones del estudiante     
    def calcular_suma(self):
        return self.acd + self.ape + self.aa
        #Verifica si la suma de las calificaciones es igual o superior a 7.0
    def verificar_aprobacion(self):
        suma = self.calcular_suma()
        return suma >= 7.0  
    #los nombres alaetorios
def generar_nombre_aleatorio():
    nombres = ["Juan", "Maria", "Pedro", "Ana", "Luis", "Laura"]
    return random.choice(nombres)
#Genera la cecula
def generar_cedula_aleatoria():
    return str(random.randint(100000000, 999999999))
#la materia 
def generar_materia_aleatoria():
    materias = ["Programación"]
    return random.choice(materias)
def main(
):
    estudiantes = []
    #Genera 6 estudiantes
    num_estudiantes = 6
    #Crea una lista vacía para almacenar estudiantes.
    #Genera 6 estudiantes con nombres, cédulas y materias aleatorias.
    for _ in range(num_estudiantes):
        nombre = generar_nombre_aleatorio()
        cedula = generar_cedula_aleatoria()
        materia = generar_materia_aleatoria()
        estudiante = Estudiante(nombre, cedula, materia)
        estudiantes.append(estudiante)
    total_aprobados = 0
    total_reprobados = 0
    print("Resultados de las calificaciones:")
    for estudiante in estudiantes:
        print(f"Nombre: {estudiante.nombre}, Cédula: {estudiante.cedula}, Materia: {estudiante.materia}")
        print(f"Calificaciones -> ACD: {estudiante.acd:.2f}, APE: {estudiante.ape:.2f}, AA: {estudiante.aa:.2f}")
        suma_notas = estudiante.calcular_suma()
        print(f"Suma Total de Notas: {suma_notas:}")
        #Calcula la suma total de las calificaciones y verifica si aprueba o reprueba
        if estudiante.verificar_aprobacion():
            print("Resultado: Aprobado")
            total_aprobados += 1
        else:
            print("Resultado: Reprobado")
            total_reprobados += 1
            print("Nota de recuperación: 3.5/10 pts agregados al 60% acumulado")
        print()
        #Calcula y muestra el porcentaje de estudiantes aprobados y reprobados
    total_estudiantes = len(estudiantes)
    porcentaje_aprobados = (total_aprobados / total_estudiantes) * 100
    porcentaje_reprobados = (total_reprobados / total_estudiantes) * 100
    print("Estadísticas finales:")
    print(f"Porcentaje de aprobados: {porcentaje_aprobados:}%")
    print(f"Porcentaje de reprobados: {porcentaje_reprobados:}%")
if __name__ == "__main__":
    main()

    