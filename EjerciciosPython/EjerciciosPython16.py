import mysql.connector
import EjerciciosPython16MENU

#Creamos la conexion con la base de datos
conexion = mysql.connector.connect(
    host='localhost',
    user='root',
    password='curso',
    database='SUPERMERCADO'
)

if conexion.is_connected():
    print('Conexion exitosa a la base de datos\n')

#Llamo a una funcion de otro archivo, 
#que hace todo lo necesario
EjerciciosPython16MENU.menu_tablas(conexion)

#cerramos la conexion con la base de datos
conexion.close()