lista_reproduccion = []

cancion = input('Dame el nombre de una canción: ')

while cancion != 'fin':
    lista_reproduccion.append(cancion)
    cancion = input('Dame el nombre de una canción: ').lower()

print (lista_reproduccion)


for i in range(len(lista_reproduccion)):
    print(f"{i}.- {lista_reproduccion[i]}")
    #print(lista_reproduccion[i])

cancion_a_reproducir = int(input("Dime el número de canción que deseas escuchar: "))
print(f"Estas escuchando la canción: {lista_reproduccion[cancion_a_reproducir]}")









contactos = {}

while True:
    nombre = input("Ingresa el nombre de contacto o 'fin'para terminar: ")
    if nombre.lower() == "fin":
        break
    telefono = input(f"Ingresa el numero de telefono de, {nombre}: ")
    contactos[nombre] = telefono 

print("Tus contactos:")
for nombre, telefono in contactos.items():
    print(f"- {nombre}: {telefono}")

# Buscar un contacto
buscar = input("Ingresa el nombre del contacto que deseas buscar: ")
if buscar in contactos:
    print(f"El número de teléfono de {buscar} es {contactos[buscar]}.")
else:
    print(f"El contacto {buscar} no se encuentra en la lista.")









tupla_viaje = ("Mallorca", "Benidorm", "Canarias", "Barcelona", "Valencia")
print(tupla_viaje)

for i in range(len(tupla_viaje)):
    print(f"{i}.- {tupla_viaje[i]}")
    

lugar_usuario = int(input("Ingresa la posicion para sabe rque lugar visitaras: "))
print(f"Vas a viajar a: {tupla_viaje[lugar_usuario]}")









asignaturas = {}    

while True:
    asignatura_usuario = input("Introduce la asignatura: ")

    if asignatura_usuario == "fin":
        break

    else:
        notas_usuario = int(input(f"Introduce tu nota de {asignatura_usuario}: "))
        asignaturas[asignatura_usuario] = notas_usuario

   
print("Resumen de las calificaciones: ")
print(f"{asignaturas}: {notas_usuario}")









elemento_menu = {"Café": (1.5, 50),"Té": (1.0, 0),"Bocadillo": (3.0, 300),"Ensalada": (2.5, 150)}

print("Bienvenido a la cafetería. Aquí está nuestro menú:")
for producto, (precio, calorias) in elemento_menu.items():
    print(f"{producto}: {precio}€ - {calorias} kcal")






