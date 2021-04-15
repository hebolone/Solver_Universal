package Events

class Event<T>(private val eventHandler: EventHandler<T>) {
    operator fun plusAssign(handler: (T) -> Unit) { eventHandler.handlers.add(handler) }
}

class EventHandler<T> {
    val handlers = arrayListOf<((T) -> Unit)>()
    operator fun invoke(value: T) { handlers.forEach { it(value) } }
}