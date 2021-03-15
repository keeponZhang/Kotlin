package cn.kotliner.coroutine.sequence

public abstract class SequenceBuilder<in T> internal constructor() {
    /**
     * Yields a value to the [Iterator] being built.
     */
    public abstract suspend fun yield(value: T)

    /**
     * Yields all values from the `iterator` to the [Iterator] being built.
     *
     * The sequence of values returned by the given iterator can be potentially infinite.
     */
    public abstract suspend fun yieldAll(iterator: Iterator<T>)

    /**
     * Yields a collections of values to the [Iterator] being built.
     */
    public suspend fun yieldAll(elements: Iterable<T>) {
        if (elements is Collection && elements.isEmpty()) return
        return yieldAll(elements.iterator())
    }

    /**
     * Yields potentially infinite sequence of values  to the [Iterator] being built.
     *
     * The sequence can be potentially infinite.
     */
    public suspend fun yieldAll(sequence: Sequence<T>) = yieldAll(sequence.iterator())
}