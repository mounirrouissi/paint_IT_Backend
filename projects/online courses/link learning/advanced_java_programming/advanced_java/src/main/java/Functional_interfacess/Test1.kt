package Functional_interfacess

import java.util.*
import java.util.function.BiFunction
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Supplier
import java.util.stream.Collectors

object Test1 {
    @JvmStatic
    fun main(args: Array<String>) {
        //       printValue(() -> "Hello, World!");
        printValue { Math.random() * 10 }
        val consumer = Consumer { c: String? -> Test2.consumeValue(c) }
        consumer.accept("fFdfdf")
        //consumeValue(() -> Math.random() * 10);
        // System.out.println(pipeline.apply(10));;
        val greetings = Greetings { c: String -> "Hi$c" }
        println(greetings.sayHi("Hello"))
        println(sum.apply(12, 12))
       // val strings = fromArrayToList(arrayOf("a", "b", "c"))
        val ints = fromArrayToList(arrayOf(1, 2))
        println(ints)
       // println(strings)
    }

    fun <T:Number> fromArrayToList(a: Array<T>?): List<T> {
        return Arrays.stream(a).collect(Collectors.toList())
    }

    private fun printValue(supplier: Supplier<Any>): Any {
        println(supplier.get())
        return supplier.get()
    }

    private fun consumeValue(o: String) {
        println(o)
    }

    private val sum = BiFunction { a: Int?, b: Int? ->
        Integer.sum(
            a!!, b!!
        )
    }
    private val add =
        Function { x: Int -> x + 2 } //private static Function<Integer,Integer> pipeline= sum.andThen(add);
}