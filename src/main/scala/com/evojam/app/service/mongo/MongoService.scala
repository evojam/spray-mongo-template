package com.evojam.app.service.mongo

import scala.concurrent.Future

import com.evojam.app.dto.MongoDBNamesInfo

trait MongoService {
  def dbNames(): Future[MongoDBNamesInfo]
}