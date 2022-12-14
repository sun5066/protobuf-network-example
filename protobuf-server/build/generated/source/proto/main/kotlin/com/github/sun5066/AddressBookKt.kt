//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: com/github/sun5066/sampe.proto

package com.github.sun5066;

@kotlin.jvm.JvmName("-initializeaddressBook")
inline fun addressBook(block: com.github.sun5066.AddressBookKt.Dsl.() -> kotlin.Unit): com.github.sun5066.AddressBook =
  com.github.sun5066.AddressBookKt.Dsl._create(com.github.sun5066.AddressBook.newBuilder()).apply { block() }._build()
object AddressBookKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: com.github.sun5066.AddressBook.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.github.sun5066.AddressBook.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.github.sun5066.AddressBook = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class PeopleProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     */
     val people: com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getPeopleList()
      )
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     * @param value The people to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addPeople")
    fun com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>.add(value: com.github.sun5066.Person) {
      _builder.addPeople(value)
    }
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     * @param value The people to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignPeople")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>.plusAssign(value: com.github.sun5066.Person) {
      add(value)
    }
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     * @param values The people to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllPeople")
    fun com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>.addAll(values: kotlin.collections.Iterable<com.github.sun5066.Person>) {
      _builder.addAllPeople(values)
    }
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     * @param values The people to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllPeople")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>.plusAssign(values: kotlin.collections.Iterable<com.github.sun5066.Person>) {
      addAll(values)
    }
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     * @param index The index to set the value at.
     * @param value The people to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setPeople")
    operator fun com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>.set(index: kotlin.Int, value: com.github.sun5066.Person) {
      _builder.setPeople(index, value)
    }
    /**
     * <code>repeated .grpcchat.Person people = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearPeople")
    fun com.google.protobuf.kotlin.DslList<com.github.sun5066.Person, PeopleProxy>.clear() {
      _builder.clearPeople()
    }

  }
}
@kotlin.jvm.JvmSynthetic
inline fun com.github.sun5066.AddressBook.copy(block: com.github.sun5066.AddressBookKt.Dsl.() -> kotlin.Unit): com.github.sun5066.AddressBook =
  com.github.sun5066.AddressBookKt.Dsl._create(this.toBuilder()).apply { block() }._build()

