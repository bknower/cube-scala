package Rep

import java.awt.Dimension

import scala.swing._
import scala.swing.MainFrame
import scala.swing.Panel
import scala.swing.SimpleSwingApplication
import scala.swing.event._

object Draw extends SimpleSwingApplication {
  var r = new Representation
  //r.algorithm("UUDDFFBBRRLL")

  var data = Array.ofDim[Char](12, 9)
  reArray
  addArray(3, 3, r.toArray(r.front))
  addArray(0, 3, r.toArray(r.left))
  addArray(3, 6, r.toArray(r.down))
  addArray(6, 3, r.toArray(r.right))
  addArray(9, 3, r.toArray(r.back))

  var cubeD = new CubeDisplay(data) { preferredSize = new Dimension(400, 300) }

  def top = new MainFrame {
    contents = new NullPanel {
      preferredSize = new Dimension(400, 300)
      add(cubeD, 0, 0)
      add(ui, 0, 0)
    }
  }

  def reArray = { //add the array of colors for each face to a 9 x 12 array that represents what will be displayed on the screen
    addArray(3, 0, r.toArray(r.up))
    addArray(3, 3, r.toArray(r.front))
    addArray(0, 3, r.toArray(r.left))
    addArray(3, 6, r.toArray(r.down))
    addArray(6, 3, r.toArray(r.right))
    addArray(9, 3, r.toArray(r.back))
  }

  lazy val ui = new NullPanel {
    { preferredSize = new Dimension(400, 300) }
    listenTo(mouse.clicks)
    reactions += {
      case e @ MouseClicked(ui, pt, _, _, _) =>
        val which = e.peer.getButton

        if (which == 1) {
          if (e.point.getX > 0 && e.point.getX < 100) {
            if (e.point.getY > 100 && e.point.getY < 200) {
              r.L
            }
          } else if (e.point.getX > 100 && e.point.getX < 200) {
            if (e.point.getY > 0 && e.point.getY < 100) {
              r.U
            } else if (e.point.getY > 100 && e.point.getY < 200) {
              r.F
            } else if (e.point.getY > 200 && e.point.getY < 300) {
              r.D
            }
          } else if (e.point.getX > 200 && e.point.getX < 300) {
            if (e.point.getY > 100 && e.point.getY < 200) {
              r.R
            }
          } else if (e.point.getX > 300 && e.point.getX < 400)
            if (e.point.getY > 100 && e.point.getY < 200) {
              r.B
            }
        } else if (which == 3) {
          if (e.point.getX > 0 && e.point.getX < 100) {
            if (e.point.getY > 100 && e.point.getY < 200) {
              r.L(3)
            }
          } else if (e.point.getX > 100 && e.point.getX < 200) {
            if (e.point.getY > 0 && e.point.getY < 100) {
              r.U(3)
            } else if (e.point.getY > 100 && e.point.getY < 200) {
              r.F(3)
            } else if (e.point.getY > 200 && e.point.getY < 300) {
              r.D(3)
            }
          } else if (e.point.getX > 200 && e.point.getX < 300) {
            if (e.point.getY > 100 && e.point.getY < 200) {
              r.R(3)
            }
          } else if (e.point.getX > 300 && e.point.getX < 400)
            if (e.point.getY > 100 && e.point.getY < 200) {
              r.B(3)
            }
        }

        reArray
        //  contents.clear
        add(new CubeDisplay(data) { preferredSize = new Dimension(400, 300) }, 0, 0)
        repaint
    }
  }

  def addArray(x: Int, y: Int, arr: Array[Array[Char]]) = { //add an array to a larger array at a specified x and y value
    for (a <- x to x + 2)
      for (b <- y to y + 2)
        data(a)(b) = arr(a - x)(b - y)
  }
}