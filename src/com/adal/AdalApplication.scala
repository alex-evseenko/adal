/**
 * 30-MAY-2013
 * 
 * Kiev, Ukraine.
 * 
 */
package com.adal

/**
 * Meta-container allows generating of an adal-application to target native code.
 * 
 * @author Alex Evseenko
 *
 */
class AdalApplication {
  var list = List[AdalTopLevelArtifact]()


  def add(c: Container): Unit = {
    println("Container added.")

    list = c::list
  }

  def add(d: Dataflow): Unit = {
    println("Dataflow added.")

    list = d::list
  }

  def setRxEndpoint(receiver: Container, rx: Dataflow): Unit = println("Rx-endpoint added.")

  def setTxEndpoint(sender: Container, tx: Dataflow): Unit = println("Tx-endpoint added.")

  def generate: Unit = {
    println("generating...")

    println(list.map(e => e.generate))
  }

}