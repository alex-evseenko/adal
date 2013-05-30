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
class Dataflow {

  // transform data from src to dst
  type Transform = (Container, Container) => Boolean

  var src: Option[Container] = None
  var dst: Option[Container] = None
  def >>(d: Dataflow): Dataflow = this
  def <<(d: Dataflow): Dataflow = this

  def >>(c: Container): Dataflow = {
    dst = Option(c)
    this
  }
  def <<(c: Container): Dataflow = {
    src = Option(c)
    this
  }

  def isConnected = (src.isDefined && dst.isDefined)

  def doSend(transform: Transform): Boolean = {
    // check end-points
    require(isConnected, "The dataflow endpoints are not defoned")

    // propagates data
    val result = transform(src.get, dst.get)

    // invoke the callback for the sender & receiver
    if (result) {
      src.get.onDataSent
      dst.get.onDataReceived
    }

    result
  }

  override def toString = "(" + src + " -> " + dst + ")"
}