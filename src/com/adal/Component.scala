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

  def <<(optValue: Option[Any]): Component = { value = optValue; this }
  def <<(tx: Component): Component = { value = tx.value; this }
  def >>(rx: Component): Component = { rx << value; this }

  override def toString = "(" + name + "," + value + ")"
}