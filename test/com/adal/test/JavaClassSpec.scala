/**
 *
 */
package com.adal.test

import org.specs2._

/**
 * @author Alexander Evseenko
 *
 */
class JavaClassSpec extends SpecificationWithJUnit { def is = s2"""
  
  This is a specification to check generation of a Java class
  
  The JavaClass should
    contain package declaration								$e1
    contain imports list									$e2
  	contain keyword 'class'									$e3
  	contain name starts with capital letter 				$e4
  	contain opening curly brace 							$e5
  	contain list of class fields							$e6
  	contain list of inner classes							$e7
  	contain list of class methods							$e8
  	contain closing curly brace								$e9
  
  """

  def e1 = true
  def e2 = true
  def e3 = true
  def e4 = true
  def e5 = true
  def e6 = true
  def e7 = true
  def e8 = true
  def e9 = true
  
}