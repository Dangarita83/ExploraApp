package me.davidangarita.exploraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import me.davidangarita.exploraapp.ui.elements.AddTouristicPlaceScreen
import me.davidangarita.exploraapp.ui.elements.HomeScreen
import me.davidangarita.exploraapp.ui.elements.LoginScreen
import me.davidangarita.exploraapp.ui.elements.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()
            var myStartDestination: String = "login"
            val auth = Firebase.auth
            val currentUser = auth.currentUser

            if(currentUser != null){
                myStartDestination = "home"

            }else{
                myStartDestination = "login"
            }

            NavHost(
                navController = myNavController,
                startDestination = myStartDestination,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login") {
                    LoginScreen(
                        onLoginSuccess = {
                            myNavController.navigate("home") {
                                popUpTo("login") { inclusive = true }
                            }
                        },
                        onNavigateToRegister = {
                            myNavController.navigate(route = "register")
                        }

                    )
                }
                composable(route = "register") {
                    RegisterScreen(onRegisterSuccess = {
                        myNavController.navigate("home") {
                            popUpTo(0)
                        }
                    }, onNavigateToLogin = {}, onBackClick = {
                        myNavController.popBackStack()
                    }
                    )
                }

                composable(route = "home"){
                    HomeScreen(onClickAddTouristicPlace = {
                        myNavController.navigate("add_touristic_place")
                    })
                }

                composable(route="add_touristic_place"){
                    AddTouristicPlaceScreen()
                }




            }

        }
    }
}