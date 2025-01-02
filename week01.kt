import java.awt.Stroke

fun welcome(){
    println("Wellcome to Kotlin");
}

fun userInfor() {
    print("Enter your name: ");
    val name: String = readLine() ?: ""
    print("Enter your age: ");
    val age: Int = readLine()!!.toInt()
    print("Enter your GPA: ");
    val GPA: Double = readLine()!!.toDouble()

    println("your name: $name");
    println("Your age; $age");
    println("Your GPA: $GPA");
}

fun display(name: String, age: Int, GPA: Double) {
    println("your name: $name");
    println("Your age; $age");
    println("Your GPA: $GPA");
}

var list:List<List<Any>> = listOf(
    listOf("KHMT", 20, "hanh"),
    listOf("KTMT", 10, "hieu"),
    listOf("TMDT", 5, "duong"),
)
fun displayDepartment(name: String, numberOfPerson: Int, leader: String) {
    println("Department: $name \n" +
            "Number of person: $numberOfPerson \n" +
            "leader: $leader");
}
fun departmentDetails() {
    println("=== Department ===")
    print("1.KHMT \n" +
            "2.KTMT \n" +
            "3.TMDT \n");
    print("Enter the number of the department: ")
    val department = readLine()
    when(department) {
        "1" -> {displayDepartment(list[0][0] as String, list[0][1] as Int, list[0][2] as String)}
        "2" -> {displayDepartment(list[1][0] as String, list[1][1] as Int, list[1][2] as String)}
        "3" -> {displayDepartment(list[2][0] as String, list[2][1] as Int, list[2][2] as String)}
    }

}

fun main() {
    // task 1
    welcome();
    // task 2
    userInfor();
    // task 3
    departmentDetails();
}
