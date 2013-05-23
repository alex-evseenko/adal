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
class Component(val name: String) {
  var value: Option[Any] = None
  def <<(optValue: Option[Any]): Unit = { value = optValue }
  def <<(tx: Component): Unit = { value = tx.value }
  def >>(rx: Component): Unit = { rx << value }
  override def toString = "(" + name + "," + value + ")"
}