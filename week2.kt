class Car(val name: String, val year: Int, val price: Double) {
    val tax: Double = when {
        price > 1000 -> price * 0.1
        price > 500 -> price * 0.05
        else -> price * 0.03
    }

    fun displayCar() {
        println("Car name: $name")
        println("Car year: $year")
        println("Car price: ${"%,.1f".format(price)}")
        println("Car tax: ${"%,.1f".format(tax)}")
    }

    fun sumPayment(): Double {
        return price + tax
    }
}

class Customer(val name: String, val age: Int, val address: String) {
    fun displayCustomer() {
        println("Customer name: $name")
        println("Customer age: $age")
        println("Customer address: $address")
    }

    fun isAdult(): Boolean {
        return age >= 18
    }
}

// Global variables
val cars = mutableListOf<Car>()
var customer: Customer? = null

fun addCars() {
    print("Input the number of cars: ")
    val n = readLine()!!.toInt()
    for (i in 1..n) {
        println("Input information of car $i")
        print("Input the car name: ")
        val name = readLine()!!
        print("Input the car year: ")
        val year = readLine()!!.toInt()
        print("Input the car price: ")
        val price = readLine()!!.toDouble()
        val car = Car(name, year, price)
        cars.add(car)
    }
}

fun displayCars() {
    if (cars.isEmpty()) {
        println("No cars available.")
    } else {
        for (car in cars) {
            car.displayCar()
        }
    }
}

fun inputCustomer() {
    println("Input information of customer:")
    print("Input the customer name: ")
    val name = readLine()!!
    print("Input the customer age: ")
    val age = readLine()!!.toInt()
    print("Input the customer address: ")
    val address = readLine()!!
    customer = Customer(name, age, address)
}

fun displayCustomer() {
    customer?.displayCustomer() ?: println("Customer information is not available.")
}

fun buyCar() {
    if (customer == null) {
        println("Please input customer information first.")
        return
    }
    print("Input the car name you want to buy: ")
    val name = readLine()!!
    val car = cars.find { it.name == name }
    if (car != null) {
        if (customer!!.isAdult()) {
            println("Price of the car: ${car.sumPayment()}")
        } else {
            println("You are not an adult. You cannot buy a car.")
        }
    } else {
        println("Car not found.")
    }
}

fun exit() {
    println("Exit the program.")
    System.exit(0)
}

fun main() {
    // Add initial cars
    cars.addAll(
        listOf(
            Car("Toyota", 2010, 700.0),
            Car("Honda", 2015, 250.0),
            Car("BMW", 2018, 10000000000.0)
        )
    )



    while (true) {
        println("------ Menu ------")
        println("1. Add car")
        println("2. Display cars")
        println("3. Input customer information")
        println("4. Display customer information")
        println("5. Buy car")
        println("6. Exit")
        println("------------------")
        print("Enter your choice: ")
        when (readLine()!!.toInt()) {
            1 -> addCars()
            2 -> displayCars()
            3 -> inputCustomer()
            4 -> displayCustomer()
            5 -> buyCar()
            6 -> exit()
            else -> println("Invalid choice. Please try again.")
        }
    }
}