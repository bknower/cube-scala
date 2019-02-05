package Rep

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea
import java.awt.Dimension
import java.awt.BorderLayout
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Representation {
  
  //initializes each face to the corresponding solid color
  //a face numbered in order with the substrings of each of these characters looks like this:
  //(a spiral inwards, starting on the top left and going clockwise)
  // 0 1 2
  // 7 8 3
  // 6 5 4
  var front = "ggggggggg"
  var back =  "bbbbbbbbb"
  var left =  "ooooooooo"
  var right = "rrrrrrrrr"
  var up =    "wwwwwwwww"
  var down =  "yyyyyyyyy"
  
  //right-shifts each character in a string by 1, displacing the last character back to the beginning
  def rotate(str: String) = str.substring(str.length - 1, str.length) + str.substring(0, str.length - 1)
  
  //rotates a face clockwise 90 degrees
  def rotateFace(str: String) = rotate(rotate(str.substring(0, str.length - 1))) + str.substring(str.length - 1, str.length)
  
  //prints to console a representation of each face
  def printCube = {
    println("Front:")
    printFace(front)
    println("Back:")
    printFace(back)
    println("Left:")
    printFace(left)
    println("Right:")
    printFace(right)
    println("Up:")
    printFace(up)
    println("Down:")
    printFace(down)
  }
  
  //creates a 2D array from a face string
  def toArray(str: String) = Array(Array(str.charAt(0), str.charAt(7), str.charAt(6)), Array(str.charAt(1), str.charAt(8), str.charAt(5)), Array(str.charAt(2), str.charAt(3), str.charAt(4)))
  
  //prints to console a representation of a given face string
  def printFace(str: String) = {
    println(str.substring(0, 3))
    print(str.substring(7, 9))
    println(str.substring(3, 4))
    println(str.substring(4, 7).reverse)
  }
  
  def cross = {
    
  }
  
  def F2L = {
    
  }
  
  def OLL = {
    
  }
  
  def PLL = {
    
  }
  
  //executes an algorithm written as a string n times
  def algorithm(str: String, n: Int) = {
    for (a <- 1 to n) {
      for (a <- 0 to str.length - 1) {
        str.charAt(a) match {
          case 'R' => R
          case 'L' => L
          case 'F' => F
          case 'B' => B
          case 'U' => U
          case 'D' => D
        }
      }
    }
  }

  //executes an algorithm written as a string once
  def algorithm(str: String) = {
    for (a <- 0 to str.length - 1) {
      str.charAt(a) match {
        case 'R' => R
        case 'L' => L
        case 'F' => F
        case 'B' => B
        case 'U' => U
        case 'D' => D
      }
    }
  }

  //executes n clockwise turns of the front face
  def F(n: Int): Unit = {
    for (a <- 1 to n)
      F
  }
  
  //executes one clockwise turn of the front face
  def F = {
      front = rotateFace(front)
      var tempLeft = left.substring(0, 2) + down.substring(0, 3) + left.substring(5, 9)
      var tempUp = up.substring(0, 4) + left.substring(2, 5) + up.substring(7, 9)
      var tempRight = up.charAt(6) + right.substring(1, 6) + up.substring(4, 6) + right.charAt(8)
      var tempDown = right.substring(6, 8) + right.charAt(0) + down.substring(3, 9)
      left = tempLeft
      up = tempUp
      right = tempRight
      down = tempDown
  }

  //executes n clockwise turns of the back face
  def B(n: Int): Unit = {
    for (a <- 1 to n)
      B
  }
  
  //executes one clockwise turn of the back face
  def B = {
      back = rotateFace(back)
      var tempRight = right.substring(0, 2) + down.substring(4, 7) + right.substring(5, 9)
      var tempUp = right.substring(2, 5) + up.substring(3, 9)
      var tempLeft = up.charAt(2) + left.substring(1, 6) + up.substring(0, 2) + left.charAt(8)
      var tempDown = down.substring(0, 4) + left.substring(6, 8) + left.charAt(0) + down.substring(7, 9)
      left = tempLeft
      up = tempUp
      right = tempRight
      down = tempDown
  }
  
  //executes n clockwise turns of the left face
  def L(n: Int): Unit = {
    for (a <- 1 to n)
      L
  }
  
  //executes one clockwise turn of the left face
  def L = {
      left = rotateFace(left)
      var tempFront = up.substring(0, 1) + front.substring(1, 6) + up.substring(6, 8) + front.charAt(8)
      var tempUp = back.substring(4, 5) + up.substring(1, 6) + back.substring(2, 4) + up.charAt(8)
      var tempBack = back.substring(0, 2) + down.substring(6, 8) + down.substring(0, 1) + back.substring(5, 9)
      var tempDown = front.charAt(0) + down.substring(1, 6) + front.substring(6, 8) + down.charAt(8)
      front = tempFront
      up = tempUp
      back = tempBack
      down = tempDown
  }
  
  //executes n clockwise turns of the right face
  def R(n: Int): Unit = {
    for (a <- 1 to n)
      R
  }
  
  //executes one clockwise turn of the right face
  def R = {
      right = rotateFace(right)
      var tempBack = up.substring(4, 5) + back.substring(1, 6) + up.substring(2, 4) + back.charAt(8)
      var tempDown = down.substring(0, 2) + back.substring(6, 8) + back.charAt(0) + down.substring(5, 9)
      var tempFront = front.substring(0, 2) + down.substring(2, 5) + front.substring(5, 9)
      var tempUp = up.substring(0, 2) + front.substring(2, 5) + up.substring(5, 9)
      front = tempFront
      up = tempUp
      back = tempBack
      down = tempDown
  }
  
  //executes n clockwise turns of the up face
  def U(n: Int): Unit = {
    for (a <- 1 to n)
      U
  }
  
  //executes one clockwise turn of the up face
  def U = {
      up = rotateFace(up)
      var tempLeft = front.substring(0, 3) + left.substring(3, 9)
      var tempBack = left.substring(0, 3) + back.substring(3, 9)
      var tempRight = back.substring(0, 3) + right.substring(3, 9)
      var tempFront = right.substring(0, 3) + front.substring(3, 9)
      front = tempFront
      left = tempLeft
      back = tempBack
      right = tempRight
  }

  //executes n clockwise turns of the down face
  def D(n: Int): Unit = {
    for (a <- 1 to n)
      D
  }
  
  //executes one clockwise turn of the down face
  def D = {
      down = rotateFace(down)
      var tempLeft = left.substring(0, 4) + back.substring(4, 7) + left.substring(7, 9)
      var tempFront = front.substring(0, 4) + left.substring(4, 7) + front.substring(7, 9)
      var tempRight = right.substring(0, 4) + front.substring(4, 7) + right.substring(7, 9)
      var tempBack = back.substring(0, 4) + right.substring(4, 7) + back.substring(7, 9)
      front = tempFront
      left = tempLeft
      back = tempBack
      right = tempRight
  }
}