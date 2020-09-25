package ch04.ex2_1_InitializingClasses

import android.content.Context
import android.view.View
import java.util.jar.Attributes

//这个类没有主构造方法，只有2个从构造方法
class MyButton : View {
    constructor(ctx: Context)
        : super(ctx) {
    }

    constructor(ctx: Context, attr: Attributes)
        : super(ctx) {
    }
}

class MyButton2 : View {
    constructor(ctx: Context)
        : this(ctx, Attributes()) {
    }

    constructor(ctx: Context, attr: Attributes)
        : super(ctx) {
    }
}