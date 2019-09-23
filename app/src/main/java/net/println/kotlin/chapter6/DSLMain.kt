package net.println.kotlin.chapter6


/**
 * Created by benny on 5/29/17.
 */
fun main(args: Array<String>) {
//    <html id="HtmlId" ><head id="headId" ></head><body id="bodyId" class="bodyClass" ><a href="https://www.kotliner.cn" >Kotlin 中文博客</a></body><div></div></html>
//    Tag("html").apply {
//        proerties["id"] = "HtmlId"
//        children.add(Tag("headId"))
//    }.render().let {
//        println(it) }


    html {
        println("准备调用")
        //这个是properties
        "id"("HtmlId")
        //这个是children
        "head"{
            "id"("headId")
        }
        println("before body")
        //this+Body().apply(block)-> children.add(node) 所以body也是一个child
        //这里相当于调用方法
        body (){
            id="bodyId"
            `class` = "bodyClass"
            println("befeore a")
            "a"{
                println("href()")
                "href"("https://www.kotliner.cn")
                println("Kotlin 中文博客")
                +"Kotlin 中文博客"

            }
        }

//        "div"{
//
//        }
        println("over-----------")

    }.render().let(::println)

//    render Kotlin 中文博客  StringNode
//    render <a href="https://www.kotliner.cn" >Kotlin 中文博客</a>   Tag<a>
//    render <body id="bodyId" class="bodyClass" ><a href="https://www.kotliner.cn" >Kotlin 中文博客</a></body>  Tag<body>
//    <html id="HtmlId" ><head id="headId" ></head><body id="bodyId" class="bodyClass" ><a href="https://www.kotliner.cn" >Kotlin 中文博客</a></body></html>
}