/**
 * 24-MAY-2013
 * 
 * Kiev, Ukraine.
 * 
 */
package test

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.adal._

/**
 * @author Alex Evseenko
 *
 */
@RunWith(classOf[JUnitRunner])
class GuiAndPersistContainersSuite extends FunSuite {
  implicit object App extends AdalApplication

  val landmark = "landmark"
  val landmarkValue = "Home, sweet home"
  val address = "address"
  val addressValue = "Kiev, Ukraine"
  val longAndLat = "long,lat"
  val longAndLatValue = "30.522301,50.45111"
  val longitude = "longitude"
  val longValue = 30.522301
  val latitude = "latitude"
  val latValue = 50.45111

  test("Create an abstract container") {
    val c = Container(createLandmarkComponents)
    
    assert(c(landmark).value.get === landmarkValue)
  }

  test("Connect the dataflow to an abstract container") {
    val src = Container(createLandmarkComponents)
    val dst = Container(createPersistComponents)
    val dmod = src >> Dataflow()

    assert(!dmod.isConnected)
    
    dmod >> dst

    assert(dmod.isConnected, "The dataflow "+dmod+" is not connected to containers.")
  }

// TODO remove the propagation -- it's not the DSL capabilities but rather Core-framework
  test("Check data propagation via the dataflow") {
    val src = Container(createLandmarkComponents)
    val dst = Container(createPersistComponents)
    val dmod = Dataflow()
    
    src >> dmod >> dst

    dmod.doSend((src, dst) => {
      src(landmark) >> dst(landmark)
      src(address)  >> dst(address)
      val ll = src(longAndLat).value.get.asInstanceOf[String].split(",")
      dst(longitude) << Option(ll(0).toDouble)
      dst(latitude) << Option(ll(1).toDouble)
      true
    })

    assert(dst(landmark).value.get === landmarkValue)
    assert(dst(address).value.get === addressValue)
    assert(dst(longitude).value.get === longValue)
    assert(dst(latitude).value.get === latValue)
  }

  test("Check for components names duplicate") {
    
  }

  test("Check of the dataflow connected to both end-points") {
    
  }

  private def createLandmarkComponents = {
    List(Component(landmark) << Option(landmarkValue),
         Component(address) << Option(addressValue),
         Component(longAndLat) << Option(longAndLatValue))
  }

  private def createPersistComponents = List(Component(landmark), Component(address), Component(longitude), Component(latitude))
}
