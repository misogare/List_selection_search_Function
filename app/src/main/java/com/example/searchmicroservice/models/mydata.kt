//
//import com.example.searchmicroservice.R
//import com.example.searchmicroservice.Category
//import com.example.searchmicroservice.Course
//
//class  DataRepository {
//    // Simulate loading data from an API
//    fun initializeCategories(): List<Category> {
//        val mathCourses = initializeMathCourses()
//        val econCourses = initializeEconCourses()
//
//        return listOf(
//            Category("Mathematics", mathCourses, R.drawable.logo2),
//            Category("Economics", econCourses, R.drawable.logo)
//        )
//    }
//
//    fun initializeMathCourses(): List<Course> {
//        return listOf(
//            Course("Geometry", "6 weeks", "John Doe", "Learn geometry basics", "Location A"),
//            Course("Algebra", "8 weeks", "Jane Smith", "Master algebraic equations", "Location B"),
//            Course("Calculus", "10 weeks", "Mike Johnson", "Calculus for advanced learners", "Location C")
//        )
//    }
//
//    fun initializeEconCourses(): List<Course> {
//        return listOf(
//            Course("Accounting", "12 weeks", "Emily Brown", "Fundamental accounting principles", "Location X"),
//            Course("Economics", "8 weeks", "Chris Wilson", "Economics for beginners", "Location Y"),
//            Course("Finance", "14 weeks", "Sarah Adams", "Financial management", "Location Z")
//        )
//    }
//
//}