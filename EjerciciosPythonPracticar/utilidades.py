def convertir_a_mayusculas(texto):
    return texto.upper()

def convertir_a_minusculas(texto):
    return texto.lower()

def es_palindromo(texto):
    texto = texto.replace(" ", "").lower()
    return texto == texto[::-1]