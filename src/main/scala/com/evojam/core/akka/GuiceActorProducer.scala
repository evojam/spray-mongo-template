package com.evojam.core.akka

import akka.actor.{Actor, IndirectActorProducer}
import com.google.inject.Injector

class GuiceActorProducer[A <: Actor](injector: Injector, actorClz: Class[A])
  extends IndirectActorProducer {

  override def actorClass = actorClz

  override def produce = injector.getInstance(actorClass)
}
