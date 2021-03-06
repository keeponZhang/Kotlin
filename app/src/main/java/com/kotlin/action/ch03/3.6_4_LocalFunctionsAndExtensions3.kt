package ch03.ex6_4_LocalFunctionsAndExtensions3

class User(val id: Int, val name: String, val address: String)
//我们可以继续改进，把验证逻辑放到User类的扩展函数中
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
               "Can't save user $id: empty $fieldName")  //属性需要是公有的
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    // Save user to the database
}

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
}
