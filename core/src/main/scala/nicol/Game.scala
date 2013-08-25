package nicol

import akka.actor.ActorSystem
import akka.event.Logging
import akka.actor.ActorDSL._
import org.lwjgl.opengl.Display
import java.util.UUID

abstract class Game(entry: Scene){
  val name = Display.getTitle.replaceAll("\\s", "-")
  implicit val system = ActorSystem(s"${UUID.randomUUID()}-$name")

  val theGame = actor(new Act {
    become{
      case "start" => entry.apply
    }
  })

  val log = Logging(system, theGame)

  def main(args: Array[String]) = theGame ! "start"
}
