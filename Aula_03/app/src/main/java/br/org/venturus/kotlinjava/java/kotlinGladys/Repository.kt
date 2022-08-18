package br.org.venturus.kotlinjava.java.kotlinGladys

class Repository {

    private val users: MutableList<User>? = null

    init {
        users?.addAll(listOf(User("Jane", ""), User("John", null), User("Anne", "Doe")))
    }

    private fun getFormattedUserNames(): List<String>? = users?.map { user ->
        when {
            user.lastName != null -> if (user.firstName != null)
                "${user.firstName} ${user.lastName}"
            else
                user.lastName
            user.firstName != null -> user.firstName
            else -> "Unknown"
        }
    }

    companion object {

        private var INSTANCE: Repository? = null

        fun getInstance(): Repository? = INSTANCE ?: run {
            INSTANCE = Repository()
            INSTANCE
        }
    }
}