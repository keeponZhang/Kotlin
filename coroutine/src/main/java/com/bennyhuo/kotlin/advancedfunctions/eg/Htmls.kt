package com.bennyhuo.kotlin.advancedfunctions.eg

import java.io.File

interface Node {
    fun render(): String
}

class StringNode(val content: String) : Node {
    override fun render(): String {
        return content
    }
}

class BlockNode(val name: String) : Node {
    init {
        println("BlockNode.name = $name")
    }

    val children = ArrayList<Node>()
    val properties = HashMap<String, Any>()

    override fun render(): String {
        val s = """<$name ${properties.map { "${it.key}='${it.value}'" }
                .joinToString(" ")}>${children.joinToString("") { it.render() }}</$name>"""
        println("渲染$name 开始==" + s)
        println("渲染$name 结束")
        return s
    }

    //    "meta" { "charset"("UTF-8") }
    operator fun String.invoke(block: BlockNode.() -> Unit): BlockNode {
        println("invoke=" + name)
        val node = BlockNode(this)
        node.block()
        this@BlockNode.children += node
        return node
    }

    //    "charset"("UTF-8")
    operator fun String.invoke(value: Any) {
        println("属性开始this=$this, value=$value")
        this@BlockNode.properties[this] = value
        println("属性结束--------")
    }

    operator fun String.unaryPlus() {
        this@BlockNode.children += StringNode(this)
    }
}

fun html(block: BlockNode.() -> Unit): BlockNode {
    val html = BlockNode("html")
    html.block()
    return html
}

fun BlockNode.head(block: BlockNode.() -> Unit): BlockNode {
    val head = BlockNode("head")
    head.block()
    this.children += head
    return head
}

fun BlockNode.body(block: BlockNode.() -> Unit): BlockNode {
    val head = BlockNode("body")
    head.block()
    this.children += head
    return head
}

fun main() {
    val htmlContent = html {
        head {
            "meta" { "charset"("UTF-8") }
        }
        body {
            "div" {
                "style"(
                        """
                    width: 200px; 
                    height: 200px; 
                    line-height: 200px; 
                    background-color: #C9394A;
                    text-align: center
                    """.trimIndent()
                )
                "span" {
                    "style"(
                            """
                        color: white;
                        font-family: Microsoft YaHei
                        """.trimIndent()
                    )
                    +"Hello HTML DSL!!"
                }
            }
        }
    }.render()

    File("Kotlin.html").writeText(htmlContent)
}