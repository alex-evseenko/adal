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
object Dsl {
  implicit object App extends AdalApplication
   
  val LANDMARK = "landmark"
  val ADDRESS = "address"
  val LONG_LAT = "longAndLat"
    
  val src = new Container(List(new Component(LANDMARK), new Component(ADDRESS), new Component(LONG_LAT)))

  val LANDMARK_FIELD = "landmarkField"
  val ADDRESS_FIELD = "addressField"
  val LONG_FIELD = "longitude"
  val LAT_FIELD = "latitude"

  val dst = new Container(List(new Component(LANDMARK_FIELD), new Component(ADDRESS_FIELD), new Component(LONG_FIELD), new Component(LAT_FIELD)))

  val dmod = new Dataflow 

  src >> dmod >> dst

  
  def main(args: Array[String]): Unit = {
	App.generate
  }

}