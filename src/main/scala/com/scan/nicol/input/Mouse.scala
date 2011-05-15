package com.scan.nicol
package input

import org.lwjgl.input.Mouse._

object Mouse {

  trait Button {
    val button: Int
  }

  case object Left extends Button {
    val button = 0
  }

  case object Right extends Button {
    val button = 1
  }

  case object Middle extends Button {
    val button = 2
  }

  def apply: (Float, Float) = (getX, getY)

  def apply(btn: Button):Boolean = isButtonDown(btn.button)

  def apply(x:Float,y:Float) = setCursorPosition(x.toInt,y.toInt); updateCursor
}