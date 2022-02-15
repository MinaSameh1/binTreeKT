package BinaryTree

import kotlin.random.Random

/*
 * This is just a tree it holds the root so we can use it to iterate the tree
 * @property root It is the root Node
 * @constructor Creates the tree and sets its root
 */
data class BinaryTree(var root: Node?)

/*
 * This is the main node itself
 * @property msg The question/item it will carry
 * @property yesNode the path we will take if yes
 * @property noNode the path we will take if no
 * @constructor Creates the msg with nodes as null by default
 */
data class Node(
    var msg: String,
    var yesNode: Node? = null,
    var noNode: Node? = null,
) {
    public fun isQuestion(): Boolean {
        if (yesNode != null && noNode != null) return true
        return false
    }
}

/*
 * Function that generates a binary tree for testing :)
 * @param level the level of the tree
 */
fun generateTree(level: Int): Node? {
    if (level == 0) {
        return null
    } else {
        var node: Node = Node("${Random.nextInt(0,100)}")
        node.yesNode = generateTree(level - 1)
        node.noNode = generateTree(level - 1)
        return node
    }
}

/*
 * Function that prints the binary tree :)
 * @param node the node that will be printed
 * @param level the level indicates its well level, and the first one is the yes
 * while the second one is the no, for ex: 3=5 \n 3=7 the first one(5) is yes while
 * the second(7) is no
 */
fun printTree(node: Node?, level: Int = 0) {
    if (node == null) {
        return
    }
    println("$level = ${node.msg}")
    printTree(node.yesNode, level + 1)
    printTree(node.noNode, level + 1)
}
