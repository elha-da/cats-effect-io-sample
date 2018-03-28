package demo

import better.files.File
import cats.effect.IO

object DemoApp extends App {

  import FileConverter._

  //  convert(File.temp / "demofile", File.temp / "result")
  val program: IO[Either[Error, Unit]] =
    convert(File.temp / "demofile", File.temp / "result")

  //  program.unsafeRunSync() match {
  //    case Left(error) => println(s"error: $error")
  //    case Right(_) => println("successfully written")
  //  }

  def handle(e: Either[Error, Unit]) = e match {
    case Left(error) => IO {
      println(s"error: $error")
    }
    case Right(value) => IO {
      println("successfully written")
    }
  }

  program.flatMap(e => handle(e)).unsafeToFuture() //unsafeRunSync()

}
