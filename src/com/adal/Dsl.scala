/**
 * 23-MAY-2013
 * 
 * Kiev, Ukraine.
 * 
 */
package com.adal

import com.adal.containers.GuiContainer

/**
 * @author Alex Evseenko
 *
 */
object Dsl {
  implicit object App extends AdalApplication
   
  val LANDMARK = "landmark"
  val ADDRESS = "address"
  val LONG_LAT = "longAndLat"
    
  val src = GuiContainer("LandmarkView", List(Component(LANDMARK), Component(ADDRESS), Component(LONG_LAT)))

  val LANDMARK_FIELD = "landmarkField"
  val ADDRESS_FIELD = "addressField"
  val LONG_FIELD = "longitude"
  val LAT_FIELD = "latitude"

  val dst = Container(List(Component(LANDMARK_FIELD), Component(ADDRESS_FIELD), Component(LONG_FIELD), Component(LAT_FIELD)))

  val dmod = Dataflow((src, dst) => {
      src(LANDMARK) >> dst(LANDMARK_FIELD)
      src(ADDRESS)  >> dst(ADDRESS_FIELD)
      val ll = src(LONG_LAT).value.get.asInstanceOf[String].split(",")
      dst(LONG_FIELD) << Option(ll(0).toDouble)
      dst(LAT_FIELD) << Option(ll(1).toDouble)
      true
    }) 

  src >> dmod >> dst

  
  def main(args: Array[String]): Unit = {
	App.generate
  }

}