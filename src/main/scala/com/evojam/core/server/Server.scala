package com.evojam.core.server

import javax.inject.{Inject, Named}

import akka.actor.{ActorRef, ActorSystem}
import akka.io.IO
import spray.can.Http

import com.typesafe.config.Config

class Server @Inject()(config: Config, @Named("RouterRef") routerRef: ActorRef)
  (implicit actorSystem: ActorSystem) {

  lazy val host = config.getString("server.host")
  lazy val port = config.getInt("server.port")

  def start() = IO(Http) ! Http.Bind(routerRef, host, port = port)
}
