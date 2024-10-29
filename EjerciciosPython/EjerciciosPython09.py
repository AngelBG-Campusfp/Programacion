import numpy as np

array1 = np.array([1, 2, 3, 4, 5])
array2 = np.array([6, 7, 8, 9, 10])
suma_arrays = array1 + array2
print("Suma arrays:", suma_arrays)

array3 = np.array([2, 4, 6, 8, 10, 12])
multiplicacion_escalar = array3 * 3
print("Array multiplicado por 3:", multiplicacion_escalar)

array4 = np.array([10, 20, 30, 40, 50, 60, 70, 80, 90, 100])
promedio = np.mean(array4)
print("Promedio array:", promedio)

array5 = np.array([1, 3, 5, 7, 9, 11, 13, 15])
filtro_mayores_5 = array5[array5 > 5]
print("numeros mayores a 5:", filtro_mayores_5)

array6 = np.array([1, 2, 3, 4, 5])
cuadrado_elementos = array6 ** 2
print("numeros elevados al cuadrado:", cuadrado_elementos)
