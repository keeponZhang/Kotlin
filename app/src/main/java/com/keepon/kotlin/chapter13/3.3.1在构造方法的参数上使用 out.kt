package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */
//构造方法的参数既不在in位置，也不再out位置，即使类型参数声明成了out，仍然可以在构造方法参数的声明中使用它。
//class Herd<out T : Animal> (vararg animals : T) { ... }
//如果把类的实例当成一个更泛化的类型的实例使用，变型会防止该实例被误用，不能调用存在潜在危险的方法。构造方法不是那种在实例创建之后还能调用的方法，因此它不会有潜在的危险。
//
//然而，如果你在构造方法的参数上使用了关键字var和val，同时就会声明一个getter和setter，
//因此，对只读属性来说，类型参数用在了out位置，而可变属性在out和in位置都使用了它。
//
//class Herd<T : Animal> (var leadAnimal : T, vararg animals : T) { ... }
//
//上面这个例子中，T不能用out标记，因为类包含属性leadAnimal的setter，它在in位置用到了T。
//
//位置规则只覆盖了类外部可见的 API
//
//位置规则只覆盖了类外部可见的api，私有方法的参数既不在in位置，也不在out位置，变型规则只会防止外部使用者对类的误用，但不会对类自己的实现起作用。
//class Herd<out T : Animal> (private var leadAnimal : T, vararg animals : T) { ... }
//现在可以安全地让Herd在T上协变，因为属性leadAnimal被声明成了私有。




















