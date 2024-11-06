import mysql.connector

conexion = mysql.connector.connect(
    host= 'localhost',
    user= 'root',
    password= 'curso',
    database= 'mundoanimal'
)

if conexion.is_connected():
    print('Conexion exitosa a la base de datos')

cursor = conexion.cursor()

consulta = """
SELECT ANIMAL.animal, FAMILIA.familia
FROM ANIMAL
JOIN FAMILIA ON ANIMAL.idFamilia = FAMILIA.idfamilia;
"""

cursor.execute(consulta)

resultados = cursor.fetchall()

for animal, familia in resultados:
    print(f'Animal: {animal} | Familia: {familia}')

cursor.close()
conexion.close()

