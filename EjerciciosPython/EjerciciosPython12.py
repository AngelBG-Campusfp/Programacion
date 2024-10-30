#Creamos el archivo de texto con "w"
crear_archivo = open("saludo.txt", "w")
crear_archivo.close()

#Modificamos el archivo con "w" tambien
crear_archivo = open("saludo.txt", "w")
crear_archivo.write("Modificando el archivo")
crear_archivo.close





#Creacion de archivo de texto
archivo2 = open("frase.txt", "w")
archivo2.close()

#Escribiendo dentro del archivo
archivo2 = open("frase.txt", "w")
archivo2.write("Modificando este segundo archivo")

with open("frase.txt", "r") as archivo2:
    contenido = archivo2.read()
    print(contenido)





#Creamos el archivo de texto
with open("notas.txt", "w") as archivo3:

    #Bucle for, en un rango de 1 a 4 para que nos pregunte 3 veces sobre la nota
    for i in range(1,4):
        nota = input("Ingresa una nota(en texto): ")
        #Escribimos la nota en el archivo, con un salto de linea
        archivo3.write(nota + "\n")
    archivo3.close()






#Crear archivo en escritura
archivo4 = open("alumnos.txt", "w")

# Escribe cada nombre en una nueva línea
archivo4.write("Ana\n")
archivo4.write("Luis\n")
archivo4.write("Carlos\n")
archivo4.write("Marta\n")
archivo4.write("Elena\n")

archivo4.close()

#abrir archivo en modo lectura
archivo4 = open("alumnos.txt", "r")
print(archivo4.read())
archivo4.close()





#Crear y escribir en el archivo de texto
with open("diario.txt", "w") as archivo5:
    archivo5.write("Estoy aprendiendo a programar\n")

    #Crear nueva entrada al diario
    nueva_entrada = input("Ingresa una nueva esntrada: ")

    #Abrir el archivo en modo de añadido
    with open("diario.txt", "a") as archivo5:
        #Escribir en el archivo la nueva entrada mas salto de linea
        archivo5.write(nueva_entrada + "\n")
    
    #Abrir archivo modo lectura
    with open("diario.txt", "r") as archivo5:
        # Mostrar su contenido
        contenido2 = archivo5.read()
        print(contenido2)




