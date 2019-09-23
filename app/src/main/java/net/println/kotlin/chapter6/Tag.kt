package net.println.kotlin.chapter6


/**
 * Created by benny on 5/29/17.
 */
open class Tag(val name: String): Node {

    val children = ArrayList<Node>()

    val proerties = HashMap<String, String>()

    //String的拓展方法
    operator fun String.invoke(value: String){
        println("only invoke $value")
        proerties[this] = value
    }

    operator fun String.invoke(block: Tag.()->Unit){
        println("invoke block")
        this@Tag.children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus(){
        println("String.unaryPlus  + 加string--------")
        children.add(StringNode(this))
    }

    operator fun plus(node: Node){
        println("两个 Tag 相加 plus")
        children.add(node)
    }

    // <html id="htmlId" style=""><head> </head> <body></body></html>
    override fun render(): String {
        val b = Tag@ this.name == "html"
        if(b){
            println(" html.size >>>>>>> ${children.size}")
        }
        return StringBuilder()
                .append("<")
                .append(name)
                .let {
                    stringBuilder ->
                    if(!this.proerties.isEmpty()){
                        stringBuilder.append(" ")
                        this.proerties.forEach{
                            stringBuilder.append(it.key)
                                    //转义符
                                    .append("=\"")
                                    .append(it.value)
                                    .append("\" ")
                        }
                    }
                    stringBuilder
                }
                .append(">")
                .let {
                    stringBuilder ->
                    //之所以可以这样调用，默认lambda表达式的默认参数调用该方法
//                    children.map(Node::render)
                    children.map{
                        node->
                        val render = node.render()
                        //children 才会调用render
                        println(" render $render")
                        render
                    }
                            .map{str->
                                stringBuilder.append(str)
                            }
                    // map(stringBuilder::append) 之所以可以这样调用，StringBuilder方法调用append，把lambda表达式的默认方法参数作为append的方法参数
                    // .map(stringBuilder::append)
                    stringBuilder
                }
                .append("</$name>")
                .toString()
    }

}