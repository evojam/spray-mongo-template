package com.evojam.app.dto

import spray.json.DefaultJsonProtocol

case class MongoDBNamesInfo(names: Iterable[String])

object MongoDBNamesInfo extends DefaultJsonProtocol {
  implicit val format = jsonFormat1(MongoDBNamesInfo.apply)
}
