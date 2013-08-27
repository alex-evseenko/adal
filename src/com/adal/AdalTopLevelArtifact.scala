/**
 * 31-MAY-2013
 * 
 * Kiev, Ukraine.
 */
package com.adal


/**
 * Intended to constitute abstract functionality for any top-level artifact, i.e. container, data-flow, etc.
 * 
 * TODO
 * 
 * The best approach is to emulate the same syntax as the generated native code has using endomorphic functions,
 * like below:
 * 
 *  gen public static final void method1("onCreate", "Bundle") {}
 *  
 *  Nearest example using Int => Int endomorphisms:
 *  
 *  lst map add1 map sq map add100
 * 
 *
 * @author Alex Evseenko
 *
 */
trait AdalTopLevelArtifact {
  
	def generate = "\nCONTENT GENERATED\n"

	def gslc(comment: String) =
	  "// "+comment+"\n"

	def gmlc(comment: String) =
	  "\n/**\n"+
	  " * "+comment+"\n"+
	  " *\n"+
	  " * @author Alex Evseenko\n"+
	  " *\n"+
	  " */\n"

	
	def _override = {
	  this
	}
	
	def _suppressWarning = {
	  this
	}
	
	def _final = {
	  this
	}
	
	def _public = {
	  
	  this
	}
	
	def _protected = {
	  this
	}

	def _void = {
	  this
	}
	
	def _method(name: String, param: String) = (body: String) => {
	  name+"("+param+") "+"{\n"+
	  "  "+body+
	  "\n}\n"
	}
}