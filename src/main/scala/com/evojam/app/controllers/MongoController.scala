package com.evojam.app.controllers

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

import spray.httpx.SprayJsonSupport._
import spray.routing.Directives

import com.evojam.app.dto.MongoDBNamesInfo._
import com.evojam.app.service.mongo.MongoService
import com.evojam.core.server.RouteComponent
import com.google.inject.Inject

class MongoController @Inject() (mongoService: MongoService)(implicit exc: ExecutionContext)
  extends Directives with RouteComponent {

  override def route = {
    pathPrefix("db") {
      path("names") {
        onComplete(mongoService.dbNames()) {
          case Success(names) => complete(names)
          case Failure(ex) => complete(ex.getMessage)
        }
      }
    }
  }

}
