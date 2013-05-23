/**
 * 23-MAY-2013
 * 
 * Kiev, Ukraine.
 * 
 */
package com.adal

/**
 * @author Alex Evseenko
 *
 */
class Container(components: List[Component]) {

  def <<(rx: Dataflow): Dataflow = {
    rx.dst = Option(this)
    rx
  }

  def >>(tx: Dataflow): Dataflow = {
    tx.src = Option(this)
    tx
  }

  /*
  	 * Get the named component from the container
  	 */
  def apply(name: String): Component =
    if (components.exists(c => c.name == name))
      components.filter(c => c.name == name)(0)
    else
      throw new java.util.NoSuchElementException(name)

  /*
  	 * Get the n-th component from the container
  	 */
  def apply(n: Int): Component = components(n)

  def onDataReceived: Unit = ()
  def onDataSent: Unit = ()

  override def toString = components.toString

}