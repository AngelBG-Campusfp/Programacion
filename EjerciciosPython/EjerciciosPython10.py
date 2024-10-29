import numpy as np

#matriz 3x3 llena de ceros
array1 = np.zeros((3,3))
array1[1,1] = 1#cambio del elemento 1,1

print(array1)



#definir matrices
matriz1 = np.array([[1,2,3], [4,5,6]])
matriz2 = np.array([[7,8,9], [10,11,12]])

#sumar matrices
suma_matrices = matriz1 + matriz2
print(suma_matrices)



#Crear matriz 4x4 con numeros del 1 al 16
matriz3 = np.arange(1,17).reshape((4,4))
print(matriz3[:,2])#sacar numeros tercera columna



#crear matriz
matriz4 = np.array([[1,2,3,4], [5,6,7,8], [9,10,11,12]])
promedio_matriz4 = np.mean(matriz4, axis=1)#sacar promedio por fila
print(promedio_matriz4)



#Crear matriz con numeros random
matriz5 = np.random.randint(1,51, size=(4,3))
#Indica q queremos el maximo de cada columna
valor_matriz5 = np.max(matriz5, axis=0)
print(valor_matriz5)