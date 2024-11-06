import utilidades

texto = input('Escribe algo: ')

print("Texto en mayúsculas:", utilidades.convertir_a_mayusculas(texto))
print("Texto en minúsculas:", utilidades.convertir_a_minusculas(texto))

if utilidades.es_palindromo(texto):
    print('Es palindromo')
else:
    print('No es palindormo')