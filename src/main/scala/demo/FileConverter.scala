package demo

import better.files.File
import cats.data.EitherT
import cats.effect.IO

import scala.util.Try


object FileConverter {

  //  def convert(in: File, out: File): IO[Unit] = {
  //    val str = read(in)
  //    write(out, str.toUpperCase())
  def convert(in: File, out: File)
  : IO[Either[Error, Unit]] = {
//    val r = for {
    for {
      str <- read(in)
      _ <- write(out, str.toUpperCase())
    } yield ()
//    r.value // this gets the IO[Either[Error, Unit]]
  }.value


  //  private def write(file: File, s: String): Unit = {
  private def write(file: File, s: String)
  : EitherT[IO, Error, Unit] = EitherT {
    IO {
      //      val bytes = s.getBytes.iterator
      //      file.writeBytes(bytes)
      val bytes = s.getBytes.iterator
      Try(file.writeBytes(bytes))
        .map(_ => ())
        .toEither
        .left.map(t => IOError(t.getMessage))
    }
  }

  //  private def read(file: File): String = {
  private def read(file: File)
  : EitherT[IO, Error, String] = EitherT {
    IO {
      //      val bytes = file.loadBytes
      //      new String(bytes)
      Try(file.loadBytes)
        .map(bytes => new String(bytes))
        .toEither
        .left.map(t => IOError(t.getMessage))
    }
  }
}


