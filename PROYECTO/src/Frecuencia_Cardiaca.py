#random: Para generar nombres y frecuencias cardíacas aleatorias.
import random
#datetime: Para trabajar con fechas y calcular la edad.
from datetime import datetime, timedelta
class FrecuenciasCardiacas:
    #Inicializa los atributos nombre y fecha_nacimiento.
    def __init__(self, nombre, fecha_nacimiento):
        self.nombre = nombre
        self.fecha_nacimiento = fecha_nacimiento
        #Calcula la edad de la persona en años.
    def calcular_edad(self):
        hoy = datetime.now()
        edad = hoy.year - self.fecha_nacimiento.year - ((hoy.month, hoy.day) < (self.fecha_nacimiento.month, self.fecha_nacimiento.day))
        return edad
    #Calcula la frecuencia cardíaca máxima usando la fórmula 
    def calcular_frecuencia_maxima(self):
        edad = self.calcular_edad()
        frecuencia_maxima = 220 - edad
        return frecuencia_maxima
    #Calcula el rango de frecuencia cardíaca esperada (50% a 85% de la frecuencia máxima)
    def calcular_frecuencia_esperada(self):
        frecuencia_maxima = self.calcular_frecuencia_maxima()
        rango_inferior = frecuencia_maxima * 0.50
        rango_superior = frecuencia_maxima * 0.85
        return rango_inferior, rango_superior
#nombres aleatorios
nombres = ["Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Javier", "Claudia", "Pedro", "Sofía"]
# Generación de un nombre aleatorio
nombre_aleatorio = random.choice(nombres)
# Generación de una edad aleatoria entre 18 y 65 años
edad_aleatoria = random.randint(18, 65)
# Cálculo de la fecha de nacimiento a partir de la edad
fecha_nacimiento_aleatoria = datetime.now() - timedelta(days=edad_aleatoria * 365)
# Creación de la instancia de FrecuenciasCardiacas
persona = FrecuenciasCardiacas(nombre_aleatorio, fecha_nacimiento_aleatoria)
# Cálculo de la edad, frecuencia máxima y frecuencia esperada
edad = persona.calcular_edad()
frecuencia_maxima = persona.calcular_frecuencia_maxima()
frecuencia_esperada = persona.calcular_frecuencia_esperada()
# Impresión de resultados
print(f"Nombre: {persona.nombre}")
print(f"Edad: {edad} años")
print(f"Frecuencia Cardíaca Máxima: {frecuencia_maxima} pulsos por minuto")
print(f"Rango de Frecuencia Cardíaca Esperada: {frecuencia_esperada[0]:.2f} - {frecuencia_esperada[1]:.2f} pulsos por minuto")
# Historial de seguimiento
historial = [
    {"tiempo": 30, "frecuencia": random.randint(90, 180)},  # 30 minutos, frecuencia aleatoria
    {"tiempo": 45, "frecuencia": random.randint(90, 180)},  # 45 minutos, frecuencia aleatoria
    {"tiempo": 60, "frecuencia": random.randint(90, 180)},  # 60 minutos, frecuencia aleatoria
]
# Presentación del historial en forma de tabla
print("\nHistorial de Seguimiento:")
print(f"{'Tiempo (min)':<15} {'Frecuencia (ppm)':<20}")
for registro in historial:
    print(f"{registro['tiempo']:<15} {registro['frecuencia']:<20}")
    
    """
    Nombre: Carlos
Edad: 44 años
Frecuencia Cardíaca Máxima: 176 pulsos por minuto
Rango de Frecuencia Cardíaca Esperada: 88.00 - 149.60 pulsos por minuto

Historial de Seguimiento:
Tiempo (min)    Frecuencia (ppm)    
30              106
45              154
60              123
    """
