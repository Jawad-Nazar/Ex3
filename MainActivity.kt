// Base class: Employee
open class Employee(
    protected val name: String,
    protected val baseSalary: Double
) {
    open fun calculateSalary(): Double = baseSalary
}

// Subclass: FullTimeEmployee
class FullTimeEmployee(
    name: String,
    baseSalary: Double,
    private val bonus: Double
) : Employee(name, baseSalary) {
    override fun calculateSalary(): Double = baseSalary + bonus
}

// Subclass: PartTimeEmployee
class PartTimeEmployee(
    name: String,
    private val hourlyRate: Double,
    private val hoursWorked: Int
) : Employee(name, 0.0) { // baseSalary not used
    override fun calculateSalary(): Double = hourlyRate * hoursWorked
}

fun main() {
    // Create employees
    val employees = mapOf(
        "Alice" to FullTimeEmployee("Alice", 50000.0, 10000.0),
        "Bob"   to FullTimeEmployee("Bob", 60000.0, 12000.0),
        "Cara"  to PartTimeEmployee("Cara", 25.0, 120),
        "Dave"  to PartTimeEmployee("Dave", 30.0, 80)
    )

    // Loop through map and display salaries
    println("Employee Salaries:")
    println("==================")
    employees.forEach { (name, employee) ->
        val salary = employee.calculateSalary()
        println("$name: $${"%.2f".format(salary)}")
    }
}