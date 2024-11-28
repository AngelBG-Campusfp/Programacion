import pandas as pd  # Importamos Pandas
import matplotlib.pyplot as plt  # Importamos Matplotlib

# Cargamos los datos desde un archivo CSV
data = pd.read_csv('ventas.csv')


# Mostramos las primeras filas del archivo
print(data.describe())


# Creamos un gráfico de líneas para visualizar las ventas
plt.plot(data['Mes'], data['Ventas'])  # Asumiendo que tenemos columnas 'Mes' y 'Ventas'
plt.xlabel('Mes')
plt.ylabel('Ventas')
plt.title('Ventas mensuales')
plt.show()
