/**
 * 30-MAY-2013
 * 
 * Kiev, Ukraine.
 * 
 */
package com.adal

/**
 * @author Alex Evseenko
 *
 */
class AdalApplication {
  abstract class AST
  case class Branch extends AST
  case class Leaf extends AST

  def add(c: Container): Unit = println("Container added.")

  def add(d: Dataflow): Unit = println("Dataflow added.")
  
  def setRxEndpoint(receiver: Container, rx: Dataflow): Unit = println("Rx-endpoint added.")
  
  def setTxEndpoint(sender: Container, tx: Dataflow): Unit = println("Tx-endpoint added.")

  def generate: Unit = println("generating...")
}