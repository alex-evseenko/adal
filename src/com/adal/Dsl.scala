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
    
  val src = Container(List(Component(LANDMARK), Component(ADDRESS), Component(LONG_LAT)))

  val LANDMARK_FIELD = "landmarkField"
  val ADDRESS_FIELD = "addressField"
  val LONG_FIELD = "longitude"
  val LAT_FIELD = "latitude"

  val dst = Container(List(Component(LANDMARK_FIELD), Component(ADDRESS_FIELD), Component(LONG_FIELD), Component(LAT_FIELD)))

  val dmod = Dataflow() 

  src >> dmod >> dst

  
  def main(args: Array[String]): Unit = {
	App.generate
  }

}