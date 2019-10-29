package net.println.kotlin.chapter5.tailrecursive

/**
 * Created by benny on 4/15/17.
 */
data class ListNode(val value: Int, var next: ListNode? = null)

//尾递归加入tailrec，编译器会做优化，变成迭代
 tailrec fun findListNode(head: ListNode?, value: Int): ListNode?{
    //head?: 表示head为空时，执行下一行
    head?: return  null
    if(head.value == value) return head
    //在调用自身之后，没有返回任何东西，这是尾递归
    return findListNode(head.next, value)
}

//尾递归转换成迭代代码
fun findListNode2(head: ListNode?, value: Int): ListNode? {
    var head = head
    while (head != null) {
        if (head.value == value) {
            return head
        }

        head = head.next
    }

    return null
}

fun main(args: Array<String>) {
    val MAX_NODE_COUNT = 100000
    val head = ListNode(0)
    var p = head
    for(i in 1.. MAX_NODE_COUNT){
        p.next = ListNode(i)
        p = p.next!!
    }

    println(findListNode(head, MAX_NODE_COUNT - 2)?.value)
}

//这里因为不是尾递归，会提示不是尾递归
 fun factorial(n: Long): Long{
    //这个不是尾递归，因为乘以n了
    return n * factorial(n - 1)
}

data class TreeNode(val value: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findTreeNode(root: TreeNode?, value: Int): TreeNode?{
    root?: return null
    if(root.value == value) return root
    //这个也不算尾递归
    return findTreeNode(root.left, value)?: return findTreeNode(root.right, value)
}