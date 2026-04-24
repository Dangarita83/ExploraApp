package me.davidangarita.exploraapp

import android.util.Patterns


// returna un true si es valido y un false si no es valido
// retorna una cadena de texti que me diga que paso si no es valido
fun validateEmail(email: String): Pair<Boolean, String>{
    return when{
        email.isEmpty() -> Pair(false, "El correo es requerido")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair(false, "El correo es invalido")
        else -> Pair(true, "")
    }

}


fun validatePassword(password:String): Pair <Boolean, String>{
    return when{
        password.isEmpty() -> Pair(false, "La contraseña es requerida")
        else -> Pair(true, "")
    }
}


fun validateName(name: String): Pair<Boolean, String>{
    return when {
        name.isEmpty() -> Pair(false, "El nombre es requerido")
        name.length < 3 -> Pair(false, "El nombre debe tener 3 caracteres")
        else -> Pair(true, "")
    }
}


fun validateConfirmPassword(password: String, confirmPassword: String): Pair<Boolean, String>{
    return when{
        confirmPassword.isEmpty() -> Pair(false, "La contraseña es requerida")
        confirmPassword != password -> Pair(false, "Las contraseñas no coinciden")
        else -> Pair(true,"")
    }
}

