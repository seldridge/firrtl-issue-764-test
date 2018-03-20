package experimental

import org.clapper.classutil.ClassFinder

abstract class MyAbstractClass

case class Foo(name: String) extends MyAbstractClass
case class Bar(xs: List[Int]) extends MyAbstractClass

object Test extends App {

  val finder = ClassFinder()
  val classes = finder.getClasses

  println(s"ClassFinder is searching on finder.classpath: ${finder.classpath}")
  println(s"There are ${classes.size} total classes")

  val subclasses1 = ClassFinder.concreteSubclasses(classOf[experimental.MyAbstractClass], classes).toList
  val subclasses2 = ClassFinder.concreteSubclasses("experimental.MyAbstractClass", classes).toList

  println(s"Subclasses1: $subclasses1")

  println(s"Subclasses2: $subclasses2")
}
