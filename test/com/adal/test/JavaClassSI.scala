/**
 * 28-AUG-2013
 * 
 * Kiev, Ukrine.
 * 
 */
package com.adal.test

/**
 * Implementation of template for Java class generation based on Scala string interpolation.
 * 
 * @author Alexander Evseenko
 *
 */
object JavaClassSI {
  val packageName = "com.adal.test"
  val import1 = "java.lang.String"
  val classVisibility = "public"
  val className = "JavaClass"

// implicits?
  val defaultTemplate = template(packageName, import1, classVisibility, className)
    
  def template(xs: List[String]): String = template(xs(0), xs(1), xs(2), xs(3))

  def template(packageName: String, import1: String, classVisibility: String, className: String) =
s"""
package $packageName;

import $import1;

$classVisibility class $className {

}
""".trim

}
