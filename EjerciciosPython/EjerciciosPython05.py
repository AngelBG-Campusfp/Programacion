numeros = [1,2,3,4,5]#definimos la lista de numeros

def sumar_a_numeros(n):#funcion para sumar 5 a cada numero
    return n + 5

sumar = map(sumar_a_numeros, numeros)#variable para que haga la funcion dentro de la lista
print(list(sumar))#imprimir la variable que hace la funcion









frases = ['hola', 'adios', 'dios']#defimos una lista con palabras

def mayusculas(n):#funcion para mostrar mayuscula la primera letra de cada palabra
    return n.title()#hacemos que muestre la primera letra mayuscula de cada palabra

titulo = map(mayusculas, frases)#variable para que haga la funcion dentro de la lista
print(list(titulo))#imprimir la variable que hace la funcion









numeros2 = [1,3,5,7,9]#definimos la lista de nuemeros

def calcular_el_doble(n):#funcion para sacar el doble de cada numero
    return n * 2

doble = map(calcular_el_doble, numeros2)#variable para que haga la funcion dentro de la lista
print(list(doble))#imprimir la variable que hace la funcion









numeros3 = [1.4, 2.6, 7.1,8.8]#almacenar numeros decimales en lista

def redondear_numeros3(n):#funcion para redondear os numeros decimales
    return round(n)

redondear = map(redondear_numeros3, numeros3)#variable para que haga la funcion dentro de la lista
print(list(redondear))#imprimir la variable que hace la funcion









frases2 = ['hola', 'adios', 'loca']#variable que almacena palabras

def calcular_longitud(n):#funcion para calcular la longitud de cada palabra 
    return len(n)

longitud = map(calcular_longitud, frases2)#variable para que haga la funcion
print(list(longitud))#imprimir la variable que hace la funcion

