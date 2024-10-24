import random

#Contadores de victoias
victoria_maquina = 0
victoria_usuario = 0

#Almacenamos todos los elementos en una lista
lista = ['Piedra', 'Papel', 'Tijera']

while True:
    #Solicitar elccion 
    eleccion = int(input("\nElige 1-Pidra | 2-Papel | 3-Tijera: "))

    #Hacemos que certifique la eleccion
    if eleccion not in [1,2,3]:
        print("Vuelve a intentarlo.")
        continue#Vuelve al bucle

    #Imprime la eleccion del usuario, pongo el -1 porque los indices empiezan en cero y sino me daria otro valor al elegido
    print(f"\nHas elegido: {lista[eleccion - 1]}")

    #Diciendo que me saque un elemento aleatorio de la lista definida y que lo imprima
    numero_random = random.choice(lista)
    print(f"La maquina ha elegido {numero_random}")

    #Hacemos que si yo gano a los valores random de la maquina, imprima que he ganado y sume 1 a mi contador
    if eleccion == 1  and numero_random == 'Tijera' or eleccion == 2  and numero_random == 'Piedra' or eleccion == 3  and numero_random == 'Papel':
        print("\n¡Has ganado la ronda!")
        victoria_usuario += 1

        #Hacemos que si la amquina a mis valores introducidos, imprima que ha ganado la maquina y sume 1 a su contador
    elif eleccion == 1  and numero_random == 'Papel' | eleccion == 2  and numero_random == 'Tijera' | eleccion == 3  and numero_random == 'Piedra':
        print("\nHas perdido la ronda")
        victoria_maquina += 1

    #Hacemos que si no pasa nada de lo anterior, muestre que ha sido un empate
    else:
        print("Habeis empatado")

    print(f"Usuario: {victoria_usuario} - Maquina {victoria_maquina}")

    #si el usuario gana 3 partidas, salir del bucle
    if victoria_usuario == 3:
        print("¡Has ganado!")
        break
    elif victoria_maquina == 3:
        print("Has perdido")
        break