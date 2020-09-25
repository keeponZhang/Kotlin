package ch04.ex2_3_2_ImplementingPropertiesDeclaredInInterfaces1

import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr
import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr.value

interface User {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')

}
