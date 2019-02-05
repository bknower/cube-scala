package Rep

import scala.swing.Panel
import scala.swing.Component

class NullPanel extends Panel {
  peer.setLayout(null)

  protected def add(comp: Component, x: Int, y: Int): Unit = {
    val p = comp.peer
    p.setLocation(x, y)
    p.setSize(p.getPreferredSize) // !
    peer.add(p)
  }
  
  def clear = peer.removeAll
}