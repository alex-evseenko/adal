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

  test("Create an abstract container") {
    val c = new Container(createLandmarkComponents)
    c("landmark") << Option("Home, sweet home")
    
    assert(c("landmark").value.get === "Home, sweet home")
  }

  test("") {
    
  }


  private def createLandmarkComponents = List(new Component("landmark"), new Component("address"), new Component("long,lat"))
}