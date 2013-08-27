/**
 *
 */
package com.adal.test

import org.specs2._
import scala.io.Source
import javax.tools.JavaCompiler
import javax.tools.ToolProvider

/**
 * @author Alexander Evseenko
 *
 */
class JavaClassSpec extends SpecificationWithJUnit { def is = s2"""
  
  This is a specification to check generation of a Java class
  
  The JavaClass should
    start with package declaration							$e1
    contain imports list									$e2
  	contain keyword 'class'									$e3
  	contain name starts with capital letter 				$e4
  	contain opening curly brace 							$e5
  	contain list of class fields							$e6
  	contain list of inner classes							$e7
  	contain list of class methods							$e8
  	end with closing curly brace							$e9
  	be compiled 											$e10
  
  """

  val javaClass = Source.fromFile("C:/Projects/git/adal/test/com/adal/test/JavaClass.java").mkString.trim

  def e1 = javaClass must startWith ("package")
  def e2 = javaClass must contain ("import")
  def e3 = javaClass must contain ("class")
  def e4 = javaClass must contain ("JavaClass")
  def e5 = javaClass must contain ("{")
  def e6 = pending
  def e7 = pending
  def e8 = pending
  def e9 = javaClass must endWith ("}")
  def e10 = {
	val compiler = ToolProvider.getSystemJavaCompiler()
	
	pending
  }
  
}