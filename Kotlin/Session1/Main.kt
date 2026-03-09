@Target(AnnotationTarget.FUNCTION)
annotation class Composable

class MainActivity {

    fun onCreate() {
        println("Launching Greeting Card Simulation...")

        setContent {
            GreetingScreen("Neha")
        }
    }

    private fun setContent(content: () -> Unit) {
        println("Setting up the content...")
        content()
    }
}

@Composable
fun GreetingScreen(name: String) {
    println("Hello $name! Welcome to your first Kotlin App!")
}

@Composable
fun AppTheme(content: () -> Unit) {
    println("Applying GreetingCard Theme...")
    content()
}

fun preview() {
    println("--- Preview Mode ---")
    GreetingScreen("Android Learner")
    println("--- End of Preview ---")
}

fun main() {
    println("========== Simulated Android App ==========\n")

    val activity = MainActivity()
    activity.onCreate()

    println()
    AppTheme {
        GreetingScreen("Neha")
    }

    println()
    preview()

    println("\n========== End of Simulation ==========")
}
