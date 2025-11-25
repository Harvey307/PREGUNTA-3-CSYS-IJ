package org.example;

public class IsValidEmail {
    private String email;

    public boolean validoEmail(String email) {
        if (email == null || email.equals("")) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // 2. REGLAS BÁSICAS: Debe tener @, punto y NO tener espacios [cite: 118, 131, 135]
        if (!email.contains(
                "@") || !email.contains(".") || email.contains(" ")) {
            return false;
        }

        // 3. SEPARAR EL CORREO: Antes y después del @
        int arroba = email.indexOf('@');

        // Si hay más de una @, es inválido
        if (email.indexOf('@', arroba + 1) != -1) {
            return false;
        }

        String usuario = email.substring(0, arroba);
        String dominio = email.substring(arroba + 1);
        // 4. VALIDAR USUARIO (Parte local) [cite: 127, 128]
        // No vacío, no empezar/terminar con punto, no dos puntos seguidos
        if (usuario.isEmpty() || usuario.startsWith(".") || usuario.endsWith(".") || usuario.contains("..")) {
            return false;
        }
        // 5. VALIDAR DOMINIO [cite: 133]
        // Buscamos el último punto del dominio
        int punto = dominio.lastIndexOf('.');

        // El punto debe tener al menos 2 letras antes (ej: "a.com" es invalido, "ab.com" es valido)
        // Y el punto no puede ser el último caracter (ej: "gmail.com.")
        if (punto < 2 || punto == dominio.length() - 1) {
            return false;
        }

        return true; // Si pasó todo, es válido

    }
}
