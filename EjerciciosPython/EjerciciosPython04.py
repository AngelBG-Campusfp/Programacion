def contador_pares(numeros):
    contador = 0
    for i in numeros:
        if i % 2 == 0:
            contador += 1
    return contador

print(contador_pares([1, 2, 3, 4, 5, 6]))  



def encontrar_maximo(numeros):
    maximo = numeros[0]

    for i in numeros[1:]:
        if i > maximo:
            maximo = i
    
    return maximo

print(encontrar_maximo([3, 5, 2, 9, 1])) 


def suma_limite(limite):
    suma = 0
    for num in range(1, limite + 1):
        suma += num
    return suma

print(suma_limite(5)) 

def contar_vocales(cadena):
    vocales = "aeiou"
    contador = 0
    
    for caracter in cadena.lower():
        if caracter in vocales:
            contador += 1
    
    return contador

print(contar_vocales("HOla")) 
