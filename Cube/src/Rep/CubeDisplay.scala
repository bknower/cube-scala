package Rep

import java.awt.Graphics2D
import java.awt.Color
import scala.swing.Panel
import scala.swing.event.MouseClicked

class CubeDisplay(data: Array[Array[Char]]) extends Panel {
  override def paintComponent(g: Graphics2D) {
    val dx = g.getClipBounds.width.toFloat  / data.length
    val dy = g.getClipBounds.height.toFloat / data.map(_.length).max
    for {
      x <- 0 until data.length
      y <- 0 until data(x).length
      x1 = (x * dx).toInt
      y1 = (y * dy).toInt
      x2 = ((x + 1) * dx).toInt
      y2 = ((y + 1) * dy).toInt
    } {
      data(x)(y) match {
        case 'g' => g.setColor(Color.GREEN)
        case 'b' => g.setColor(Color.BLUE)
        case 'w' => g.setColor(Color.WHITE)
        case 'y' => g.setColor(Color.YELLOW)
        case 'r' => g.setColor(Color.RED)
        case 'o' => g.setColor(Color.ORANGE)
        case _ => g.setColor(Color.BLACK)
      }
      g.fillRect(x1, y1, x2 - x1, y2 - y1)
    }
  }
}