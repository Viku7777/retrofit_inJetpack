
sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object GetExample : NavRoutes("GetExample")
    object PostExample : NavRoutes("PostExample")



//    object Profile : NavRoutes("profile/{userId}") {
//        fun createRoute(userId: Int) = "profile/$userId"
//    }
}