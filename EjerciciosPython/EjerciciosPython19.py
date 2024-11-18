import mysql.connector
import EjerciciosPython19MENU

conexion = mysql.connector.connect(
    host='localhost',
    user='root',
    password='curso',
    database='centro_deportivo'
)

if conexion.is_connected():
    print('Conexion exitosa a la base de datos\n')

EjerciciosPython19MENU.menu_principal(conexion)

conexion.close()