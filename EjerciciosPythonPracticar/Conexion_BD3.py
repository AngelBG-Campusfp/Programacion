import mysql.connector

conexion = mysql.connector.connect(
    host='localhost',
    user='root',
    password='curso',
    database='mundoanimal'
)

if conexion.is_connected():
    print('Conexion exitosa a la base de datos')

cursor = conexion.cursor()

nuevo_animal = (10,2,'Tigre',2)

consulta = "INSERT INTO ANIMAL (idAnimal, idFamilia, animal, cuantos) VALUES (%s, %s, %s, %s)"
cursor.execute(consulta, nuevo_animal)

conexion.commit()
print('Nuevo animal insertado correctamente')

cursor.close()
conexion.close()
