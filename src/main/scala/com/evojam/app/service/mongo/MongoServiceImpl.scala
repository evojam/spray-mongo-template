package com.evojam.app.service.mongo

import scala.concurrent.ExecutionContext.Implicits.global

import com.evojam.app.dto.MongoDBNamesInfo
import com.evojam.mongodb.client.MongoClient
import com.google.inject.Inject

class MongoServiceImpl @Inject() (mongo: MongoClient) extends MongoService {

  def dbNames() =
    mongo.databaseNames()
      .map(MongoDBNamesInfo(_))
}