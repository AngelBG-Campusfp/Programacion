productos = [
    {"nombre": "manzana", "tipo": "perecedero"},
    {"nombre": "arroz", "tipo": "no perecedero"},
    {"nombre": "leche", "tipo": "perecedero"},
    {"nombre": "pasta", "tipo": "no perecedero"},
    {"nombre": "zanahoria", "tipo": "perecedero"},
    {"nombre": "atún enlatado", "tipo": "no perecedero"}
]

# Función que determina si un producto es perecedero
def es_perecedero(producto):
    return producto["tipo"] == "perecedero"

# Usar filter() para obtener solo los productos perecederos
productos_perecederos = list(filter(es_perecedero, productos))

# Imprimir los productos perecederos
print("Productos perecederos en el almacén:")
for producto in productos_perecederos:
    print(producto["nombre"])









# Lista de vehículos con su estado de revisión técnica
vehiculos = [
    {"marca": "Toyota", "modelo": "Corolla", "revision": "aprobada"},
    {"marca": "Ford", "modelo": "Focus", "revision": "pendiente"},
    {"marca": "Honda", "modelo": "Civic", "revision": "aprobada"},
    {"marca": "Chevrolet", "modelo": "Sonic", "revision": "pendiente"},
    {"marca": "Nissan", "modelo": "Versa", "revision": "aprobada"}
]

# Usar filter() para obtener solo los vehículos con revisión técnica aprobada
vehiculos_aprobados = list(filter(lambda vehiculo: vehiculo["revision"] == "aprobada", vehiculos))

# Imprimir los vehículos que han pasado la revisión
print("Vehículos con revisión técnica aprobada:")
for vehiculo in vehiculos_aprobados:
    print(f"{vehiculo['marca']} {vehiculo['modelo']}")









# Lista de empleados con su estado laboral
empleados = [
    {"nombre": "Juan Pérez", "estado": "activo"},
    {"nombre": "Ana García", "estado": "inactivo"},
    {"nombre": "Luis Rodríguez", "estado": "activo"},
    {"nombre": "María López", "estado": "inactivo"},
    {"nombre": "Carlos Torres", "estado": "activo"}
]

# Usar filter() para obtener solo los empleados activos
empleados_activos = list(filter(lambda empleado: empleado["estado"] == "activo", empleados))

# Imprimir los nombres de los empleados activos
print("Empleados activos:")
for empleado in empleados_activos:
    print(empleado["nombre"])









# Lista de libros con sus categorías
libros = [
    {"titulo": "Cien años de soledad", "categoria": "novela"},
    {"titulo": "El arte de la guerra", "categoria": "ensayo"},
    {"titulo": "El jardín secreto", "categoria": "novela"},
    {"titulo": "Poemas de Pablo Neruda", "categoria": "poesía"},
    {"titulo": "Don Quijote de la Mancha", "categoria": "novela"},
    {"titulo": "Sapiens: De animales a dioses", "categoria": "ensayo"}
]

# Usar filter() para obtener solo los libros de la categoría "novela"
libros_novela = list(filter(lambda libro: libro["categoria"] == "novela", libros))

# Imprimir los títulos de los libros de la categoría "novela"
print("Libros de la categoría 'novela':")
for libro in libros_novela:
    print(libro["titulo"])









# Lista de tareas de un gestor de proyectos
tareas = [
    {"titulo": "Enviar informe a cliente", "urgente": True},
    {"titulo": "Actualizar la presentación", "urgente": False},
    {"titulo": "Revisar el presupuesto", "urgente": True},
    {"titulo": "Programar reunión de equipo", "urgente": False},
    {"titulo": "Enviar invitaciones a la conferencia", "urgente": True},
    {"titulo": "Limpiar el código del proyecto", "urgente": False}
]

# Usar filter() para obtener solo las tareas urgentes
tareas_urgentes = list(filter(lambda tarea: tarea["urgente"], tareas))

# Imprimir las tareas urgentes
print("Tareas urgentes:")
for tarea in tareas_urgentes:
    print(tarea["titulo"])