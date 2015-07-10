package com.evojam.core.akka

import javax.inject.{Provider, Singleton}

import scala.concurrent.ExecutionContext

import akka.actor.{ActorRefFactory, ActorSystem}

import com.google.inject.{Injector, Provides}
import net.codingwell.scalaguice.ScalaModule

/*
Akka module and related forked from:
  https://github.com/ehalpern/sandbox/tree/master/src/main/scala/twine/akka
*/
object AkkaModule extends ScalaModule {

  override def configure() = {}

  @Provides @Singleton
  def provideActorSystem(injector: Injector) : ActorSystem = {
    val system = ActorSystem("system")
    GuiceAkkaExtension(system).initialize(injector)
    system
  }

  @Provides @Singleton
  def provideActorRefFactory(systemProvider: Provider[ActorSystem]): ActorRefFactory =
    systemProvider.get

  @Provides @Singleton
  def provideExecutionContext(systemProvider: Provider[ActorSystem]): ExecutionContext =
    systemProvider.get.dispatcher
}
