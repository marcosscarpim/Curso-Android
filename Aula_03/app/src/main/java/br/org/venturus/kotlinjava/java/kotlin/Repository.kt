package br.org.venturus.kotlinjava.java.kotlin

object Repository {
    private val _users: MutableList<User> = mutableListOf(
        User("Jane", ""),
        User("John", null),
        User("Anne", "Doe")
    )
    val users: List<User>
        get() = _users.toList()

    val formattedUserNames: List<String>
        get() {
            return _users.map { user -> user.getFormattedName() }
        }
}

// Apenas para testar acessibilidade da lista
fun main() {
    val users = Repository.users
    (users as MutableList).add(User("Marcos", ""))
    println(Repository.formattedUserNames)
}
