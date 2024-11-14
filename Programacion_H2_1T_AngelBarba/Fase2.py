import mysql.connector
import Fase2Menu

#Creamos la conexion con la base de datos
conexion = mysql.connector.connect(
    host='localhost',
    user='root',
    password='curso',
    database='HitoProgramacion'

)

if conexion.is_connected():
    print('Conexion exitosa a la base de datos\n')

#Inicar pagina principal
Fase2Menu.mostrar_menu(conexion)

#cerramos la conexion con la base de datos
conexion.close()