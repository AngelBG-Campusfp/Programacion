import numpy as np

def iniciar_juego():
    # Crear tablero 5x5 y llenarlo con ceros
    tablero = np.zeros((5, 5), dtype=int)

    # Colocar el barco en una posición aleatoria
    fila_barco = np.random.randint(0, 5)
    columna_barco = np.random.randint(0, 5)
    tablero[fila_barco, columna_barco] = 1

    # Contador de intentos
    intentos = 0
    encontrado = False

    print("¡Bienvenido a Hundir la Flota!")
    print("Intenta encontrar el barco en un tablero 5x5.")

    # Bucle de juego
    while not encontrado:
        print("\nEstado del tablero:")
        # Mostrar tablero sin revelar el barco, salvo si ha sido encontrado
        tablero_mostrar = np.where(tablero == 1, 1, tablero) if encontrado else np.where(tablero == -1, -1, 0)
        print(tablero_mostrar)

        # Pedir coordenadas de ataque
        try:
            fila = int(input("Ingresa la fila (0-4): "))
            columna = int(input("Ingresa la columna (0-4): "))
        except ValueError:
            print("Por favor, ingresa números válidos.")
            continue

        # Verificar que las coordenadas están en el rango
        if fila < 0 or fila > 4 or columna < 0 or columna > 4:
            print("Coordenadas fuera de rango. Intenta nuevamente.")
            continue

        # Incrementar el contador de intentos
        intentos += 1

        # Verificar si se ha acertado
        if (fila, columna) == (fila_barco, columna_barco):
            print("¡Has hundido el barco!")
            encontrado = True
        else:
            # Marcar el intento fallido con -1
            if tablero[fila, columna] != -1:
                print("Agua")
                tablero[fila, columna] = -1
            else:
                print("Ya has intentado esta posición. Intenta en otra coordenada.")

    # Mostrar el tablero final y el número de intentos
    print("\nTablero final:")
    print(tablero)
    print(f"¡Juego terminado! Has encontrado el barco en {intentos} intentos.")

# Iniciar el juego
iniciar_juego()