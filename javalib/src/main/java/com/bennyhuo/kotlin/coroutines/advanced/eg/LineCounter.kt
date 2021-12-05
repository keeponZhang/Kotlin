package com.bennyhuo.kotlin.coroutines.advanced.eg

import com.bennyhuo.kotlin.coroutines.advanced.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.Executors

val KotlinFileFilter = { file: File -> file.isDirectory || file.name.endsWith(".kt") }

data class FileLines(val file: File, val lines: Int) {
    override fun toString(): String {
        return "${file.name}: $lines"
    }
}

suspend fun main() {
    val result = lineCounter(
            File("D:\\test5\\keeponGitgub\\Kotlin1_3\\javalib\\src\\main\\java\\com\\bennyhuo" +
                    "\\kotlin\\coroutines\\advanced\\callback2suspend"))
    log(result)
}

suspend fun lineCounter(root: File): HashMap<File, Int> {
    return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1)
            .asCoroutineDispatcher()
            .use {
                withContext(it) {
                    val fileChannel = walkFile(root)
//相当于并发操作
                    val fileLinesChannels = List(5) {
//                    把file转为fileLine
                        fileLineCounter(fileChannel)
                    }

                    resultAggregator(fileLinesChannels)
                }
            }
}

fun CoroutineScope.walkFile(root: File): ReceiveChannel<File> {
    return produce(capacity = Channel.BUFFERED) {
//        本身是sendChannel
        fileWalker(root)
    }
}

suspend fun SendChannel<File>.fileWalker(file: File) {
    if (file.isDirectory) {
        file.listFiles()?.filter(KotlinFileFilter)?.forEach { fileWalker(it) }
    } else {
        send(file)
    }
}

fun CoroutineScope.fileLineCounter(input: ReceiveChannel<File>): ReceiveChannel<FileLines> {
    return produce(capacity = Channel.BUFFERED) {
        for (file in input) {
            file.useLines {
                send(FileLines(file, it.count()))
            }
        }
    }
}

suspend fun CoroutineScope.resultAggregator(
        channels: List<ReceiveChannel<FileLines>>
): HashMap<File, Int> {
    val map = HashMap<File, Int>()
//    因为要演示多路复用，所以上面是故意搞成List的
    channels.aggregate { filteredChannels ->
        select<FileLines?> {
//            filteredChannels表示最快的那个
            filteredChannels.forEach {
                it.onReceiveOrNull {
                    log("received: $it")
                    it
                }
            }
        }?.let {
//            log("--------received let---------: $it")
            map[it.file] = it.lines
        }
    }
    return map
}

//因为select是个挂起函数
tailrec suspend fun List<ReceiveChannel<FileLines>>.aggregate(
        block: suspend (List<ReceiveChannel<FileLines>>) -> Unit
) {
    block(this)
//    可能已经处理完了，这里过滤下
    filter { !it.isClosedForReceive }.takeIf { it.isNotEmpty() }?.apply {
//        只要有一个通道不为空，这里还会再执行
        aggregate(block)
    }
}