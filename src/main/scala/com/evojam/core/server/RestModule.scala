package com.evojam.core.server

import javax.inject.{Named, Singleton}

import akka.actor.{ActorRef, ActorSystem}
import com.evojam.core.akka.GuiceAkkaExtension
import com.google.inject.Provides
import net.codingwell.scalaguice.ScalaModule

object RestModule extends ScalaModule {
  override def configure() = bind[Server]

  @Provides
  @Singleton
  @Named("RouterRef")
  def provideRouterRef(system: ActorSystem): ActorRef =
    system.actorOf(GuiceAkkaExtension(system).props[RestServiceActor])
}
